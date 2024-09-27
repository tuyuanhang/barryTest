package org.crazyit.chat.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.IOException;

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
@WebServlet(urlPatterns={"/login.do"})
public class LoginServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response)throws IOException,ServletException
	{
		// ����ʹ��GBK�ַ����������������
		request.setCharacterEncoding("GBK");
		// ȡ���û��������������
		String name = request.getParameter("name");
		String pass = request.getParameter("pass");
		// ���з������˵�����У��
		if (name == null || name.trim().equals("")
			|| pass == null || pass.trim().equals(""))
		{
			request.setAttribute("tip" , "�û��������붼����Ϊ��");
			forward("/index.jsp" , request , response);
		}
		else
		{
			// ����ChatService�����validLogin��������֤��¼
			// �����¼�ɹ�
			if (ChatService.instance().validLogin(name , pass))
			{
				request.getSession(true).setAttribute("user" , name);
				request.setAttribute("msg" , ChatService.instance().getMsg());
				forward("/chat.jsp" ,request , response);
			}
			// �����¼ʧ��
			else
			{
				request.setAttribute("error" , "�û��������벻ƥ��");
				forward("/index.jsp" , request , response);
			}
		}
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