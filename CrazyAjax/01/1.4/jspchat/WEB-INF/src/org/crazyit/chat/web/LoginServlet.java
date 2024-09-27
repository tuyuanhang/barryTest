package org.crazyit.chat.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

import org.crazyit.chat.service.*;

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
@WebServlet(urlPatterns={"/login.do"})
public class LoginServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response)throws IOException,ServletException
	{
		// 设置使用GBK字符集来解析请求参数
		request.setCharacterEncoding("GBK");
		// 取得用户的两个请求参数
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		// 进行服务器端的输入校验
		if (name == null || name.trim().equals("")
			|| pass == null || pass.trim().equals(""))
		{
			request.setAttribute("tip" , "用户名和密码都不能为空");
			forward("/index.jsp" , request , response);
		}
		else
		{
			// 调用ChatService对象的validLogin方法来验证登录
			// 如果登录成功
			if (ChatService.instance().validLogin(name , pass))
			{
				request.getSession(true).setAttribute("user" , name);
				request.setAttribute("msg" , ChatService.instance().getMsg());
				forward("/chat.jsp" ,request , response);
			}
			// 如果登录失败
			else
			{
				request.setAttribute("error" , "用户名和密码不匹配");
				forward("/index.jsp" , request , response);
			}
		}
	}
	// 执行转发请求的方法
	private void forward(String url , HttpServletRequest request,
		HttpServletResponse response)throws ServletException,IOException
	{
		// 执行转发
		request.getRequestDispatcher(url)
			.forward(request,response);
	}
}