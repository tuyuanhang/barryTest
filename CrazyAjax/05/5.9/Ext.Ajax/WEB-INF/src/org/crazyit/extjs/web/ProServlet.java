package org.crazyit.extjs.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

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
@WebServlet(urlPatterns="/pro")
public class ProServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		// 获取请求参数
		String user = request.getParameter("user");
		String[] books = request.getParameterValues("books");
		// 生成HTML字符串响应
		out.println(user + ",您好，现在时间是:" + new java.util.Date());
		out.println("<br />您喜欢的图书如下：");
		out.println("<ol>");
		for(int i = 0 ; i < books.length ; i++)
		{
			out.println("<li>" + books[i] + "</li>");
		}
		out.println("</ol>");
	}
}