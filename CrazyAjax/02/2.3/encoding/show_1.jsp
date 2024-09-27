<%@ page contentType="text/html; charset=GBK" language="java"%>
<%
// 设置解码所用的字符集
request.setCharacterEncoding("UTF-8");
// 服务器页面获取用户的value请求参数，并将其在控制台输出
System.out.println(request.getParameter("value"));
%>
