package com.hrm.mapper;

import static com.hrm.utils.HrmConstants.EMPLOYEETABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.stereotype.Repository;

import com.hrm.entity.Employee;
import com.hrm.provider.EmployeeDynaSqlProvider;

@Repository("employeeMapper")
public interface EmployeeMapper {

	// 根据参数查询员工总数
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	// 根据参数动态查询员工
	
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="empId",property="empId"),
		@Result(column="codeId",property="codeId"),
		@Result(column="postCode",property="postCode"),
		@Result(column="birthday",property="birthday",javaType=java.util.Date.class),
		@Result(column="deptId",property="dept",
			one=@One(select="com.hrm.mapper.DeptMapper.selectById",
		fetchType=FetchType.EAGER)),
		@Result(column="positionId",property="job",
			one=@One(select="com.hrm.mapper.JobMapper.selectById",
		fetchType=FetchType.EAGER))
	})
	List<Employee> selectByPage(Map<String, Object> params);
		
	// 动态插入员工
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="insertEmployee")
	void save(Employee employee);

	// 根据id删除员工
	@Delete(" delete from "+EMPLOYEETABLE+" where empId = #{empId} ")
	void deleteById(Integer id);
		
	// 根据id查询员工
	@Select("select * from "+EMPLOYEETABLE+" where empId = #{empId}")
	@Results({
		@Result(id=true,column="empId",property="empId"),
		@Result(column="codeId",property="codeId"),
		@Result(column="postCode",property="postCode"),
		@Result(column="birthday",property="birthday",javaType=java.util.Date.class),
		@Result(column="deptId",property="dept",
			one=@One(select="com.hrm.mapper.DeptMapper.selectById",
		fetchType=FetchType.EAGER)),
		@Result(column="positionId",property="job",
			one=@One(select="com.hrm.mapper.JobMapper.selectById",
		fetchType=FetchType.EAGER))
	})
	Employee selectById(Integer id);
		
	// 动态修改员工
	@SelectProvider(type=EmployeeDynaSqlProvider.class,method="updateEmployee")
	void update(Employee employee);
	
}
