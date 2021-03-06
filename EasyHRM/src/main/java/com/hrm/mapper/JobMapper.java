package com.hrm.mapper;

import static com.hrm.utils.HrmConstants.POSITIONTABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.hrm.entity.Position;
import com.hrm.provider.JobDynaSqlProvider;

@Repository("jobMapper")
public interface JobMapper {

	@Select("select * from "+POSITIONTABLE+" where positionId = #{id}")
	Position selectById(int id);
	
	@Select("select * from "+POSITIONTABLE+" ")
	List<Position> selectAllJob();

	// 动态查询
	@SelectProvider(type=JobDynaSqlProvider.class,method="selectWhitParam")
	List<Position> selectByPage(Map<String, Object> params);
	
	@SelectProvider(type=JobDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
	
	// 根据id删除部门
	@Delete(" delete from "+POSITIONTABLE+" where positionId = #{positionId} ")
	void deleteById(Integer id);
	
	// 动态插入部门
	@SelectProvider(type=JobDynaSqlProvider.class,method="insertJob")
	void save(Position position);
	
	// 动态修改用户
	@SelectProvider(type=JobDynaSqlProvider.class,method="updateJob")
	void update(Position position);
	
}
