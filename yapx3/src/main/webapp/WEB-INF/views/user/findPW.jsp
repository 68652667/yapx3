<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>reset password</title>

<script src="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.js"></script>
<!-- 부트스트랩관련 라이브러리 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>
<style>

/*중복아이디체크관련*/
div#memberId-container{position:relative; padding:0px;}
div#memberId-container span.guide {display:none;font-size: 12px;position:absolute; top:12px; right:10px;}
div#memberId-container span.ok{color:green;}
div#memberId-container span.error{color:red;}
</style>
</head>
<body>
<div id="findPW-container">
	<form name="findPWFrm" action="${pageContext.request.contextPath}/user/findPWEnd.do" method="post" onsubmit="return validate();" >
		<table>
			<tr>
				<th></th>
				<td>새로운 password가 이메일로 보내집니다.</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td>	
					<div id="memberId-container" >
						<div class="col-md1">	
							<input type="email" class="form-control" placeholder="abc@xyz.com" name="userEmail" id="email">
						</div>
						
				        <div class="col-md1">	
				        	<input type="hidden" name="idDuplicateCheck" id="idDuplicateCheck" value="1"/>
				        </div>
				    </div>
				</td>
			</tr>
		</table>
		<input type="submit" value="RESET" >
	</form>
</div>

<script>
var active = false;
$(()=>{

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
});


function validate(){
	var memberId = $("#email");
	if( $( "#idDuplicateCheck" ).val().length < 4 ) {
		alert("아이디를 입력하세요.");
		memberId.focus();
		return false;
	}
	if( $( "#idDuplicateCheck" ).val() == 1 ) {
		alert("미사용 아이디 입니다.");
		memberId.focus();
		return false;
	}
	return true;
}
</script>
</body>
</html>