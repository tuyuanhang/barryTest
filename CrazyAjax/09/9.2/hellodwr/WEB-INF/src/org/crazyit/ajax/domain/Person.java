package org.crazyit.ajax.domain;

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
public class Person
{
	// ˽��Field
	private String name;
	// �޲����Ĺ�����
	public Person()	{}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Person(String name)
	{
		this.name = name;
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
}