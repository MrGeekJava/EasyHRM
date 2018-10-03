package com.hrm.entity;

import java.util.Date;

public class Invite implements java.io.Serializable{
	private int inviteId;		//招聘单ID
	private int empId;			//招聘发布人
	private String title;		//招聘名称
	private String type;		//招聘方式
	private double cost;		//预计费用
	private int number;			//招聘人数
	private Date createDate;	//登记日期
	private Date startDate;			//开始日期
	private Date endDate;			//结束日期
	private String responsibility;	//岗位职责
	private String welfare;			//公司福利
	private int status;				//审核状态（0未审批，1,不通过，2通过）
	private String minSalary;		//最低薪资
	private String maxSalary;		//最高薪资
	public int getInviteId() {
		return inviteId;
	}
	public void setInviteId(int inviteId) {
		this.inviteId = inviteId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public Date getStartDate() {
		return startDate;
	}
	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	public Date getEndDate() {
		return endDate;
	}
	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}
	public String getResponsibility() {
		return responsibility;
	}
	public void setResponsibility(String responsibility) {
		this.responsibility = responsibility;
	}
	public String getWelfare() {
		return welfare;
	}
	public void setWelfare(String welfare) {
		this.welfare = welfare;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public String getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(String minSalary) {
		this.minSalary = minSalary;
	}
	public String getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(String maxSalary) {
		this.maxSalary = maxSalary;
	}
	@Override
	public String toString() {
		return "Invite [inviteId=" + inviteId + ", empId=" + empId + ", title=" + title + ", type=" + type + ", cost="
				+ cost + ", number=" + number + ", createDate=" + createDate + ", startDate=" + startDate + ", endDate="
				+ endDate + ", responsibility=" + responsibility + ", welfare=" + welfare + ", status=" + status
				+ ", minSalary=" + minSalary + ", maxSalary=" + maxSalary + "]";
	}
	
	
}
