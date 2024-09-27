var tip = "";
function searchBrand()
{
	// ��������ķ�����URL
	var url = 'getBrands.do';
	// �����������
	var params = "prefix=" + $F('brand');
	// ����Ajax.Request�������ڷ�������
	new Ajax.Request(
	url,
	{
		method:'post',
		// ���Ͳ���
		parameters: params,
		// ָ���ص�������
		onComplete: showResponse,
	});
}

function searchModel()
{
	// ���������URL
	var url = 'getModels.do';
	var params = "brand=" + $F('brand');
	// ����Ajax.Request���󣬷����첽����
	new Ajax.Request(
	url,
	{
		method:'post',
		// �����������
		parameters: params,
		// ָ���ص�����
		onComplete: showModel,
	});
}

function getDetail()
{
	// ���������URL
	var url = 'getDetail.do';
	var params = "model=" + $F('model');
	// ����Ajax.Updater���󣬷����첽����
	new Ajax.Updater(
	// ָ������modelDetailԪ��
	'modelDetail',
	url,
	{
		method: 'post',
		parameters: params,
		// ʹ������������Ϊ�ص��������ú���������ϸ��Ϣ<div.../>Ԫ�صĳ���
		onComplete:function()
		{
			$('modelDetail').show();
		}
	});
}

function showResponse(request)
{
	// ��ȡ��������Ӧ��������Ӧ�ַ�����$����Ϊ�ָ������ֽ���ַ�������
	var brandList = request.responseText.split("$");
	// ��ȡƷ����ʾԪ��
	var bt = $("brandTip");
	// ���Ʒ����ʾԪ�ص�����
	bt.innerHTML = "";
	// ����ַ�������ĳ��ȴ���1
	if ( brandList.length > 1)
	{
		// ����Ʒ��������ÿ��Ʒ����ӵ�brandTipԪ����
		for(var i = 0 ; i < brandList.length - 1 ; i++)
		{
			var a = document.createElement("div");
			a.innerHTML = brandList[i];
			bt.appendChild(a);
		}
		// ѡ�е�һ��Ʒ������<div.../>Ԫ��
		bt.firstChild.className = "selectTip";
		// ��ʾbrandTipԪ��
		if( tip != $("brand").value)
		{
			bt.show();
		}
	}
	else
	{
		// ����brandTipԪ��
		bt.hide();
	}
}

function showModel(request)
{
	// ����������Ӧ�ַ�����$��Ϊ�ָ����ֽ���ַ�������
	var modelList = request.responseText.split("$");
	// ��ȡ�ͺ���ʾ��<div.../>Ԫ��
	var mt = $("modelTip");
	// ����ͺ���ʾ��<div.../>������
	mt.innerHTML = "";
	// ����ַ������鳤�ȴ���1
	if ( modelList.length > 1)
	{
		// ������������ʾ�������ͺ�
		for(var i = 0 ; i < modelList.length - 1 ; i++)
		{
			// ��ÿ���ͺŴ���<div.../>Ԫ��
			var a = document.createElement("div");
			// ʹ��<div.../>��ʾ��ǰ�ͺŵ��ͺ���
			a.innerHTML = modelList[i];
			// ��ӵ�ǰ�ͺ���ʾ
			mt.appendChild(a);
		}
		// ѡ�е�һ��
		mt.firstChild.className = "selectTip";
		// ��ʾ�ͺ���ʾԪ��
		if( tip != mt.value)
		{
			mt.show();
		}
	}
	else
	{
		// �����ͺ���ʾԪ��
		mt.hide();
	}
}

function move(event)
{
	// ��ȡ�û������¼����¼�Դ��ֻ��brand��model����Ԫ��
	var srcEl = Event.element(event);
	// ��ȡbrandTip��modelTipԪ�أ�����ȡƷ�ƻ�ģ����ʾ���õ�<div.../>Ԫ��
	var tipEl = $(srcEl.id + "Tip");
	// �����ʾDIVԪ�ش�����ʾ״̬����Ҫ����
	// �����ʾDIVԪ�ض�û�г��֣��û��������ϡ����¼����������κη�Ӧ��
	if (tipEl.style.display == "" )
	{
		// ���¼�
		if(event.keyCode == 40 )
		{
			// �����ʾ��������ʾ��Ʒ�ƻ���ʾ�ͺ�
			if (tipEl.childNodes.length > 1)
			{
				// ����Ѿ�ѡ�������һ��
				if(tipEl.lastChild.className == "selectTip")
				{
					// �ı�Ϊѡ�е�һ��
					tipEl.firstChild.className = "selectTip";
					// �����һ�����ٴ���ѡ��״̬
					tipEl.lastChild.className = "null";
					return ;
				}
				// ��ȡ��ʾ�����ʾ������
				var bList = tipEl.childNodes;
				// ������ʾ<div.../>Ԫ���е�Ʒ�ƻ��ͺ�
				for (var i = 0 ; i < bList.length - 1 ; i ++)
				{
					//�����i��Ʒ�ƻ��ͺű�ѡ��
					if (bList[i].className == "selectTip")
					{
						// ����i+1��Ʒ�ƻ��ͺ�ѡ�У��������ƶ�
						bList[i + 1].className = "selectTip";
						// ��ԭ���ĵ�i��Ʒ�ƻ��ͺŸ�Ϊ��ѡ��
						bList[i].className = "null";
						return ;
					}
				}
			}

		}
		// ���ϼ�
		else if(event.keyCode == 38)
		{
			// �����ʾ��������ʾ��Ʒ�ƻ���ʾ�ͺ�
			if (tipEl.childNodes.length > 1)
			{
				// ����Ѿ�ѡ���˵�һ��
				if(tipEl.firstChild.className == "selectTip")
				{
					// ��Ϊѡ�����һ��
					tipEl.lastChild.className = "selectTip";
					// ����һ����Ϊ��ѡ��
					tipEl.firstChild.className = "null";
					return ;
				}
				// ��ȡ��ʾ�����ʾ������
				var bList = tipEl.childNodes;
				// �������е�Ʒ�ƻ��ͺ�
				for (var i = 1 ; i < bList.length ; i ++)
				{
					// �����i��Ʒ�ƻ��ͺ�Ϊѡ��״̬
					if (bList[i].className == "selectTip")
					{
						// ��i-1��Ʒ�ƻ��ͺŸ�Ϊѡ��״̬���������ƶ�
						bList[i - 1].className = "selectTip";
						// ��ԭ����i��Ʒ�ƻ��ͺŸ�Ϊ��ѡ��
						bList[i].className = "null";
						return ;
					}
				}
			}
		}
		// �س���
		else if(event.keyCode == 13)
		{
			// ��ȡ��ʾ<div.../>Ԫ�ص�������Ԫ��
			var bList = tipEl.childNodes;
			// ������ʾ<div.../>Ԫ�ص�ȫ����Ԫ��
			for (var i = 0 ; i < bList.length ; i ++)
			{
				// �����i��Ԫ�ص�ǰ����ѡ��״̬
				if (bList[i].className == "selectTip")
				{
					// ��tipֵ��������ֵ��Ϊѡ��״̬�µ�Ʒ�ƻ��ͺš�
					tip = srcEl.value = bList[i].innerHTML;	
					// ������ʾ
					Element.hide(tipEl);
					// �����brandԪ���Ϸ����˵����س��¼�
					if (srcEl.id == "brand")
					{
						// ��modelԪ�ػ�ý���
						$("model").focus();
						// ����searchModel()������Ajax������ʾ��ǰƷ�Ƶ�ȫ���ͺ�
						searchModel();
					}
					// ���modelԪ�ط����˵����س��¼�
					if (srcEl.id == "model")
					{
						// ����getDetail()������Ajax������ʾ��ǰƷ�Ƶ���ϸ��Ϣ
						getDetail();
					}
					return ;
				}
			}
		}
	}
}
// ����brand���ؼ���value�ĸı�
new Form.Element.Observer("brand", 1, searchBrand);
// Ϊbrand��modelԪ�ذ�keydown�¼��Ĵ�����Ϊmove��
// false��ʾ���¼���������ð�ݽ׶μ�����
Event.observe("brand", "keydown", move, false);
Event.observe("model", "keydown", move, false);

var myGlobalHandlers = 
{
	// ������XMLHttpRequest����ʱ����������������
	onCreate: function()
	{
		// ��ʾloadingԪ��
		$('loading').show();;
	},
	// �����������Ӧ����ʱ��������������
	onFailure:function()
	{
		alert('�Բ���!\nҳ����س���!');
	},
	// ��Ajax�������ʱ����������������
	onComplete: function()
	{
		// ���û�����ڽ�����Ajax����
		if(Ajax.activeRequestCount == 0)
		{
			// ����loadingԪ��
			$('loading').hide();
		}
	}
};
// ajax�¼���
Ajax.Responders.register(myGlobalHandlers);