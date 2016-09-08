package com.lance.mybatis.utils;

import java.io.UnsupportedEncodingException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * 获取配置文件的值
 * 
 * @author Administrator
 *
 */
@Component("UTF-8")
public class ItemProperties {

    @Value("${com.lance.name}")
    private String name;

    @Value("${com.lance.title}")
    private String title;

    @Value("${com.lance.desc}")
    private String desc;

    @Value("${com.lance.value}")
    private String value;

    @Value("${com.lance.number}")
    private String number;

    @Value("${com.lance.bignumber}")
    private String bignumber;

    @Value("${com.lance.test1}")
    private String test1;

    @Value("${com.lance.test2}")
    private String test2;

	public String getName() {
		try {
			return new String(name.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return "";
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTitle() {
		try {
			return new String(title.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return "";
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDesc() {
		try {
			return new String(desc.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return "";
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}

	public String getValue() {
		try {
			return new String(value.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return "";
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getNumber() {
		try {
			return new String(number.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return "";
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getBignumber() {
		try {
			return new String(bignumber.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return "";
	}

	public void setBignumber(String bignumber) {
		this.bignumber = bignumber;
	}

	public String getTest1() {
		try {
			return new String(test1.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return "";
	}

	public void setTest1(String test1) {
		this.test1 = test1;
	}

	public String getTest2() {
		try {
			return new String(test2.getBytes("iso-8859-1"), "utf-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		};
		return "";
	}

	public void setTest2(String test2) {
		this.test2 = test2;
	}
    
}
