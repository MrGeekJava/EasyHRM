package com.hrm.entity;

public class Addressbook implements java.io.Serializable{
	private int addressBookId;		//外部通讯人员ID
	private String name;			//外部通讯人员名
	private int category;			//外部通讯人员分类
	private int gender;				//性别（1男，2女）
	private String company;			//所属单位
	private String settledPhone;	//固定电话
	private String telephone;		//移动电话
	private String email;			//邮箱
	private String  remark;			//备注
	
	public Addressbook() {
	}

	public Addressbook(int addressBookId, String name, int category, int gender, String company, String settledPhone,
			String telephone, String email, String remark) {
		this.addressBookId = addressBookId;
		this.name = name;
		this.category = category;
		this.gender = gender;
		this.company = company;
		this.settledPhone = settledPhone;
		this.telephone = telephone;
		this.email = email;
		this.remark = remark;
	}

	public int getAddressBookId() {
		return addressBookId;
	}

	public void setAddressBookId(int addressBookId) {
		this.addressBookId = addressBookId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCategory() {
		return category;
	}

	public void setCategory(int category) {
		this.category = category;
	}

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
		this.gender = gender;
	}

	public String getCompany() {
		return company;
	}

	public void setCompany(String company) {
		this.company = company;
	}

	public String getSettledPhone() {
		return settledPhone;
	}

	public void setSettledPhone(String settledPhone) {
		this.settledPhone = settledPhone;
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

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	@Override
	public String toString() {
		return "Addressbook [addressBookId=" + addressBookId + ", name=" + name + ", category=" + category + ", gender="
				+ gender + ", company=" + company + ", settledPhone=" + settledPhone + ", telephone=" + telephone
				+ ", email=" + email + ", remark=" + remark + "]";
	}
	
}
