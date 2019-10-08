<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<!-- Page Container -->
<div class="w3-container w3-content"
	style="max-width: 1400px; margin-top: 115px; min-height: 768px;">
	<style>
#chat_box, #main_box {
	width: 800px;
	min-width: 800px;
	height: 300px;
	min-height: 300px;
	border: 1px solid black;
	margin-top: 10px;
}

#msg {
	width: 550px;
	height: 30px;
}

#msg_process {
	width: 70px;
	height: 37px;
}
</style>
	<link rel="stylesheet"
		href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css"
		integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4"
		crossorigin="anonymous">
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"
		integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
	</head>
	<body>
		<div id="main_container" style="margin: 0 auto; margin-left: 12px;">
			<div id="main_box" style="overflow: scroll;">
				<table style="text-align: center;">
					<tr>
						<th>No</th>
						<th>방 제목</th>
						<th>티어</th>
						<th>방장</th>
						<th>인원</th>
					</tr>

					<c:forEach items="${rlist}" var="room">
						<tr id="${room.partnerBoardNo}" class="boardNo"
							bNo="${room.boardPersonnelNo}" bMax="${room.partnerBoardMaxno}">
							<td>${room.partnerBoardNo }</td>
							<td>${room.partnerBoardTitle }</td>
							<td>${room.summonerTier }</td>
							<td>${room.summonerNickname }</td>
							<td>${room.boardPersonnelNo}/${room.partnerBoardMaxno}</td>
						</tr>
					</c:forEach>
					<tr>
						<td>
							<button type="button" id="creatingRoom" onclick="createRoom();"
								class="btn btn-outline-success">방만들기</button>
						</td>
					</tr>
				</table>
			</div>
			<div id="chat_box"></div>
			<input type="text" style="height: 30px;" id="summonerNameVal"
				readonly /><input type="text" id="msg">
			<button id="msg_process" class="btn btn-outline-success">전송</button>
		</div>
	</body>
	<script type="text/javascript">
	$(() => {
		var memberLoggedIn = "${memberLoggedIn.userEmail}";
		console.log( "${memberLoggedIn.userEmail}" );
		$("#creatingRoom").on( "click", function(){
			if( memberLoggedIn == "" ){
				alert("로그인후 사용가능합니다 !")
			}else{
				$.ajax({
					url : "${pageContext.request.contextPath}/board/createRoomCheck.do?userId=${memberLoggedIn.userEmail}",
					type : "GET",
					success : function( data ){
						console.log( data );
						if( data == 1 ){
							alert("채팅방 중복 생성 불가");
						}else{
							location.href = "${pageContext.request.contextPath}/board/createRoom.do";
						}
					},
					error : function( err ){
						return;
					}
				});	
			}
		});
	
		$(".boardNo").on( "click", function(){
			console.log( "클!릭!" );
			if( memberLoggedIn == "" ){
				alert("로그인후 사용가능합니다 !")
			}else{
					
				var boardNo = $( this ).attr("id");
				var bNo = $( this ).attr("bNo");
				var bMax = $( this ).attr("bMax");
				
				console.log( boardNo );
				console.log( bNo );
				console.log( bMax );
				
				//아이디 체크 해야함
				if( bNo >= bMax ){
					alert("인원수가 초과되었습니다 !!");
					return;
				}
				console.log( "prompt Open" );
				var summonerName = prompt("소환사 닉네임을 입력해주세요 !").replace(/ /g,"%20");
				console.log( "prompt Open" );
	
				
				var summonerId;
				var msg;
				var html;
				
				$.ajax({
					url : "${pageContext.request.contextPath}/summoner/search?summonerName="+summonerName,
					type : "GET",
					dataType : "json",
					success : function( data ){
						console.log( data );
						summonerId = data.id;
	
						console.log( "summonerName=" + summonerName );
						if( summonerId != null ){
							alert("존재하는 소환사 입니다.");
							$.ajax({
								url : "${pageContext.request.contextPath}/board/selectRobi.do",
								data : { boardNo : boardNo, summonerName : summonerName },
								type : "POST",
								dataType : "json",
								success : function( data ){
									console.log( "data" );
									console.log( data );
									
									if( data.bool == "false" ){
										$("#summonerNameVal").val( summonerName );
										console.log( summonerName );
										location.href = "${pageContext.request.contextPath}/board/robi.do?roomId=" + data.robiRoom + "&summonerName=" + data.summonerName;
									} else {
										alert("중복된 소환사명입니다.");
									}
								},
								error : function( err ){
									return;
								}
							});
						}
					},
					error : function( err ){
						alert( "존재하지 않는 소환사입니다." );
						return;
					}
				});
			}
		});
	});
</script>
	<!-- End Page Container -->

	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>