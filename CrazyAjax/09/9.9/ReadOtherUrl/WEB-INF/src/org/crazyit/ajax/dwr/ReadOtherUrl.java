package org.crazyit.ajax.dwr;

import org.directwebremoting.WebContextFactory;
import javax.servlet.*;
import java.io.*;

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
public class ReadOtherUrl
{
	// �÷������ڽ�name��������Ϊһ��HttpSession����
	public String read(String name)
		throws ServletException , IOException
	{
		WebContextFactory.get().getHttpServletRequest()
			.setAttribute("name" , name);
		return WebContextFactory.get()
			.forwardToString("/forward.jsp");
	}
}