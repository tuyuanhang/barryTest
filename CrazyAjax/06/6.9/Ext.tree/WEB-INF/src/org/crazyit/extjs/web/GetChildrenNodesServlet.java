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
@WebServlet(urlPatterns="/getChildrenNodes")
public class GetChildrenNodesServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		response.setContentType("text/html;charset=utf-8");
		Map<String , Object> result = new HashMap<>();
		// 获取id请求参数
		String mgrIdStr = request.getParameter("id");
		int mgrId = 0;
		try
		{
			// 将请求参数转换为经理ID
			mgrId = Integer.parseInt(mgrIdStr);
		}
		catch (Exception ex)
		{
		}
		// 下面输出代码没有实际意义，仅用于查看请求参数
		System.out.println("经理ID--------" + mgrId);
		// 调用业务逻辑组件的方法根据经理ID获取他的员工
		List<Employee> emps = new EmpService().getEmployees(mgrId);
		result.put("data" , emps);
		PrintWriter out = response.getWriter();
		// 将Map包装成JSONObject后输出
		out.print(new JSONObject(result));
	}
}