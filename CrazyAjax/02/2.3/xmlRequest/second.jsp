<%@ page contentType="text/html; charset=GBK" language="java" %>
<%@ page import="java.io.*,org.dom4j.*,org.dom4j.io.XPPReader,java.util.*"%>
<%
// ����һ��StringBuffer�������ڽ����������
StringBuffer xmlBuffer = new StringBuffer();
String line = null;
// ͨ��request�����ȡ������
BufferedReader reader = request.getReader();
// ���ζ�ȡ����������������
while((line = reader.readLine()) != null ) 
{
	xmlBuffer.append(line);
}
// �����������ж�ȡ��������ת��Ϊ�ַ���
String xml = xmlBuffer.toString();
// ��Dom4J��ʼ����XML�ִ���
Document xmlDoc = new XPPReader().read( 
	new ByteArrayInputStream(xml.getBytes()));
// ���countrys�ڵ�������ӽڵ�
List countryList = xmlDoc.getRootElement().elements();
// �����������Ӧ�Ľ��
String result = "";
// ����countrys�ڵ�������ӽڵ�
for(Iterator it = countryList.iterator(); it.hasNext();)
{
	Element country = (Element)it.next();
	// ������͵ĸýڵ��ֵΪ1������ѡ�����й�
	if (country.getText().equals("1"))
	{
		result += "�Ϻ�$����$����";
	}
	// ������͵ĸýڵ��ֵΪ1������ѡ��������
	else if(country.getText().equals("2"))
	{
		result += "$��ʢ��$ŦԼ$����";
	}
	// ������͵ĸýڵ��ֵΪ1������ѡ�����ձ�
	else if(country.getText().equals("3"))
	{
		result += "$����$���$����";
	}
}
// ��ͻ��˷�����Ӧ
out.println(result);
%>