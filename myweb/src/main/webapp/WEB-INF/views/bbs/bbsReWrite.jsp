<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자유게시판 답글쓰기</h2>
<form name="bbsReWrite" action="bbsReWrite.do" method="post">
	<input type="hidden" name="ref" value="${dto.ref}">
	<input type="hidden" name="lev" value="${dto.lev}">
	<input type="hidden" name="sunbun" value="${dto.sunbun}">
	<table>
		<tr>
			<th>작성자</th>
			<td><input type="text" name="writer"></td>
			<th>비밀번호</th>
			<td><input type="password" name="pwd"></td>
		</tr>
		<tr>
			<th>제목</th>
			<td colspan="3">
				<input type="text" name="subject" value="re)${dto.subject}">
			</td>
		</tr>
		<tr>
			<td colspan="4">
				<textarea rows="10" cols="45" name="content"></textarea>
			</td>
		</tr>
		<tr>
			<td colspan="4" align="center">
				<input type="submit" value="글쓰기">
				<input type="reset" value="다시작성">
			</td>
		</tr>
	</table>
</form>
</body>
</html>