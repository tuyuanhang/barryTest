$(document).ready(function()
{
	// ҳ�����ʱ��pageLoad��������
	$.getScript("pageLoad");
});
function reset()
{
	// ���user��pass���������ı���
	$("#user").val("");
	$("#pass").val("");
}
// �л���ע��Ի���
function changeRegist()
{
	// ���ص�¼�õ�������ť
	$("#loginDiv").hide("500");
	// ��ʾע���õ�������ť
	$("#registDiv").show("500");
}
// �����û���¼�ĺ���
function proLogin()
{
	// ��ȡuser��pass�����ı����ֵ
	var user = $.trim($("#user").val());
	var pass = $.trim($("#pass").val());
	if (user == null || user == "" 
		|| pass == null|| pass =="")
	{
		alert("�����������û�����������ܵ�¼");
		return false;
	}
	else
	{
		// ��proLogin�����첽��POST����
		$.post("proLogin", $('#user,#pass').serializeArray()
			, null , "script");
	}
}
// �����û�ע��ĺ���
function regist()
{
	// ��ȡuser��pass�����ı����ֵ
	var user = $.trim($("#user").val());
	var pass = $.trim($("#pass").val());
	if (user == null || user == "" || pass == null || pass =="")
	{
		alert("�����������û������������ע��");
		return false;
	}
	else
	{
		// ��proRegist�����첽��POST����
		$.post("proRegist", $('#user,#pass').serializeArray()
			, null , "script");
	}
}

// ��֤�û����Ƿ����
function validateName()
{
	// ��ȡuser�ı����ֵ
	var user = $.trim($("#user").val());
	if (user == null || user == "")
	{
		alert("����û�������û�����");
		return false;
	}
	else
	{
		// ��validateName�����첽��POST����
		$.post("validateName", $('#user').serializeArray()
			, null , "script");
	}
}

// �����Եػ�ȡ��ǰ�û�����ǰҳ����Ƭ
function onLoadHandler()
{
	// ��getPhoto�����첽��GET����
	$.getScript("getPhoto");
	// ָ��1��֮���ٴ�ִ�д˷���
	setTimeout("onLoadHandler()", 1000);
}

// �ϴ��ļ��Ļص�����
function callback(msg)
{
	alert(msg);
	// �����ļ��ϴ��ĶԻ���
	$('#uploadDiv').dialog('close');
	// ���title��file��������
	$('#title,#file').val('');
	$('#hideframe').attr('src' , '');
}

// ��ʾ��Ƭ
function showImg(fileName)
{
	$.getScript("showImg?img=" + fileName);
}

// ����ҳ�ĺ���
function turnPage(flag)
{
	$.getScript("turnPage?turn=" + flag);
}

// ���ϴ�����
function openUpload()
{

	$("#uploadDiv").show()
		.dialog(
		{
			modal: true,
			title: '�ϴ���Ƭ',
			resizable: false,
			width: 428,
			height: 220,
			overlay: {opacity: 0.5 , background: "black"}
		});
}