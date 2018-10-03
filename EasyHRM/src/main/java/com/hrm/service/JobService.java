package com.hrm.service;

import java.util.List;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;

import com.hrm.entity.Position;
import com.hrm.utils.PageModel;

public interface JobService {
	
	/**
	 * 获得所有职位
	 * @return Job对象的List集合
	 * */
	List<Position> findAllJob();
	
	List<Position> findJob(Position position,PageModel pageModel);
	
	/**
	 * 根据id删除职位
	 * @param id
	 * */
	public void removeJobById(Integer id);
	
	/**
	 * 添加职位
	 * @param Job 部门对象
	 * */
	void addJob(Position job);
	
	/**
	 * 根据id查询职位
	 * @param id
	 * @return 职位对象
	 * */
	Position findJobById(Integer id);
	
	/**
	 * 修改职位
	 * @param dept 部门对象
	 * */
	void modifyJob(Position job);

}
