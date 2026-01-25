window.onload = function() {
	let clear = document.getElementById("clear");
	let myDrawer = document.getElementById("myDrawer");
	
	// let webSocket = new WebSocket("ws://192.168.50.142:8080/HuiWeb/mycenter");;
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
		webSocket.send(JSON.stringify({isTeacher : true}));
	}
	
	webSocket.onclose = function(){
		// console.log("onClose");
		isConnect = false;
	}
	
	webSocket.onerror = function(event){
		console.log("onError" + event);
	}
	
	// 畫線 ------------------------------------
	
	let ctx = myDrawer.getContext("2d");
	let isDrag = false;
	
	myDrawer.onmousedown = function(e){
		isDrag = true;
		let x = e.offsetX, y = e.offsetY;
		ctx.beginPath();
		ctx.lineWidth = 4;
		ctx.moveTo(x, y);
		
		let data = {
			isClear : false,
			isNewLine : true,
			x : x,
			y : y
		};
		webSocket.send(JSON.stringify(data));
	}
	myDrawer.onmouseup = function(e){
		isDrag = false;
	}
	myDrawer.onmousemove = function(e){
		if(isDrag){
			let x = e.offsetX, y = e.offsetY;
			ctx.lineTo(x, y);
			ctx.stroke();
			
			let data = {
				isClear : false,
				isNewLine : false,
				x : x,
				y : y
			};
			webSocket.send(JSON.stringify(data));
		}
	}
	
	clear.addEventListener("click", function(){
		ctx.clearRect(0, 0, myDrawer.width, myDrawer.height);
		let data = {
			isClear : true
		};
		webSocket.send(JSON.stringify(data));
		
	});
	
	
}