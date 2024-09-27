package org.crazyit.ajax.dwr;

import org.directwebremoting.WebContextFactory;

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
	// 该方法用于将name参数添加为一个HttpSession属性
	public void addSession(String name)
	{
		// 通过WebContextFactory访问Servlet API
		WebContextFactory.get().getSession(true)
			.setAttribute("user" , name);
	}
}
