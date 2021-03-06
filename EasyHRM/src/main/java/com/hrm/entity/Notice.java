package com.hrm.entity;


public class Notice implements java.io.Serializable{

	private Integer noticeId;		// 公告ID
	private Manager user;		//管理员ID
	private String title;   // 标题
	private String content; // 内容
	private java.util.Date createDate;  // 发布日期
	// 无参数构造器
	public Notice() {
		super();
		// TODO Auto-generated constructor stub
	}
	// setter和getter方法
	public Integer getNoticeId() {
		return noticeId;
	}
	public void setNoticeId(Integer noticeId) {
		this.noticeId = noticeId;
	}
	public Manager getUser() {
		return user;
	}
	public void setUser(Manager user) {
		this.user = user;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public java.util.Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(java.util.Date createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", user=" + user + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + "]";
	}

}