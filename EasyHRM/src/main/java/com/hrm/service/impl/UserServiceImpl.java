package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.entity.Manager;
import com.hrm.entity.User;
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
		return null;
	}

	@Override
	public List<Manager> findUser(Manager user, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeUserById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void modifyUser(Manager user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addUser(Manager user) {
		// TODO Auto-generated method stub
		
	}

}
