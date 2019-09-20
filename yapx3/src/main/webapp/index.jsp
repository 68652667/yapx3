<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>인덱스</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>
<body>
	
<button onclick="test1();">버튼</button>
	
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
</script>
</body>
</html>