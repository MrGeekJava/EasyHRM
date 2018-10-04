package com.hrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
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
		return jobMapper.selectAllJob();
	}

	@Transactional(readOnly=true)
	@Override
	public List<Position> findJob(Position job, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("job", job);
		int recordCount = jobMapper.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<Position> jobs = jobMapper.selectByPage(params);
		return jobs;
	}
	
	@Override
	public void removeJobById(Integer id) {
		// TODO Auto-generated method stub
		jobMapper.deleteById(id);
	}

	@Override
	public void addJob(Position job) {
		// TODO Auto-generated method stub
		jobMapper.save(job);
	}

	@Transactional(readOnly=true)
	@Override
	public Position findJobById(Integer id) {
		// TODO Auto-generated method stub
		return jobMapper.selectById(id);
	}

	@Override
	public void modifyJob(Position job) {
		// TODO Auto-generated method stub
		jobMapper.update(job);
	}

}
