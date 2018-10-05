package com.hrm.entity;

import org.springframework.web.multipart.MultipartFile;


public class Document implements java.io.Serializable{

	private Integer documentId;		// 编号
	private Integer managerId;		
	private String title;			// 标题
	private String filename;		// 文件名
	private MultipartFile file;		// 文件
	private String remark;			// 描述
	private java.util.Date createDate;	// 上传时间
	private Manager user;				// 上传人
	// 无参数构造器
	public Document() {
		super();
	}
	// setter和getter方法
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	
	public String getFilename() {
		return filename;
	}
	public void setFilename(String filename) {
		this.filename = filename;
	}
	public MultipartFile getFile() {
		return file;
	}
	public void setFile(MultipartFile file) {
		this.file = file;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return this.remark;
	}
	public void setCreateDate(java.util.Date createDate){
		this.createDate = createDate;
	}
	public java.util.Date getCreateDate(){
		return this.createDate;
	}
	public Manager getUser() {
		return user;
	}
	public void setUser(Manager user) {
		this.user = user;
	}
	public Integer getDocumentId() {
		return documentId;
	}
	public void setDocumentId(Integer documentId) {
		this.documentId = documentId;
	}
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", managerId=" + managerId + ", title=" + title + ", filename="
				+ filename + ", file=" + file + ", remark=" + remark + ", createDate=" + createDate + ", user=" + user
				+ "]";
	}
	

}