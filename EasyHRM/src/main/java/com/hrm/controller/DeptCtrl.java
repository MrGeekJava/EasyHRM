package com.hrm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.entity.Dept;
import com.hrm.service.DeptService;
import com.hrm.utils.PageModel;

@Controller("deptCtrl")
//@RequestMapping("/hrm")
public class DeptCtrl {
	
	@Resource(name="deptService")
	private DeptService deptService;
	
	/**
	 * 处理/login请求
	 * */
	@RequestMapping("/dept/selectDept")
	public String selectDept(Model model, Integer pageIndex, @ModelAttribute Dept dept){
		
		PageModel pageModel = new PageModel();
		
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		/** 查询用户信息     */
		List<Dept> depts = deptService.findDept(dept, pageModel);
		model.addAttribute("depts", depts);
		model.addAttribute("pageModel", pageModel);
		return "dept/dept";
		
	}
	
	/**
	 * 处理删除部门请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping("/dept/removeDept")
	 public ModelAndView removeDept(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除部门
			deptService.removeDeptById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
		mv.setViewName("redirect:/dept/selectDept");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理添加请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param Dept  dept  要添加的部门对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping("/dept/addDept")
	 public ModelAndView addDept(
			 String flag,
			 @ModelAttribute Dept dept,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 设置跳转到添加页面
			mv.setViewName("dept/showAddDept");
		}else{
			// 执行添加操作
			deptService.addDept(dept);
			System.out.println("addDept"+dept);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/dept/selectDept");
		}
		// 返回
		return mv;
	}
	
	
	/**
	 * 处理修改部门请求
	 * @param String flag 标记， 1表示跳转到修改页面，2表示执行修改操作
	 * @param Dept dept 要修改部门的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping("/dept/updateDept")
	 public ModelAndView updateDpet(
			 String flag,
			 @ModelAttribute Dept dept,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据id查询部门
			Dept target = deptService.findDeptById(dept.getDeptId());
			System.out.println("dept.getDeptId()"+dept.getDeptId());
			// 设置Model数据
			mv.addObject("dept", target);
			// 设置跳转到修改页面
			mv.setViewName("dept/showUpdateDept");
		}else{
			// 执行修改操作
			deptService.modifyDept(dept);
			System.out.println("updateDpet"+dept);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/dept/selectDept");
		}
		// 返回
		return mv;
	}

}
