function sendMessage()
{
	var p = {
		name : $("name").value,
		age : 29};
	hello.hello(p, cb);
}
function cb(data)
{
	$("show").innerHTML = data;
}
