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
@WebServlet(urlPatterns={"/reg.do"})
public class RegServlet extends HttpServlet
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
		}
		else
		{
			try
			{
				// ����ChatService�����addUser�����������û�
				// ���ע��ɹ�
				if(ChatService.instance().addUser(name , pass))
				{
					request.setAttribute("tip" , "ע��ɹ������¼ϵͳ");
				}
				// ���ע��ʧ��
				else
				{
					request.setAttribute("tip" , "�޷�����ע�ᣬ������");
				}
			}
			catch(Exception e)
			{
				request.setAttribute("tip" , e.getMessage());
			}
		}
		forward("/reg.jsp" ,request , response);
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