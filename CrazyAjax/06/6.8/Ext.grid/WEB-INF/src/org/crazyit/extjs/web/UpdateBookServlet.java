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
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns="/updateBook")
public class UpdateBookServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		// ��ȡ�������
		String id = request.getParameter("id");
		String name = request.getParameter("name");
		String author = request.getParameter("author");
		String price = request.getParameter("price");
		Map<String , Object> result = new HashMap<>();
		boolean rvtVal = new BookService().updateBook(
			Integer.parseInt(id) , name , author ,
			Double.parseDouble(price));
		result.put("success" , rvtVal);
		result.put("tip" , rvtVal ? "�޸ĳɹ���" : "�޸�ʧ�ܣ�");
		// ׼�������������Ӧ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��Map��װ��JSONObject�����
		out.print(new JSONObject(result));
	}
}