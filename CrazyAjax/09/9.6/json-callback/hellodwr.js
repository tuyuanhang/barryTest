// 使用JSON对象指定各种回调选项
function sendMessage()
{
	var name = $("name").value;
	hello.hello(name , 
	{
		// 指定回调函数
		callback:cb,
		// 指定超时时长
		timeout:5000,
		// 指定错误处理函数
		errorHandler:function(message) { alert("错误提示: " + message); },
		warningHandler:function(message) { alert("Oops: " + message); },
		textHtmlHandler: function(message) { alert("Oops: " + message); },
		exceptionHandler: function(message) { alert("Oops: " + message); },
		// 指定发送请求的方式
		httpMethod:'POST',
		async:true,
		// 指定发送异步请求的实现机制
		rpcType:dwr.engine.XMLHttpRequest,
		// 指定发送请求之前的勾子函数
		preHook:function(){alert('远程调用之前...')},
		// 指定发送请求之后的勾子函数
		postHook:function(){alert('远程调用之后...')}
	});
}
// 回调函数
function cb(data)
{
	document.getElementById("show").innerHTML = data;
}
