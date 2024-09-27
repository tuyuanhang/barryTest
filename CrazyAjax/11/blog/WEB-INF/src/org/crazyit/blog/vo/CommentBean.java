package org.crazyit.blog.vo;

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
public class CommentBean
{
	//�����ߵ�����
	private String user;
	//�����˵ĵ����ʼ�
	private String email;
	//�����˵�url
	private String url;
	//���۵�����
	private String content;
	//���۵����ʱ��
	private Date addTime;

	//�޲����Ĺ�����
	public CommentBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public CommentBean(String user , String email , String url ,
		String content , Date addTime)
	{
		this.user = user;
		this.email = email;
		this.url = url;
		this.content = content;
		this.addTime = addTime;
	}

	//user���Ե�setter��getter����
	public void setUser(String user)
	{
		this.user = user;
	}
	public String getUser()
	{
		return this.user;
	}

	//email���Ե�setter��getter����
	public void setEmail(String email)
	{
		this.email = email;
	}
	public String getEmail()
	{
		return this.email;
	}

	//url���Ե�setter��getter����
	public void setUrl(String url)
	{
		this.url = url;
	}
	public String getUrl()
	{
		return this.url;
	}

	//content���Ե�setter��getter����
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}

	//addTime���Ե�setter��getter����
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}
	public Date getAddTime()
	{
		return this.addTime;
	}

}