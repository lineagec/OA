function get(url, data, fn) {
	// 创建对象
	var xhr = null;
	try {
		xhr = new XMLHttpRequest();
	} catch(e) {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	if(data) {
		url += ("?" + data);
	}
	xhr.open("get", url);
	
	xhr.onreadystatechange = function () {
		if(4 == xhr.readyState && 200 == xhr.status) {
			var data = eval("(" + xhr.responseText + ")" );
			fn(data);
		}
	}
	
	xhr.send();
}

function post(url, data, fn) {
	// 创建对象
	var xhr = null;
	try {
		xhr = new XMLHttpRequest();
	} catch(e) {
		xhr = new ActiveXObject("Microsoft.XMLHTTP");
	}
	xhr.open("post", url);
	xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");
	xhr.onreadystatechange = function () {
		if(4 == xhr.readyState && 200 == xhr.status) {
			var data = eval("(" + xhr.responseText + ")" );
			fn(data);
		}
	}
	
	xhr.send(data);
}