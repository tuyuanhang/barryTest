var curShow;
var curItem = 0;
// ָ���Զ��崴��ѡ��
var option =
{
	// ָ��rowCreatorѡ��
	rowCreator:function(options)
	{
		var row = document.createElement("tr");
		// �����ǰ������Ϊż���������䱳��ɫΪ��ɫ
		if(options.rowNum % 2 == 0)
		{
			row.style.backgroundColor = "#fff";
		}
		// �����ǰ������Ϊ�����������䱳��ɫΪ����ɫ
		else
		{
			row.style.backgroundColor = "#efe";
		}
		return row;
	}
};

function init()
{
	// ��ʼ��ȫ�ֱ���curShow
	curShow = $("index");
	// ����ȫ�ִ�������
	dwr.engine.setErrorHandler(errHandler);
	// ����ҳ���loadMesssage
	dwr.util.useLoadingMessage();
}
// ȫ�ִ�������
function errHandler(msg)
{
	alert(msg);
}

// ʹ��������ʽȥ���ַ���ǰ��Ŀո�
function trim(s)
{
   	return s.replace( /^\s*/, "" ).replace( /\s*$/, "" );
}

// ��ʾ��ҳ
function showIndex()
{
	// curShow�Ǹ�ȫ�ֱ������ñ��������û���ǰ�����ҳ������
	if (curShow != null)
	{
		// ����ǰ��������
		curShow.style.display = "none";
	}
	// ��ʾ��ҳ����
	$("index").style.display = "";
	// ����ҳ������Ϊ��ǰ�������
	curShow = $("index");
}

// ��ʾ��¼��
function showLogin()
{
	// ���ص�ǰ��ʾ������
	if (curShow != null)
	{
		curShow.style.display = "none";
	}
	// ��ʾ��¼���
	$("login").style.display = "";
	curShow = $("login");
}

// �ύ��¼
function submitLogin()
{
	// ��ȡloginUser�ı����е�����ֵ
	var loginUser = trim($("loginUser").value);
	// ��ȡloginPass�ı����е�����ֵ
	var loginPass = trim($("loginPass").value);
	// ��ȡ��֤��������е�����ֵ
	var loginVer = trim($("vercode").value);
	var errStr = "";
	// ���л���У�飬�ж��û����������ͼ����֤��������룬
	// ������������ָ����ʽ
	if (loginUser == null || loginUser == "")
	{
		errStr += "��û�������û�����\n";
	}
	else if (loginPass == null || loginPass == "")
	{
		errStr += "��û���������룡\n";
	}
	else if (loginVer == null || loginVer == "")
	{
		errStr += "��û��������֤�룡\n";
	}
	else if (loginUser.length >= 10 || loginUser.length <= 3)
	{
		errStr += "�û����ĳ��ȱ�����3��10֮�䣡\n";
	}
	else if (loginPass.length >= 10 || loginPass.length <= 3)
	{
		errStr += "�û����ĳ��ȱ�����3��10֮�䣡\n";
	}
	else if (loginVer.length != 6)
	{
		errStr += "��֤�볤�ȱ���Ϊ6��\n";
	}
	// �������ͨ���ͻ���У�飬����������ʾ
	if (errStr != "")
	{
		alert(errStr);
		return false;
	}
	// ���ͨ���˿ͻ���У�飬����Զ��Java����
	else
	{
		am.validLogin(loginUser , loginPass , loginVer , submitLoginCb);
	}
}

// �����¼�Ļص�����
function submitLoginCb(data)
{
	// �����������Ӧ����Ϊtrue��������¼�ɹ�
	if (data)
	{
		// ����û�����ĵ�¼����
		dwr.util.setValue("loginUser" , "");
		dwr.util.setValue("loginPass" , "");
		dwr.util.setValue("vercode" , "");
		alert("��¼�ɹ�������Լ���ʹ�ñ�ϵͳ");
		showIndex();
	}
	// ��¼ʧ��
	else
	{
		alert("�û��������벻���ϣ���¼ʧ�ܣ�");
	}
}

// ���������Ʒ
function viewFail()
{
	// ������һ���ͻ�����꣬�����ǻ�ȡ������Ʒ
	var flag = "fail";
	// ʹ�ñհ������������ݺ����������ͬʱ����ص�����
	var callbackAdapter = function(data) 
	{
		viewFailCb(data, flag); 
	}; 
	// ����am�����getFailItems����
	am.getFailItems(callbackAdapter); 
}

// ����Լ�����Ʒ
function viewOwnerItem()
{
	// ʹ�ñհ������������ݺ����������ͬʱ����ص�����
	var callbackAdapter = function(data) 
	{
		viewFailCb(data, "owner"); 
	}; 
	am.getItemsByOwner(callbackAdapter); 
}

function viewFailCb(data , flag)
{
	// ���ص�ǰ��ʾ������
	if (curShow != null)
	{
		curShow.style.display = "none";
	}
	$("viewFail").style.display = "";
	$("addItem").style.display = "none";
	curShow = $("viewFail");
	// ɾ�����viewFailBody��ȫ����
	dwr.util.removeAllRows("viewFailBody");
	// ������������������Ʒ
	if (flag == "fail")
	{
		// ���ñ�����
		dwr.util.setValue("failAndOwnerTitle" , "�������ĵ���Ʒ");
		// ���������Ʒ��û�������Ʒ�ĳ�����
		$("addItemHref").style.display = "none";
	}
	// �鿴�Լ���������Ʒ
	if (flag == "owner")
	{
		dwr.util.setValue("failAndOwnerTitle" , "����ǰ��������Ʒ��");
		// �鿴�Լ���������Ʒʱ����Ҫ�����Ʒ�ĳ�����
		$("addItemHref").style.display = "";
	}
	// ������������ص����ݲ�Ϊ�գ������ٰ�����һ����Ʒ
	if (data != null && data.length > 0)
	{
		// ָ����Ԫ������ÿ��������Ӧһ��
		var cellfuncs = [
			// �����Ʒ��
			function(data){ 
				return data['name'];
			},
			// �����Ʒ����
			function(data){
				return data['kind'];
			},
			// �����Ʒ���۸�
			function(data){
				return data['maxPrice'];
			},
			// �����Ʒ������
			function(data){
				return data['remark'];
			}
		];
		// ʹ��data�����е�����ΪviewFailBody���ӱ����
		dwr.util.addRows("viewFailBody" , data , cellfuncs , option);
	}
	// ���û����Ʒ��ʾ
	else if (flag == "owner")
	{
		alert("����ʱ��û��������Ʒ��");
	}
	else if (flag == "fail")
	{
		alert("��ʱû��������Ʒ��");
	}
}

// ���Ӯȡ����Ʒ
function viewSuccess()
{
	// ����getItemByWinerǰ�˴�������ȡ��ǰ�û�Ӯȡ����Ʒ
	am.getItemByWiner(viewSuccessCb); 
}

// �����ǰ�û�Ӯȡ��Ʒ�Ļص�����
function viewSuccessCb(data)
{
	// ���ص�ǰ��ʾ����
	if (curShow != null)
	{
		curShow.style.display = "none";
	}
	// ��ʾ�鿴Ӯȡ��Ʒ�ı��
	$("viewSucc").style.display = "";
	curShow = $("viewSucc");
	// ɾ��viewSuccBody�����б����
	dwr.util.removeAllRows("viewSuccBody");
	// �������getItemByWiner��������ֵ��Ϊ�գ��һ�ȡ������һ����Ʒ
	if (data != null && data.length > 0)
	{
		// ��������飬ÿ��������Ӧһ��
		var cellfuncs = [
			// �����Ʒ��
			function(data){ 
				return data['name'];
			},
			// �����Ʒ����
			function(data){
				return data['kind'];
			},
			// �����Ʒ��Ӯȡ�۸�
			function(data){
				return data['maxPrice'];
			},
			// �����Ʒ�ı�ע
			function(data){
				return data['remark'];
			}
		];
		// ��data�������ΪviewSuccBody�ı����
		dwr.util.addRows("viewSuccBody" , data , cellfuncs , option);
	}
	else
	{
		alert("��ʱû��Ӯȡ�κ���Ʒ��");
	}
}


// ����Լ��ľ���
function viewBid()
{
	// ����getBidByUser()ǰ�˴���������ȡ��ǰ�û��ľ��ۼ�¼��
	am.getBidByUser(viewBidCb); 
}
// �����ǰ�û�ȫ�����۵Ļص�����
function viewBidCb(data)
{
	// �������ֵ��Ϊ�գ������ٻ�ȡ��һ�ξ��ۼ�¼
	if (data != null && data.length > 0)
	{
		// ��������飬ÿ��������Ӧһ��
		var cellfuncs = [
			// ������۵���Ʒ
			function(data){ 
				return data['item'];
			},
			// ������۵ļ۸�
			function(data){
				return data['price'];
			},
			// �������ʱ��
			function(data){
				return data['bidDate'].toLocaleString();
			},
			// ��������û�
			function(data){
				return data['user'];
			}
		];
		// ɾ��viewBidBody����е����б����
		dwr.util.removeAllRows("viewBidBody");
		// ��data�е��������ΪviewBidBody�ı����
		dwr.util.addRows("viewBidBody" , data , cellfuncs , option);
		// ���ص�ǰ��ʾ������
		if (curShow != null)
		{
			curShow.style.display = "none";
		}
		// ��ʾ�鿴���۵ı��
		$("viewBid").style.display = "";
		curShow = $("viewBid");
	}
	// ���û�л�ȡ��Ӧ�ľ��ۼ�¼��
	else
	{
		alert("����ʱ��û���κξ��ۼ�¼��");
	}
}

// �鿴ȫ����Ʒ����
function viewCatalog()
{
	// ����getAllKindǰ�˴���������ȡ��ǰ��������
	am.getAllKind(viewCatalogCb); 
}
// �鿴����Ļص�����
function viewCatalogCb(data)
{
	// �������������ȡ������Ϣ
	if (data != null && data.length > 0)
	{
		// ָ����������飬ÿ��������Ӧһ��
		var cellfuncs = [
			// ���������
			function(data){ 
				return data['kindName'];
			},
			// �����������
			function(data){
				return data['kindDesc'];
			}
		];
		// ɾ��viewCatalogBody����е����б����
		dwr.util.removeAllRows("viewCatalogBody");
		// ��data�е�������ӵ�viewCatalogBody����С�
		dwr.util.addRows("viewCatalogBody" , data , cellfuncs , option);
		// ���ص�ǰ��ʾ������
		if (curShow != null)
		{
			curShow.style.display = "none";
		}
		// ����������ʾ����
		$("viewCatalog").style.display = "";
		$("addKind").style.display = "none";	
		curShow = $("viewCatalog");
	}
	else
	{
		alert("��ʱ��û��������Ϣ��");
	}
}

// ȡ���������
function cancelCatalog()
{
	// ���û�������������������������
	dwr.util.setValue("addKindName" , "");
	dwr.util.setValue("addKindDesc" , "");
	// �����������������
	$("addKind").style.display = "none";
}

function addCatalog()
{
	// ��ȡ������
	var addKindName = trim($("addKindName").value);
	// ��ȡ��������
	var addKindDesc = trim($("addKindDesc").value);
	var errStr = "";
	// ���пͻ�������У��
	if (addKindName == null || addKindName == "")
	{
		errStr += "��û��������������\n";
	}
	else if (addKindDesc == null || addKindDesc == "")
	{
		errStr += "��û����������������\n";
	}
	else if (addKindName.length >= 10 || addKindName.length < 2)
	{
		errStr += "�������ĳ��ȱ�����2��10֮�䣡\n";
	}
	else if (addKindDesc.length <=8)
	{
		errStr += "���������ĳ��ȱ������8���ַ���\n";
	}
	// �������ͨ���ͻ�������У��
	if (errStr != "")
	{
		alert(errStr);
		return false;
	}
	// �������ͨ���ͻ�������У��
	else
	{
		// ����addKindǰ�˴������������������
		am.addKind(addKindName , addKindDesc , addKindCb);
	}
}

// �������Ļص�����
function addKindCb(data)
{
	// ��������ֵ����������������������������0��������������ɹ�
	if (data != null && typeof data == "number" && data > 0)
	{
		alert("�������ɹ�");
		// ȡ�����
		cancelCatalog();
		// ���²鿴ϵͳ�����е���Ʒ����
		viewCatalog();
	}
	else
	{
		alert("�������ʧ��");
	}
}

// ��ʾ�����Ʒ�ı��ؼ�
function showAddItem()
{
	// ��ȡ������Ʒ����
	am.getAllKind(showAddItemCb);
}

// ��ʾ�����Ʒ�Ļص�����
function showAddItemCb(data)
{
	if (data != null && data.length > 0)
	{
		// ��addItemCatalog��select�б���ɾ������ѡ��
		dwr.util.removeAllOptions("addItemCatalog");
		// ��data�е����������ΪaddItemCatalog��select�б��еĸ���
		dwr.util.addOptions("addItemCatalog" , data ,
			'id' , 'kindName');
		$("addItem").style.display = "";
	}
	// ��������Ʒ���࣬�ſ��������Ʒ
	else
	{
		alert("��û����Ʒ���࣬���������Ʒ����");
	}
}

// ȡ�������Ʒ
function cancelItem()
{
	// ���������Ʒ�ĸ�����ؼ����
	dwr.util.setValue("addItemName" , "");
	dwr.util.setValue("addItemDesc" , "");
	dwr.util.setValue("addItemPrice" , "");
	dwr.util.setValue("addItemPic" , "");
	// ���������Ʒ��ҳ�����
	$("addItem").style.display = "none";
}

// �����Ʒ
function addItem()
{
	// ��ͨ��������ȡ�����Ʒ�ĸ��������Ϣ
	var addItemName = trim($("addItemName").value);
	var addItemDesc = trim($("addItemDesc").value);
	var addItemPic = trim($("addItemPic").value);
	// ��ȡ��Ʒ�ĳ�ʼ�۸�
	var addItemPrice = trim($("addItemPrice").value);
	// ��ȡ��Ʒ������ʱ��
	var addItemAvail = trim(dwr.util.getValue("addItemAvail"));
	var addItemCatalog = trim(dwr.util.getValue("addItemCatalog"));
	var errStr = "";
	// ���пͻ�������У��
	if (addItemName == null || addItemName == "")
	{
		errStr += "��û��������Ʒ����\n";
	}
	else if (addItemPrice == null || addItemPrice == "")
	{
		errStr += "��û��������Ʒ�����ļ�\n";
	}
	else if (addItemName.length >= 10 || addItemName.length < 2)
	{
		errStr += "��Ʒ���ĳ��ȱ�����2��10֮�䣡\n";
	}
	if (isNaN(addItemPrice))
	{
		errStr += "��Ʒ�����ļ۱��������֣�\n";
	}
	// ����ͻ�������У�鲻��ͨ��
	if (errStr != "")
	{
		// ���У����ʾ��Ϣ
		alert(errStr);
		return false;
	}
	// ���ͨ���ͻ�������У��
	else
	{
		// ����addItemҵ�񷽷������������Ʒ
		am.addItem(addItemName, addItemDesc, addItemPic, 
			parseFloat(addItemPrice), addItemAvail, addItemCatalog, addItemCb);
	}
}

// �����Ʒ�Ļص�����
function addItemCb(data)
{
	// �����Ʒ�󷽷�����������Ʒ������
	if (data != null && typeof data == "number" && data > 0)
	{
		alert("�����Ʒ�ɹ�");
		// ȡ�����
		cancelItem();
		// �鿴�Լ����д��������е���Ʒ
		viewOwnerItem();
	}
	else
	{
		alert("�����Ʒʧ��");
	}
}

// ��������е���Ʒ
function viewInBid()
{
	// ����getAllKindǰ�˴�������ȡ���е���Ʒ����
	am.getAllKind(viewInBidCb);
}
// ��������е���Ʒ�Ļص�����
function viewInBidCb(data)
{
	// �����ǰ��Ʒ���಻Ϊ�գ������ٷ�����һ����Ʒ����
	if (data != null && data.length > 0)
	{
		// ɾ��selectBidCatalog�����б��е�����ѡ��
		dwr.util.removeAllOptions("selectBidCatalog");
		// ɾ��������Ʒ���е�ȫ����
		dwr.util.removeAllRows("viewInBidBody");
		// ��ϵͳ��ǰ��������Ʒ���������selectBidCatalog�����б�����ʾ
		dwr.util.addOptions("selectBidCatalog" , data , 'id' , 'kindName');
		// ���ص�ǰ��ʾ������
		if (curShow != null)
		{
			curShow.style.display = "none";
		}
		// ��ʾ���������Ʒ�ı��
		$("viewInBid").style.display = "";
		curShow = $("viewInBid");
	}
	else
	{
		alert("��ʱû���κ���Ʒ");
	}
}

// �����û�ѡ������������Ʒ
function loadItemByCatalog(cataId)
{
	// ������ʾ��Ʒ�б�ı���
	dwr.util.setValue("bidCatalog" , dwr.util.getText("selectBidCatalog"));
	// ɾ����Ʒ����е����б����
	dwr.util.removeAllRows("viewInBidBody");
	// ����getItemsByKind()ǰ�˴�����
	am.getItemsByKind(cataId , loadItemByCatalogCb);
}
// �����û�ѡ������������Ʒ�Ļص�����
function loadItemByCatalogCb(data)
{
	// �������Զ�̷����ķ���ֵΪ���գ��һ��������һ����Ʒ
	if (data != null && data.length > 0)
	{
		// ������������ֵ�е�ÿ������
		for (var i = 0; i < data.length; i++ )
		{
			// ����һ�������
			var tr = $("viewInBidBody").insertRow(i);
			// ���ݱ���е���ż��ͬ�����ñ���еı���ɫ
			if(i % 2 == 0)
			{
				tr.style.backgroundColor = "#ffffff";
			}
			else
			{
				tr.style.backgroundColor = "#e2ffe2";
			}
			// ��������Ԫ�񣬽������ڱ������ʾ����
			var td = tr.insertCell(0);
			td.innerHTML = '<a href="#" onClick="viewDetail('
				+ data[i]['id'] +')">' + data[i]['name'] + '</a>';
			td = tr.insertCell(1);
			td.innerHTML = data[i]['addTime'].toLocaleString();
			td = tr.insertCell(2);
			td.innerHTML = data[i]['endTime'].toLocaleString();
			td = tr.insertCell(3);
			td.innerHTML = data[i]['maxPrice'];
			td = tr.insertCell(4);
			td.innerHTML = data[i]['owner'];
		}
	}
	else
	{
		alert("����������ʱû��������Ʒ��������ѡ��");
	}
}

// �鿴��Ʒ��ϸ��Ϣ
function viewDetail(itemId)
{
	// ����getItemǰ�˴�������������ƷID��ȡ����Ʒ����ϸ��Ϣ��
	am.getItem(itemId , viewDetailCb);
}
// �鿴��Ʒ��ϸ��Ϣ�Ļص�����
function viewDetailCb(data)
{
	// ���ص�ǰ��ʾ������
	if (curShow != null)
	{
		curShow.style.display = "none";
	}
	// curItem�Ǹ�ȫ�ֱ��������ڱ��浱ǰ��ƷID
	curItem = data["id"];
	// ����ȡ����Ʒ��Ϣ��ҳ������ʾ����
	dwr.util.setValue("detailName" , data["name"]);
	dwr.util.setValue("detailDesc" , data["desc"]);
	dwr.util.setValue("detailRemark" , data["pic"]);
	dwr.util.setValue("detailKind" , data["kind"]);
	dwr.util.setValue("detailOwner" , data["owner"]);
	dwr.util.setValue("detailInitPrice" , data["initPrice"]);
	dwr.util.setValue("detailMaxPrice" , data["maxPrice"]);
	dwr.util.setValue("detailStartTime" , data["addTime"].toLocaleString());
	dwr.util.setValue("detailEndTime" , data["endTime"].toLocaleString());
	// ��ʾ�����Ʒ��ϸ��Ϣ�ı��
	$("viewDetail").style.display = "";
	curShow = $("viewDetail");
}

// ȡ������
function cancelBid()
{
	dwr.util.setValue("bidPrice" , "");
}

// �����û�����
function submitBid()
{
	// ��ȡ���ļ�
	var bidPrice = trim(dwr.util.getValue("bidPrice"));
	// ��ȡ����Ʒ�ĵ�ǰ��߼�
	var maxPrice = trim(dwr.util.getValue("detailMaxPrice"));
	var errStr = "";
	// ���пͻ��˵�����У��
	if (bidPrice == null || bidPrice == "")
	{
		errStr += "��û�������뾺�۵ļ۸�\n";
	}
	if (isNaN(bidPrice))
	{
		errStr += "���۵ļ۸���������֣�\n";
	}
	// �ж�����ľ��ļ۱��������Ʒ�ĵ�ǰ��߼�
	if (parseFloat(bidPrice) <= parseFloat(maxPrice))
	{
		errStr += "���۵ļ۸������ڵ�ǰ��߳��ۣ�\n";
	}
	// ����ͻ�������У��ʧ�ܣ�����������ʾ
	if (errStr != "")
	{
		alert(errStr);
		return false;
	}
	// �ͻ�������У��ͨ��
	else
	{
		if(curItem && curItem > 0)
		{
			//����addBidǰ�˴�����������Ӿ���
			am.addBid(curItem , parseFloat(bidPrice) , submitBidCb);
		}
	}
}
// �ύ���ۻص�����
function submitBidCb(data)
{
	// �����������ֵ�����֣��Ҵ���0���������۳ɹ�
	if (data != null && typeof data == "number" && data > 0)
	{
		alert("���۳ɹ���");
		viewDetail(curItem);
		// ��վ��������
		dwr.util.setValue("bidPrice" , "");
	}
	else
	{
		alert("����ʧ�ܣ�");
	}
}