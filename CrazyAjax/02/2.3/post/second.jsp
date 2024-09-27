<%@ page contentType="text/html; charset=GBK" language="java" %>
<%
String idStr = (String)request.getParameter("id");
int id = idStr == null ? 1 : Integer.parseInt(idStr);
System.out.println(id);
switch(id)
{
	case 1:
%>
上海$广州$北京
<%
	break;
	case 2:
%>
华盛顿$纽约$加州
<%
	break;
	case 3:
%>
东京$大板$福冈
<%
	break;
}
%>
