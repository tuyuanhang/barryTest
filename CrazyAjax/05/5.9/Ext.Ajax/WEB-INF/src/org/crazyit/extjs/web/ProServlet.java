package org.crazyit.extjs.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

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
@WebServlet(urlPatterns="/pro")
public class ProServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		// ��ȡ�������
		String user = request.getParameter("user");
		String[] books = request.getParameterValues("books");
		// ����HTML�ַ�����Ӧ
		out.println(user + ",���ã�����ʱ����:" + new java.util.Date());
		out.println("<br />��ϲ����ͼ�����£�");
		out.println("<ol>");
		for(int i = 0 ; i < books.length ; i++)
		{
			out.println("<li>" + books[i] + "</li>");
		}
		out.println("</ol>");
	}
}