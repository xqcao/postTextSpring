var myxmlhttp = "";

function checkit() {

	var uname = document.getElementById("username").value;
	// alert("i am here" + uname);

	if (window.XMLHttpRequest) {

		myxmlhttp = new XMLHttpRequest();

	} else {

		myxmlhttp = new ActiveXObject("Microsoft.XMLHTTP");

	}

	myxmlhttp.onreadystatechange = callbackFunction;

	var url = "dojson";

	myxmlhttp.open("POST", url, true);

	myxmlhttp.setRequestHeader("Content-Type",
			"application/x-www-form-urlencoded");

	var data = "name=" + uname;
	myxmlhttp.send(data);

}

function callbackFunction() {

	if (myxmlhttp.readyState == 4) {
		if (myxmlhttp.status == 200) {

			var domObj = myxmlhttp.responseText;// 接收dom对象
			
			var prejson = eval("("+domObj+")");//通过eval函数将serviet返回的数据转成对象数组
			
			var divNode = document.getElementById("cctv");
			var divNode2 = document.getElementById("tv");
			divNode.innerHTML = prejson.msg;
			divNode2.innerHTML = prejson.name;
			document.getElementById("lisi").value=prejson.name;
		}
	}
}