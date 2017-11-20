<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script>
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
	
	function show() { // 요청함수
		XHR = getXHR();
	
		var name = document.fm.name.value;
		var param = 'name=' + name;
	
		XHR.onreadystatechange = showResult;
		XHR.open('GET', 'test.jsp?'+param, true);
		XHR.send(null);
	}
	
	function showResult() { // 응답함수
		if(XHR.readyState == 4) {
			if(XHR.status == 200) {
				var data = XHR.responseText;
				window.alert(data);
			}	
		}
	}
</script>
</head>
<body>
<form name="fm" enctype="application/x-www-form-urlencoded">
이름 : <input type="text" name="name">
<input type="button" value="AjaxTest" onclick="show()">
</form>
</body>
</html>