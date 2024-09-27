package org.crazyit.extjs.domain;

/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
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

	// �޲����Ĺ�����
	public Employee()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Employee(Integer id , String name , String desc , Integer mgrId)
	{
		this.id = id;
		this.name = name;
		this.desc = desc;
		this.mgrId = mgrId;
	}

	// id��setter��getter����
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// name��setter��getter����
	public void setName(String name)
	{
		this.name = name;
	}
	public String getName()
	{
		return this.name;
	}

	// desc��setter��getter����
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	public String getDesc()
	{
		return this.desc;
	}

	// mgrId��setter��getter����
	public void setMgrId(Integer mgrId)
	{
		this.mgrId = mgrId;
	}
	public Integer getMgrId()
	{
		return this.mgrId;
	}
}