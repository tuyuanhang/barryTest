package org.crazyit.extjs.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.*;
import org.json.*;

import org.crazyit.extjs.domain.*;
import org.crazyit.extjs.service.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">Java</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns="/getChildrenNodes")
public class GetChildrenNodesServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		response.setContentType("text/html;charset=utf-8");
		Map<String , Object> result = new HashMap<>();
		// ��ȡid�������
		String mgrIdStr = request.getParameter("id");
		int mgrId = 0;
		try
		{
			// ���������ת��Ϊ����ID
			mgrId = Integer.parseInt(mgrIdStr);
		}
		catch (Exception ex)
		{
		}
		// �����������û��ʵ�����壬�����ڲ鿴�������
		System.out.println("����ID--------" + mgrId);
		// ����ҵ���߼�����ķ������ݾ���ID��ȡ����Ա��
		List<Employee> emps = new EmpService().getEmployees(mgrId);
		result.put("data" , emps);
		PrintWriter out = response.getWriter();
		// ��Map��װ��JSONObject�����
		out.print(new JSONObject(result));
	}
}