<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Test1</h1>
	<form:form modelAttribute="dataBean" action="result">	<!-- method는 생략하면 기본이 post -->
		<form:hidden path="a1"/>
		text : <form:input path="a2"/><br/>
		password : <form:password path="a3" showPassword="true"/><br/>
		textarea : <form:textarea path="a4"/><br/>
		<form:button disabled="true">확인버튼</form:button>	<!-- type은 submit / disabled은 true면 비활성화 -->
	</form:form>
</body>
</html>