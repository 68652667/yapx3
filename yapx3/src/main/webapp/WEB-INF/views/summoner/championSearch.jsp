<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8" session="false"%>
<html>
<head>
<style>
table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	font-family: Arial;
}
img {
	width : 100;
	height : 100;
}
#chamImage{
	padding : 10px;
}
</style>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="text/javascript"
	src="http://cdnjs.cloudflare.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>
<script type="text/javascript"
	src="http://netdna.bootstrapcdn.com/bootstrap/3.3.4/js/bootstrap.min.js"></script>
<link
	href="http://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.3.0/css/font-awesome.min.css"
	rel="stylesheet" type="text/css">
<link
	href="http://pingendo.github.io/pingendo-bootstrap/themes/default/bootstrap.css"
	rel="stylesheet" type="text/css">
</head>
<body>
	<div class="section">
		<div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h1>League Of Legends</h1>
					<p>챔피언 분석</p>
					<br>
					<form role="form">
						<div class="form-group">
							<label class="control-label" for="exampleInputEmail1">챔피언 이름</label> 
							<input class="form-control" id="exampleInputEmail1"
								   placeholder="챔피언 이름을 입력하세요." 
								   type="text" name="username"
								   style="width : 500px; text-align : center; margin-left: 100px;">
						</div>
						<button type="button" class="btn btn-default">Search</button>
					</form>
					<br> <br>
					<form role="form">
						<div class="form-group">
							<label class="control-label" for="exampleInputEmail1">챔피언</label> 
							<table id="champion" style="text-align: center; margin-left: 100px; margin-top : 10px;">
								
							</table>
						</div>
					</form>
				</div>
			</div>
		</div>
	</div>
<script>
	$( () => {
		$.ajax({
			url : "${pageContext.request.contextPath}/summoner/championAll",
			type : "GET",
			dataType : "json",
			success : function( data ){
				console.log( data );
				var chamHmtml = "<img id='chamImage' src='https://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/";
				var chamHmtml2 = "'>";
				data = data.sort();
				for(var i = 0; i < data.length; i++){
					var html = chamHmtml + data[i] + chamHmtml2;
					if( i%5 == 4 ){	
						html += "<br/>";
					}
					$("#champion").append( html );
				}
			},
			error : function( xhr, txtStatus, err ){
				console.log( xhr, txtStatus, err );
			}
		});
	} );
</script>
</body>
</html>