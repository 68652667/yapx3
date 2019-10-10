
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<!DOCTYPE html>
<html>
<title>YapYapYap</title>
<meta charset="UTF-8">

<title>인덱스</title>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
</head>


<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
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
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.em3but {height: 3em;}

img {
	width : 100;
	height : 100;
}

#championLote{
	cursor: pointer;
}

</style>
<body class="w3-theme-l5">

<!-- Navbar -->

<div class="w3-top" style="top: 3em;">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a href="${pageContext.request.contextPath}/champion/championView" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white em3but" >챔피언분석</a>
  <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large w3-hover-white" >통계</button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block w3-white" style="width:300px;">
      <a href="${pageContext.request.contextPath}/stat/statChamp.do" class="w3-bar-item w3-button">챔피언별 통계</a>
      <a href="${pageContext.request.contextPath}/stat/statTear.do" class="w3-bar-item w3-button">티어별 통계</a>
    </div>
  </div>
  <a href="${pageContext.request.contextPath}/ranking/ladder.do?page=1" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white em3but" >랭킹</a>
  <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large" >커뮤니티</button>
    <div class="w3-dropdown-content w3-card-4 w3-bar-block w3-white" style="width:300px;">
      <a href="${pageContext.request.contextPath}/free/freeList.do" class="w3-bar-item w3-button">자유게시판</a>
      <a href="${pageContext.request.contextPath}/tip/tipList.do" class="w3-bar-item w3-button">팁게시판</a>
      <a href="${pageContext.request.contextPath}/gontip/gontipList.do" class="w3-bar-item w3-button">공략게시판</a>
      <a href="${pageContext.request.contextPath}/board/viewRoom.do" class="w3-bar-item w3-button">소환사 구인구직</a>
    </div>
  </div>
 </div>
</div>

<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="${pageContext.request.contextPath}/" class="w3-bar-item w3-button w3-padding-large w3-theme-d4 em3but w3-hover-white">YapX3</a>
  <c:if test="${memberLoggedIn!=null}">
	<a href="${pageContext.request.contextPath}/user/logoutClick.do" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">
	 	 로그아웃
	</a>
	<div class="w3-dropdown-hover w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" id="btnHoverCheck" title="${memberLoggedIn.userNickname}">
		<img src="${pageContext.request.contextPath}/resources/images/login_icon.png" width="30" height="30" alt="${memberLoggedIn.userNickname}"/>  
		<div class="w3-dropdown-content w3-card-4 w3-bar-block w3-white">
		    <button class="w3-bar-item w3-button" onclick="messageClick();" title="" id="messageBtn" >쪽지함</button>
			<button class="w3-bar-item w3-button" onclick="myPassClick();" title="">비밀번호 변경</button>
			<button class="w3-bar-item w3-button" onclick="myBoardClick();" title="">내글보기</button>
			<c:if test="${memberLoggedIn.userCode == 0 }">
				<button class="w3-bar-item w3-button" onclick="memberClick();" title="">회원관리</button>
			</c:if>
		</div>
	</div>
	<script>
		$(()=>{
			$( "#btnHoverCheck" ).hover(function(){
				
				messageCount();
			});
		});
		
		function messageCount() {
			var memberId = "${memberLoggedIn.userEmail}";
			console.log( "memberId : ", memberId );
			$.ajax({
				url : "${pageContext.request.contextPath}/message/messageCount.do",
				data : { memberId : memberId },
				//dataType : "json",
				success: data => {
					console.log( data ); //json타입이 js object로 변환되어 전달됨.
					if( data > 0 ) {
						$( "#messageBtn" ).html( "<span>쪽지함<span style = 'color:red;'>( " + data + " )</span></span>" );
					}else {
						$( "#messageBtn" ).html( "<span>쪽지함</span>" );
					}
				},
				error: ( jqxhr, textStatus, errorThrown ) => {
					console.log( "ajax처리실퍠!", jqxhr, textStatus, errorThrown );
				}
			
			});
		}
	</script>
  </c:if>
  <c:if test="${memberLoggedIn==null}">
	  <a href="${pageContext.request.contextPath}/user/loginClick.do" class="w3-hover-pink w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">
	    로그인
	  </a>
  </c:if>
 </div>
</div>

<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1024px;margin-top:115px; min-height: 768px;">    
   
   <div class="container">
			<div class="row">
				<div class="col-md-12 text-center">
					<h1>League Of Legends</h1>
					<p>전적 검색</p>
					<br>
						<div class="form-group">
							<input class="form-control" id="exampleInputEmail1"
								   placeholder="소환사 이름을 입력하세요." 
								   type="text" name="username"
								   style="width : 500px; text-align : center; margin-left: 200px;">
						</div>
					<br> <br>
					<form role="form">
						<div class="form-group" style="margin-left: 49px;">
							<label class="control-label" for="exampleInputEmail1" style="margin-bottom: 28px; margin-right: 51px; font-size: 25px;">금주의 로테이션</label> 
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
   
   
<!-- End Page Container -->
</div>

<footer class="w3-container w3-theme-d5">
  KH. YapYapYap
</footer>
 
<script>
// Accordion
function myFunction(id) {
  var x = document.getElementById(id);
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
    x.previousElementSibling.className += " w3-theme-d1";
  } else { 
    x.className = x.className.replace("w3-show", "");
    x.previousElementSibling.className = 
    x.previousElementSibling.className.replace(" w3-theme-d1", "");
  }
}

function openNav() {
  var x = document.getElementById("navDemo");
  if (x.className.indexOf("w3-show") == -1) {
    x.className += " w3-show";
  } else { 
    x.className = x.className.replace(" w3-show", "");
  }
}

function messageClick() {
	var popup = "width=470,height=600,resizable=no,scrollbars=no,status=no";
	window.open( "${pageContext.request.contextPath}/message/message?memberId=${memberLoggedIn.userEmail}", "", popup ).focus();
}

function myPassClick() {
	var popup = "width=500,height=150,resizable=no,scrollbars=no,status=no";
	window.open( "${pageContext.request.contextPath}/user/updatePassword?memberId=${memberLoggedIn.userEmail}", "", popup ).focus();
}

function memberClick() {
	location.href = "${pageContext.request.contextPath}/user/memberList";
}

function myBoardClick() {
	location.href = "${pageContext.request.contextPath}/user/myBoardList?memberId=${memberLoggedIn.userEmail}";
}

</script>

<script>
	$( () => {
		
		$.ajax({
			url : "${pageContext.request.contextPath}/summoner/champion",
			type : "GET",
			dataType : "json",
			success : function( data ){
				console.log( data );

				for(var i = 0; i <data.length; i++){
					var html = "<a href='${pageContext.request.contextPath}/champion/championInfo?championId="+data[i].ChamNum+"'><img src='https://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].ChamName+"'>'"+"</a>";
					
					
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
		
		
		
		
		
		$("#exampleInputEmail1").on("keypress", function(e){
			
			console.log(e.keyCode);
			
			if(e.keyCode == '13'){
			
			$("#summonerRank").html("");
			
			var summonerName = $(".form-control").val();
			location.href = "${pageContext.request.contextPath}/summoner/summonerView?Name=" + summonerName;
			
			}
			
		});
		
		
	});
	
</script>

</body>
