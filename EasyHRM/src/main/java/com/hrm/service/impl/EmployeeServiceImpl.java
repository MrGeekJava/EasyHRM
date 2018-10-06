package com.hrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.entity.Employee;
import com.hrm.mapper.EmployeeMapper;
import com.hrm.service.EmployeeService;
import com.hrm.utils.PageModel;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeMapper employeeMapper;

	@Transactional(readOnly=true)
	@Override
	public List<Employee> findEmployee(Employee employee,PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		
		params.put("employee", employee);
		int recordCount = employeeMapper.count(params);
	    pageModel.setRecordCount(recordCount);
	    if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
	    
	    System.out.println("pageModel:"+pageModel);
	    
	    List<Employee> employees = employeeMapper.selectByPage(params);
	    return employees;
	}
	
	@Override
	public void removeEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		employeeMapper.deleteById(id);
	}
	
	@Transactional(readOnly=true)
	@Override
	public Employee findEmployeeById(Integer id) {
		// TODO Auto-generated method stub
		return employeeMapper.selectById(id);
	}

	@Override
	public void addEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.save(employee);
	}

	@Override
	public void modifyEmployee(Employee employee) {
		// TODO Auto-generated method stub
		employeeMapper.update(employee);
	}

}
