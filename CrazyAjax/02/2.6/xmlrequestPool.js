// ����һ������XMLHttp
var XMLHttp = 
{
	// �����һ�����ԣ����������ڻ���XMLHttpRequest���������
	XMLHttpRequestPool: [],
	// ����ĵ�һ���������÷������ڷ���һ��XMLHttpRequest����
	getInstance:function()
	{
		// ��XMLHttpRequest�������ȡ��һ�����е�XMLHttpRequest
		for (var i = 0; i < this.XMLHttpRequestPool.length; i ++)
		{
			// ���XMLHttpReuqest��readyStateΪ0������Ϊ4��
			// ����ʾ��ǰ��XMLHttpRequest����Ϊ���õĶ���
			if (this.XMLHttpRequestPool[i].readyState == 0 || 
				this.XMLHttpRequestPool[i].readyState == 4)
			{
				return this.XMLHttpRequestPool[i];
			}
		}
		// ���û�п��еģ����ٴδ���һ���µ�XMLHttpRequest����
		this.XMLHttpRequestPool[this.XMLHttpRequestPool.length] 
			= this.createXMLHttpRequest();
		// ���ظոմ�����XMLHttpRequest����
		return this.XMLHttpRequestPool[this.XMLHttpRequestPool.length - 1];
	},
	// �����µ�XMLHttpRequest����
	createXMLHttpRequest:function()
	{
		// ����DOM 2 �淶�������
		if (window.XMLHttpRequest)
		{
			var objXMLHttp = new XMLHttpRequest();
		}
		// ����Internet Explorer�����
		else
		{
			// ��Internet Explorer���õ�����XMLHTTP ActiveX�������ó�����
			var MSXML = ['MSXML2.XMLHTTP.5.0', 'MSXML2.XMLHTTP.4.0', 
				'MSXML2.XMLHTTP.3.0', 'MSXML2.XMLHTTP', 'Microsoft.XMLHTTP'];
			// ���ζ�Internet Explorer���õ�XMLHTTP�ؼ���ʼ��
			for(var n = 0; n < MSXML.length; n ++)
			{
				try
				{
					// ���������������XMLHttpRequest����ʹ��break����ѭ��
					var objXMLHttp = new ActiveXObject(MSXML[n]); 
					break;
				}
				catch(e)
				{
				}
			}
		}
		// MozillaĳЩ�汾û��readyState����
		if (objXMLHttp.readyState == null)
		{
			// ֱ��������readyStateΪ0
			objXMLHttp.readyState = 0;
			// ������Щû��readyState���Ե����������load����������ĺ�����������
			objXMLHttp.addEventListener("load", function ()
			{
				// ���ӷ���������������ɺ󣬽�readyState״̬��Ϊ4
				objXMLHttp.readyState = 4;
				if (typeof objXMLHttp.onreadystatechange == "function")
				{
					objXMLHttp.onreadystatechange();
				}
			}, false);
		}
		return objXMLHttp;
	},
	// �������ĵ����������� ��������(����[POST,GET],��ַ,����,�ص�����)
	sendRequest: function(method, url, data, callback)
	{
		var objXMLHttp = this.getInstance();
		with(objXMLHttp)
		{
			try
			{
				// ����һ�������randnum������������ڷ�ֹIE�����������Ӧ
				if (url.indexOf("?") > 0)
				{
					url += "&randnum=" + Math.random();
				}
				else
				{
					url += "?randnum=" + Math.random();
				}
				// ���������������
				open(method, url, true);
				// ����ʹ��POST����ʽ
				if (method == "POST")
				{
					// �趨����ͷ
					setRequestHeader('Content-Type', 
						'application/x-www-form-urlencoded');
					send(data);
				}
				// ���ڲ���GET����
				if (method == "GET")
				{
					send(null);
				}
				// ����״̬�ı�Ļص�����
				onreadystatechange = function()
				{
					//�� ����������Ӧ���ʱ���Լ�����������ķ�������Ӧ
					if (objXMLHttp.readyState == 4 &&
						(objXMLHttp.status == 200 || 
							objXMLHttp.status == 304))
					{
						// ����Ӧʱ������ʱ�����ûص�����������Ӧ
						callback.call(null , objXMLHttp);
					}
				}
			}
			catch(e)
			{
				alert(e);
			}
		}
	}
};