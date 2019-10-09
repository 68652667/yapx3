<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>login</title>
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

div#login-container{
	position:relative; 
	padding:20px 30px;
	
	width:300px; 
	height:300px;
	top:234px;
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
.right{
	text-align:right;
}
</style>
<script src="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.js"></script>
<!-- 부트스트랩관련 라이브러리 -->
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js" integrity="sha384-uefMccjFJAIv6A+rW+L4AHf99KvxDjWSu1z9VI8SKNVmz4sk7buKt/6v9KI65qnm" crossorigin="anonymous"></script>

</head>
<body>

<div id="login-container" >
	
	<button onclick="backPage();">&lt;</button>
	
	<form name="memberLoginFrm" action="${pageContext.request.contextPath}/user/loginCheck.do" method="post" onsubmit="return validate();" >
		<table>
			<tr>
				<th class="center">YapX3</th>
			</tr>
			<tr>
				<td>Email Login</td>
			</tr>
			<tr>
				<td>
					<div id="memberId-container">
						<input type="email" class="form-control" placeholder="email" name="memberId" id="memberId_" required>
					</div>
					
				</td>
			</tr>
			
			<tr>
				<td>
					<div id="password-container">
						<input type="password" class="form-control" placeholder="password" name="password" id="password_" required>
			
					</div>
					
				</td>
			</tr>
			<tr>
				<td>
				<input name="remember_me" type="checkbox" id="reme" >Remember Me</input>
				<a href="${pageContext.request.contextPath}/user/findPW.do">Forget Password</a>
				
				</td>
			</tr>
			<tr>
				<td class="right">
				<button id="Login" >Login</button>
				</td>
			</tr>
			<tr>
				<td>
				<label for="signUp">계정이 없으신가요?</label>
				<a href="${pageContext.request.contextPath}/user/loginForm.do" id="signUp">sign up</a>
				</td>
			</tr>
		</table>
	</form>
	
</div>

<div  class="bgLayer">

</div>

<script>
function backPage() {
	location.href = "${pageContext.request.contextPath}/";
}

function validate() {
	if($("#password_").val().trim().length < 4 ){
		alert("패스워드는 4글자 이상이어야 합니다.");
		$("#password_").focus();
		return false;
	}
	if( $( "#reme" ).is( ":checked" ) == true ) {
		localStorage.setItem( "id", $( "#memberId_" ).val() );
	}
	return true;
}

$(()=>{
	if( localStorage.getItem("id") != null ) {
		if( localStorage.getItem("id").length > 4 ) {
			$( "#memberId_" ).val( localStorage.getItem("id") );
			$( "#reme" ).attr( "checked" , true );
		}
	}
});

</script>
			
</body>
</html>