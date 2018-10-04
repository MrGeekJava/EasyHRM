package com.hrm.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.hrm.entity.Notice;
import com.hrm.mapper.NoticeMapper;
import com.hrm.service.NoticeService;
import com.hrm.utils.PageModel;

@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("noticeService")
public class NoticeServiceImpl implements NoticeService {

	@Autowired
	private NoticeMapper noticeMapper;
	
	@Transactional(readOnly=true)
	@Override
	public List<Notice> findNotice(Notice notice, PageModel pageModel) {
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		params.put("notice", notice);
		int recordCount = noticeMapper.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<Notice> notices = noticeMapper.selectByPage(params);
		 
		return notices;
	}
	
	@Transactional(readOnly=true)
	@Override
	public Notice findNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return noticeMapper.selectById(id);
	}

	@Override
	public void removeNoticeById(Integer id) {
		// TODO Auto-generated method stub
		noticeMapper.deleteById(id);
	}

	@Override
	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeMapper.save(notice);
	}

	@Override
	public void modifyNotice(Notice notice) {
		// TODO Auto-generated method stub
		noticeMapper.update(notice);
	}

}
