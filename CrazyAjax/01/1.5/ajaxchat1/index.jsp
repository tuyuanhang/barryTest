<%--
��վ: <a href="http://www.crazyit.org">���Java����</a>
author yeeku.H.lee kongyeeku@163.com
version 1.0
Copyright (C), 2001-2014, yeeku.H.Lee
This program is protected by copyright laws.
Program Name:
Date: 
--%>

<%@ page contentType="text/html;charset=GBK" errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
	<meta name="author" content="Yeeku.H.Lee(CrazyIt.org)" />
	<meta http-equiv="Content-Type" content="text/html; charset=GBK" />
	<title> ��¼ϵͳ </title>
</head>
<body>
<center>
<div style="width:540px;border:1px solid black;background-color:#ddd;">
<form id="loginForm" method="post" action="login.do">
<span style="color:red">
${requestScope.error}
</span>
<hr/>
<table>
<tr>
	<td colspan="2" align="center">
		�������û����������¼
	</td>
</tr>
<tr>
	<td>�û�����</td>
	<td><input id="name" type="text" name="name" required="true"/></td>
</tr>
<tr>
	<td>��&nbsp;&nbsp;�룺</td>
	<td><input id="pass" type="text" name="pass" required="true"/></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="�ύ"/>
		<input type="reset" value="����"/>
	</td>
</tr>
</table>
<br/>
<div align="center">
<a href="reg.jsp">ע�����û�</a>
</div>
</form>
</div>
</center>
<script type="text/javascript">
	// �Զ����û��������ú���������ɻ����Ŀͻ�������У��
	function check()
	{
		// ��ȡ�ĵ��е��û����ı������
		var name = document.getElementById("name");
		// ��ȡ�ĵ��е������ı������
		var pass = document.getElementById("pass");
		var errStr = "";
		// ���û���Ϊ��ʱ
		if (name.value == "" || name.value == null)
		{
			// ��Ӵ�����ʾ�ַ���
			errStr += "�û�������Ϊ��\n";
		}
		// ������Ϊ��ʱ
		if (pass.value == "" || pass.value == null)
		{
			//��Ӵ�����ʾ�ַ���
			errStr += "���벻��Ϊ��\n";
		}
		// ���������ʾ�ַ���Ϊ�գ������û��������붼�Ѿ�����
		if (errStr == "" || errStr == null)
		{
			return true;
		}
		// ���򵯳�������ʾ
		alert(errStr);
		// �ܾ��ύ��
		return false;
	}
	// �������ύ������У�麯��
	document.getElementById("loginForm").onsubmit = check;
</script>
</body>
</html>
