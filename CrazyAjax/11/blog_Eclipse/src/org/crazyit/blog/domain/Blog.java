package org.crazyit.blog.domain;

import java.util.Set;
import java.util.HashSet;
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
public class Blog
{
	// 标识属性
	private Integer id;
	// 标题
	private String title;
	// 内容
	private String content;
	// 添加时间
	private Date addTime;
	// 该Blog关联的全部评论
	private Set<Comment> comments
		= new HashSet<>();

	// 无参数的构造器
	public Blog()
	{
	}
	// 初始化全部成员变量的构造器
	public Blog(Integer id , String title
		, String content , Date addTime)
	{
		this.id = id;
		this.title = title;
		this.content = content;
		this.addTime = addTime;
		this.comments = comments;
	}

	// id的setter和getter方法
	public void setId(Integer id)
	{
		this.id = id;
	}
	public Integer getId()
	{
		return this.id;
	}

	// title的setter和getter方法
	public void setTitle(String title)
	{
		this.title = title;
	}
	public String getTitle()
	{
		return this.title;
	}

	// content的setter和getter方法
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getContent()
	{
		return this.content;
	}

	// addTime的setter和getter方法
	public void setAddTime(Date addTime)
	{
		this.addTime = addTime;
	}
	public Date getAddTime()
	{
		return this.addTime;
	}

	// comments的setter和getter方法
	public void setComments(Set<Comment> comments)
	{
		this.comments = comments;
	}
	public Set<Comment> getComments()
	{
		return this.comments;
	}
}