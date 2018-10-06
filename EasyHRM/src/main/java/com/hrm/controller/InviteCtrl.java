package com.hrm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.entity.Invite;
import com.hrm.service.InviteService;
import com.hrm.utils.PageModel;

@Controller("inviteCtrl")
public class InviteCtrl {
		@Resource(name="inviteService")
		private InviteService inviteService;
		/**
		 * 处理查询请求
		 * @param pageIndex 请求的是第几页
		 * 
		 */
		
		@RequestMapping("/invite/selectInvite")
		public String selectInvite(Integer pageIndex,Model model) {
			
			PageModel pageModel = new PageModel();
			if(pageIndex != null) {
				pageModel.setPageIndex(pageIndex);
			}
			/**查询招聘信息 */
			List<Invite> invites = inviteService.selectInvite(pageModel);
			model.addAttribute("invites", invites);
			model.addAttribute("pageModel", pageModel);
			System.out.println("invites"+invites);
			System.out.println(invites.size());
			return "invite/invite";

			
		}
}
