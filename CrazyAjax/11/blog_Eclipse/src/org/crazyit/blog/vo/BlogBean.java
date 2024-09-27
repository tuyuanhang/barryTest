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
public class BlogBean
{
	//Blog��ID
	private int id;
	//Blog�ı���
	private String title;
	//Blog���µ�����
	private String content;
	//Blog���µ����ʱ��
	private Date addTime;

	//�޲����Ĺ�����
	public BlogBean()
	{
	}
	//��ʼ��ȫ�����ԵĹ�����
	public BlogBean(int id , String title , String content , Date addTime)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.addTime = addTime;
	}

	//id���Ե�setter��getter����
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}

	//title���Ե�setter��getter����
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
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