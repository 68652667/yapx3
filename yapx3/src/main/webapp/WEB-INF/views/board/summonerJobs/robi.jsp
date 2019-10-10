<%@page import="com.kh.yapx3.user.model.vo.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:115px; min-height: 768px;">    
<style>
	#chat_box, #main_box{
		width : 800px;
		min-width: 800px;
	    height: 300px;
	    min-height: 300px;
	    border: 1px solid black;
	    margin-top : -10px;
	    margin-left: 80px;
	}
	#inputMessage {
	    width: 550px;
	    height: 30px;
	}
	#msg_process {
		    width: 70px;
		    height: 37px;
	}
	#main_container{
		margin : 0 auto;
	}
		.checkbox {
    margin-top : 10px; }
.checkbox label {
    display: inline-block;
    position: relative;
    margin-left: 10px;
    }
.checkbox label::before {
    content: "";
    display: inline-block;
    position: absolute;
    width: 17px;
    height: 17px;
    left: 0;
    margin-top: 4px;
    margin-left: -20px;
    border: 1px solid #cccccc;
    border-radius: 3px;
    background-color: #fff;
    -webkit-transition: border 0.15s ease-in-out, color 0.15s ease-in-out;
    -o-transition: border 0.15s ease-in-out, color 0.15s ease-in-out;
    transition: border 0.15s ease-in-out, color 0.15s ease-in-out; }
.checkbox label::after {
    display: inline-block;
    position: absolute;
    width: 16px;
    height: 16px;
    left: 0;
    top: 0;
    margin-left: -20px;
    padding-left: 3px;
    padding-top: 4px;
    font-size: 11px;
    color: #555555; }
.checkbox input[type="checkbox"] {
    opacity: 0; }
.checkbox input[type="checkbox"]:focus + label::before {
    outline: thin dotted;
    outline: 5px auto -webkit-focus-ring-color;
    outline-offset: -2px; }
.checkbox input[type="checkbox"]:checked + label::after {
    font-family: 'FontAwesome';
    content: "\f00c"; }
.checkbox input[type="checkbox"]:disabled + label {
    opacity: 0.65; }
.checkbox input[type="checkbox"]:disabled + label::before {
    background-color: #eeeeee;
    cursor: not-allowed; }
.checkbox.checkbox-circle label::before {
    border-radius: 50%; }
.checkbox.checkbox-inline {
    margin-top: 0; }

.checkbox-primary input[type="checkbox"]:checked + label::before {
    background-color: #428bca;
    border-color: #428bca; }
.checkbox-primary input[type="checkbox"]:checked + label::after {
    color: #fff; }

.checkbox-danger input[type="checkbox"]:checked + label::before {
    background-color: #d9534f;
    border-color: #d9534f; }
.checkbox-danger input[type="checkbox"]:checked + label::after {
    color: #fff; }

.checkbox-info input[type="checkbox"]:checked + label::before {
    background-color: #5bc0de;
    border-color: #5bc0de; }
.checkbox-info input[type="checkbox"]:checked + label::after {
    color: #fff; }

.checkbox-warning input[type="checkbox"]:checked + label::before {
    background-color: #f0ad4e;
    border-color: #f0ad4e; }
.checkbox-warning input[type="checkbox"]:checked + label::after {
    color: #fff; }

.checkbox-success input[type="checkbox"]:checked + label::before {
    background-color: #5cb85c;
    border-color: #5cb85c; }
.checkbox-success input[type="checkbox"]:checked + label::after {
    color: #fff; }

.radio {
	margin-left : 10px;
    }
.radio label {
    display: inline-block;
    position: relative;
    padding-left: 5px; }
.radio label::before {
    content: "";
    display: inline-block;
    position: absolute;
    width: 17px;
    height: 17px;
    left: 0;
    margin-left: -20px;
    border: 1px solid #cccccc;
    border-radius: 50%;
    background-color: #fff;
    -webkit-transition: border 0.15s ease-in-out;
    -o-transition: border 0.15s ease-in-out;
    transition: border 0.15s ease-in-out; }
.radio label::after {
    display: inline-block;
    position: absolute;
    content: " ";
    width: 11px;
    height: 11px;
    left: 3px;
    top: 3px;
    margin-left: -20px;
    border-radius: 50%;
    background-color: #555555;
    -webkit-transform: scale(0, 0);
    -ms-transform: scale(0, 0);
    -o-transform: scale(0, 0);
    transform: scale(0, 0);
    -webkit-transition: -webkit-transform 0.1s cubic-bezier(0.8, -0.33, 0.2, 1.33);
    -moz-transition: -moz-transform 0.1s cubic-bezier(0.8, -0.33, 0.2, 1.33);
    -o-transition: -o-transform 0.1s cubic-bezier(0.8, -0.33, 0.2, 1.33);
    transition: transform 0.1s cubic-bezier(0.8, -0.33, 0.2, 1.33); }
.radio input[type="radio"] {
    opacity: 0; }
.radio input[type="radio"]:focus + label::before {
    outline: thin dotted;
    outline: 5px auto -webkit-focus-ring-color;
    outline-offset: -2px; }
.radio input[type="radio"]:checked + label::after {
    -webkit-transform: scale(1, 1);
    -ms-transform: scale(1, 1);
    -o-transform: scale(1, 1);
    transform: scale(1, 1); }
.radio input[type="radio"]:disabled + label {
    opacity: 0.65; }
.radio input[type="radio"]:disabled + label::before {
    cursor: not-allowed; }
.radio.radio-inline {
    margin-top: 0; }

.radio-primary input[type="radio"] + label::after {
    background-color: #428bca; }
.radio-primary input[type="radio"]:checked + label::before {
    border-color: #428bca; }
.radio-primary input[type="radio"]:checked + label::after {
    background-color: #428bca; }

.radio-danger input[type="radio"] + label::after {
    background-color: #d9534f; }
.radio-danger input[type="radio"]:checked + label::before {
    border-color: #d9534f; }
.radio-danger input[type="radio"]:checked + label::after {
    background-color: #d9534f; }

.radio-info input[type="radio"] + label::after {
    background-color: #5bc0de; }
.radio-info input[type="radio"]:checked + label::before {
    border-color: #5bc0de; }
.radio-info input[type="radio"]:checked + label::after {
    background-color: #5bc0de; }

.radio-warning input[type="radio"] + label::after {
    background-color: #f0ad4e; }
.radio-warning input[type="radio"]:checked + label::before {
    border-color: #f0ad4e; }
.radio-warning input[type="radio"]:checked + label::after {
    background-color: #f0ad4e; }

.radio-success input[type="radio"] + label::after {
    background-color: #5cb85c; }
.radio-success input[type="radio"]:checked + label::before {
    border-color: #5cb85c; }
.radio-success input[type="radio"]:checked + label::after {
    background-color: #5cb85c; }
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
<script>
var firstCheck = false;
	window.onbeforeunload = function(){
		if( firstCheck ) return;
		firstCheck = true;
		if( createrName != currentuser_session ){
			//방장이아닐경우
			//인원수 - 1 update문 작성
				$.ajax({
					url : "${pageContext.request.contextPath}/board/outRoom.do?roomId=" + $("#roomId").val() + "&summonerId=" + currentuser_session,
					type : "GET",
					dataType : "json",
					success : function( data ){
						console.log( "data" , data );
						if( data != 0 ){
							sock.send(currentuser_session+" : " + "님이 퇴장했습니다." + ":" + $("#roomId").val() );
							alert("채팅방을 나가셨습니다.");
							location.href = "${pageContext.request.contextPath}/board/viewRoom.do";
							$("#personNum").val( data + "/" +$("#partnerBoardMaxno").val() );
							$("#personNum").val();
						}

					},
					error : function( err ){
						console.log("방 나가기에 실패했습니다.")
					}
				});
			//방장일경우
			//방을 삭제
			}else{
				$.ajax({
					url : "${pageContext.request.contextPath}/board/deleteRoom.do?roomId=" + $("#roomId").val(),
					type : "GET",
					dataType : "json",
					success : function( data ){
						if( data == 1 ){
							sock.send( $("#roomId").val() + ":" + "방장이 나갔습니다." + ":" + $("#roomId").val());
							alert("채팅방이 삭제되었습니다.");
							location.href = "${pageContext.request.contextPath}/board/viewRoom.do";
						}
					},
					error : function( err ){
					}
				});
			}
	}
</script>
</head>
<body>
<div id="main_container">
<div id="main_box">
	<form id="createRoomFrm"  style="text-align : left;">
<c:forEach items="${rlist }" var="room">
		<div><input type="hidden" name="roomId" id="roomId" value="${room.roomId }"/></div>
		<div><input type="hidden" name="userEmail" value="${room.userEmail}" /></div>
		<div><input type="hidden" name="partnerBoardMaxno" id="partnerBoardMaxno" value="${room.partnerBoardMaxno}" /></div>
		<div><input type="hidden" name="boardPersonnelNo" id="boardPersonnelNo" value="${room.boardPersonnelNo}" /></div>
		<div><input type="hidden" name="chatContent" id="chatContent" value="${room.chatContent}" /></div>
		<div><input type="hidden" name="summonerTier" id="summonerTier" value="${room.summonerTier}" /></div>
		<div class="form-group" style="margin-top : 25px; margin-left : 20px;">
			<label for="chatTitle">방 제목</label>
			<input type="text" name="partnerBoardTitle" id="chatTitle" value="${room.partnerBoardTitle }" style="width : 300px;" readonly/>
		</div>
		<div><input type="hidden" name="userNickname" value="${room.userNickname }" /></div>
		<div class="form-group" style="margin-top : 25px; margin-left : -30px;">
			<label for="summonerName" style="margin-left : 50px;">소환사 닉네임</label>
			<input type="text" name="summonerNickname" id="createrName" value="${room.summonerNickname }" readonly/>
		</div>
		<div style="margin-top : 25px; margin-left : 20px;">
			<label for="personNum">방 인원</label>
			<input type="text" id="personNum" value="${room.boardPersonnelNo}/${room.partnerBoardMaxno }"
					style="width : 50px;"/>
		</div>
		<div>
			<div class="checkbox checkbox-info" style="margin-left : 13px;">
				<input type="checkbox" class="tier" id="iron" name="summonerTier" value="IRON" />
				<label for="iron">Iron</label>
                                                         
				<input type="checkbox" class="tier" id="Bronze" name="summonerTier" value="BRONZE"/>
				<label for="Bronze">Bronze</label>                      
                                                                       
				<input type="checkbox" class="tier" id="Silver" name="summonerTier" value="SILVER"/>
				<label for="Silver">Silver</label>                     
	                                                                   
				<input type="checkbox" class="tier" id="Gold" name="summonerTier" value="GOLD"/>
				<label for="Gold">Gold</label>                         
                                                                       
				<input type="checkbox" class="tier" id="Platinum" name="summonerTier" value="PLATINUM"/>
				<label for="Platinum">Platinum</label>                 
                                                                       
				<input type="checkbox" class="tier" id="Diamond" name="summonerTier" value="DIAMOND"/>
				<label for="Diamond">Diamond</label>                   
                                                                       
				<input type="checkbox" class="tier" id="Master" name="summonerTier" value="MASTER"/>
				<label for="Master">Master</label>                     
                                                                       
				<input type="checkbox" class="tier" id="GrandMaster" name="summonerTier" value="GRANDMASTER"/>
				<label for="GrandMaster">GrandMaster</label>           
                                                                       
				<input type="checkbox" class="tier" id="Challenger" name="summonerTier" value="CHALLENGER"/>
				<label for="Challenger">Challenger</label>            
			</div>
		</div>
		<div style="margin-top : 25px; margin-left : 13px;">
			<div class="checkbox checkbox-info">
				<input type="checkbox" id="duo" class="rankType"/>
				<label for="duo">듀오</label>

				<input type="checkbox" id="teamRank" class="rankType" />
				<label for="teamRank">팀 5:5 랭크</label>
			</div>
		</div>
		<div><input type="hidden" name="chatContent" value="..." /></div>
		<div><input type="hidden" name="expulisionList" value="...." /></div>
		<div>
			<button type="button" class="btn btn-outline-success" id="outRoom"
			style="position : absolute; margin-left : 720px; margin-top : -14px;">나가기</button>
		</div>
</c:forEach>
</form>
</div>
	<div id="chat_box" style="overflow: scroll;">
		<fieldset>
			<div id="messageWindeow"></div>
			<div class="well" id="chatdata">
		   		<!-- User Session Info Hidden -->
		   	</div>
		</fieldset>
	</div>
</div>
	<br />
	<input type="text" value="${summonerName }" id="summonerName" name="summonerName" readonly style="margin-left: 80px;" />
	<input type="text" id="inputMessage" name="sendMessage" />
	<button id="msg_process" class="btn btn-outline-success" onclick="sendMessage();">전송</button>
</body>
<script type="text/javascript">

//새로고침 못하게하기
function noEvent() {
	if (event.keyCode == 116) {
		event.keyCode= 2;
		return false;
	}
	else if(event.ctrlKey && (event.keyCode==78 || event.keyCode == 82))
	{
		return false;
	}
}
document.onkeydown = noEvent;

var boardMaxNo = $("#partnerBoardMaxno").val();

console.log( boardMaxNo );
console.log( $("#teamRank").prop("checked",true) );

if( boardMaxNo == 5 ){
	$("#teamRank").prop("checked",true);
}else if ( boardMaxNo == 2 ){
	$("#duo").prop("checked",true);
}

var tier = $("#summonerTier").val();
tiers = tier.split(",");

for( var i in tiers){
	if( tiers[i] == "IRON"){
		$("input[value="+tiers[i]+"]").prop("checked", true).attr( "type", "checkbox");
	   }else if( tiers[i] == "BRONZE"){
		   $("input[value="+tiers[i]+"]").prop("checked", true).attr( "type", "checkbox");
	   }else if( tiers[i] == "SILVER"){
		   $("input[value="+tiers[i]+"]").prop("checked", true).attr( "type", "checkbox");
	   }else if( tiers[i] == "GOLD"){
		   $("input[value="+tiers[i]+"]").prop("checked", true).attr( "type", "checkbox");
	   }else if( tiers[i] == "PLATINUM"){
		   $("input[value="+tiers[i]+"]").prop("checked", true).attr( "type", "checkbox");
	   }else if( tiers[i] == "DIAMOND"){
		   $("input[value="+tiers[i]+"]").prop("checked", true).attr( "type", "checkbox");
	   }else if( tiers[i] == "MASTER"){
		   $("input[value="+tiers[i]+"]").prop("checked", true).attr( "type", "checkbox");
	   }else if( tiers[i] == "GRANDMASTER"){
		   $("input[value="+tiers[i]+"]").prop("checked", true).attr( "type", "checkbox");
	   }else if( tiers[i] == "CHALLENGER"){
		   $("input[value="+tiers[i]+"]").prop("checked", true).attr( "type", "checkbox");
	   }
}

//난수생성
function makeid()
{
    var text = "";
    var possible = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

    for( var i=0; i < 8; i++ )
        text += possible.charAt(Math.floor(Math.random() * possible.length));

    return text;
}

var currentuser_session = $("#summonerName").val();
var createrName = $("#createrName").val();

var rnd = makeid();

//websocket을 지정한 URL로 연결
var sock = new SockJS("<c:url value='/robi.do/'/>", [], { sessionId : function(){ return rnd }} );
//websocket 서버에서 메세지를 보내면 자동으로 실행된다.
sock.onmessage = onMessage;
//websocket 과 연결을  끊고 싶을때 실행하는 메소드
sock.onclose = onClose;

sock.onopen = function(){
	sessionStorage.setItem( currentuser_session, rnd );
	var roomNumber = $( '#roomId' ).val();
	
	if( createrName != currentuser_session ){
		$.ajax({
			url : "${pageContext.request.contextPath}/board/boardPersonnelNo.do?roomId=" + roomNumber,
			success : function(data){
				console.log( "data" , data );
				if( data == 0 ){
					alert("중복된 아이디입니다 !");
					location.href = "${pageContext.request.contextPath}/board/viewRoom.do";
				}else{
					$("#personNum").val( data + "/" +$("#partnerBoardMaxno").val() );
					
					var printHTML = $("#insertSummoner").val( currentuser_session + "님이 입장했습니다.");
					
					sock.send(currentuser_session+" : " + "님이 입장했습니다." + ":" + $("#roomId").val() );
				}
			},
			error : function( err ){
			}
		});
	}
}

$("input[name=sendMessage]").keydown( function( key ){
	if( key.keyCode == 13 ){
		sendMessage();	
		$("input[name=sendMessage]").val("");
	}
} )

$(function(){
	$("#sendBtn").click(function(){
		sendMessage();
	});
});

function sendMessage(){
	//websocket으로 메시지를 보내겟다.
	if( $("#inputMessage").val() == "@"){
		$("#inputMessage").val("");
		var summonerName = prompt("소환사 닉네임을 입력해주세요 !").replace(/ /g,"%20");
		var summonerId;
		$.ajax({
			url : "${pageContext.request.contextPath}/summoner/search?summonerName="+summonerName,
			type : "GET",
			dataType : "json",
			success : function( data ){
				summonerId = data.id;
				if( summonerId != null ){
					alert("존재하는 소환사 입니다.");
					$.ajax({
		 				url : "${pageContext.request.contextPath}/summoner/league?summonerId=" + summonerId,
						type : "GET",
						async : false,
						dataType : "json",
						success : function( data ){
							for(var i in data){
								var printHTML = "";
								if( data[i].queueType != "RANKED_TFT" && data[i].queueType != "RANKED_FLEX_SR"){
									printHTML +="<div class='alert alert-success'>" +
									       "<tr>" +
									       "<td>" + "검색한 서머너 : [ " + summonerName + " ] </td>" +  "</br>" +
									   	   "</tr>" +
										   "<tr>" +
										   "<td>" + "솔로랭크 티어 : [ " + data[i].tier + " " + data[i].rank + " " + data[i].leaguePoints + "LP ]</td>" + "</br>" +
										   "</tr>" +
										   "<tr>" +
										   "<td>" + " 전적 : [ " + data[i].wins + "승" + " " + data[i].losses + "패 ]" + " 승률 : [ " + Math.round(( data[i].wins/( data[i].wins + data[i].losses ) )*100) + "% ]</td>" +
										   "</tr>" +
										   "<tr>" +
										   "</div>";
									sock.send( printHTML + ":" + $("#roomId").val() );
								}
							}
							if( data == "" ){
								printHTML +=":<div class='alert alert-success'>" +
							       "<tr>" +
							       "<td>" + "검색한 서머너 : [ " + summonerName + " ]님은 최근 랭크 게임을 하지않았습니다.</td>" +  "</br>" +
							   	   "</tr>" +
							   	   "</div>";
								sock.send( printHTML + ":" + $("#roomId").val() );
							}
						},
						error : function( xhr, txtStatus, err ){
							
						}
					});
				}else{
					
				}
			},
			error : function( err ){
				alert( "존재하지 않는 소환사입니다." );
				return;
			}
		});
		
	}else{
		sock.send(currentuser_session+" : "+$("#inputMessage").val() + ":" + $("#roomId").val() );
		
		var obj = {
			roomId :$("#roomId").val(),
			userEmail :"${memberLoggedIn.userEmail}",
			chatContent :$("#inputMessage").val(),
			userKey : rnd,
			summonerNickname : currentuser_session
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath}/board/insertMsg.do",
			data : obj,
			type : "GET",
			dataType : "json",
			success : function( data ){
				
			},
			error : function( err ){
				
			}
		});
	}
}

//event 파라미터는 websocket이 보내준 데이터. 즉, message
function onMessage( event ){ //변수 안에 function자체를 넣는다.
	var data = event.data;
	
	var sessionId = null;
	var message = null;
	
	//문자열을 splite
	var strArray = data.split(":");

	for( var i in strArray ){
		console.log( "stt["+i+"]" + strArray[i] );
	}
	
	//current session id
	sessionid = strArray[0].trim(); // 현재 메세지를 보낸 사람의 세션 등록
	message = strArray[1] + " : " + strArray[2]; // 현재 메세지를 저장
	
	//나와 상대방이 보낸 메세지를 구분하여 영역을 나눈다
	if( $( "#roomId" ).val() == strArray[ 6 ] ){
		if( data.match( "<div class='alert alert-success'>" ) ) {
			$("#chatdata").append( strArray[1] + strArray[2] + strArray[3] + strArray[4] + strArray[5] );
			$("#chat_box").scrollTop( $("#chat_box").prop('scrollHeight'));
			$("input[name=sendMessage]").val("");
			return;
		}
	}
	if( $( "#roomId" ).val() == strArray[ 4 ] ){
		if( data.match( "<div class='alert alert-success'>" ) ) {
			$("#chatdata").append( strArray[2] + strArray[3]);
			$("#chat_box").scrollTop( $("#chat_box").prop('scrollHeight'));
			$("input[name=sendMessage]").val("");
			return;
		}
	}
	if( $( "#roomId" ).val() == strArray[ 3 ] ) {
		if( data.match( "최근 게임을" ) ) {
			$("#chatdata").append( strArray[3] + strArray[4]);
			$("#chat_box").scrollTop( $("#chat_box").prop('scrollHeight'));
			$("input[name=sendMessage]").val("");
			return;
		}
		var insertSum = strArray[1]+strArray[2];

		if( strArray[1] + strArray[2] == strArray[1] + " 님이 입장했습니다.") {
			var printHTML = "<div class='well'>";
				printHTML += "<div class='alert alert-light'>";
				printHTML += "<strion>"+insertSum+" </strion>";
				printHTML += "</div>";
				printHTML += "</div>";
				
				$("#chatdata").append(printHTML);
				$("#chat_box").scrollTop( $("#chat_box").prop('scrollHeight'));
				
				$.ajax({
					url : "${pageContext.request.contextPath}/board/checkBoardNo.do?roomId=" + $("#roomId").val(),
					type : "GET",
					dataType : "json",
					success : function( data ){
						console.log( "data" , data );
						$("#personNum").val( data + "/" +$("#partnerBoardMaxno").val() );
						$("#personNum").val();
					},
					error : function( err ){
						console.log("방 나가기에 실패했습니다.")
					}
				});
		}else if( strArray[1] + strArray[2] == strArray[1] + " 님이 퇴장했습니다.") {
			var printHTML = "<div class='well'>";
			printHTML += "<div class='alert alert-light'>";
			printHTML += "<strion>"+insertSum+" </strion>";
			printHTML += "</div>";
			printHTML += "</div>";
			
			$("#chatdata").append(printHTML);
			$("#chat_box").scrollTop( $("#chat_box").prop('scrollHeight'));
			
			$.ajax({
				url : "${pageContext.request.contextPath}/board/checkBoardNo.do?roomId=" + $("#roomId").val(),
				type : "GET",
				dataType : "json",
				success : function( data ){
					$("#personNum").val( data + "/" +$("#partnerBoardMaxno").val() );
					$("#personNum").val();
				},
				error : function( err ){
				}
			});
	}else if( strArray[1] + strArray[2] == " " + $("#roomId").val() + "방장이 나갔습니다." ){
		alert("방장이 나갔습니다.");
		location.href = "${pageContext.request.contextPath}/board/viewRoom.do";	
	}else {
			if( sessionStorage.getItem( currentuser_session ) == sessionid ){
				var printHTML = "<div class='well'>";
					printHTML += "<div class='alert alert-info'>";
					printHTML += "<strion>"+message+" </strion>";
					printHTML += "</div>";
					printHTML += "</div>";
					
				$("#chatdata").append(printHTML);
				$("#chat_box").scrollTop( $("#chat_box").prop('scrollHeight'));
			}else {
				var printHTML = "<div class='well'>";
					printHTML += "<div class='alert alert-warning'>";
					printHTML += "<strion>"+message+"</strion>";
					printHTML += "</div>";
					printHTML += "</div>";
				
				$("#chatdata").append(printHTML);
				$("#chat_box").scrollTop( $("#chat_box").prop('scrollHeight'));
			}
		}
	}
	
}

	$("#outRoom").on( "click", function(){
		firstCheck = true;
		if( createrName != currentuser_session ){
		//방장이아닐경우
		//인원수 - 1 update문 작성
			$.ajax({
				url : "${pageContext.request.contextPath}/board/outRoom.do?roomId=" + $("#roomId").val() + "&summonerId=" + currentuser_session,
				type : "GET",
				dataType : "json",
				success : function( data ){
					console.log( "data" , data );
					if( data != 0 ){
						sock.send(currentuser_session+" : " + "님이 퇴장했습니다." + ":" + $("#roomId").val() );
						alert("채팅방을 나가셨습니다.");
						location.href = "${pageContext.request.contextPath}/board/viewRoom.do";
						$("#personNum").val( data + "/" +$("#partnerBoardMaxno").val() );
						$("#personNum").val();
					}

				},
				error : function( err ){
					console.log("방 나가기에 실패했습니다.")
				}
			});
		//방장일경우
		//방을 삭제
		}else{
			$.ajax({
				url : "${pageContext.request.contextPath}/board/deleteRoom.do?roomId=" + $("#roomId").val(),
				type : "GET",
				dataType : "json",
				success : function( data ){
					if( data == 1 ){
						sock.send( $("#roomId").val() + ":" + "방장이 나갔습니다." + ":" + $("#roomId").val());
						alert("채팅방이 삭제되었습니다.");
						location.href = "${pageContext.request.contextPath}/board/viewRoom.do";
					}
				},
				error : function( err ){
				}
			});
		}
	});

function onClose(event){
	$("#data").append("연결 끊김");
	sessionStorage.removeItem( currentuser_session );	
}
</script>   
<!-- End Page Container -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>