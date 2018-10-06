package com.hrm.provider;

import org.apache.ibatis.jdbc.SQL;

import com.hrm.entity.Addressbook;
import com.hrm.entity.Dept;

import static com.hrm.utils.HrmConstants.ADDRESSBOOK;
import static com.hrm.utils.HrmConstants.DEPTTABLE;;

public class AddressbookDynaSqlProvider {
	
	// 动态插入
	public String insertAddressbook(Addressbook addressbook) {

		return new SQL() {
			{
				INSERT_INTO(ADDRESSBOOK);
				if(addressbook.getName() != null && !addressbook.getName().equals("")) {
					VALUES("name","#{name}");
				}
				if(addressbook.getCategory()!=0) {
					VALUES("category","#{category}");
				}
				if(addressbook.getGender()==0 || addressbook.getGender()== 1) {
					VALUES("gender","#{gender}");
				}
				if(addressbook.getCompany() != null && !addressbook.getCompany().equals("")) {
					VALUES("company","#{company}");
				}
				if(addressbook.getSettledPhone() != null && !addressbook.getSettledPhone().equals("")) {
					VALUES("settledPhone","#{settledPhone}");
				}			
				if(addressbook.getTelephone() != null && !addressbook.getTelephone().equals("")) {
					VALUES("telephone","#{telephone}");
				}
				if(addressbook.getEmail() != null && !addressbook.getEmail().equals("")) {
					VALUES("email","#{email}");
				}			
				if(addressbook.getRemark() != null && !addressbook.getRemark().equals("")) {
					VALUES("remark","#{remark}");
				}
			}
		}.toString();
	}

}
