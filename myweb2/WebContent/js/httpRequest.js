var XHR = null;

function getXHR() {
	if(window.ActiveXObject) {
		return new ActiveXObject('Msxml2.XMLHTTP');
	} else if(window.XMLHttpRequest) {
		return new XMLHttpRequest();
	} else {
		return null;
	}
}

function sendRequest(url, params, callback, method) {
	
	XHR = getXHR();
	
	var httpMethod = method ? method : 'GET';
	if(httpMethod!='GET' && 'POST') {
		httpMethod = 'GET';
	}
	
	var httpParam = (params == null || params == '') ? null : params;
	var httpUrl = url;
	if(httpMethod == 'GET' && httpParam != null) {
		httpUrl = httpUrl + '?' + httpParam;
	}
	
	XHR.onreadystatechange = callback;
	XHR.open(httpMethod, httpUrl, true);
	XHR.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
	XHR.send(httpMethod == 'POST' ? httpParam : null);
}