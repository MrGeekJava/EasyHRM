package com.hrm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.boot.autoconfigure.batch.BatchProperties.Job;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.entity.Position;
import com.hrm.service.JobService;
import com.hrm.utils.PageModel;

@Controller("jobCtrl")
@RequestMapping("/hrm/job")
public class JobCtrl {

	@Resource(name="jobService")
	private JobService jobService;
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping("/selectJob")
	 public String selectJob(Model model, Integer pageIndex, @ModelAttribute Position job){
		System.out.println("selectJob -->> " + job);
		PageModel pageModel = new PageModel();
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<Position> jobs = jobService.findJob(job, pageModel);
		model.addAttribute("jobs", jobs);
		model.addAttribute("pageModel", pageModel);
		return "job/job";
		
	}
	
	/**
	 * 处理删除职位请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping("/removeJob")
	 public ModelAndView removeJob(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除职位
			jobService.removeJobById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/job/selectJob");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param Job  job  要添加的职位对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping("/addJob")
	 public ModelAndView addJob(
			 String flag,
			 @ModelAttribute Position job,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("job/showAddJob");
		}else{
			// 执行添加操作
			jobService.addJob(job);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/job/selectJob");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理修改职位请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Job job 要修改部门的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping("/updateJob")
	 public ModelAndView updateDpet(
			 String flag,
			 @ModelAttribute Position job,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据id查询部门
			Position target = jobService.findJobById(job.getPositionId());
			// 设置Model数据
			mv.addObject("job", target);
			// 设置跳转到修改页面
			mv.setViewName("job/showUpdateJob");
		}else{
			// 执行修改操作
			jobService.modifyJob(job);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/job/selectJob");
		}
		// 返回
		return mv;
	}
}
