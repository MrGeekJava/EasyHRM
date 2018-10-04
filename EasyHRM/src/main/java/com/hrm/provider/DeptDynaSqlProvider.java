package com.hrm.provider;


import static com.hrm.utils.HrmConstants.DEPTTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.entity.Dept;

/**
 * @Description: 部门动态SQL语句提供类
 * @author Nier
 *
 */
public class DeptDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(DEPTTABLE);
				if(params.get("dept") != null){
					Dept dept = (Dept) params.get("dept");
					if(dept.getName() != null && !dept.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{dept.name},'%') ");
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
				FROM(DEPTTABLE);
				if(params.get("dept") != null){
					Dept dept = (Dept) params.get("dept");
					if(dept.getName() != null && !dept.getName().equals("")){
						WHERE("  name LIKE CONCAT ('%',#{dept.name},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertDept(Dept dept){
		
		return new SQL(){
			{
				INSERT_INTO(DEPTTABLE);
				if(dept.getName() != null && !dept.getName().equals("")){
					VALUES("name", "#{name}");
				}
				if(dept.getRemark() != null && !dept.getRemark().equals("")){
					VALUES("remark", "#{remark}");
				}
				if(dept.getDuty() != null && !dept.getDuty().equals("")){
					VALUES("duty", "#{duty}");
				}
			}
		}.toString();
	}
	// 动态更新
	public String updateDept(Dept dept){
		
		return new SQL(){
			{
				UPDATE(DEPTTABLE);
				if(dept.getName() != null){
					SET(" name = #{name} ");
				}
				if(dept.getRemark() != null){
					SET(" remark = #{remark} ");
				}
				if(dept.getDuty() != null){
					SET(" duty = #{duty} ");
				}
				
				WHERE(" deptId = #{deptId} ");
			}
		}.toString();
	}


}
