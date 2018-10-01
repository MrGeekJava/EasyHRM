package com.hrm.entity;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 *  实体类Demo
 * 存放：实体类属性、getter、setter方法
 * 规范：属性名与数据库字段名相同，基本数据类型统一使用其包装类（如：原来是 int 的使用 Integer），属性后面加备注
 * 时间格式统一为：yyyy-MM-dd 或 yyyy-MM-dd hh:mm:ss
 * @author Mr.Z		注明author
 *
 */
public class Demo implements Serializable{
	
	//对实体类进行序列化
	private static final long serialVersionUID = 1L;
	
	private Integer id;					//Demo的ID
	private String name;				//Demo的名字
	private String hobits;		//Demo的爱好
	@DateTimeFormat(pattern="yyyy-MM-dd")		//时间格式化
	private Date birthday;				//Demo的生日
	

	public Demo() {
		
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHobits() {
		return hobits;
	}
	public void setHobits(String hobits) {
		this.hobits = hobits;
	}
	public Date getBirthday() {
		return birthday;
	}
	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	@Override
	public String toString() {
		return "Demo [id=" + id + ", name=" + name + ", hobits=" + hobits + ", birthday=" + birthday + "]";
	}
	
}
