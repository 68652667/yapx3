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
	#msg {
	    width: 550px;
	    height: 30px;
	}
	#msg_process {
		    width: 70px;
		    height: 37px;
	}

</style>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
</head>
<body>
<div class="w3-container w3-content" style=" margin : 0 auto; margin-left : 2px;">
<div id="main_container">
	<div id="main_box">
		<form id="createRoomFrm" action="${pageContext.request.contextPath}/board/createRoomEnd.do" method="get">
			<div><input type="hidden" name="userEmail" value="${memberLoggedIn.userEmail }" /></div>
			<div><input type="hidden" name="boardPersonnelNo" value="1"/></div>
			<div>
				<label for="chatTitle">방 제목</label>
				<input type="text" name="partnerBoardTitle" id="chatTitle"/>
			</div>
			<div><input type="hidden" name="userNickname" value="${memberLoggedIn.userNickname}" /></div>
			<div>
				<label for="summonerName">소환사 닉네임</label>
				<input type="text" name="summonerNickname" id="summonerName"/>
				<button type="button" onclick="complete();">확인</button>
			</div>
			<div>
				<label for="chatTitle">티어</label>
				<div id="tierCheck">
					<input type="checkbox" class="tier" name="summonerTier" value="IRON"/>
					<label for="iron">Iron</label>
	                                                                        
					<input type="checkbox" class="tier" name="summonerTier" value="BRONZE"/>
					<label for="Bronze">Bronze</label>                      
	                                                                       
					<input type="checkbox" class="tier" name="summonerTier" value="SILVER"/>
					<label for="Silver">Silver</label>                     
		                                                                   
					<input type="checkbox" class="tier" name="summonerTier" value="GOLD"/>
					<label for="Gold">Gold</label>                         
	                                                                       
					<input type="checkbox" class="tier" name="summonerTier" value="PLATINUM"/>
					<label for="Platinum">Platinum</label>                 
	                                                                       
					<input type="checkbox" class="tier" name="summonerTier" value="DIAMOND"/>
					<label for="Diamond">Diamond</label>                   
	                                                                       
					<input type="checkbox" class="tier" name="summonerTier" value="MASTER"/>
					<label for="Master">Master</label>                     
	                                                                       
					<input type="checkbox" class="tier" name="summonerTier" value="GRANDMASTER"/>
					<label for="GrandMaster">GrandMaster</label>           
	                                                                       
					<input type="checkbox" class="tier" name="summonerTier" value="CHALLENGER"/>
					<label for="Challenger">Challenger</label>             
				</div>
			</div>
			<div>
				<label for="chatTitle">인원</label>
				<div>
					<input type="checkbox" name="partnerBoardMaxno" class="rankType" value="2"/>
					<label for="duo">듀오</label>
	
					<input type="checkbox" name="partnerBoardMaxno" class="rankType" value="5"/>
					<label for="teamRank">팀 5:5 랭크</label>
				</div>
			</div>
			<div><input type="hidden" name="chatContent" value="..." /></div>
			<div><input type="hidden" name="expulisionList" value="...." /></div>
			<div>
				<button type="button" class="btn btn-outline-success" onclick="cancel();">취소</button>
				<button type="submit" id="checkTier" class="btn btn-outline-success">만들기</button>
			</div>
	</form>
	</div>
	<div id="chat_box"></div>
	<input type="text" style="height: 30px;"readonly/><input type="text" id="msg">
	<button id="msg_process" class="btn btn-outline-success">전송</button>
</div>
</div>
</body>
<script type="text/javascript">

	function complete(){
		
		$("input[class=tier]").prop("checked", false).attr( "type", "checkbox");
		
		var summonerName = $("#summonerName").val().replace(/ /g,"%20");
		
		console.log( summonerName );
		
		var summonerId;
		var msg;
		var html;
		
		$.ajax({
			url : "${pageContext.request.contextPath}/summoner/search?summonerName="+summonerName,
			type : "GET",
			async : false,
			dataType : "json",
			success : function( data ){
				console.log( data );
				summonerId = data.id;
				
				if( summonerId != null ){
					msg = "존재하는 소환사 입니다."
					html = "<label for='summonerName' style='color : green;'>" + msg + "</label>";
				}else {
					msg = "존재하지 않는 소환사 입니다."
					html = "<label for='summonerName' style='color : red;'>" + msg + "</label>";
				}
			},
			error : function( err ){
				console.log( "에러가 발생했다 고쳐라" );
			}
		});
		
		console.log( summonerId );
		
		$.ajax({
			url : "${pageContext.request.contextPath}/summoner/league?summonerId=" + summonerId,
			type : "GET",
			async : false,
			dataType : "json",
			success : function( data ){
				console.log( data );
				if( data == "" ){
					$("input[value=IRON]").prop("checked", true).attr( "type", "checkbox");
				}else{	
					for(var i in data){				
						if( data[i].queueType == "RANKED_SOLO_5x5" && data[i].queueType != "RANKED_TFT" && data[i].queueType != "RANKED_FLEX_SR" ){
							if( data[i].tier == "IRON"){
								$("input[value=IRON]").prop("checked", true).attr( "type", "checkbox");
								$("input[value=BRONZE]").prop("checked", true).attr( "type", "checkbox");
							   }else if( data[i].tier == "BRONZE"){
								   $("input[value=IRON]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=BRONZE]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=SILVER]").prop("checked", true).attr( "type", "checkbox");
							   }else if( data[i].tier == "SILVER"){
								   $("input[value=BRONZE]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=SILVER]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=GOLD]").prop("checked", true).attr( "type", "checkbox");
							   }else if( data[i].tier == "GOLD"){
								   $("input[value=SILVER]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=GOLD]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=PLATINUM]").prop("checked", true).attr( "type", "checkbox");
							   }else if( data[i].tier == "PLATINUM"){
								   $("input[value=GOLD]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=PLATINUM]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=DIAMOND]").prop("checked", true).attr( "type", "checkbox");
							   }else if( data[i].tier == "DIAMOND"){
								   $("input[value=PLATINUM]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=DIAMOND]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=MASTER]").prop("checked", true).attr( "type", "checkbox");
							   }else if( data[i].tier == "MASTER"){
								   $("input[value=DIAMOND]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=MASTER]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=GRANDMASTER]").prop("checked", true).attr( "type", "checkbox");
							   }else if( data[i].tier == "GRANDMASTER"){
								   $("input[value=MASTER]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=GRANDMASTER]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=CHALLENGER]").prop("checked", true).attr( "type", "checkbox");
							   }else if( data[i].tier == "CHALLENGER"){
								   $("input[value=GRANDMASTER]").prop("checked", true).attr( "type", "checkbox");
								   $("input[value=CHALLENGER]").prop("checked", true).attr( "type", "checkbox");
							   }
							}
						}
					}
			},
			error : function( err ){
				console.log( "에러가 발생했다 고쳐라" );
			}
		});
	}
	
	function cancel(){
		location.href = "${pageContext.request.contextPath}/board/viewRoom.do";
	}

</script>  
<!-- End Page Container -->
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>