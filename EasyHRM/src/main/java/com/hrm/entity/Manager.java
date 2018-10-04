package com.hrm.entity;

import java.util.Date;

public class Manager implements java.io.Serializable{
	private int managerId;			//管理员ID
	private String loginName;		//管理员名
	private String username;		//用户名
	private String password;		//密码
	private String status;			//状态（1.正常，0禁用）
	private Date createDate;		//创建时间
	private int role;				//角色
	private String head;			//头像
	private Date lastTime;			//最后登录时间
	public int getManagerId() {
		return managerId;
	}
	public void setManagerId(int managerId) {
		this.managerId = managerId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public int getRole() {
		return role;
	}
	public void setRole(int role) {
		this.role = role;
	}
	public String getHead() {
		return head;
	}
	public void setHead(String head) {
		this.head = head;
	}
	public Date getLastTime() {
		return lastTime;
	}
	public void setLastTime(Date lastTime) {
		this.lastTime = lastTime;
	}
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	@Override
	public String toString() {
		return "Manager [managerId=" + managerId + ", loginName=" + loginName + ", username=" + username + ", password="
				+ password + ", status=" + status + ", createDate=" + createDate + ", role=" + role + ", head=" + head
				+ ", lastTime=" + lastTime + "]";
	}
	
}
