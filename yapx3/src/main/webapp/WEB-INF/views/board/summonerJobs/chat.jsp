<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<style>
.Progress{
	display: inline-block;
    max-width: 60%;
    height: 8px;
    border: 1px solid #b8bfbf;
    background-color: #c3c8c8;
}
.Progress.Blue{
	background-color: #1f8ecd;
    border-color: #1a78ae;
}
.Progress.Yellow{
	background-color: #f6af2e;
    border-color: #d3962b;
}
.Progress.Green{
	background-color: #2daf7f;
    border-color: #249069;
}
.champImg{width: 32px; border-radius: 50%}
	#chat_box, #main_box{
		width : 800px;
		min-width: 800px;
	    height: 300px;
	    min-height: 300px;
	    border: 1px solid black;
	    margin-top : 10px;
	}
	#msg {
	    width: 550px;
	    height: 30px;
	}
</style>
<script src="https:cdn.jsdelivr.net/sockjs/1/sockjs.min.js"></script>
<script>
	//websocket을 지정한 URL로 연결
	var sock = new SockJS("<c:url value='/echo/'/>");
	//websocket 서버에서 메세지를 보내면 자동으로 실행된다.
	sock.onmessage = onMessage;
	//websocket 과 연결을  끊고 싶을때 실행하는 메소드
	sock.onclose = onClose;
	
	$(function(){
		$("#sendBtn").click(function(){
			console.log("send message.." );
			sendMessage();
		});
	});
	
	function sendMessage(){
		//websocket으로 메시지를 보내겟다.
		sock.send($("#message").val());
	}
	
	//event 파라미터는 websocket이 보내준 데이터. 즉, message
	function onMessage(event){ //변수 안에 function자체를 넣는다.
		var data = event.data;
		var sessionId = null;
		var message = null;
		
		//문자열을 splite
		var strArray = data.split("|");
		
		for(var i = 0; i < strArray.length; i++){
			console.log("str["+i+"] : " + strArray[i]);
		}
		
		//current session id
		var currentuser_session = $("#sessionuserid").val();
		console.log("current session id : " + currentuser_session);
		
		sessionid = strArray[0]; // 현재 메세지를 보낸 사람의 세션 등록
		message = strArray[1]; // 현재 메세지를 저장
		
		//나와 상대방이 보낸 메세지를 구분하여 영역을 나눈다
		if(sessionid == currentuser_session){
			var printHTML = "<div class='well'>";
				printHTML += "<div class='alert alert-info'>";
				printHTML += "<strion>["+sessionid+"] -> "+message+" </strion>";
				printHTML += "</div>";
				printHTML += "</div>";
				
			$("#chatdata").append(printHTML);
		}else {
			var printHTML = "<div class='well'>";
				printHTML += "<div class='alert alert-warning'>";
				printHTML += "<strion>["+sessionid+"] -> "+message+" </strion>";
				printHTML += "</div>";
				printHTML += "</div>";
			
			$("#chatdata").append(printHTML);
		}
		
		console.log("chatting data : " + data);
		
	}
	
	function OnClose(event){
		$("#data").append("연결 끊김");
	}

</script>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1024px;margin-top:175px; min-height: 768px; margin-bottom: 15px;">
<div><input type="button" id="chattinglistbtn" value="채팅 참여자 리스트"></div>
<br>
<div>

	<div>
		<input type="text" id="message"/>
   		<input type="button" id="sendBtn" value="전송"/>
   	</div>
   	<br>
   	<div class="well" id="chatdata">
   		<!-- User Session Info Hidden -->
   		<input type="hidden" value='${userid}' id="sessionuserid">
   	</div>
</div>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>