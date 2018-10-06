package com.hrm.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.hrm.entity.Dept;
import com.hrm.entity.Employee;
import com.hrm.entity.Position;
import com.hrm.service.DeptService;
import com.hrm.service.EmployeeService;
import com.hrm.service.JobService;
import com.hrm.utils.PageModel;

@Controller("employeeCtrl")
//@RequestMapping("/hrm/employee")
public class EmployeeCtrl {
	
	@Resource(name="employeeService")
	private EmployeeService employeeService;
	@Resource(name="jobService")
	private JobService jobService;
	@Resource(name="deptService")
	private DeptService deptService;
	
	/**
	 * 处理查询请求
	 * @param pageIndex 请求的是第几页
	 * @param String job_id 职位编号
	 * @param String dept_id 部门编号
	 * @param employee 模糊查询参数
	 * @param Model model
	 * */
	@RequestMapping("/employee/selectEmployee")
	 public String selectEmployee(Integer pageIndex, Integer positionId, Integer deptId, @ModelAttribute Employee employee, Model model){
		
		// 模糊查询时判断是否有关联对象传递，如果有，创建并封装关联对象
		this.genericAssociation(positionId, deptId, employee);
		
		// 创建分页对象
		PageModel pageModel = new PageModel();
		// 如果参数pageIndex不为null，设置pageIndex，即显示第几页
		if(pageIndex != null){
			pageModel.setPageIndex(pageIndex);
		}
		
		// 查询职位信息，用于模糊查询
		List<Position> jobs = jobService.findAllJob();
		// 查询部门信息 ，用于模糊查询
		List<Dept> depts = deptService.findAllDept();
		// 查询员工信息    
		List<Employee> employees = employeeService.findEmployee(employee,pageModel);
		
		// 设置Model数据
		model.addAttribute("one", employee);
		model.addAttribute("employees", employees);
		model.addAttribute("jobs", jobs);
		model.addAttribute("depts", depts);
		model.addAttribute("pageModel", pageModel);
		
		// 返回员工页面
		return "employee/employee";
		
	}
	
	/**
	 * 处理添加员工请求
	 * @param String flag 标记， 1表示跳转到添加页面，2表示执行添加操作
	 * @param String job_id 职位编号
	 * @param String dept_id 部门编号
	 * @param Employee employee 接收添加参数
	 * @param ModelAndView mv 
	 * */
	@RequestMapping("/employee/addEmployee")
	 public ModelAndView addEmployee(
			 String flag,
			 Integer positionId,Integer deptId,
			 @ModelAttribute Employee employee,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 查询职位信息
			List<Position> jobs = jobService.findAllJob();
			// 查询部门信息 
			List<Dept> depts = deptService.findAllDept();
			// 设置Model数据
			mv.addObject("jobs", jobs);
			mv.addObject("depts", depts);
			System.out.println("jobs2="+jobs);
			System.out.println("depts2="+depts);
			// 返回添加员工页面
			mv.setViewName("employee/showAddEmployee");
		}else{
			// 判断是否有关联对象传递，如果有，创建关联对象
			this.genericAssociation(positionId, deptId, employee);
			// 添加操作
			employeeService.addEmployee(employee);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/employee/selectEmployee");
		}
		// 返回
		return mv;
		
	}
	
	/**
	 * 处理删除员工请求
	 * @param String ids 需要删除的id字符串
	 * @param ModelAndView mv
	 * */
	@RequestMapping("/employee/removeEmployee")
	 public ModelAndView removeEmployee(String ids,ModelAndView mv){
		// 分解id字符串
		String[] idArray = ids.split(",");
		for(String id : idArray){
			// 根据id删除员工
			employeeService.removeEmployeeById(Integer.parseInt(id));
		}
		// 设置客户端跳转到查询请求
//		mv.setView(new RedirectView("/hrmapp/employee/selectEmployee"));
//		mv.setViewName("forward:/employee/selectEmployee");
		mv.setViewName("redirect:/employee/selectEmployee");
		// 返回ModelAndView
		return mv;
	}
	
	/**
	 * 处理修改员工请求
	 * @param String flag 标记，1表示跳转到修改页面，2表示执行修改操作
	 * @param String job_id 职位编号
	 * @param String dept_id 部门编号
	 * @param Employee employee  要修改员工的对象
	 * @param ModelAndView mv
	 * */
	@RequestMapping(value="/employee/updateEmployee")
	 public ModelAndView updateEmployee(
			 String flag,
			 Integer positionId,Integer deptId,
			 @ModelAttribute Employee employee,
			 ModelAndView mv){
		if(flag.equals("1")){
			// 根据id查询员工
			Employee target = employeeService.findEmployeeById(employee.getEmpId());
			// 需要查询职位信息 
			List<Position> jobs = jobService.findAllJob();
			// 需要查询部门信息 
			List<Dept> depts = deptService.findAllDept();
			// 设置Model数据
			mv.addObject("jobs", jobs);
			mv.addObject("depts", depts);
			mv.addObject("employee", target);
			// 返回修改员工页面
			mv.setViewName("employee/showUpdateEmployee");
		}else{
			// 创建并封装关联对象
			this.genericAssociation(positionId, deptId, employee);
			// 执行修改操作
			employeeService.modifyEmployee(employee);
			// 设置客户端跳转到查询请求
			mv.setViewName("redirect:/employee/selectEmployee");
		}
		// 返回
		return mv;
	}
	
	/**
	 * 由于部门和职位在Employee中是对象关联映射，
	 * 所以不能直接接收参数，需要创建Job对象和Dept对象
	 * */
	private void genericAssociation(Integer positionId,
			Integer deptId,Employee employee){
		if(positionId != null){
			Position job = new Position();
			job.setPositionId(positionId);
			employee.setJob(job);
		}
		if(deptId != null){
			Dept dept = new Dept();
			dept.setDeptId(deptId);
			employee.setDept(dept);
		}
	}

}
