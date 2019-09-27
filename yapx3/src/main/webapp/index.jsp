<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	
<c:if test="${memberLoggedIn!=null}">
<span>${memberLoggedIn.userNickname} 님, 안녕하세요</span>
</c:if>
<button onclick="test1();">버튼</button>
<button onclick="loginClick();">login버튼</button>

<script>
function test1() {
	$.ajax({
		url : "${pageContext.request.contextPath}/match/test",
		type :"GET",
		dataType : "json",
		success : function(data){
			console.log(data);
		},
		error : function(err){
			console.log("fail");
		}
	});
}

function loginClick() {
	console.log( "loginClick" );
	location.href = "${pageContext.request.contextPath}/user/loginClick.do";
}
</script>
</body>
</html>