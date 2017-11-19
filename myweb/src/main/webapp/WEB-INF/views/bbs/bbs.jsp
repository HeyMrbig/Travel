<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>자유게시판</h2>
<table>
	<thead>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>조회수</th>	
		</tr>
	</thead>
	<tbody>
		<c:if test="${empty list}">
			<tr>
				<td colspan="4" align="center"> 등록된 게시물이 없습니다.</td>
			</tr>
		</c:if>
		<c:forEach var="dto" items="${list}">
			<tr>
				<c:url var="bbsUrl" value="bbsContent.do">
					<c:param name="idx">${dto.idx}</c:param>
				</c:url>
				<td>${dto.idx}</td>
				<td><a href="${bbsUrl}">${dto.subject}</a></td>
				<td>${dto.writer}</td>
				<td>${dto.readnum}</td>
			</tr>
		</c:forEach>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="3" align="center">${pageStr}</td>
			<td><a href="bbsWrite.do">글쓰기</a></td>
		</tr>
	</tfoot>
</table>
</body>
</html>