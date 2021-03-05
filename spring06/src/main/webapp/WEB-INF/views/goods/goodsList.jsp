<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1"  style="text-align:enter">
		<tr><th>코드</th><th>이름</th><th>가격</th><th>색상</th><th>수정</th><th>삭제</th></tr>
		<c:forEach var="list" items="${list}">
			<tr>
				<td><a href="goodsView.do?code=${list.code}">${list.code}</a></td>
				<td>${list.name}</td>
				<td>${list.price}</td>
				<td>${list.color}</td>
				<td><a href="goodsUpdate.do?code=${list.code}">수정</a></td>
				<td><a href="goodsDelete.do?code=${list.code}">삭제</a></td>
			</tr>
		</c:forEach>
		<tr>
			<td colspan="6"><a href="goodsInsert.do">추가</a></td>
		</tr>
	</table>
</body>
</html>