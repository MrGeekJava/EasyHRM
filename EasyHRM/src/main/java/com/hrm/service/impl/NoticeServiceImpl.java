package com.hrm.service.impl;

import java.util.List;

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
	
	@Override
	public List<Notice> findNotice(Notice notice, PageModel pageModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Notice findNoticeById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void removeNoticeById(Integer id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void addNotice(Notice notice) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyNotice(Notice notice) {
		// TODO Auto-generated method stub

	}

}
