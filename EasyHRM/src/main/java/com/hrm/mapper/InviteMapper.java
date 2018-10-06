package com.hrm.mapper;

import static com.hrm.utils.HrmConstants.INVITETABLE;


import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.hrm.entity.Invite;

import com.hrm.provider.InviteDynaSqlProvider;


@Repository("inviteMapper")
public interface InviteMapper {
		
	
	     //查询所有的部门
	     @Select("select * from "+INVITETABLE+" ")
	     List<Invite> selectInvite();
	     
		//根据id查询招聘信息
		@Select("select * from "+INVITETABLE+"where inviteId=#{inviteId}")
		Invite selectById(Integer inviteId);
		
		
		// 根据参数查询招聘总数
		@SelectProvider(type=InviteDynaSqlProvider.class,method="count")
		Integer count(Map<String, Object> params);
		
		// 动态查询
		@SelectProvider(type=InviteDynaSqlProvider.class,method="selectWhitParam")
		List<Invite> selectByPage(Map<String, Object> params);
}
