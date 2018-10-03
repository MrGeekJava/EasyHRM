package com.hrm.entity;

public class Position implements java.io.Serializable{
	private int positionId;		//职位ID
	private String name;		//职位名称
	private String remark;		//职位描述
	private double minSalary;	//最低薪资
	private double maxSalary;	//最高薪资
	public int getPositionId() {
		return positionId;
	}
	public void setPositionId(int positionId) {
		this.positionId = positionId;
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
	public double getMinSalary() {
		return minSalary;
	}
	public void setMinSalary(double minSalary) {
		this.minSalary = minSalary;
	}
	public double getMaxSalary() {
		return maxSalary;
	}
	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}
	@Override
	public String toString() {
		return "Position [positionId=" + positionId + ", name=" + name + ", remark=" + remark + ", minSalary="
				+ minSalary + ", maxSalary=" + maxSalary + "]";
	}
	
	
	
	
}
