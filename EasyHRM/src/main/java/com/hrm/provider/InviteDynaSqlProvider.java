package com.hrm.provider;

import static com.hrm.utils.HrmConstants.INVITETABLE;

import java.util.Map;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.entity.Invite;


public class InviteDynaSqlProvider {
	// 分页动态查询
		public String selectWhitParam(Map<String, Object> params){
			String sql =  new SQL(){
				{
					SELECT("*");
					FROM(INVITETABLE);
					if(params.get("invite") != null){
						Invite invite = (Invite)params.get("invite");
						if(invite.getTitle() != null && !invite.getTitle().equals("")){
							WHERE("  title LIKE CONCAT ('%',#{invite.title},'%') ");
						}
					if(invite.getStatus() != null && invite.getStatus() > 0){
						WHERE(" status LIKE CONCAT ('%',#{invite.status},'%') ");
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
					FROM(INVITETABLE);
					if(params.get("invite") != null){
						Invite invite = (Invite)params.get("invite");
						if(invite.getTitle() != null && !invite.getTitle().equals("")){
							WHERE("  title LIKE CONCAT ('%',#{invite.title},'%') ");
						}
						if(invite.getStatus() != null && invite.getStatus() > 0){
							WHERE(" status LIKE CONCAT ('%',#{invite.status},'%') ");
						}
					}
				}
			}.toString();
		}	
		
//		// 动态插入
//		public String insertUser(Manager user){
//			return new SQL(){
//				{
//					INSERT_INTO(INVITETABLE);
//					if(user.getUsername() != null && !user.getUsername().equals("")){
//						VALUES("username", "#{username}");
//					}
//					if(user.getStatus() != null && !user.getStatus().equals("")){
//						VALUES("status", "#{status}");
//					}
//					if(user.getLoginName() != null && !user.getLoginName().equals("")){
//						VALUES("loginName", "#{loginName}");
//					}
//					if(user.getPassword() != null && !user.getPassword().equals("")){
//						VALUES("password", "#{password}");
//					}
//				}
//			}.toString();
//		}
//		// 动态更新
//			public String updateUser(Manager user){
//				
//				return new SQL(){
//					{
//						UPDATE(MANAGERTABLE);
//						if(user.getUsername() != null){
//							SET(" username = #{username} ");
//						}
//						if(user.getLoginName() != null){
//							SET(" loginName = #{loginName} ");
//						}
//						if(user.getPassword()!= null){
//							SET(" password = #{password} ");
//						}
//						if(user.getStatus()!= null){
//							SET(" status = #{status} ");
//						}
//						if(user.getCreateDate()!= null){
//							SET(" createDate = #{createDate} ");
//						}
//						WHERE(" managerId = #{managerId} ");
//					}
//				}.toString();
//			}
}
