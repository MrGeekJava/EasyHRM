package com.hrm.entity;

import java.util.Date;

public class Dept implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer deptId;		// id
	private String name;	// 部门名称
	private String remark;	// 详细描述
	private String duty;
	private Integer state;
	private Date createTime;
	private Integer positionId;
	
	// 无参数构造器
	public Dept() {
		super();
	}
	// setter和getter方法
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}
	public void setRemark(String remark){
		this.remark = remark;
	}
	public String getRemark(){
		return this.remark;
	}
	public Integer getDeptId() {
		return deptId;
	}
	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}
	public String getDuty() {
		return duty;
	}
	public void setDuty(String duty) {
		this.duty = duty;
	}
	public Integer getState() {
		return state;
	}
	public void setState(Integer state) {
		this.state = state;
	}
	public Date getCreateTime() {
		return createTime;
	}
	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}
	public Integer getPositionId() {
		return positionId;
	}
	public void setPositionId(Integer positionId) {
		this.positionId = positionId;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", name=" + name + ", remark=" + remark + ", duty=" + duty + ", state="
				+ state + ", createTime=" + createTime + ", positionId=" + positionId + "]";
	}
	

}