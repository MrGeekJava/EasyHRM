package com.hrm.provider;


import java.util.Map;
import static com.hrm.utils.HrmConstants.DOCUMENTTABLE;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.entity.Document;

/**
 * @Description: 文件上传动态SQL语句提供类
 * @author Nier
 *
 */
public class DocumentDynaSqlProvider {
	// 分页动态查询
	public String selectWhitParam(Map<String, Object> params){
		String sql =  new SQL(){
			{
				SELECT("*");
				FROM(DOCUMENTTABLE);
				if(params.get("document") != null){
					Document document = (Document) params.get("document");
					if(document.getTitle() != null && !document.getTitle().equals("")){
						WHERE("  title LIKE CONCAT ('%',#{document.title},'%') ");
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
				FROM(DOCUMENTTABLE);
				if(params.get("document") != null){
					Document document = (Document) params.get("document");
					if(document.getTitle() != null && !document.getTitle().equals("")){
						WHERE("  title LIKE CONCAT ('%',#{document.title},'%') ");
					}
				}
			}
		}.toString();
	}	
	// 动态插入
	public String insertDocument(Document document){
		
		return new SQL(){
			{
				INSERT_INTO(DOCUMENTTABLE);
				if(document.getTitle() != null && !document.getTitle().equals("")){
					VALUES("title", "#{title}");
				}
				if(document.getFilename() != null && !document.getFilename().equals("")){
					VALUES("filename", "#{filename}");
				}
				if(document.getRemark() != null && !document.getRemark().equals("")){
					VALUES("remark", "#{remark}");
				}
				if(document.getUser() != null && document.getUser().getManagerId() != -1){
					VALUES("managerId", "#{user.managerId}");
				}
			}
		}.toString();
	}
	
	// 动态更新
	public String updateDocument(Document document){
		
		return new SQL(){
			{
				UPDATE(DOCUMENTTABLE);
				if(document.getTitle() != null && !document.getTitle().equals("")){
					SET(" title = #{title} ");
				}
				if(document.getFilename() != null && !document.getFilename().equals("")){
					SET(" filename = #{filename} ");
				}
				if(document.getRemark() != null && !document.getRemark().equals("")){
					SET("remark = #{remark}");
				}
//				if(document.getUser() != null && document.getUser().getManagerId() != -1){
//					SET("managerId = #{user.managerId}");
//				}
				WHERE(" documentId = #{documentId} ");
			}
		}.toString();
	}
	

}
