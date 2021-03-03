<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="memberUpt.do" method="POST">
	아이디 : <input type="text" name="id" readonly value="${member.id}"><br/>
	비밀번호 : <input type="password" name="passwd"><br/>
	이름 : <input type="text" name="name"><br/>
	남여구분 : 남<input type="radio" name="gender" value="M" ${member.gender =='M' ? 'checked' : ''}>
			 여<input type="radio" name="gender" value="F" ${member.gender =='F' ? 'checked' : ''}><br/>
	나이 : <input type="text" name="age"><br/>
	<input type="submit">
</form>
</body>
</html>