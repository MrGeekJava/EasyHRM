package com.hrm.mapper;

import static com.hrm.utils.HrmConstants.NOTICETABLE;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import com.hrm.entity.Notice;

@Repository("noticeMapper")
public interface NoticeMapper {
	
	// 动态查询
//	@SelectProvider(type=NoticeDynaSqlProvider.class,method="selectWhitParam")
//	@Results({
//		@Result(id=true,column="id",property="id"),
//		@Result(column="CREATE_DATE",property="createDate",javaType=java.util.Date.class),
//		@Result(column="USER_ID",property="user",
//			one=@One(select="org.fkit.hrm.dao.UserDao.selectById",
//		fetchType=FetchType.EAGER))
//	})
	List<Notice> selectByPage(Map<String, Object> params);
	
//	@SelectProvider(type=NoticeDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
		
	@Select("select * from "+NOTICETABLE+" where ID = #{id}")
	Notice selectById(int id);
	
	// 根据id删除公告
	@Delete(" delete from "+NOTICETABLE+" where id = #{id} ")
	void deleteById(Integer id);
		
	// 动态插入公告
//	@SelectProvider(type=NoticeDynaSqlProvider.class,method="insertNotice")
	void save(Notice notice);
			
	// 动态修改公告
//	@SelectProvider(type=NoticeDynaSqlProvider.class,method="updateNotice")
	void update(Notice notice);

}
