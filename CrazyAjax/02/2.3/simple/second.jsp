<%@ page contentType="text/html; charset=GBK" language="java"%>
<%@ page import="java.util.Random"%>
<%
// ����α���������ϵͳʱ����Ϊα�����������
Random rand = new Random(System.currentTimeMillis());
// ��������α������֣�����$���Ÿ������͵��ͻ���
out.println(rand.nextInt(10) + "$" + rand.nextInt(10)
	+ "$" + rand.nextInt(10));
%>
