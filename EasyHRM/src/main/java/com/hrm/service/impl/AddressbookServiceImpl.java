package com.hrm.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hrm.entity.Addressbook;
import com.hrm.mapper.AddressbookMapper;
import com.hrm.service.AddressbookService;
@Service("addressbookService")
public class AddressbookServiceImpl implements AddressbookService {
	@Autowired
	private AddressbookMapper addressbookMapper;

	@Override
	public List<Addressbook> selectAddressbooks() {
		return addressbookMapper.selectAddressbooks();
	}

	@Override
	public List<Addressbook> selectAddressbooksByCategory(Integer category) {
		return addressbookMapper.selectAddressbooksByCategory(category);
	}

	@Override
	public void insertAddressbook(Addressbook addressbook) {
		addressbookMapper.insertAddressbooks(addressbook);
	}

	@Override
	public List<Addressbook> searchAddressbook(String key) {
		return addressbookMapper.searchAddressbooks(key);
	}
}
