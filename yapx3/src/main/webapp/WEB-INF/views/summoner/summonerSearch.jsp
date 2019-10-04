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
					<p>전적 검색</p>
					<br>
					<form role="form">
						<div class="form-group">
							<label class="control-label" for="exampleInputEmail1">소환사 이름</label> 
							<input class="form-control" id="exampleInputEmail1"
								   placeholder="소환사 이름을 입력하세요." 
								   type="text" name="username"
								   style="width : 500px; text-align : center; margin-left: 100px;">
						</div>
						<button type="button" class="btn btn-default">Search</button>
						<table id="summonerStatus" style="text-align: center; margin-left: 100px;"></table>
						<table id="summonerRank" style="text-align: center; margin-left: 100px; margin-top : 10px;"></table>
					</form>
					<br> <br>
					<form role="form">
						<button id="spectatorBoolean" style="display: none;">인게임정보</button>
					</form>
					<br /><br />
					<form role="form">
						<div class="form-group">
							<label class="control-label" for="exampleInputEmail1">금주의 로테이션</label> 
							<table id="championLote" style="text-align: center; margin-left: 100px; margin-top : 10px;">
								
							</table>
						</div>
					</form>
						<form id="frm" name="frm">
						<input type="hidden" name="summonerName" id="summonerView" />
						<input type="hidden" name="summonerId" id="summonerId" />
						</form>
				</div>
			</div>
		</div>
	</div>
<script>
	$( () => {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/summoner/champion",
			type : "GET",
			dataType : "json",
			success : function( data ){
				console.log( data );
				var chamHmtml = "<img src='https://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/";
				var chamHmtml2 = "'>";

				for(var i = 0; i < data.length; i++){
					var html = chamHmtml + data[i] + chamHmtml2;
					if( i%5 == 4 ){	
						html += "<br/>";
					}
					$("#championLote").append( html );
				}
			},
			error : function( xhr, txtStatus, err ){
				console.log( xhr, txtStatus, err );
			}
		});
		
		
		
		$(".btn").on("click", function(){
			$("#summonerRank").html("");
			$("#spectatorBoolean").attr("style","display: none;");
			var summonerName = $(".form-control").val().replace(/ /g,"%20");
			
			console.log( summonerName );
			var summonerId;
			
			$.ajax({
 				url : "${pageContext.request.contextPath}/summoner/search?summonerName=" + summonerName,
				type : "GET",
				async : false,
				dataType : "json",
				success : function( data ){
					console.log( data );
					var html = "<tr>" +
							   "<td>" + "<img src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/profileicon/"+ data.profileIconId +".png'></td>" +
							   "</tr>" +
							   "<tr>" +
							   "<td>" + "닉네임 : " + data.name + "</td>" +
							   "</tr>" +
							   "<tr>" +
							   "<td>" + "레벨 : " + data.summonerLevel + "</td>" +
							   "</tr>";
					$("#summonerStatus").html(html);		
					summonerId = data.id;
					$("#summonerView").attr("value",data.name);
					$("#summonerId").attr("value",data.id);
				},
				error : function( xhr, txtStatus, err ){
					console.log( xhr, txtStatus, err );
				},
			});
			
			console.log( summonerId );
			
			$.ajax({
 				url : "${pageContext.request.contextPath}/summoner/league?summonerId=" + summonerId,
				type : "GET",
				async : false,
				dataType : "json",
				success : function( data ){
					console.log( data );
					for(var i in data){
						var html = "";
						if( data[i].queueType != "RANKED_TFT" ){
						   if( data[i].queueType == "RANKED_FLEX_SR" ){
							   html += "<tr>" +
							   "<td>" + "랭크타입 : " + "자유 5:5 랭크" + "</td>" +
							   "</tr>";
						   }else if( data[i].queueType == "RANKED_SOLO_5x5" ){
							   html += "<tr>" +
							   "<td>" + "랭크타입 : " + "솔로랭크" + "</td>" +
							   "</tr>";
						   }
						   if( data[i].tier == "IRON" ){
							   html += "<tr>" +
							   "<td>"  + "<img src='${pageContext.request.contextPath}/resources/images/tier/IRON.png'>" + "</td>" +
							   "</tr>";
						   }else if( data[i].tier == "BRONZE" ){
							   html += "<tr>" +
							   "<td>"  + "<img src='${pageContext.request.contextPath}/resources/images/tier/BRONZE.png'>" + "</td>" +
							   "</tr>";
						   }else if( data[i].tier == "SILVER" ){
							   html += "<tr>" +
							   "<td>"  + "<img src='${pageContext.request.contextPath}/resources/images/tier/SILVER.png'>" + "</td>" +
							   "</tr>";
						   }else if( data[i].tier == "GOLD" ){
							   html += "<tr>" +
							   "<td>"  + "<img src='${pageContext.request.contextPath}/resources/images/tier/GOLD.png'>" + "</td>" +
							   "</tr>";
						   }else if( data[i].tier == "PLATINUM" ){
							   html += "<tr>" +
							   "<td>"  + "<img src='${pageContext.request.contextPath}/resources/images/tier/PLATINUM.png'>" + "</td>" +
							   "</tr>";
						   }else if( data[i].tier == "DIAMOND" ){
							   html += "<tr>" +
							   "<td>"  + "<img src='${pageContext.request.contextPath}/resources/images/tier/DIAMOND.png'>" + "</td>" +
							   "</tr>";
						   }else if( data[i].tier == "MASTER" ){
							   html += "<tr>" +
							   "<td>"  + "<img src='${pageContext.request.contextPath}/resources/images/tier/MASTER.png'>" + "</td>" +
							   "</tr>";
						   }else if( data[i].tier == "GRANDMASTER" ){
							   html += "<tr>" +
							   "<td>"  + "<img src='${pageContext.request.contextPath}/resources/images/tier/GRANDMASTER.png'>" + "</td>" +
							   "</tr>";
						   }else if( data[i].tier == "CHALLENGER" ){
							   html += "<tr>" +
							   "<td>"  + "<img src='${pageContext.request.contextPath}/resources/images/tier/CHALLENGER.png'>" + "</td>" +
							   "</tr>";
						   }
						   html +=
								   "<tr>" +
								   "<td>" + "티어 : " + data[i].tier + " " + data[i].rank + "</td>" +
								   "</tr>" +
								   "<tr>" +
								   "<td>" + "리그포인트 : " + data[i].leaguePoints + " LP</td>" +
								   "</tr>" +
								   "<tr>" +
								   "<td>" + data[i].wins + "승" + " " + data[i].losses + "패</td>" +
								   "</tr>" +
								   "<tr>" +
								   "<td>" + "승률 : " + Math.round(( data[i].wins/( data[i].wins + data[i].losses ) )*100) + "%</td>" +
								   "</tr>";
						   $("#summonerRank").append(html);
						}
					}
				},
				error : function( xhr, txtStatus, err ){
					console.log( xhr, txtStatus, err );
				}
			});
			
// 			$.ajax({
// 				url : "${pageContext.request.contextPath}/summoner/spectator?summonerId="+summonerId,
// 				tpye : "GET",
// 				dataType : "json",
// 				success : function( data ){
// 					console.log(data);
// 						$("#spectatorBoolean").attr("style","background-color: pink; display: inline;");
					
// 				},
// 				error : function( xhr, txtStatus, err ){
// 					console.log( xhr, txtStatus, err );
// 				}
// 			});
		
		});
		
		
		//소환사 프로필클릭시 상세보기로 이동
		$("#summonerStatus").on('click',function(){
			
			var Name = $("#summonerView").val();
			var summonerId2 = $("#summonerId").val();
			
			$.ajax({
				url : "${pageContext.request.contextPath}/summoner/summonerView?Name="+Name+"&summonerId="+summonerId2,
				type : "GET",
				dataType : "text",
				data : {
					"Name" : Name,
					"summonerId" : summonerId2
				},
				success : function(data){
					console.log(data);
				location.href = "${pageContext.request.contextPath}/summoner/summonerView?Name="+Name+"&summonerId="+summonerId2;
				},
				error : function( xhr, txtStatus, err ){
					console.log( xhr, txtStatus, err );
				}
			});
			
		});
		
		
	});
		
	
	
			
	
</script>
</body>
</html>