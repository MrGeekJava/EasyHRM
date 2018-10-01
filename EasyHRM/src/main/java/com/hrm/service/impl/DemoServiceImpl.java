package com.hrm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hrm.entity.Demo;
import com.hrm.mapper.DemoMapper;
import com.hrm.service.DemoService;
import com.hrm.utils.RedisUtil;

/**
 * 调用 Mapper 接口的实现类
 * 注解：类使用@Service；属性使用@Resource，并显示地取个名（只需要 xxxService 就行）
 * 缓存：查询的时候添加缓存，增加的时候加入数据到已有缓存，删除的时候删除缓存，修改的时候删除缓存
 * @author Mr.Z
 *
 */
@Service("demoService")
public class DemoServiceImpl implements DemoService {
	
	@Resource(name="demoMapper")
	private DemoMapper demoMapper;
	@Resource(name="redisUtil")
	private RedisUtil redisUtil;

	@Override
	public Demo getDemoById(Integer id) {
		return demoMapper.getDemoById(id);
	}

	@Override
	public List<Demo> getAllDemos() {
		List<Demo> demos = null;
		String key = "demos";
		if(redisUtil.isExist(key)) {
			demos = (List)redisUtil.listGet(key, 0, -1);
		} else {
			demos = demoMapper.getAllDemos();
			redisUtil.listSet(key, (List)demos);
		}
		return demos;
	}

	@Override
	public void addDemo(Demo demo) {
		String key = "demos";
		demoMapper.addDemo(demo);
		redisUtil.listSetOne(key, demo);
	}

	@Override
	public void updateDemo(Demo demo) {
		String key = "demos";
		redisUtil.remove(key);
		demoMapper.updateDemo(demo);
	}

	@Override
	public void removeDemo(Integer id) {
		String key = "demos";
		redisUtil.remove(key);
		demoMapper.removeDemo(id);
	}

}
