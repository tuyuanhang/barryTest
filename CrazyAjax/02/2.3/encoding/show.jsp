<%@ page contentType="text/html; charset=GBK" language="java" %>
<%
// ����POST����
if (request.getMethod().equalsIgnoreCase("POST"))
{
	request.setCharacterEncoding("UTF-8");
	System.out.println(request.getParameter("value"));
}
// ����GET����
else if (request.getMethod().equalsIgnoreCase("GET"))
{
	String tmp = request.getParameter("value");
	String a = new String(tmp.getBytes("ISO-8859-1") , "UTF-8");
	System.out.println(a);
}
%>
