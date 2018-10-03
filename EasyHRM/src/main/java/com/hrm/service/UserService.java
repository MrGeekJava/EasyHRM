package com.hrm.service;

import java.util.List;

import com.hrm.entity.Manager;
import com.hrm.utils.PageModel;

public interface UserService {
	
	/**
	 * 用户登录
	 * @param  loginname
	 * @param  password
	 * @return User对象
	 * */
	Manager login(String loginname,String password);
	
	/**
	 * 根据id查询用户
	 * @param id
	 * @return 用户对象
	 * */
	Manager findUserById(Integer id);
	
	/**
	 * 获得所有用户
	 * @return User对象的List集合
	 * */
	List<Manager> findUser(Manager manager,PageModel pageModel);
	
	/**
	 * 根据id删除用户
	 * @param id
	 * */
	void removeUserById(Integer id);
	
	/**
	 * 修改用户
	 * @param User 用户对象
	 * */
	void modifyUser(Manager manager);
	
	/**
	 * 添加用户
	 * @param User 用户对象
	 * */
	void addUser(Manager manager);

}
