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
public class Category
{
	private Integer id;
	private String name;

	// �޲����Ĺ�����
	public Category()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Category(Integer id , String name)
	{
		this.id = id;
		this.name = name;
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

	public boolean equals(Object obj)
	{
		if(this == obj)
		{
			return true;
		}
		if(obj.getClass() == Category.class)
		{
			Category target = (Category)obj;
			return this.getId() == target.getId();
		}
		return false;
	}
	public int hashCode()
	{
		return this.getId();
	}
}