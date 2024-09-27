package org.crazyit.extjs.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;
import org.json.*;

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
@WebServlet(urlPatterns="/simplePro")
public class SimpleProServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		// ��ȡ�������
		String name = request.getParameter("name");
		int a = 5 / 0;
		Map<String , Object> result = new HashMap<>();
		if(name.equals("fkjava"))
		{
			result.put("success" , true);
			result.put("msg" , "��ϲ�㣬��¼�ɹ���");
		}
		else
		{
			result.put("success" , false);
			result.put("msg" , "�Բ��������û��������벻ƥ�䣡");
		}
		// ׼�������������Ӧ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��Map��װ��JSONObject�����
		out.print(new JSONObject(result));
	}
}