package com.hrm.mapper;

import static com.hrm.utils.HrmConstants.ADDRESSBOOKTABLE;

import java.util.List;

import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.springframework.stereotype.Repository;

import com.hrm.entity.Addressbook;
import com.hrm.provider.AddressbookDynaSqlProvider;

@Repository("addressbookMapper")
public interface AddressbookMapper {
	// 查询所有的通讯录信息
	@Select("select * from addressbook")
	List<Addressbook> selectAddressbooks();
	
	// 根据类别查找通讯录的信息
	@Select("select * from addressbook where category = #{category}")
	List<Addressbook> selectAddressbooksByCategory(Integer category);
	
	// 添加数据到通讯录
	@SelectProvider(type=AddressbookDynaSqlProvider.class,method="insertAddressbook")
	void insertAddressbooks(Addressbook addressbook);
	
	@Select("select * from addressbook where name like concat('%',#{0},'%') ")
	List<Addressbook> searchAddressbooks(String name);
	
}
