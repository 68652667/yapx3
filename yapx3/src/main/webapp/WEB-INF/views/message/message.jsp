<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>쪽지함</title>
</head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">


<script src="${pageContext.request.contextPath }/resources/js/jquery-3.4.1.js"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.em3but {height: 3em;}
.table {
	width : 100%;
	border-top: 1px solid #444444;
    border-collapse: collapse;
}
th, td {
  border-top: 1px solid #444444;
  border-bottom: 1px solid #444444;
}

</style>
<body class="w3-theme-l5">

<div class="w3-top" >
	<div class="w3-bar w3-theme-d1 w3-left-align w3-responsive">
		<div class="w3-bar-item w3-padding-large w3-theme-d4 em3but">YapX3</div>
		<div class="w3-bar-item w3-padding-large w3-display-middle em3but ">${memberLoggedIn.userNickname}의 쪽지함</div>		
		<div id="closeBtn" class="w3-bar-item w3-padding-large w3-right w3-theme-d4 em3but w3-button w3-hover-white" title="창닫기">X</div>
	</div>
</div>

<div id="container" class="w3-top w3-center w3-display-position" style="top:50px;" >
	<table class="table">
		<tr>
			<th>보낸사람</th>
			<th>제목</th>
			<th>날짜</th>
		</tr>
		<c:forEach items="${list }" var="msg" varStatus="vs">
			<tr class="msgBtn" msgNo="${msg.messageNo }" >
				<td><button class="w3-button w3-block w3-hover-light-grey" title="쪽지보내기">${msg.sendUserNickName }</button></td>
				<td><button class="w3-button w3-block w3-hover-light-grey" title="내용보기">${msg.messageTitle }</button></td>
				<td>${msg.messageDate }</td>
			
			</tr>
		</c:forEach>
	</table>
</div>

<!-- 로그인모달 : https://getbootstrap.com/docs/4.1/components/modal/#live-demo -->
<div class="modal fade" id="msgModal"  data-keyboard="false" data-backdrop="static" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">받은 쪽지</h5>
        <button type="button" class="close" data-dismiss="modal" aria-label="Close">
          <span aria-hidden="true">&times;</span>
        </button>
      </div>
      <div id="modal-body">
     	<table class="table">
     		<tr>
     			<td id="userNickname">
		        </td>
		        <td id="messageTitle">
		        </td>
		         <td id="messageDate">
		        </td>
	        </tr>
	        <tr>
	        	<td colspan='3' >
	        		<textarea id="messageContent" cols="42" rows="15" disabled readonly style="resize:none;" ></textarea>
	        	</td>
	        </tr>
	    </table>
 	  </div>
 	  
 	  <div class="modal-footer">
       	<button class="btn btn-primary">답장쓰기</button>
      </div>
    </div>
  </div>
</div>
<script>
$(()=>{
	$( "#closeBtn" ).on( "click", function() {
		console.log( "close" );
		self.close();
	});
	
	$( ".msgBtn" ).on( "click", function() {
		var msgNo = $( this ).attr( "msgNo" );
		var saveDate = $( this ).children().last().text();
		$(()=>{
			console.log( "msgNo : ", msgNo );
			$.ajax({
				url : "${pageContext.request.contextPath}/message/getMsg.do",
				data : { msgNo : msgNo },
				success: data => {
					console.log( data ); //json타입이 js object로 변환되어 전달됨.
					$( "#userNickname" ).html( "To. " + data.sendUserNickName );
					$( "#messageTitle" ).html( data.messageTitle );
					$( "#messageDate" ).html( saveDate );
					$( "#messageContent" ).val( data.messageContent );
					$( "#msgModal" ).modal("show");
				},
				error: ( jqxhr, textStatus, errorThrown ) => {
					console.log( "ajax처리실퍠!", jqxhr, textStatus, errorThrown );
				}
			
			});
			
		});
		
	});
});
	
</script>
</body>
</html>