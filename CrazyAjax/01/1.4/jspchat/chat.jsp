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
	<title> ����ҳ�� </title>
</head>
<body>
<div style="width:780px;border:1px solid black;text-align:center">
<h3>����ҳ��</h3>
<p>
	<textarea name="textarea" cols="90" rows="30"
	readonly="readonly">${requestScope.msg}</textarea> 
</p>
<form name="form1" method="post" action="chat.do" >
	<div align="center">
		<input name="chatMsg" type="text" size="90"
			onclick="document.form1.submit;"/>
		<input type="submit" name="Submit" value="����"/>
	</div>
</form>
</div>
<script type="text/javascript">
	var input = document.getElementById("chatMsg");
	input.focus();

	function check()
	{
		if (input.value == null || input.value == "")
		{
			alert("������������Ϣ����Ҫ���Ϳ���Ϣ!");
			return false;
		}
	}

	function submitChat()
	{
		document.getElementById("form1").onsubmit();
	}

	document.getElementById("form1").onsubmit = check;
</script>
</body>
</html>
