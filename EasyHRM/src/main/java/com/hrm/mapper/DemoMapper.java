package com.hrm.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.hrm.entity.Demo;

/**
 * 操作数据库的接口
 * 存放：数据库操作的方法
 * 规范：方法名要简单易懂（首字母小写，后面用驼峰表示法）
 * 方法开头：	查询--getXXX();增加--addXXX();修改--updateXXX();删除--removeXXX()
 * 注解：使用@Repository，显式地取个名（类名首字母小写）
 * @author Mr.Z
 *
 */
@Repository("demoMapper")
public interface DemoMapper {
	
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
