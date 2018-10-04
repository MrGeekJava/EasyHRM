package com.hrm.mapper;

import static com.hrm.utils.HrmConstants.DOCUMENTTABLE;

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

import com.hrm.entity.Document;
import com.hrm.provider.DocumentDynaSqlProvider;

@Repository("documentMapper")
public interface DocumentMapper {
	
	// 动态查询
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="selectWhitParam")
	@Results({
		@Result(id=true,column="noticeId",property="noticeId"),
		@Result(column="createDate",property="createDate",javaType=java.util.Date.class),
		@Result(column="managerId",property="manager",
			one=@One(select="com.hrm.mapper.NoticeMapper.selectById",
		fetchType=FetchType.EAGER))
	})
	List<Document> selectByPage(Map<String, Object> params);
			
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="count")
	Integer count(Map<String, Object> params);
			
	// 动态插入文档
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="insertDocument")
	void save(Document document);
		
	@Select("select * from "+DOCUMENTTABLE+" where documentId = #{documentId}")
	Document selectById(int id);
	
	// 根据id删除文档
	@Delete(" delete from "+DOCUMENTTABLE+" where documentId = #{documentId} ")
	void deleteById(Integer id);
		
	// 动态修改文档
	@SelectProvider(type=DocumentDynaSqlProvider.class,method="updateDocument")
	void update(Document document);

}
