package com.hrm.utils;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import javax.annotation.Resource;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

@Component
public class RedisUtil {

	@Resource(name="redisTemplate")
	private RedisTemplate redisTemplate;
	
	//=========================common========================
	/**
	 * 判断缓存中是否存在 key
	 * @param key
	 * @return
	 */
	public boolean isExist(String key) {
		try {
			return redisTemplate.hasKey(key);
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 设置缓存中 key 的过期时间
	 * @param key
	 * @param time
	 * @return
	 */
	public boolean expire(String key, long time) {
		try {
			if(time > 0) {
				redisTemplate.expire(key, time, TimeUnit.SECONDS);
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 获取缓存中 key 的过期时间
	 * @param key
	 * @return
	 */
	public long getExpire(String key) {
		return redisTemplate.getExpire(key, TimeUnit.SECONDS);
	}
	
	/**
	 * 删除缓存中的 key
	 * @param keys
	 * @return
	 */
	public void remove(String ... keys) {
		if(keys.length == 1) {
			redisTemplate.delete(keys[0]);
		} else {
			redisTemplate.delete(CollectionUtils.arrayToList(keys));
		}
	}
	
	//=========================String========================
	/**
	 * 普通缓存获取
	 * @param key
	 * @return
	 */
	public Object get(String key) {
		return key==null ? null : redisTemplate.opsForValue().get(key);
	}
	
	/**
	 * 普通缓存放入
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean set(String key, Object value) {
		try {
			redisTemplate.opsForValue().set(key, value);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 普通缓存放入并设置时间
	 * @param key
	 * @param value
	 * @param time
	 * @return
	 */
	public boolean set(String key, Object value, long time) {
		try {
			if(time > 0) {
				redisTemplate.opsForValue().set(key, value, time, TimeUnit.SECONDS);
			} else {
				set(key, value);
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//========================= Map ========================
	/**
	 * 获取缓存中 Map 类型的某一 hashkey 的值
	 * @param key
	 * @param hashKey
	 * @return
	 */
	public Object hashGet(String key, String hashKey) {
		return redisTemplate.opsForHash().get(key, hashKey);
	}
	
	/**
	 * 获取缓存中 Map 类型的所有键值
	 * @param key
	 * @return
	 */
	public Map<String, Object> hashGetAll(String key){
		return redisTemplate.opsForHash().entries(key);
	}
	
	/**
	 * 将 Map 类型数据放入缓存
	 * @param key
	 * @param map
	 * @return
	 */
	public boolean hashSet(String key, Map<String, Object> map) {
		try {
			redisTemplate.opsForHash().putAll(key, map);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 将 Map 类型数据放入缓存并设置时间
	 * @param key
	 * @param map
	 * @param time
	 * @return
	 */
	public boolean hashSet(String key, Map<String, Object> map, long time) {
		try {
			redisTemplate.opsForHash().putAll(key, map);
			if(time > 0) {
				expire(key, time);
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 向一张 Hash 表中放入数据，如果不存在则创建
	 * @param key
	 * @param hashKey
	 * @param value
	 * @return
	 */
	public boolean hashAdd(String key, String hashKey, Object value) {
		try {
			redisTemplate.opsForHash().put(key, hashKey, value);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除 hash 表中的内容
	 * @param key
	 * @param hashKeys
	 */
	public void hashRemove(String key, Object ...hashKeys) {
		redisTemplate.opsForHash().delete(key, hashKeys);
	}
	
	/**
	 * 判断 hash 表中是否存在改项的值
	 * @param key
	 * @param hashKey
	 * @return
	 */
	public boolean hashIsExist(String key, String hashKey) {
		return redisTemplate.opsForHash().hasKey(key, hashKey);
	}
	
	//========================= Set ========================
	/**
	 * 获取 Set 中的所有值
	 * @param key
	 * @return
	 */
	public Set<Object> setGet(String key){
		try {
			return redisTemplate.opsForSet().members(key);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 根据value从一个set中查询,是否存在 
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean setHasKey(String key, Object value) {
		try {
			redisTemplate.opsForSet().isMember(key, value);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 将 set 放入缓存
	 * @param key
	 * @param values
	 * @return
	 */
	public long setSet(String key, Object ... values) {
		try {
			return redisTemplate.opsForSet().add(key, values);
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 将 set 放入缓存并设置过期时间
	 * @param key
	 * @param time
	 * @param values
	 * @return
	 */
	public long setSet(String key, long time, Object ... values) {
		try {
			long count = redisTemplate.opsForSet().add(key, values);
			if(time > 0) {
				expire(key, time);
			}
			return count;
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 获取 set 缓存的长度
	 * @param key
	 * @return
	 */
	public long setGetSize(String key) {
		try {
			return redisTemplate.opsForSet().size(key);
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 删除缓存中 set 的值
	 * @param key
	 * @param values
	 * @return
	 */
	public long setRemove(String key, Object ...values) {
		try {
			return redisTemplate.opsForSet().remove(key, values);
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	//========================= List ========================
	/**
	 * 获取缓存中 start ~ end 的 list 的值
	 * @param key
	 * @param start
	 * @param end
	 * @return
	 */
	public List<Object> listGet(String key, long start, long end){
		try {
			return redisTemplate.opsForList().range(key, start, end);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 获取缓存中 list 的长度
	 * @param key
	 * @return
	 */
	public long listGetSize(String key) {
		try {
			return redisTemplate.opsForList().size(key);
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
	/**
	 * 通过索引获取缓存中 list 的值
	 * @param key
	 * @param index
	 * @return
	 */
	public Object listGetValue(String key, long index) {
		try {
			return redisTemplate.opsForList().index(key, index);
		} catch(Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	/**
	 * 通过值获取缓存中 list 的索引
	 * @param key
	 * @param value
	 * @return
	 */
	public long listGetIndex(String key, Object value) {
		try {
			long i = 0;
			List<Object> lists = listGet(key, 0, -1);
			System.out.println(value);
			for(Object list : lists) {
				System.out.println(list);
				if(value.equals(list)) {
					System.out.println("找到了");
					return i;
				} else {
					i++;
				}
			}
			return -1;
		} catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	
	/**
	 * 将 list 放入缓存
	 * @param key
	 * @param value
	 * @return
	 */
	public boolean listSetOne(String key, Object value) {
		try {
			redisTemplate.opsForList().rightPush(key, value);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 将 list 放入缓存并设置过期时间
	 * @param key
	 * @param value
	 * @param time
	 * @return
	 */
	public boolean listSetOne(String key, Object value, long time) {
		try {
			redisTemplate.opsForList().rightPush(key, value);
			if(time > 0) {
				expire(key, time);
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 将 list 放入缓存
	 * @param key
	 * @param list
	 * @return
	 */
	public boolean listSet(String key, List<Object> list) {
		try {
			redisTemplate.opsForList().rightPushAll(key, list);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 将 list 放入缓存并设置过期时间
	 * @param key
	 * @param list
	 * @param time
	 * @return
	 */
	public boolean listSet(String key, List<Object> list, long time) {
		try {
			redisTemplate.opsForList().rightPush(key, list);
			if(time > 0) {
				expire(key, time);
			}
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 通过索引修改缓存中 list 的值
	 * @param key
	 * @param index
	 * @param value
	 * @return
	 */
	public boolean listUpdate(String key, long index, Object value) {
		try {
			redisTemplate.opsForList().set(key, index, value);
			return true;
		} catch(Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	/**
	 * 删除 list 中的 count 个值
	 * @param key
	 * @param count
	 * @param value
	 * @return
	 */
	public long listRemove(String key, long count, Object value) {
		try {
			return redisTemplate.opsForList().remove(key, count, value);
		} catch(Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
	
}
