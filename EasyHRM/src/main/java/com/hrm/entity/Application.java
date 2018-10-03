package com.hrm.entity;

import java.util.Date;

public class Application implements java.io.Serializable{
	private int applicationId;		//申请表ID
	private String title;			//主题
	private String enteringName;	//录入人
	private int empId;				//申请人ID
	private String deptname;		//部门名
	private Date appDate;			//申请时间
	private Date startDate;			//开始时间
	private Date endDate;			//结束时间
	private String cause;			//原因
	private String type;			//申请类型
	public int getApplicationId() {
		return applicationId;
	}
	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getEnteringName() {
		return enteringName;
	}
	public void setEnteringName(String enteringName) {
		this.enteringName = enteringName;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getDeptname() {
		return deptname;
	}
	public void setDeptname(String deptname) {
		this.deptname = deptname;
	}
	public Date getAppDate() {
		return appDate;
	}
	public void setAppDate(Date appDate) {
		this.appDate = appDate;
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
	public String getCause() {
		return cause;
	}
	public void setCause(String cause) {
		this.cause = cause;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return "Application [applicationId=" + applicationId + ", title=" + title + ", enteringName=" + enteringName
				+ ", empId=" + empId + ", deptname=" + deptname + ", appDate=" + appDate + ", startDate=" + startDate
				+ ", endDate=" + endDate + ", cause=" + cause + ", type=" + type + "]";
	}
	
	
	
	
	
	
	
	
}
