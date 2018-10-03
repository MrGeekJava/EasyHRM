package com.hrm.entity;


public class Notice implements java.io.Serializable{

	private Integer noticeId;		// 公告ID
	private String managerId;		//管理员ID
	private String title;   // 标题
	private String content; // 内容
	private java.util.Date createDate;  // 发布日期
	private User user;		// 发布人
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
	public String getManagerId() {
		return managerId;
	}
	public void setManagerId(String managerId) {
		this.managerId = managerId;
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
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public String toString() {
		return "Notice [noticeId=" + noticeId + ", managerId=" + managerId + ", title=" + title + ", content=" + content
				+ ", createDate=" + createDate + ", user=" + user + "]";
	}
	

}