package org.crazyit.ajax.dto;

import org.directwebremoting.annotations.*;

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
@DataTransferObject
public class Person
{
	// ʹ��Annotation��ʶ�������������ǿ�ת��������
	@RemoteProperty
	private String name;
	@RemoteProperty
	private int age;

	// �޲����Ĺ�����
	public Person()
	{
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

	// age��setter��getter����
	public void setAge(int age)
	{
		this.age = age;
	}
	public int getAge()
	{
		return this.age;
	}

}