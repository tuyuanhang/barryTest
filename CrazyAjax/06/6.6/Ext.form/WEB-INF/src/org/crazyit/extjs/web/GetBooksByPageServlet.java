package org.crazyit.extjs.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;
import org.json.*;

import org.crazyit.extjs.service.*;

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
@WebServlet(urlPatterns="/getBooksByPage")
public class GetBooksByPageServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		Map<String , Object> result = new HashMap<>();
		result.put("success" , true);
		// 获取分页的请求参数
		String start = request.getParameter("start");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		// 下面输出语句没有实际用处，仅仅只是让读者在控制台观察这些参数值
		System.out.println(start + "====="
			+ page + "=====" + limit);
		BookService bs = new BookService();
		// 调用业务逻辑组件的方法，获取数据，并设置成data属性
		result.put("data" , bs.getBooksByPage(Integer.parseInt(start)
			, Integer.parseInt(page) , Integer.parseInt(limit)));
		result.put("total" , bs.getBookCount());
		// 准备输出服务器响应
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 将Map包装成JSONObject后输出
		out.print(new JSONObject(result));
	}
}