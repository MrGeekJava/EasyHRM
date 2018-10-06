package com.hrm.service;

import java.util.List;

import com.hrm.entity.Invite;
import com.hrm.utils.PageModel;


public interface InviteService {
		/**
		 * 查询所有的招聘信息
		 * @return Invite对象的集合
		 */
		List<Invite> selectInvite(PageModel pageModel);
}