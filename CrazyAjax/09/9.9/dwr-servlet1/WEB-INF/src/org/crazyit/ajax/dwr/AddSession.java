package org.crazyit.ajax.dwr;

import org.directwebremoting.WebContextFactory;

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
public class AddSession
{
	// �÷������ڽ�name�������Ϊһ��HttpSession����
	public void addSession(String name)
	{
		// ͨ��WebContextFactory����Servlet API
		WebContextFactory.get().getSession(true)
			.setAttribute("user" , name);
	}
}
