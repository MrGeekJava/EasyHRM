package com.hrm.service;

import java.util.List;

import com.hrm.entity.Addressbook;

public interface AddressbookService {
	/**
	 * 获取所有通讯录信息
	 * @return
	 */
	List<Addressbook> selectAddressbooks();
	
	/**
	 * 根据类别查找通讯录信息
	 * @return
	 */
	List<Addressbook> selectAddressbooksByCategory(Integer category);
	
	/**
	 * 添加数据到通讯录
	 * @param addressbook
	 */
	void insertAddressbook(Addressbook addressbook);
	
	/**
	 * 搜索
	 * @param key
	 * @return
	 */
	List<Addressbook> searchAddressbook(String key);
}
