function sendMessage()
{
	// ����Զ�̵�hello������ʹ����dwr.util��getValue������ȡHTMLԪ�ص�ֵ
	hello.hello(dwr.util.getValue('name') , cb);
}
// �ص�����
function cb(data)
{
	// ʹ��dwr.util��setValue��������HTMLԪ�ص�ֵ
	dwr.util.setValue('show' ,data);
}
