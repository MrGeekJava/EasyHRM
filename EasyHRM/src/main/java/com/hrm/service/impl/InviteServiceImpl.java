package com.hrm.service.impl;


import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;


import com.hrm.entity.Invite;
import com.hrm.entity.Manager;
import com.hrm.mapper.InviteMapper;
import com.hrm.service.InviteService;
import com.hrm.utils.PageModel;


@Transactional(propagation=Propagation.REQUIRED,isolation=Isolation.DEFAULT)
@Service("inviteService")
public class InviteServiceImpl implements InviteService{
	
	@Autowired
	private InviteMapper inviteMapper;
	
	@Transactional(readOnly=true)
	@Override
	public List<Invite> selectInvite(PageModel pageModel) {
		// TODO Auto-generated method stub
		/** 当前需要分页的总数据条数  */
		Map<String,Object> params = new HashMap<>();
		
		int recordCount = inviteMapper.count(params);
		pageModel.setRecordCount(recordCount);
		if(recordCount > 0){
	        /** 开始分页查询数据：查询第几页的数据 */
		    params.put("pageModel", pageModel);
	    }
		List<Invite> invites = inviteMapper.selectByPage(params);
		 
		return invites;
	}
	
	

	
	
	
	

}
