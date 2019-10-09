<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>sign up</title>

<script src="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.js"></script>
<!-- 부트스트랩관련 라이브러리 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<style>

.bgLayer {
	position:absolute; 
	top:0; 
	left:0; 
	width:100%; 
	height:100%; 
	background:#000; 
	opacity:1; 
	filter:alpha(opacity=50); 
	z-index:100;
}  /* z-index가 10이다. 이보다 위에 보이기 위해선 팝을 이보다 크게 설정해야한다. */

/*중복아이디체크관련*/
div#terms-container{
	position:relative; 
	padding:20px 30px;
	
	width:550px; 
	height:650px;
	top:34px;
	margin-left:auto; 
	margin-right:auto;
	margin-top:auto;
	margin-bottom:auto;
	background:#fff; 
	z-index:101;
}

.center{
	text-align:center;
}

.modal.modal-center {
  text-align: center;
}

@media screen and (min-width: 768px) { 
  .modal.modal-center:before {
    display: inline-block;
    vertical-align: middle;
    content: " ";
    height: 100%;
  }
}

.modal-dialog.modal-center {
  text-align: center;
  top: 40px;
  vertical-align: middle; 
}



.formTable{
	width:400px;
	height:400px;
	margin-left:auto; 
	margin-right:auto;
	margin-top:auto;
	margin-bottom:auto;
}
</style>
</head>
<body>

<div id="terms-container">
	<table >
		<tr>
			<th class="center"><h1>YapX3</h1></th>
		</tr>
		<tr>
			<td>
				<label for="terms1">개인 정보 보호 정책 및 프로모션 이메일 수신에 동의합니다.</label>
				<input id="terms1" class="cbAll" type="checkbox">
			</td>
			
		</tr>
		<tr>
			<td>
				<label for="terms2">이용약관</label>
				<input id="terms2" class="cbAll" type="checkbox">				
				<div class="agree__term-scroll"><iframe class="term-iframe" width="100%" height="100%" src="${pageContext.request.contextPath}/resources/terms/member_term.html" frameborder="0" allowtransparency="true" scrolling="yes"> </iframe></div>
			</td>
			
		</tr>
		<tr>
			<td>
				<label for="terms3">개인 정보 정책</label>
				<input id="terms3" class="cbAll"  type="checkbox">
				<div class="agree__term-scroll"><iframe class="term-iframe" width="100%" height="100%" src="${pageContext.request.contextPath}/resources/terms/privacy_policy.html" frameborder="0" allowtransparency="true" scrolling="yes"> </iframe></div>
			</td>
			
		</tr>
		<tr>
			<td>
				<label for="terms4">YapX3 서비스에 관한 이메일을 받는데 동의합니다.</label>
				<input id="terms4" class="cbAll"  type="checkbox">
			</td>
		</tr>
		<tr>
			<td>
				<label for="allTerms">모든 약관에 동의</label>
				<input id="allTerms" type="checkbox">
			</td>
		</tr>
		<tr>
			<td class="center">
				<button type="button" class="btn btn-outline-danger my-2 my-sm-0" id="disagree" >DISAGREE</button>
				<button type="button" class="btn btn-outline-success my-2 my-sm-0" id="iagree" >IAGREE</button>
				<!-- <button class="btn btn-outline-success my-2 my-sm-0" type="button" data-toggle="modal" data-target="#loginModal">IAGREE</button> -->
			</td>
			
		</tr>
		
	</table>                  
</div>
<!-- 로그인모달 : https://getbootstrap.com/docs/4.1/components/modal/#live-demo -->
<div class="modal fade" id="loginModal" data-keyboard="false" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="myLargeModalLabel" aria-hidden="true">
  <div class="modal-dialog modal-center" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="myLargeModalLabel">YapX3</h5>

      </div>
		<div id="enroll-container">
		<br>
			<form name="memberEnrollFrm" action="${pageContext.request.contextPath}/user/loginFormEnd.do" method="post" onsubmit="return validate();" >
				<table class="formTable" >
					<tr class="pnc">
						<th>이메일</th>
						<td>	
							<div id="memberId-container" class="row">
								<div class="col-md1">
									
									<input type="email" class="form-control" placeholder="abc@xyz.com" name="userEmail" id="email">
								</div>
								<div class="col-md2">
									<button type="button" class="btn btn-sm btn-success" id="emailCheck" >인증키생성</button>
						        </div>
						        <div class="col-md3">	
						        	<input type="hidden" name="idDuplicateCheck" id="idDuplicateCheck" value="0"/>
						        </div>
						    </div>
						</td>
					</tr>
					
					<tr class="pnc">
						<th>인증키확인</th>
						<td>	
							<div id="activeKey-container" class="row">
								<div class="col-md1">
									
									<input type="text" class="form-control" name="activeKey" id="activeKey">
								</div>
								<div class="col-md1">
									<button type="button" class="btn btn-sm btn-success" id="activeCheck" >인증</button>
						        </div>
						    </div>
						</td>
					</tr>
					
					<tr class="pnc">
						<th>닉네임</th>
						<td>
							<div id="memberId-container">
								<input type="text" class="form-control" placeholder="4글자이상" name="userNickname" id="memberId_" required>						
							</div>
							
						</td>
					</tr>
					
					<tr class="pnc">
						<th>패스워드</th>
						<td>
							<input type="password" class="form-control" name="userPassword" id="password_" required>
						</td>
					</tr>
					
					<tr class="pnc">
						
						<th>패스워드확인</th>
						<td>	
							<input type="password" class="form-control" id="password2" required>
						</td>
					</tr>  
					
				</table>
				<br>
				<input type="reset" class="btn btn-outline-danger my-2 my-sm-0" id="cancel" value="CANCEL">
				<input type="submit" class="btn btn-outline-success my-2 my-sm-0" value="SIGN UP" >
				<br>
			</form>
			<br>
		</div>


     	
    </div>
  </div>
</div>


<div  class="bgLayer">

</div>
<script>
var active = false;
$(()=>{
	
	$( "#disagree" ).on( "click", function() {
		location.href = "${pageContext.request.contextPath}/";
	});
	
	$( "#cancel" ).on( "click", function() {
		location.href = "${pageContext.request.contextPath}/";
	});
	
	$( "#allTerms" ).on( "change", function() {
		if( $( "#allTerms" ).is( ":checked" ) == false ){
			$( ".cbAll" ).attr( "checked", false );
		}else {
			$( ".cbAll" ).attr( "checked", true );
		}
	});
	
	$( "#iagree" ).on( "click", function() {
		if( $( "#terms1" ).is( ":checked" ) == false ){
			alert( "개인 정보 보호 정책및 프로모션 이메일 수신에 동의하셔야 합니다." );
			return;
		}
		if( $( "#terms2" ).is( ":checked" ) == false ){
			alert( "이용 약관에 동의하셔야 합니다." );
			return;
		}
		if( $( "#terms3" ).is( ":checked" ) == false ){
			alert( "개인 정보 정책에 동의하셔야 합니다." );
			return;
		}
		if( $( "#terms4" ).is( ":checked" ) == false ){
			alert( "Yapx3서비스에 관한 이메일수신에 동의하셔야 합니다." );
			return;
		}
		
		
		bgLayerOpen();


		$( "#loginModal" ).modal( "show" );
	});
	
	$( "#email" ).on( "keyup", (e)=>{
		var memberId = $( e.target ).val().trim();
		
		if( memberId.length < 4 ) {
			$( "#idDuplicateCheck" ).val(0);
			return;
		}
		
		$.ajax({
			url : "${pageContext.request.contextPath}/user/checkIdDuplicate.do",
			data : { memberId : memberId },
			//dataType : "json",
			success: data => {
				console.log( "email:::keyup : ", data ); //json타입이 js object로 변환되어 전달됨.
				if( data.isUsable == true ){
					$( "#idDuplicateCheck" ).val(0);//중복체크 했음
				}else {
					$( "#idDuplicateCheck" ).val(1);//중복체크 했음
				}
			},
			error: ( jqxhr, textStatus, errorThrown ) => {
				console.log( "email:::keyup : ajax처리실퍠!", jqxhr, textStatus, errorThrown );
			}
		});
	});
	
	$( "#emailCheck" ).on( "click", function() {
		if( $( "#idDuplicateCheck" ).val() == 0 ) {
			alert("이미사용중인 아이디 입니다.");
			memberId.focus();
			return false;
		}
		console.log( "emailCheck" );
		var email = $( "#email" ).val();
		$.ajax({
			url : "${pageContext.request.contextPath}/user/sendEmail.do",
			data : { memberId : email },
			//dataType : "json",
			success: data => {
				console.log( "emailCheck:::click : ", data ); //json타입이 js object로 변환되어 전달됨.
				if( data == 1 ) {
					alert( "인증키를 해당 이메일로 발송하였습니다." );
				}else if( data == -10 ) {
					alert( "회원가입된 이메일입니다." );
				}else if( data == -2147482646 ) {
					alert( "인증키를 해당 이메일로 발송하였습니다." );
				}
			},
			error: ( jqxhr, textStatus, errorThrown ) => {
				console.log( "ajax처리실퍠!", jqxhr, textStatus, errorThrown );
			}
		});
	});
	
	$( "#activeCheck" ).on( "click", function() {
		console.log( "activeCheck" );
		var email = $( "#email" ).val();
		var activeKey = $( "#activeKey" ).val();
		$.ajax({
			url : "${pageContext.request.contextPath}/user/activeCheck.do",
			data : { "memberId" : email,
					 "activeKey" : activeKey},
			//dataType : "json",
			success: data => {
				console.log( "activeKey:::click : ", data ); //json타입이 js object로 변환되어 전달됨.
				if( data == 1 ) {
					alert( "인증키를 확인 하였습니다." );
					active = true;
				}else {
					alert( "인증키가 불일치 합니다." );
					active = false;
				}
			},
			error: ( jqxhr, textStatus, errorThrown ) => {
				console.log( "ajax처리실퍠!", jqxhr, textStatus, errorThrown );
			}
		});
	});
	
	$(window).resize(function() { //화면 크기 변할 시
	    $('.bgLayer').css('width' ,  $(window).width() - 0 );
	    $('.bgLayer').css('height' ,  $(window).height() - 0 );
	});

});

function bgLayerOpen() {
    if(!$('.bgLayer').length) {
        $('<div class="bgLayer"></div>').appendTo($('body'));
    }
    var object = $(".bgLayer");
    
    console.log( object );
    
    var w = $(document).width()+12;
    var h = $(document).height();


    object.css({'width':w,'height':h}); 
    object.fadeIn(10);   //생성되는 시간 설정
}

function validate(){
	var memberId = $("#email");
	
	if(memberId.val().trim().length<4){
		alert("아이디는 email형식이어야 합니다.");
		memberId.focus();
		return false;
	}
	if( $( "#idDuplicateCheck" ).val() == 0 ) {
		alert("이미사용중인 아이디 입니다.");
		memberId.focus();
		return false;
	}
	if( active == false ) {
		$( "#activeKey" ).focus();
		return false;
	}
	
	if($("#password_").val()!=$("#password2").val()){
		alert("패스워드가 일치하지 않습니다.");
		$("#password_").focus();
	}
	return true;
}
</script>

</body>
</html>