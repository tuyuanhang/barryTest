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
	// ��ȡ�������favorite
	String hdchar = request.getParameter("favorite");
	System.out.println(hdchar);
	// ������������apple��ǰ�����ַ��������apple
	if ("apple".startsWith(hdchar))
	{
		out.println("apple");
	}
	// ������������banana��ǰ�����ַ��������banana
	else if("banana".startsWith(hdchar))
	{
		out.println("banana");
	}
	// ������������peach��ǰ�����ַ��������peach
	else if("peach".startsWith(hdchar))
	{
		out.println("peach");
	}
	// �������other fruit
	else
	{
		out.println("other fruit");
	}
%>