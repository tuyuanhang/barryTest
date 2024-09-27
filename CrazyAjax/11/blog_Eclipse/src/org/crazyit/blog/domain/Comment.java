package org.crazyit.blog.domain;

import java.util.*;

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
public class Comment
{
	// ��ʶ����
	private Integer id;
	// �������۵��÷�
	private String user;
	// �������۵��û���email
	private String email;
	// �������۵��û���url
	private String url;
	// ��������
	private String content;
	// �������ʱ��
	private Date addTime;
	// ������������Blog
	private Blog blog;

	// �޲����Ĺ�����
	public Comment()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Comment(Integer id , String user , String email
		, String url , String content , Date addTime)
	{
		this.id = id;
		this.user = user;
		this.email = email;
		this.url = url;
		this.content = content;
		this.addTime = addTime;
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

	// user��setter��getter����
	public void setUser(String user)
	{
		this.user = user;
	}
	public String getUser()
	{
		return this.user;
	}

	// email��setter��getter����
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}

	// url��setter��getter����
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getUrl()
	{
		return this.url;
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

	// addTime��setter��getter����
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}
	public Date getAddTime()
	{
		return this.addTime;
	}

	// blog��setter��getter����
	public void setBlog(Blog blog)
	{
		this.blog = blog;
	}
	public Blog getBlog()
	{
		return this.blog;
	}
}