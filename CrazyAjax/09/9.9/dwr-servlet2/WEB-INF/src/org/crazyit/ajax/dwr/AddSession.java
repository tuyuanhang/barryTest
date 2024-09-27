package org.crazyit.ajax.dwr;

import javax.servlet.http.*;

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
public class AddSession
{
	// 服务器处理方法中直接增加HttpSession参数，即可访问HttpSession
	public void addSession(String name , HttpSession sess)
	{
		sess.setAttribute("user" , name);
	}
}
