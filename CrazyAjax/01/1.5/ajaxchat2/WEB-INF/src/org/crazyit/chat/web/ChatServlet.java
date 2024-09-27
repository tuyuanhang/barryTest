package org.crazyit.chat.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;

import org.crazyit.chat.service.*;

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
@WebServlet(urlPatterns={"/chat.do"})
public class ChatServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response)throws IOException,ServletException
	{
		// ����ʹ��GBK�ַ����������������
		request.setCharacterEncoding("utf-8");
		String msg = request.getParameter("chatMsg");
		if ( msg != null && !msg.equals(""))
		{
			// ȡ�õ�ǰ�û�
			String user = (String)request.getSession(true)
				.getAttribute("user");
			// ����ChatService��addMsg�����������Ϣ
			ChatService.instance().addMsg(user , msg);
		}
		// ��ȫ��������Ϣ���ó�request����
		request.setAttribute("chatList" ,
			ChatService.instance().getMsg());
		// ת����chatreply.jspҳ��
		forward("/chatreply.jsp" , request , response);
	}
	// ִ��ת������ķ���
	private void forward(String url , HttpServletRequest request,
	HttpServletResponse response)throws ServletException,IOException
	{
		// ִ��ת��
		request.getRequestDispatcher(url)
			.forward(request,response);
	}
}