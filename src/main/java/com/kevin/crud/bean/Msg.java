package com.kevin.crud.bean;

import java.util.HashMap;
import java.util.Map;

/**
 * @author kevin
 * @version 创建时间: 2018年3月21日下午3:27:35
 * @ClassName 类名称
 * @Description 类描述
 */
public class Msg {
	
	//状态码
	private int code;
	//消息
	private String message;
	//返回数据
	private Map<String,Object> data = new HashMap<String,Object>();
	
	public static Msg success() {
		Msg msg = new Msg();
		msg.setCode(100);
		msg.setMessage("请求成功！");
		return msg;
	}
	
	public static Msg failture() {
		Msg msg = new Msg();
		msg.setCode(200);
		msg.setMessage("请求失败！");
		return msg;
	}
	
	public Msg add(String key, Object value) {
		this.getData().put(key, value);
		return this;
	}
	
	public Msg() {
	}

	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Map<String, Object> getData() {
		return data;
	}
	public void setData(Map<String, Object> data) {
		this.data = data;
	}
	
	
}
