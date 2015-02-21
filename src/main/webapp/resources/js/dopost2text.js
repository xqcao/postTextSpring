
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
	
	var url = "dotext";
	
	//对应的url:localhost:8082/demo/dotext
	
	
	myxmlhttp.open("POST",url, true);
	
	myxmlhttp.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	
	var data = "name="+uname;
	myxmlhttp.send(data);
	

}

function callbackFunction(){
	
	if(myxmlhttp.readyState==4){
		if(myxmlhttp.status==200){
			
			var respObj = myxmlhttp.responseText;
			
			var divNode = document.getElementById("cctv");

			divNode.innerHTML = respObj;
			
		}
	}
}