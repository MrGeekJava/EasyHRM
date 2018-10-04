package com.hrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

	
	@Transactional(readOnly=true)
	@Override
	public List<Dept> findDept(Dept dept,PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("dept", dept);
		int recordCount = deptMapper.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<Dept> depts = deptMapper.selectByPage(params);
		return depts;
	}

	@Override
	public List<Dept> findAllDept() {
		// TODO Auto-generated method stub
		return deptMapper.selectAllDept();
	}

	@Override
	public void removeDeptById(Integer id) {
		// TODO Auto-generated method stub
		deptMapper.deleteById(id);
	}

	@Override
	public void addDept(Dept dept) {
		// TODO Auto-generated method stub
		deptMapper.save(dept);
	}

	@Override
	public Dept findDeptById(Integer id) {
		// TODO Auto-generated method stub
		return deptMapper.selectById(id);
	}

	@Override
	public void modifyDept(Dept dept) {
		// TODO Auto-generated method stub
		deptMapper.update(dept);
	}
	
}
