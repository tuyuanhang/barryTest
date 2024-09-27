package org.crazyit.message.domain;

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
public class Message
{
	// ��ʶ����
	private Integer id;
	// ��Ϣ����
	private String title;
	// ��Ϣ����
	private String content;
	// ����Ϣ�ķ�����
	private User user;

	// �޲����Ĺ�����
	public Message()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Message(Integer id , String title , String content)
	{
		this.id = id;
		this.title = title;
		this.content = content;
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

	// title��setter��getter����
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// content��setter��getter����
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}

	// user��setter��getter����
	public void setUser(User user)
	{
		this.user = user;
	}
	public User getUser()
	{
		return this.user;
	}
}