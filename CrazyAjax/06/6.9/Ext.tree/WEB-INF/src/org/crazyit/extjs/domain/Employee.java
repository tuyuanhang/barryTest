package org.crazyit.extjs.domain;

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
public class Employee
{
	private Integer id;
	private String name;
	private String desc;
	private Integer mgrId;

	// 无参数的构造器
	public Employee()
	{
	}
	// 初始化全部成员变量的构造器
	public Employee(Integer id , String name , String desc , Integer mgrId)
	{
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.mgrId = mgrId;
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

	// desc的setter和getter方法
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		return this.desc;
	}

	// mgrId的setter和getter方法
	public void setMgrId(Integer mgrId)
	{
		this.mgrId = mgrId;
	}
	public Integer getMgrId()
	{
		return this.mgrId;
	}
}