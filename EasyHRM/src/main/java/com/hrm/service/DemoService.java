package com.hrm.service;

import java.util.List;

import com.hrm.entity.Demo;

/**
 * 定义调用Mapper方法的接口
 * 规范同Mapper接口类
 * @author Mr.Z
 *
 */
public interface DemoService {
	
//	通过ID获取Demo
	public Demo getDemoById(Integer id);
	
//	获取所有Demo
	public List<Demo> getAllDemos();
	
//	增加一个Demo
	public void addDemo(Demo demo);
	
//	修改一个Demo
	public void updateDemo(Demo demo);
	
//	删除一个Demo
	public void removeDemo(Integer id);

}
