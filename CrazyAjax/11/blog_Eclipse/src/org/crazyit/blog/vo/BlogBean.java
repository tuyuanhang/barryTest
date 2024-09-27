package org.crazyit.blog.vo;

import java.util.Date;
/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class BlogBean
{
	//Blog的ID
	private int id;
	//Blog的标题
	private String title;
	//Blog文章的内容
	private String content;
	//Blog文章的添加时间
	private Date addTime;

	//无参数的构造器
	public BlogBean()
	{
	}
	//初始化全部属性的构造器
	public BlogBean(int id , String title , String content , Date addTime)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.addTime = addTime;
	}

	//id属性的setter和getter方法
	public void setId(int id)
	{
		this.id = id;
	}
	public int getId()
	{
		return this.id;
	}

	//title属性的setter和getter方法
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	//content属性的setter和getter方法
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}

	//addTime属性的setter和getter方法
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}
	public Date getAddTime()
	{
		return this.addTime;
	}
}