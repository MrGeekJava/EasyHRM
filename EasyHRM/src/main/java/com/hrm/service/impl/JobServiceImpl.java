package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.entity.Position;
import com.hrm.mapper.JobMapper;
import com.hrm.service.JobService;
import com.hrm.utils.PageModel;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("jobService")
public class JobServiceImpl implements JobService {

	@Autowired
	private JobMapper jobMapper;
	
	@Override
	public List<Position> findAllJob() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Position> findJob(Position job, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeJobById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addJob(Position job) {
		// TODO Auto-generated method stub

	}

	@Override
	public Position findJobById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyJob(Position job) {
		// TODO Auto-generated method stub

	}

}
