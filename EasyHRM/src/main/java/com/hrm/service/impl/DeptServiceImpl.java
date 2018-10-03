package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.entity.Dept;
import com.hrm.mapper.DeptMapper;
import com.hrm.service.DeptService;
import com.hrm.utils.PageModel;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("deptService")
public class DeptServiceImpl implements DeptService {

	@Autowired
	private DeptMapper deptMapper;

	@Override
	public List<Dept> findDept(Dept dept, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Dept> findAllDept() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeDeptById(Integer id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addDept(Dept dept) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Dept findDeptById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyDept(Dept dept) {
		// TODO Auto-generated method stub
		
	}
	
}
