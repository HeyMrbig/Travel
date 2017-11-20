<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript" src="js/httpRequest.js"></script>
<script>
	function show() {
		var name = document.fm.name.value;
		var param = "name=" + name;
		
		sendRequest('test.jsp', param, showResult, 'GET');
	}
	
	function showResult() {
		if(XHR.readyState == 4) {
			if(XHR.status == 200) {
				var data = XHR.responseText;
				alert(data);
			}
		}
	}
</script>
</head>
<body>
<form name="fm">
이름 : <input type="text" name="name">
<input type="button" value="AjaxTest" onclick="show()">
</form>
</body>
</html>