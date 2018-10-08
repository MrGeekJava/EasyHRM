package com.hrm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		public String selectInvite(Integer pageIndex,@ModelAttribute Invite invite,Model model) {
			System.out.println("invite="+invite);
			PageModel pageModel = new PageModel();
			if(pageIndex != null) {
				pageModel.setPageIndex(pageIndex);
			}
			/**查询招聘信息 */
			List<Invite> invites = inviteService.findInvite(invite,pageModel);
			model.addAttribute("invites", invites);
			model.addAttribute("pageModel", pageModel);
			System.out.println("invites"+invites);
			System.out.println(invites.size());
			return "invite/invite";

			
		}
		
		
		/**
		 * 处理删除招聘请求
		 * @param String ids 需要删除的id字符串
		 * @param ModelAndView mv
		 * */
		@RequestMapping("/invite/removeInvite")
		 public ModelAndView removeInvite(String ids,ModelAndView mv){
			// 分解id字符串
			String[] idArray = ids.split(",");
			for(String id : idArray){
				// 根据id删除员工
				inviteService.removeInviteById(Integer.parseInt(id));
			}
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/invite/selectInvite");
			// 返回ModelAndView
			return mv;
		}
		
}
