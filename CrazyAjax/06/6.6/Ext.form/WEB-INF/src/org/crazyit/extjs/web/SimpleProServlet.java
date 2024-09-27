package org.crazyit.extjs.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;
import org.json.*;

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
@WebServlet(urlPatterns="/simplePro")
public class SimpleProServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		// 获取请求参数
		String name = request.getParameter("name");
		int a = 5 / 0;
		Map<String , Object> result = new HashMap<>();
		if(name.equals("fkjava"))
		{
			result.put("success" , true);
			result.put("msg" , "恭喜你，登录成功！");
		}
		else
		{
			result.put("success" , false);
			result.put("msg" , "对不起，您的用户名、密码不匹配！");
		}
		// 准备输出服务器响应
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 将Map包装成JSONObject后输出
		out.print(new JSONObject(result));
	}
}