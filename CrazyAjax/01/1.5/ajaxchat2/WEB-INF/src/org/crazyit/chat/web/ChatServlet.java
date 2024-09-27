package org.crazyit.chat.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;

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
@WebServlet(urlPatterns={"/chat.do"})
public class ChatServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response)throws IOException,ServletException
	{
		// 设置使用GBK字符集来解析请求参数
		request.setCharacterEncoding("utf-8");
		String msg = request.getParameter("chatMsg");
		if ( msg != null && !msg.equals(""))
		{
			// 取得当前用户
			String user = (String)request.getSession(true)
				.getAttribute("user");
			// 调用ChatService的addMsg来添加聊天消息
			ChatService.instance().addMsg(user , msg);
		}
		// 将全部聊天信息设置成request属性
		request.setAttribute("chatList" ,
			ChatService.instance().getMsg());
		// 转发到chatreply.jsp页面
		forward("/chatreply.jsp" , request , response);
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