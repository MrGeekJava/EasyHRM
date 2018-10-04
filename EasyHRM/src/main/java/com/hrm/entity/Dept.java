package com.hrm.entity;

import java.util.Date;

public class Dept implements java.io.Serializable{

	private static final long serialVersionUID = 1L;
	
	private Integer deptId;		// deptid
	private Integer superior;	//上级部门ID
	private Integer empId;		//部门负责人ID
	private String name;	// 部门名称
	private String remark;	// 详细描述
	private String duty;	//部门职责说明
	private Integer state;	//部门状态（1.有效，0无效）
	private Date createTime;	//部门创建时间
	public Integer getDeptId() {
		return deptId;
	}

	public void setDeptId(Integer deptId) {
		this.deptId = deptId;
	}

	public Integer getSuperior() {
		return superior;
	}

	public void setSuperior(Integer superior) {
		this.superior = superior;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
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

	public Integer getEmpId() {
		return empId;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}

	
	// 无参数构造器
	public Dept() {
		super();
	}
	// setter和getter方法

	@Override
	public String toString() {
		return "Dept [deptId=" + deptId + ", superior=" + superior + ", name=" + name + ", remark=" + remark + ", duty="
				+ duty + ", state=" + state + ", createTime=" + createTime + ", empId=" + empId + "]";
	}

}