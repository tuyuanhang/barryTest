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
 * <br/>��վ��<a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns="/getBlog")
public class GetBlogServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		// ��ȡ�������
		String blogId = request.getParameter("blogId");
		Map<String , Object> result = new HashMap<>();
		// ��ȡSpring����
		ApplicationContext ctx = WebApplicationContextUtils
			.getWebApplicationContext(getServletContext());
		BlogService bs = (BlogService)ctx.getBean("blogService");
		// ����ҵ���߼�����ķ�������ȡ���ݣ������ó�data����
		result.put("blog" , bs.getBlog(Integer.parseInt(blogId)));
		// ׼�������������Ӧ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��Map��װ��JSONObject�����
		out.print(new JSONObject(result));
	}
}