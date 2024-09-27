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
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2014, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
@WebServlet(urlPatterns="/photoUpload")
@MultipartConfig //上传文件所需的Annotation
public class PhotoUploadServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		// 获取上传的文件
		Part part = request.getPart("photo");
		System.out.println("上传文件的类型：" + part.getContentType());
		System.out.println("上传文件的大小：" + part.getSize());
		// content-disposition中包含了上传文件的文件名
		String disposition = part.getHeader("content-disposition");
		// 获取disposition字符串中filename="子串出现的位置
		int fromIndex = disposition.indexOf("filename=\"") + 10;
		// 截取disposition字符串中从fromIndex开始，到下一个引号（"）中间的内容，
		// 也就是获取原来的文件名。
		String rawFileName = disposition.substring(fromIndex
			, disposition.indexOf("\"" , fromIndex));
		// 生成随机文件名，并添加原始文件名的后缀
		String fileName = UUID.randomUUID()
			+ rawFileName.substring(rawFileName.lastIndexOf("."));
		// 将上传的文件内容写入服务器磁盘
		part.write(getServletContext().getRealPath("/uploadFiles")
			+ "/" + fileName);
		Map<String ,Object> result = new HashMap<>();
		result.put("success" ,true);
		result.put("file" , fileName);
		// 准备输出服务器响应
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// 将Map包装成JSONObject后输出
		out.print(new JSONObject(result));
	}
}