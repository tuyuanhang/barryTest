<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author yeeku.H.lee kongyeeku@163.com
version 1.0
Copyright (C), 2001-2014, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>
<%@ page contentType="text/html; charset=GBK" language="java" %>
<%
	// ��ȡ�������user
	String user = request.getParameter("user");
	String pass = request.getParameter("pass");
	// ʵ��Ӧ���д˴��ɵ���ҵ�������ҵ�񷽷������˴�����ʾ��Ajax������
	// ����ֱ��Ҫ��userΪfkjava��passΪcrazyit�ſ�������¼��
	if(user.equals("fkjava")
		&& pass.equals("crazyit"))
	{
		out.println("��¼�ɹ���");
	}
	else
	{
		out.println("��¼ʧ�ܣ�");
	}
%>