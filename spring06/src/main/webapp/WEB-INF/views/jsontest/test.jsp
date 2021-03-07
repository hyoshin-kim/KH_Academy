<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script type="text/javascript"
		src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
	$(function() {
		$('#test1').on('click',function() {
			$.ajax({
				url:'test1.do',					// 클라이언트가 요청을 보낼 서버의 URL 주소
				type:'post',					// HTTP 요청 방식(GET, POST)
				data:{"name":'신사임당'},			// HTTP 요청과 함께 서버로 보낼 데이터
				success:function(result) {
					if(result == 'ok') {
						alert('성공')
					}else {
						alert('실패')
					}
				},
				error:function(request, satus, errorData) {
					alert("error code : " + request.status + "\n"	//500 404 
						  + "message : " + request.responseText		//오류가 난 원인이 메세지로 나옴
						  + "\n" + "error : " + errorData);
				}
			});
		});
		
		$('#test2').on('click',function(){
			$.ajax({
				url:'test2.do',
				type:'post',
				dataType:'json',					 // 서버에서 보내줄 데이터의 타입
				success:function(data){
					$('#d2').html(
						"번호 : " + data.no
						+"<br>제목 : " + data.title
						+"<br>작성자 : " + decodeURIComponent(data.writer)
						+"<br>내용 : " + decodeURIComponent(data.content.replace(/\+/g, " "))
					);
				},
				error:function(request, status, errorData) {
					alert("error code : " + request.status + "\n"
							+"message : " + request.responseText
							+ "\n" + "error : " + errorData);
				}
			});
		});
		
		$('#test3').on('click',function(){
			$.ajax({
				url:"test3.do",		 
				type:'post',
				datatype:'json',
				success: function(data){
					var jsonStr = JSON.stringify(data);
					var json = JSON.parse(jsonStr);
					
					var values=$('#d3').html();
					for(var i in json.list){
						values += json.list[i].userId + ","
						+json.list[i].userPwd + ","
						+decodeURIComponent(json.list[i].userName) + ","
						+json.list[i].userAge + ","
						+json.list[i].userEmail + "<br>"
					}
					//values에 담은 값을 d3이라는 id의 div에 출력한다.
					$('#d3').html(values);
				},
				error:function(request, status, errorData) {
					alert("error code : " + request.status + "\n"
							+"message : " + request.responseText
							+ "\n" + "error : " + errorData);
				}
			});
		});
		
		$('#test4').on('click',function(){
			$.ajax({
				url:'test4.do',
				type:'post',
				dataType:'json',
				success:function(data){
					$('#d4').html('받은 맵 안의 sample 객체 정보 확인<br>'
					+ '이름 : ' + decodeURIComponent(data.sample.name) + '<br>'
					+ '나이 : ' + data.sample.age);
				},
				error:function(request, status, errorData) {
					alert("error code : " + request.status + "\n"
							+"message : " + request.responseText
							+ "\n" + "error : " + errorData);
				}
			});
		});
	});
</script>
<title>Insert title here</title>
</head>
<body>
<input type="button" id="test1" value="test1" />
<input type="button" id="test2" value="test2" />
<input type="button" id="test3" value="test3" />
<input type="button" id="test4" value="test4" />
<div id="d2"></div>
<div id="d3"></div>
<div id="d4"></div>
</body>
</html>