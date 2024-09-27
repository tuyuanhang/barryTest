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
@WebServlet(urlPatterns="/getBooksByPrefix")
public class GetBooksByPrefixServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		Map<String , Object> result = new HashMap<>();
		result.put("success" , true);
		// ��ȡquery�������
		String rawQuery = request.getParameter("query");
		// ��query��������ת��
		String prefix = new String(rawQuery.getBytes("ISO-8859-1")
			, "utf-8");
		// �����ӡ���û��ʵ����;��ֻ���ö���ÿ��������������
		System.out.println("-----" + prefix);
		BookService bs = new BookService();
		// ����ҵ���߼�����ķ�������ȡ���ݣ������ó�data����
		result.put("data" , bs.getBooksByPrefix(prefix));
		// ׼�������������Ӧ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��Map��װ��JSONObject�����
		out.print(new JSONObject(result));
	}
}