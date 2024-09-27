package org.crazyit.message.domain;

import java.util.Set;
import java.util.HashSet;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class User
{
	// 标识属性
	private Integer id;
	// 用户的用户名
	private String name;
	// 用户的密码
	private String pass;
	// 该用户所发布的全部消息
	private Set<Message> messages
		= new HashSet<>();

	// 无参数的构造器
	public User()
	{
	}
	// 初始化全部成员变量的构造器
	public User(Integer id , String name , String pass)
	{
		this.id = id;
		this.name = name;
		this.pass = pass;
	}

	// id的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// name的setter和getter方法
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// pass的setter和getter方法
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	// messages的setter和getter方法
	public void setMessages(Set<Message> messages)
	{
		this.messages = messages;
	}
	public Set<Message> getMessages()
	{
		return this.messages;
	}

}