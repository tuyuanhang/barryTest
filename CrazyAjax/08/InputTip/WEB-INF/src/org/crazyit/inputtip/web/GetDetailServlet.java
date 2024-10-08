package org.crazyit.inputtip.web;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

import java.io.*;
import java.util.List;

import org.crazyit.inputtip.service.*;

import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns="/getDetail.do")
public class GetDetailServlet extends HttpServlet
{
	public void service(HttpServletRequest request,
		HttpServletResponse response)
		throws ServletException, java.io.IOException
	{
		// 通过WebApplicationContextUtils工具类获得Spring容器，
		// 通过Spring容器访问容器中的业务逻辑组件
		TipService ts = (TipService)WebApplicationContextUtils
			.getWebApplicationContext(getServletContext())
			.getBean("tipService");
		// 设置解码用的字符集，Ajax的POST请求都采用UTF-8的编码集
		request.setCharacterEncoding("utf-8");
		// 获取请求参数
		String model = request.getParameter("model");
		response.setContentType("text/html;charset=GBK");
		PrintWriter out =  response.getWriter();
		// 输出响应
		out.println(ts.getDescByModel(model));
	}
}