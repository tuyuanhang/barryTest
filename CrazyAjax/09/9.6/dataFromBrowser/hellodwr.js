function sendMessage()
{
	var name = $("name").value;
	// 远程方法，callbackAdapter包装了回调函数
	hello.hello(name , callbackAdapter);
}
var fromBrowser = "客户端变量";
// 定义闭包函数来存储fromBrowser的引用，并调用fromServer
var callbackAdapter = function(fromServer) 
{
	cb(fromServer, fromBrowser); 
}; 
// 真正的回调函数，同时需要服务器数据和客户端数据
function cb(fromServer , fromBrowser)
{
	var show = document.getElementById("show");
	show.innerHTML += "服务器数据：" + fromServer + "<br />";
	show.innerHTML += "浏览器变量：" + fromBrowser;
}