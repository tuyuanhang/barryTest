<%--
网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
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
	<title> 登录系统 </title>
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
		请输入用户名和密码登录
	</td>
</tr>
<tr>
	<td>用户名：</td>
	<td><input id="name" type="text" name="name" required="true"/></td>
</tr>
<tr>
	<td>密&nbsp;&nbsp;码：</td>
	<td><input id="pass" type="text" name="pass" required="true"/></td>
</tr>
<tr>
	<td colspan="2" align="center">
		<input type="submit" value="提交"/>
		<input type="reset" value="重设"/>
	</td>
</tr>
</table>
<br/>
<div align="center">
<a href="reg.jsp">注册新用户</a>
</div>
</form>
</div>
</center>
<script type="text/javascript">
	// 自定义用户函数，该函数用于完成基本的客户端数据校验
	function check()
	{
		// 获取文档中的用户名文本框对象
		var name = document.getElementById("name");
		// 获取文档中的密码文本框对象
		var pass = document.getElementById("pass");
		var errStr = "";
		// 当用户名为空时
		if (name.value == "" || name.value == null)
		{
			// 添加错误提示字符串
			errStr += "用户名不能为空\n";
		}
		// 当密码为空时
		if (pass.value == "" || pass.value == null)
		{
			//添加错误提示字符串
			errStr += "密码不能为空\n";
		}
		// 如果错误提示字符串为空，表明用户名、密码都已经输入
		if (errStr == "" || errStr == null)
		{
			return true;
		}
		// 否则弹出错误提示
		alert(errStr);
		// 拒绝提交表单
		return false;
	}
	// 关联表单提交与数据校验函数
	document.getElementById("loginForm").onsubmit = check;
</script>
</body>
</html>
