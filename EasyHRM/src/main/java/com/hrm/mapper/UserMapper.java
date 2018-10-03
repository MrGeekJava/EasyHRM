package com.hrm.mapper;

import static com.hrm.utils.HrmConstants.MANAGERTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hrm.entity.Manager;
import com.hrm.entity.User;

@Repository("userMapper")
public interface UserMapper {
	
	// 根据登录名和密码查询员工
	@Select("select * from "+MANAGERTABLE+" where loginName = #{loginname} and password = #{password}")
	Manager selectByLoginnameAndPassword(
		@Param("loginname") String loginname,
		@Param("password") String password);
		
		// 根据id查询用户
	@Select("select * from "+MANAGERTABLE+" where managerId = #{id}")
	Manager selectById(Integer id);
	
	// 根据id删除用户
	@Delete(" delete from "+MANAGERTABLE+" where managerId = #{id} ")
	void deleteById(Integer id);
			
	// 动态修改用户
//	@SelectProvider(type=UserDynaSqlProvider.class,method="updateUser")
	void update(Manager user);
		
	// 动态查询
//	@SelectProvider(type=UserDynaSqlProvider.class,method="selectWhitParam")
	List<Manager> selectByPage(Map<String, Object> params);
	
	// 根据参数查询用户总数
//	@SelectProvider(type=UserDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	// 动态插入用户
//	@SelectProvider(type=UserDynaSqlProvider.class,method="insertUser")
	void save(Manager manager);

}
