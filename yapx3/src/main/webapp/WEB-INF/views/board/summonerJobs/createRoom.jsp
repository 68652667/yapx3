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
	#msg {
	    width: 550px;
	    height: 30px;
	}
	#msg_process {
		    width: 70px;
		    height: 37px;
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
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.js"></script>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/sockjs-client/1.3.0/sockjs.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/stomp.js/2.3.3/stomp.js"></script>
</head>
<body style=" margin : 0 auto; ">
<div class="w3-container w3-content" style=" margin : 0 auto; margin-left : 2px;">
<div id="main_container">
	<div id="main_box">
		<form id="createRoomFrm" class="form-sec" action="${pageContext.request.contextPath}/board/createRoomEnd.do" method="get">
			<div><input type="hidden" name="userEmail" value="${memberLoggedIn.userEmail }" /></div>
			<div><input type="hidden" name="boardPersonnelNo" value="1"/></div>
			<div class="form-group" style="margin-top : 25px; margin-left : 20px;">
				<label for="chatTitle" >방 제목</label>
				<input type="text" name="partnerBoardTitle" id="chatTitle" style=" width : 300px;"/>
			</div>
			<div><input type="hidden" name="userNickname" value="${memberLoggedIn.userNickname}" /></div>
			<div class="form-group" style="margin-top : 25px; margin-left : -30px;">
				<label for="summonerName" style="margin-left : 50px;">소환사 닉네임</label>
				<input type="text" name="summonerNickname" id="summonerName"/>
				<button type="button" onclick="complete();" class="btn btn-outline-success">확인</button>
			</div>
			<div class="form-group" style="margin-top : 25px; margin-left : 20px;">
				<div id="tierCheck" class="checkbox checkbox-info">
					<input type="checkbox" id="iron" class="tier" name="summonerTier" value="IRON"/>
					<label for="iron">Iron</label>
					                                                          
					<input type="checkbox" id="Bronze" class="tier" name="summonerTier" value="BRONZE"/>
					<label for="Bronze">Bronze</label>                      
	                                                                       
					<input type="checkbox" id="Silver" class="tier" name="summonerTier" value="SILVER"/>
					<label for="Silver">Silver</label>                     
		                                                                   
					<input type="checkbox" id="Gold" class="tier" name="summonerTier" value="GOLD"/>
					<label for="Gold">Gold</label>                         
	                                                                       
					<input type="checkbox" id="Platinum" class="tier" name="summonerTier" value="PLATINUM"/>
					<label for="Platinum">Platinum</label>                 
	                                                                       
					<input type="checkbox" id="Diamond" class="tier" name="summonerTier" value="DIAMOND"/>
					<label for="Diamond">Diamond</label>                   
	                                                                       
					<input type="checkbox" id="Master" class="tier" name="summonerTier" value="MASTER"/>
					<label for="Master">Master</label>                     
	                                                                       
					<input type="checkbox" id="GrandMaster" class="tier" name="summonerTier" value="GRANDMASTER"/>
					<label for="GrandMaster">GrandMaster</label>           
	                                                                       
					<input type="checkbox" id="Challenger" class="tier" name="summonerTier" value="CHALLENGER"/>
					<label for="Challenger">Challenger</label>             
				</div>
			</div>
			<div class="form-group" style="margin-top : 25px; margin-left : 20px;">
				<div class="checkbox checkbox-info">
					<input type="checkbox" id="duo" name="partnerBoardMaxno" class="rankType" value="2"/>
					<label for="duo">듀오</label>
	
					<input type="checkbox" id="teamRank" name="partnerBoardMaxno" class="rankType" value="5"/>
					<label for="teamRank">팀 5:5 랭크</label>
				</div>
			</div>
			<div><input type="hidden" name="chatContent" value=" " /></div>
			<div><input type="hidden" name="expulisionList" value="...." /></div>
			<div class="form-group" style="margin-top : 25px; margin-left : 600px;" >
				<button type="submit" id="checkTier" class="btn btn-outline-success"
						style="width : 100px;">만들기</button>
				<button type="button" class="btn btn-outline-success" onclick="cancel();"
						style="margin-left : 20px;">취소</button>
			</div>
		</form>
	</div>
	<div id="chat_box"></div>
	<input type="text" style="height: 30px; margin-left: 80px;"readonly/><input type="text" id="msg">
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
					$("input[value=BRONZE]").prop("checked", true).attr( "type", "checkbox");
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