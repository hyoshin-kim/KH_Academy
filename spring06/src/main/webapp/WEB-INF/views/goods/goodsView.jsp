<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1"  style="text-align:enter">
		<tr><th>코드</th><th>이름</th><th>가격</th><th>색상</th></tr>
			<tr>
				<td>${goods.code}</td>
				<td>${goods.name}</td>
				<td>${goods.price}</td>
				<td>${goods.color}</td>
			</tr>
			<tr>
				<td colspan="6"><a href="goodsList.do">목록</a></td>
			</tr>
	</table>
</body>
</html>