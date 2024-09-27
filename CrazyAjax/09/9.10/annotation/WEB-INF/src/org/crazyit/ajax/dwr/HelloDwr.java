package org.crazyit.ajax.dwr;

import org.directwebremoting.annotations.*;
import org.directwebremoting.create.*;

import org.crazyit.ajax.dto.*;
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
@RemoteProxy(creator=NewCreator.class , name="hello")
public class HelloDwr
{
	// 定义一个简单的方法
	public String hello(Person p)
	{
		return p.getName() + "，您好！您正在学习使用DWR的注释...";
	}
}
