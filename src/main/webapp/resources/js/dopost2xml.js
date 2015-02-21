
var myxmlhttp = "";

function checkit() {

	var uname = document.getElementById("username").value;
	// alert("i am here" + uname);

	
	if (window.XMLHttpRequest) {
		
		myxmlhttp = new XMLHttpRequest();
		
	} else {
		
		myxmlhttp = new ActiveXObject("Microsoft.XMLHTTP");
		
	}
	
	myxmlhttp.onreadystatechange=callbackFunction;
	
	var url = "doxml";
	
	
	myxmlhttp.open("POST",url, true);
	
	myxmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	var data = "name="+uname;
	myxmlhttp.send(data);
	

}

function callbackFunction(){
	
	if(myxmlhttp.readyState==4){
		if(myxmlhttp.status==200){
			
			var domObj = myxmlhttp.responseXML;//接收dom对象
			
			//期望取道message标签的值,首先找到该标签对应的元素节点
			var msgNodes = domObj.getElementsByTagName("message");//通过dom工具的getElementsByName方法,拿到message节点
			
			//这样就找到很多message节点,我们就要第0个,中间的文本内容也是一个子节点
			var textNode =  msgNodes[0].firstChild;
			var respMessage = textNode.nodeValue;
			
			var divNode = document.getElementById("cctv");

			divNode.innerHTML = respMessage;
			
		}
	}
}