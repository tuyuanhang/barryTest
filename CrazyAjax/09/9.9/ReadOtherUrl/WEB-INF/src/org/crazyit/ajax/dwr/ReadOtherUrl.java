package org.crazyit.ajax.dwr;

import org.directwebremoting.WebContextFactory;
import javax.servlet.*;
import java.io.*;

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
public class ReadOtherUrl
{
	// 该方法用于将name参数添加为一个HttpSession属性
	public String read(String name)
		throws ServletException , IOException
	{
		WebContextFactory.get().getHttpServletRequest()
			.setAttribute("name" , name);
		return WebContextFactory.get()
			.forwardToString("/forward.jsp");
	}
}
