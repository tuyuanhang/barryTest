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
@WebServlet(urlPatterns="/updateNode")
public class UpdateNodeServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		response.setContentType("text/html;charset=utf-8");
		Map<String , Object> result = new HashMap<>();
		String idStr = request.getParameter("id");
		String mgrIdStr = request.getParameter("mgrId");
		int id = Integer.parseInt(idStr);
		// ��ȡ����ID
		int mgrId = Integer.parseInt(mgrIdStr);
		// �����������û��ʵ�����壬�����ڲ鿴�������
		System.out.println("id----" + id + ", mgrId----" + mgrId);
		// ����ҵ���߼��������¸ýڵ�
		new EmpService().updateNode(id , mgrId);
		result.put("tip" , "���³ɹ�");
		PrintWriter out = response.getWriter();
		// ��Map��װ��JSONObject�����
		out.print(new JSONObject(result));
	}
}