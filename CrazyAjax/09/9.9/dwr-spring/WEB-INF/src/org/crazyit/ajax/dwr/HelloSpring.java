package org.crazyit.ajax.dwr;

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
// 服务器处理类
public class HelloSpring
{
	// 服务器处理方法
	public String hello(String name)
	{
		return name + "您好，您已经会调用Spring中的Bean了...";
	}
}
