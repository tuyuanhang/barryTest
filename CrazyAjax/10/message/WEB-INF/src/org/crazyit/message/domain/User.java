package org.crazyit.message.domain;

import java.util.Set;
import java.util.HashSet;

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
public class User
{
	// ��ʶ����
	private Integer id;
	// �û����û���
	private String name;
	// �û�������
	private String pass;
	// ���û���������ȫ����Ϣ
	private Set<Message> messages
		= new HashSet<>();

	// �޲����Ĺ�����
	public User()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public User(Integer id , String name , String pass)
	{
		this.id = id;
		this.name = name;
		this.pass = pass;
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

	// pass��setter��getter����
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public String getPass()
	{
		return this.pass;
	}

	// messages��setter��getter����
	public void setMessages(Set<Message> messages)
	{
		this.messages = messages;
	}
	public Set<Message> getMessages()
	{
		return this.messages;
	}

}