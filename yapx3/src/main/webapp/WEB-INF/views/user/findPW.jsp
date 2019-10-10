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

<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-teal.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">
<style>


.yapx3Margin{
	margin-left:auto;
	margin-right:auto;
}

</style>

<script src="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

</head>
<body class="w3-theme-l5">
<div id="container" class="w3-top w3-center w3-display-position" >
	<form name="findPWFrm" action="${pageContext.request.contextPath}/user/findPWEnd.do" method="post" onsubmit="return validate();" >
		<table class="table">
			<tr>
				<td colspan="2">새로운 password가 이메일로 보내집니다.</td>
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
			<tr>
				<td colspan="2">
					<input type="submit" class="btn btn-sm btn-success" value="RESET" >
					<input type="button" class="btn btn-sm btn-success" onclick="self.close();" value="닫기" />	
				</td>
			</tr>
		</table>
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
	if( memberId.val().length < 4 ) {
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