package org.crazyit.blog.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;
import org.json.*;
import org.springframework.web.context.support.*;
import org.springframework.context.*;

import org.crazyit.blog.service.*;
/**
 * Description:
 * <br/>网站：<a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns="/getAllCommentsByBlog")
public class GetAllCommentsByBlogServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		int blogId = Integer.parseInt(request.getParameter("blogId"));
		// 获取分页的请求参数
		String start = request.getParameter("start");
		String page = request.getParameter("page");
		String limit = request.getParameter("limit");
		Map<String , Object> result = new HashMap<>();
		// 获取Spring容器
		ApplicationContext ctx = WebApplicationContextUtils
			.getWebApplicationContext(getServletContext());
		BlogService bs = (BlogService)ctx.getBean("blogService");
		// 调用业务逻辑组件的方法，获取数据，并设置成data属性
		result.put("data" , bs.getCommentsByBlogAndPage(blogId
			, Integer.parseInt(page)
			, Integer.parseInt(limit)));
		result.put("total" , bs.getCommentCountByBlog(blogId));
		// 准备输出服务器响应
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 将Map包装成JSONObject后输出
		out.print(new JSONObject(result));
	}
}