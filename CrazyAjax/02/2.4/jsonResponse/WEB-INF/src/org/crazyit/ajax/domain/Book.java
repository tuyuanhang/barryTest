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
public class Book
{
	private Integer id;
	private String name;
	private String author;
	private double price;

	// �޲����Ĺ�����
	public Book()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Book(Integer id , String name
		, String author , double price)
	{
		this.id = id;
		this.name = name;
		this.author = author;
		this.price = price;
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

	// author��setter��getter����
	public void setAuthor(String author)
	{
		this.author = author;
	}
	public String getAuthor()
	{
		return this.author;
	}

	// price��setter��getter����
	public void setPrice(double price)
	{
		this.price = price;
	}
	public double getPrice()
	{
		return this.price;
	}

}