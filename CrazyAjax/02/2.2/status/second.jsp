<%@ page contentType="text/html; charset=GBK" language="java" %>
<%
String idStr = (String)request.getParameter("id");
int id = idStr == null ? 1 : Integer.parseInt(idStr);
System.out.println(id);
switch(id)
{
	case 1:
%>
�Ϻ�$����$����
<%
	break;
	case 2:
%>
��ʢ��$ŦԼ$����
<%
	break;
	case 3:
%>
����$���$����
<%
	break;
}
%>
