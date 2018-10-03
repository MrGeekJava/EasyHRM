package com.hrm.entity;

import org.springframework.web.multipart.MultipartFile;


public class Document implements java.io.Serializable{

	private int documentId;					// 编号
	private int managerId;		
	private String title;			// 标题
	private String fileName;		// 文件名
	private MultipartFile file;		// 文件
	private String remark;			// 描述
	private java.util.Date createDate;	// 上传时间
	private User user;				// 上传人
	// 无参数构造器
	public Document() {
		super();
		// TODO Auto-generated constructor stub
	}
	// setter和getter方法
	public void setTitle(String title){
		this.title = title;
	}
	public String getTitle(){
		return this.title;
	}
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public int getDocumentId() {
		return documentId;
	}
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	@Override
	public String toString() {
		return "Document [documentId=" + documentId + ", managerId=" + managerId + ", title=" + title + ", fileName="
				+ fileName + ", file=" + file + ", remark=" + remark + ", createDate=" + createDate + ", user=" + user
				+ "]";
	}
	

}