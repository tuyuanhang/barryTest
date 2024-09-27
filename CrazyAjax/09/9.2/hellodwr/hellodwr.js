// -------------发送简单字符串参数，返回普通字符串--------------
function sendMessage()
{
	// 获取页面中name元素的值
	var name = document.getElementById("name").value;
	// 调用远程方法，cb是回调函数
	hello.hello(name , cb)
}
function cb(data)
{
	document.getElementById("show").innerHTML = data;
}
// -----------发送一个JavaBean对象作为参数，返回普通字符串------------
function sendObject()
{
	var nameValue = document.getElementById("name").value;
	// 调用远程方法，使用JavaScript对象作为参数
	hello.sendObj({name:nameValue} , cb);
}

// ----------------调用返回JavaBean方法-----------------
function getBean()
{
	var name = document.getElementById("name").value;
	// 调用远程方法，beanCb是回调函数
	hello.getBean(name , beanCb)
}
function beanCb(data)
{
	// 服务器方法返回JavaBean对象，客户端的data是JavaScript对象
	document.getElementById("show").innerHTML = 
		data.name + "，您好，您已经学会了使用JavaBean返回值";
}
// ----------------调用返回getObject方法---------------
function getObject()
{
	var name = document.getElementById("name").value;
	// 调用远程方法，objCb是回调函数
	hello.getObject(name , objCb)
}
function objCb(data)
{
	// 服务器方法返回非JavaBean式的对象，客户端的data是JavaScript对象
	document.getElementById("show").innerHTML = 
		data.name + "，是从服务器返回的猫的名字";
}
// ---------------调用返回集合的方法--------------
function getBeanList()
{
	// 调用远程方法，listCb返回回调函数
	hello.getPersonList(listCb);
}
// 远程Java方法返回List对象，集合元素是JavaBean式的对象
// 此处的data是JavaScript对象数组
function listCb(data)
{
	var result='';
	// 遍历每个数组元素
	for (var i = 0 ; i < data.length ; i ++)
	{
		result += data[i].name + "<br />";
	}
	document.getElementById("show").innerHTML = result;
}
// ---------------调用返回数组的方法--------------
function getBeanArray()
{
	hello.getPersonArray(arrayCb);
}
function arrayCb(data)
{
	var result = "";
	// 下面的data是远程Java方法的返回值，
	// data是个数组，遍历数组。
	for (var i = 0 ; i < data.length ; i ++)
	{
		//依次访问数组元素，数组元素是JSON格式的对象，访问其name属性
		result += data[i].name + "<br />";
	}
	document.getElementById("show").innerHTML = result;
}
// ---------------调用返回Map对象的方法-------------
function getBeanMap()
{
	hello.getPersonMap(mapCb);
}
// 远程Java方法返回Map对象，集合元素是JavaBean式的对象
// 此处的data是JavaScript对象，且每个属性值都是JavaScript对象
function mapCb(data)
{
	var result='';
	for (var key in data)
	{
		result += "键为" + key + ",其值为:" + data[key].name + "<br />";
	}
	document.getElementById("show").innerHTML = result;
}

// ---------------调用发送集合的方法-------------------
function sendBeanList()
{
	// 创建JavaScript数组
	var args = [
		{name:"客户端aaa"},
		{name:"客户端bbb"},
		{name:"客户端ccc"}
	];
	// Java方法需要List参数，以JavaScript数组作为参数调用远程方法
	hello.sendList(args , sendListCb);
}
function sendListCb(data)
{
	document.getElementById("show").innerHTML = data;
}
// ---------------调用发送无泛型限制的集合--------------------
function sendBeanListNoGeneric()
{
	// 创建JavaScript数组
	var args = [
		{name:"客户端aaa"},
		{name:"客户端bbb"},
		{name:"客户端ccc"}
	];
	// Java方法需要List参数，以JavaScript数组作为参数调用远程方法
	hello.sendListNoGeneric(args , sendListCb);
}
// ---------------调用发送Map的方法-------------------------
function sendBeanMap()
{
	// 创建JavaScript对象
	var args = {
		first:{name:"客户端aaa"},
		second:{name:"客户端bbb"},
		third:{name:"客户端ccc"}
	};
	// Java方法需要Map参数，以JavaScript对象作为参数调用远程方法
	hello.sendMap(args , sendMapCb);
}
function sendMapCb(data)
{
	document.getElementById("show").innerHTML = data;
}
