package com.hrm.entity;


import org.springframework.format.annotation.DateTimeFormat;

public class Employee implements java.io.Serializable{

	private Integer empId;			// 员工Id
	private Dept dept;			// 部门
	private Position job;		//职位
	private String name;		// 员工名称
	private Integer gender;			//员工性别（1男，0女）
	private String codeId;		//身份证
	private String address;		// 地址
	private String postCode;	// 邮政编码
	private String telephone;	// 手机号码
	private String email;		// 邮箱
	private String party;		// 政治面貌
	private String major;		//专业
	
	
	/**
	 *  使用@ModelAttribute接收参数时
	 *  form表单中有日期,Spring不知道该如何转换,
	 *  要在实体类的日期属性上加@DateTimeFormat(pattern="yyyy-MM-dd")注解 
	 */
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private java.util.Date birthday;	//生日
	private String race;				// 名族
	private double basePay;				//基本工资
	private String remark;				// 备注
	// 无参数构造器
	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}
	// setter和getter方法
	
	public Integer getEmpId() {
		return empId;
	}
	public Dept getDept() {
		return dept;
	}

	public void setDept(Dept dept) {
		this.dept = dept;
	}

	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public String getName() {
		return name;
	}
	
	public Position getJob() {
		return job;
	}

	public void setJob(Position job) {
		this.job = job;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Integer getGender() {
		return gender;
	}
	public void setGender(Integer gender) {
		this.gender = gender;
	}
	public String getCodeId() {
		return codeId;
	}
	public void setCodeId(String codeId) {
		this.codeId = codeId;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getParty() {
		return party;
	}
	public void setParty(String party) {
		this.party = party;
	}
	public String getMajor() {
		return major;
	}
	public void setMajor(String major) {
		this.major = major;
	}
	public java.util.Date getBirthday() {
		return birthday;
	}
	public void setBirthday(java.util.Date birthday) {
		this.birthday = birthday;
	}
	public String getRace() {
		return race;
	}
	public void setRace(String race) {
		this.race = race;
	}
	public double getBasePay() {
		return basePay;
	}
	public void setBasePay(double basePay) {
		this.basePay = basePay;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", dept=" + dept + ", job=" + job + ", name=" + name + ", gender=" + gender
				+ ", codeId=" + codeId + ", address=" + address + ", postCode=" + postCode + ", telephone=" + telephone
				+ ", email=" + email + ", party=" + party + ", major=" + major + ", birthday=" + birthday + ", race="
				+ race + ", basePay=" + basePay + ", remark=" + remark + "]";
	}

}