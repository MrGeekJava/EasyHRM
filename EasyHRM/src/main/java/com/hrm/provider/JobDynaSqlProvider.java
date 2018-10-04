package com.hrm.provider;

import static com.hrm.utils.HrmConstants.POSITIONTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.entity.Position;


/**
 * @Description: 职位动态SQL语句提供类
 * @author Nier
 *
 */
public class JobDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(POSITIONTABLE);
				if(params.get("job") != null){
					Position job = (Position) params.get("job");
					if(job.getName() != null && !job.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{job.name},'%') ");
					}
				}
			}
		}.toString();
		
		if(params.get("pageModel") != null){
			sql += " limit #{pageModel.firstLimitParam} , #{pageModel.pageSize}  ";
		}
		
		return sql;
	}	
	// 动态查询总数量
	public String count(Map<String, Object> params){
		return new SQL(){
			{
				SELECT("count(*)");
				FROM(POSITIONTABLE);
				if(params.get("job") != null){
					Position job = (Position) params.get("job");
					if(job.getName() != null && !job.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{job.name},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertJob(Position job){
		
		return new SQL(){
			{
				INSERT_INTO(POSITIONTABLE);
				if(job.getName() != null && !job.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(job.getRemark() != null && !job.getRemark().equals("")){
					VALUES("remark", "#{remark}");
				}
				if(job.getMinSalary() != -1){
					VALUES("minSalary", "#{minSalary}");
				}
				if(job.getMaxSalary() != -1){
					VALUES("maxSalary", "#{maxSalary}");
				}
				
			}
		}.toString();
	}
	// 动态更新
	public String updateJob(Position job){
		
		return new SQL(){
			{
				UPDATE(POSITIONTABLE);
				if(job.getName() != null){
					SET(" name = #{name} ");
				}
				if(job.getRemark() != null){
					SET(" remark = #{remark} ");
				}
				if(job.getMinSalary() != -1){
					SET("minSalary = #{minSalary}");
				}
				if(job.getMaxSalary() != -1){
					SET("maxSalary = #{maxSalary}");
				}
				WHERE(" positionId = #{positionId} ");
			}
		}.toString();
	}
	
	
}
