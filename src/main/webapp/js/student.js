window.onload = function(){
	let myDrawer = document.getElementById("myDrawer");
	
	// let webSocket = new WebSocket("ws://192.168.50.142:8080/HuiWeb/mycenter");
	// 原本寫死： let webSocket = new WebSocket("ws://10.0.101.46:8080/HuiWeb/mycenter");
	// 改成自動抓取：
	let host = window.location.host; 
	// 自動抓取目前的 IP 和 Port (例如 localhost:8080)
	let path = window.location.pathname.substring(0, window.location.pathname.indexOf("/", 1)); 
	// 自動抓取專案名稱 (例如 /HuiWeb)
	let webSocket = new WebSocket("ws://" + host + path + "/mycenter");
	
	let isConnect = false;
	
	webSocket.onopen = function(){
		isConnect = true;
	}
	webSocket.onmessage = function(event){
		if (isConnect){
			let mesgObj = JSON.parse(event.data);
			if (mesgObj.isClear){
				clear()
			}else {
				if (mesgObj.isNewLine){
					newLine(mesgObj.x, mesgObj.y);
				}else{
					drawLine(mesgObj.x, mesgObj.y);
				}
			}
		}
		
	}
	webSocket.onclose = function(){
		isConnect = false;
	}
	webSocket.onerror = function(event){
		console.log("onError:" + event);
	}
	//--------------------------------
	
	let ctx = myDrawer.getContext("2d");
	
	function clear(){
		ctx.clearRect(0,0,myDrawer.width, myDrawer.height);	
	}
	function newLine(x,y){
		ctx.beginPath();
		ctx.lineWidth = 4;
		ctx.moveTo(x, y);		
	}
	function drawLine(x,y){
		ctx.lineTo(x, y);
		ctx.stroke();		
	}
}