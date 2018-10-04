package com.hrm.provider;


import static com.hrm.utils.HrmConstants.MANAGERTABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.entity.Manager;

/**
 * 
 * @author Nier
 *
 */
public class UserDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(MANAGERTABLE);
				if(params.get("user") != null){
					Manager user = (Manager)params.get("user");
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE("  username LIKE CONCAT ('%',#{user.username},'%') ");
					}
					if(user.getStatus() != null && !user.getStatus().equals("")){
						WHERE(" status LIKE CONCAT ('%',#{user.status},'%') ");
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
				FROM(MANAGERTABLE);
				if(params.get("user") != null){
					Manager user = (Manager)params.get("user");
					if(user.getUsername() != null && !user.getUsername().equals("")){
						WHERE(" username LIKE CONCAT ('%',#{user.username},'%') ");
					}
					if(user.getStatus() != null && !user.getStatus().equals("")){
						WHERE(" status LIKE CONCAT ('%',#{user.status},'%') ");
					}
				}
			}
		}.toString();
	}	
	
	// 动态插入
	public String insertUser(Manager user){
		return new SQL(){
			{
				INSERT_INTO(MANAGERTABLE);
				if(user.getUsername() != null && !user.getUsername().equals("")){
					VALUES("username", "#{username}");
				}
				if(user.getStatus() != null && !user.getStatus().equals("")){
					VALUES("status", "#{status}");
				}
				if(user.getLoginName() != null && !user.getLoginName().equals("")){
					VALUES("loginName", "#{loginName}");
				}
				if(user.getPassword() != null && !user.getPassword().equals("")){
					VALUES("password", "#{password}");
				}
			}
		}.toString();
	}
	// 动态更新
		public String updateUser(Manager user){
			
			return new SQL(){
				{
					UPDATE(MANAGERTABLE);
					if(user.getUsername() != null){
						SET(" username = #{username} ");
					}
					if(user.getLoginName() != null){
						SET(" loginName = #{loginName} ");
					}
					if(user.getPassword()!= null){
						SET(" password = #{password} ");
					}
					if(user.getStatus()!= null){
						SET(" status = #{status} ");
					}
					if(user.getCreateDate()!= null){
						SET(" createDate = #{createDate} ");
					}
					WHERE(" managerId = #{managerId} ");
				}
			}.toString();
		}
}
