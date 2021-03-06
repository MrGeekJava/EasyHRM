package com.hrm.mapper;

import static com.hrm.utils.HrmConstants.DEPTTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.hrm.entity.Dept;
import com.hrm.provider.DeptDynaSqlProvider;

@Repository("depyMapper")
public interface DeptMapper {
	
	// 动态查询
	@SelectProvider(type=DeptDynaSqlProvider.class,method="selectWhitParam")
	List<Dept> selectByPage(Map<String, Object> params);
		
	@SelectProvider(type=DeptDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	@Select("select * from "+DEPTTABLE+" ")
	List<Dept> selectAllDept();
		
	@Select("select * from "+DEPTTABLE+" where deptId = #{deptId}")
	Dept selectById(int deptId);

	// 根据id删除部门
	@Delete(" delete from "+DEPTTABLE+" where deptId = #{deptId} ")
	void deleteById(Integer deptId);
		
	// 动态插入部门
	@SelectProvider(type=DeptDynaSqlProvider.class,method="insertDept")
	void save(Dept dept);
		
	// 动态修改用户
	@SelectProvider(type=DeptDynaSqlProvider.class,method="updateDept")
	void update(Dept dept);

}
