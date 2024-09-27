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
@WebServlet(urlPatterns="/photoUpload")
@MultipartConfig //�ϴ��ļ������Annotation
public class PhotoUploadServlet extends HttpServlet
{
	public void service(HttpServletRequest request ,
		HttpServletResponse response)
		throws IOException , ServletException
	{
		request.setCharacterEncoding("utf-8");
		// ��ȡ�ϴ����ļ�
		Part part = request.getPart("photo");
		System.out.println("�ϴ��ļ������ͣ�" + part.getContentType());
		System.out.println("�ϴ��ļ��Ĵ�С��" + part.getSize());
		// content-disposition�а������ϴ��ļ����ļ���
		String disposition = part.getHeader("content-disposition");
		// ��ȡdisposition�ַ�����filename="�Ӵ����ֵ�λ��
		int fromIndex = disposition.indexOf("filename=\"") + 10;
		// ��ȡdisposition�ַ����д�fromIndex��ʼ������һ�����ţ�"���м�����ݣ�
		// Ҳ���ǻ�ȡԭ�����ļ�����
		String rawFileName = disposition.substring(fromIndex
			, disposition.indexOf("\"" , fromIndex));
		// ��������ļ����������ԭʼ�ļ����ĺ�׺
		String fileName = UUID.randomUUID()
			+ rawFileName.substring(rawFileName.lastIndexOf("."));
		// ���ϴ����ļ�����д�����������
		part.write(getServletContext().getRealPath("/uploadFiles")
			+ "/" + fileName);
		Map<String ,Object> result = new HashMap<>();
		result.put("success" ,true);
		result.put("file" , fileName);
		// ׼�������������Ӧ
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		// ��Map��װ��JSONObject�����
		out.print(new JSONObject(result));
	}
}