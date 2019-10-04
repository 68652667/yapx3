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
	    margin-top : 10px;
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
</style>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
</head>
<body>
<div id="main_container">
<div id="main_box">
	<form id="createRoomFrm"  style="text-align : left;">
<c:forEach items="${rlist }" var="room">
		<div><input type="hidden" name="roomId" id="roomId" value="${room.roomId }"/></div>
		<div><input type="hidden" name="userEmail" value="${room.userEmail}" /></div>
		<div><input type="hidden" name="partnerBoardMaxno" id="partnerBoardMaxno" value="${room.partnerBoardMaxno}" /></div>
		<div>
			<label for="chatTitle">방 제목</label>
			<input type="text" name="partnerBoardTitle" id="chatTitle" value="${room.partnerBoardTitle }" style="width : 350px;"/>
		</div>
		<div><input type="hidden" name="userNickname" value="${room.userNickname }" /></div>
		<div>
			<label for="summonerName">소환사 닉네임</label>
			<input type="text" name="summonerNickname" id="createrName" value="${room.summonerNickname }" readonly/>
		</div>
		<div>
			<label for="personNum">방 인원</label>
			<input type="text" id="personNum" value="${room.boardPersonnelNo}/${room.partnerBoardMaxno }"/>
		</div>
		<div>
			<label for="chatTitle">티어</label>
			<div>
				<input type="checkbox" class="tier" name="summonerTier" value="Iron"/>
				<label for="iron">Iron</label>
                                                         
				<input type="checkbox" class="tier" name="summonerTier" value="Bronze"/>
				<label for="Bronze">Bronze</label>                      
                                                                       
				<input type="checkbox" class="tier" name="summonerTier" value="Silver"/>
				<label for="Silver">Silver</label>                     
	                                                                   
				<input type="checkbox" class="tier" name="summonerTier" value="Gold"/>
				<label for="Gold">Gold</label>                         
                                                                       
				<input type="checkbox" class="tier" name="summonerTier" value="Platinum"/>
				<label for="Platinum">Platinum</label>                 
                                                                       
				<input type="checkbox" class="tier" name="summonerTier" value="Diamond"/>
				<label for="Diamond">Diamond</label>                   
                                                                       
				<input type="checkbox" class="tier" name="summonerTier" value="Master"/>
				<label for="Master">Master</label>                     
                                                                       
				<input type="checkbox" class="tier" name="summonerTier" value="GrandMaster"/>
				<label for="GrandMaster">GrandMaster</label>           
                                                                       
				<input type="checkbox" class="tier" name="summonerTier" value="Challenger"/>
				<label for="Challenger">Challenger</label>            
			</div>
		</div>
		<div>
			<label for="chatTitle">인원</label>
			<div>
				<label for="duo">듀오</label>
				<input type="checkbox" name="partnerBoardPersonnel" class="rankType" value="2"/>

				<label for="teamRank">팀 5:5 랭크</label>
				<input type="checkbox" name="partnerBoardPersonnel" class="rankType" value="5"/>
			</div>
		</div>
		<div><input type="hidden" name="chatContent" value="..." /></div>
		<div><input type="hidden" name="expulisionList" value="...." /></div>
		<div>
			<button type="button" class="btn btn-outline-success" id="outRoom"
			style="position : absolute; margin-left : 720px; margin-top : -190px;">나가기</button>
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
	<input type="text" value="${summonerName }" id="summonerName" name="summonerName">
	<input type="text" id="inputMessage" name="sendMessage" />
	<button id="msg_process" class="btn btn-outline-success" onclick="sendMessage();">전송</button>
</body>
<script type="text/javascript">

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
console.log( rnd );

//websocket을 지정한 URL로 연결
var sock = new SockJS("<c:url value='/robi.do/'/>", [], { sessionId : function(){ return rnd }} );
//websocket 서버에서 메세지를 보내면 자동으로 실행된다.
sock.onmessage = onMessage;
//websocket 과 연결을  끊고 싶을때 실행하는 메소드
sock.onclose = onClose;

sock.onopen = function(){
	sessionStorage.setItem( currentuser_session, rnd );
	
	console.log("방번호");
	console.log($( '#roomId' ).val());
	
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
					console.log( $("#personNum") );
					$("#personNum").val( data + "/" +$("#partnerBoardMaxno").val() );
					var printHTML = $("#insertSummoner").val( currentuser_session + "님이 입장했습니다.");
					sock.send(currentuser_session+" : " + "님이 입장했습니다." + ":" + $("#roomId").val() );
				}
			},
			error : function( err ){
				console.log( "에러당" );
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
		console.log("send message.." );
		sendMessage();
	});
});

function sendMessage(){
	//websocket으로 메시지를 보내겟다.
	if( $("#inputMessage").val() == "@" ){
		
	}else{
		sock.send(currentuser_session+" : "+$("#inputMessage").val() + ":" + $("#roomId").val() );
	}
}

//event 파라미터는 websocket이 보내준 데이터. 즉, message
function onMessage(event){ //변수 안에 function자체를 넣는다.
	
	console.log( "event = " + event.data )
	
	var data = event.data;
	
	var sessionId = null;
	var message = null;
	
	console.log( "event = " + event.data )
	
	//문자열을 splite
	var strArray = data.split(":");
	
	for(var i = 0; i < strArray.length; i++){
		console.log("str["+i+"] : " + strArray[i]);
	}
	
	//current session id
	
	console.log("current session id : " + currentuser_session);
	
	sessionid = strArray[0].trim(); // 현재 메세지를 보낸 사람의 세션 등록
	message = strArray[1] + " : " + strArray[2]; // 현재 메세지를 저장
	
	console.log( message );
	
	//나와 상대방이 보낸 메세지를 구분하여 영역을 나눈다
	console.log( sessionStorage.getItem( currentuser_session ) );
	console.log( sessionid );
	console.log( sessionStorage.getItem( currentuser_session ) == sessionid );

	$.ajax({
		
	});
	
	
	if( $( "#roomId" ).val() == strArray[ 3 ] ) {
		console.log(  strArray[1] );
		console.log(  strArray[2] );
		console.log(  strArray[1] + strArray[2] );
		console.log(  strArray[1] + " 님이 입장했습니다." );
		console.log(  strArray[1] + strArray[2] == strArray[1] + " 님이 입장했습니다." );
		
		var insertSum = strArray[1]+strArray[2];
		
		console.log(  insertSum );
		
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
					},
					error : function( err ){
						console.log("방 나가기에 실패했습니다.")
					}
				});
		}else {
			if( sessionStorage.getItem( currentuser_session ) == sessionid ){
				console.log( 1 );
				var printHTML = "<div class='well'>";
					printHTML += "<div class='alert alert-info'>";
					printHTML += "<strion>"+message+" </strion>";
					printHTML += "</div>";
					printHTML += "</div>";
					
				$("#chatdata").append(printHTML);
				$("#chat_box").scrollTop( $("#chat_box").prop('scrollHeight'));
				$("input[name=sendMessage]").val("");
			}else {
				console.log( 2 );
				var printHTML = "<div class='well'>";
					printHTML += "<div class='alert alert-warning'>";
					printHTML += "<strion>"+message+"</strion>";
					printHTML += "</div>";
					printHTML += "</div>";
				
				$("#chatdata").append(printHTML);
				$("#chat_box").scrollTop( $("#chat_box").prop('scrollHeight'));
				$("input[name=sendMessage]").val("");
			}
		}
	}
	console.log("chatting data : " + data);
	
}

	$("#outRoom").on( "click", function(){
		if( createrName != currentuser_session ){
		//방장이아닐경우
		//인원수 - 1 update문 작성
			$.ajax({
				url : "${pageContext.request.contextPath}/board/outRoom.do?roomId=" + $("#roomId").val(),
				type : "GET",
				dataType : "json",
				success : function( data ){
					console.log( "data" , data );
					if( data != 0 ){
						console.log( $("#personNum") );
						alert("채팅방을 나가셨습니다.");
						$("#personNum").val( data + "/" +$("#partnerBoardMaxno").val() );
						location.href = "${pageContext.request.contextPath}/board/viewRoom.do";
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
						alert("채팅방이 삭제되었습니다.");
						location.href = "${pageContext.request.contextPath}/board/viewRoom.do";
					}
				},
				error : function( err ){
					console.log("방 삭제에 실패했습니다.")
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