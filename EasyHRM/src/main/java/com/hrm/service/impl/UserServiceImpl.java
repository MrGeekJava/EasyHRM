package com.hrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.entity.Manager;
import com.hrm.mapper.UserMapper;
import com.hrm.service.UserService;
import com.hrm.utils.PageModel;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("userService")
public class UserServiceImpl implements UserService {

	@Autowired
	private UserMapper userMapper;

	
	@Override
	public Manager login(String loginname, String password) {
		return userMapper.selectByLoginnameAndPassword(loginname, password);
	}

	@Override
	public Manager findUserById(Integer id) {
		// TODO Auto-generated method stub
		return userMapper.selectById(id);
	}

	@Transactional(readOnly=true)
	@Override
	public List<Manager> findUser(Manager user,PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("user", user);
		int recordCount = userMapper.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<Manager> users = userMapper.selectByPage(params);
		 
		return users;
	}
	
	
	
	@Override
	public void removeUserById(Integer id) {
		userMapper.deleteById(id);
	}

	@Override
	public void modifyUser(Manager user) {
		System.out.println("进来UserServiceImpl了！！");
		System.out.println("UserServiceImpl"+user);
		userMapper.update(user);
	}

	@Override
	public void addUser(Manager user) {
		userMapper.save(user);
	}

}
