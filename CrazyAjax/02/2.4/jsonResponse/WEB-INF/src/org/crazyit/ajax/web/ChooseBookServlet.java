package org.crazyit.ajax.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;
import org.json.*;

import org.crazyit.ajax.domain.*;
import org.crazyit.ajax.service.*;

/**
 * Description:
 * <br/>利嫋: <a href="http://www.crazyit.org">決髄Java選男</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns={"/chooseBook"})
public class ChooseBookServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		String idStr = (String)request.getParameter("id");
		int id = idStr == null ? 1 : Integer.parseInt(idStr);
		List<Book> books = new BookService().getBookByCategory(id);
		response.setContentType("text/html;charset=GBK");
		PrintWriter out = response.getWriter();
		out.println(new JSONArray(books));
	}
}