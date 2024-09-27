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
 * <br/>网站: <a href="http://www.crazyit.org">Java</a>
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
		// 获取经理ID
		int mgrId = Integer.parseInt(mgrIdStr);
		// 下面输出代码没有实际意义，仅用于查看请求参数
		System.out.println("id----" + id + ", mgrId----" + mgrId);
		// 调用业务逻辑方法更新该节点
		new EmpService().updateNode(id , mgrId);
		result.put("tip" , "更新成功");
		PrintWriter out = response.getWriter();
		// 将Map包装成JSONObject后输出
		out.print(new JSONObject(result));
	}
}