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
	<title> ע���û� </title>
</head>
<body>
<center>
<div style="width:540px;border:1px solid black;background-color:#ddd">
<form id="regForm" method="post" action="reg.do">
<span style="color:red">
${requestScope.tip}
</span>
<hr/>
<table>
<tr>
	<td colspan="2" align="center">
		�������û������������ע��
	</td>
</tr>
<tr>
	<td>�û�����</td>
	<td><input id="name" type="text" name="name" required="true"/></td>
</tr>
<tr>
	<td>��&nbsp;&nbsp;�룺</td>
	<td><input id="pass" type="password" name="pass" required="true"/></td>
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
	<a href="index.jsp">��¼</a>
</div>
</form>
</div>
</center>
<script type="text/javascript">
	function check()
	{
		var name = document.getElementById("name");
		var pass = document.getElementById("pass");
		var errStr = "";
		if (name.value == "" || name.value == null)
		{
			errStr += "�û�������Ϊ��\n";
		}
		if (pass.value == "" || pass.value == null)
		{
			errStr += "���벻��Ϊ��\n";
		}
		if (errStr == "" || errStr == null)
		{
			return true;
		}
		alert(errStr);
		return false;
	}
	document.getElementById("regForm").onsubmit = check;
</script>
</body>
</html>
