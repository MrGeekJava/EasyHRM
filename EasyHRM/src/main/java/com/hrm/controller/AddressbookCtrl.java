package com.hrm.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.hrm.entity.Addressbook;
import com.hrm.service.AddressbookService;

@Controller("addressbookCtrl")
@RequestMapping("/addressbook")
public class AddressbookCtrl {
	@Resource(name="addressbookService")
	private AddressbookService addressbookService;
	
	/**
	 * 查询所有通讯录信息
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectAddressbooks")
	public String getAddressbooks(Model model) {
		List<Addressbook> list = addressbookService.selectAddressbooks();
		model.addAttribute("addressbooks", list);
		return "addressbook/addressbook";
	}
	
	/**
	 * 根据类别查询通讯录
	 * @param model
	 * @return
	 */
	@RequestMapping("/selectByCategory/{category}")
	public String getAddressbooksByCategory(@PathVariable(value="category")Integer category,Model model) {
		List<Addressbook> list = addressbookService.selectAddressbooksByCategory(category);
		model.addAttribute("addressbooks", list);
		return "addressbook/addressbook";
	}
	
	@RequestMapping("/addAddressbook")
	public String showAddAddressbook(Addressbook addressbook,Model model) {
		return "addressbook/addAddressbook";
	}
	
	@RequestMapping("/insertAddressbook")
	public String insertAddressbook(Addressbook addressbook,Model model) {
		addressbookService.insertAddressbook(addressbook);
		return "redirect:/addressbook/selectAddressbooks";
	}
	@RequestMapping("/searchAddressbook")
	public String searchAddressbook(String key,Model model) {
		List<Addressbook> list = addressbookService.searchAddressbook(key);
		model.addAttribute("addressbooks", list);
		return "addressbook/addressbook";
	}
}
