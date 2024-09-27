package org.crazyit.blog.domain;

import java.util.Set;
import java.util.HashSet;
import java.util.Date;

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
public class Blog
{
	// ��ʶ����
	private Integer id;
	// ����
	private String title;
	// ����
	private String content;
	// ���ʱ��
	private Date addTime;
	// ��Blog������ȫ������
	private Set<Comment> comments
		= new HashSet<>();

	// �޲����Ĺ�����
	public Blog()
	{
	}
	// ��ʼ��ȫ����Ա�����Ĺ�����
	public Blog(Integer id , String title
		, String content , Date addTime)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.addTime = addTime;
		this.comments = comments;
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

	// addTime��setter��getter����
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}
	public Date getAddTime()
	{
		return this.addTime;
	}

	// comments��setter��getter����
	public void setComments(Set<Comment> comments)
	{
		this.comments = comments;
	}
	public Set<Comment> getComments()
	{
		return this.comments;
	}
}