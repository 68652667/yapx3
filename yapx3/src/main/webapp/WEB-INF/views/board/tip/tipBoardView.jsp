<%@page import="com.kh.yapx3.user.model.vo.Member"%>
<%@page import="com.kh.yapx3.board.free.model.vo.FreeComment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<style>
.w3-content{
	margin-bottom: 25px;
}
.header{
	padding: 24px 16px;
	display: block;
}
.title{
	line-height: 36px;
    font-size: 24px;
    color: #1e2022;
    word-wrap: break-word;
    word-break: break-all;
}
.leftInfo{
	float: left;
}
.rightInfo{
	float: right;
}
.boardType, .boardType:hover{
	text-decoration: none;
	color: inherit;
}
.boardComment{
	margin: auto;
	width: 75%;
}
#tbl-comment{
	box-shadow: 0 1px 3px 0 rgba(0,0,0,.15);
}
.boardContent{
	border: 1px solid #EBEEF1;
	background: white;
	margin: auto;
	width: 75%;
	box-shadow: 0 1px 3px 0 rgba(0,0,0,.15);
}
.boardType, .date, #btnSendMsg{
	display: inline-block;
    vertical-align: middle;
    position: relative;
    margin-left: 8px;
    padding-left: 9px;
}
.date{
	border-left: 1px solid #EBEEF1;
}
.content{
	padding: 20px;
	border-top: 1px solid #EBEEF1;
}
#btnSendMsg{
	border-left: 1px solid #EBEEF1;
	height: 20px;
	padding: 0 0 0 9px;
}
.boardType{
	padding-left: 0;
	margin-left: 0;
}
.vote{
	text-align: center;
	padding: 10px 0;
	border-top: 1px solid #EBEEF1;
}
.like{
	border-left: 1px solid #EBEEF1;
	margin-left: 8px;
	padding-left: 9px;
}
.comment{
	border-left: 1px solid #EBEEF1;
	margin-left: 8px;
	padding-left: 9px;
}
textarea{
	resize: none;
}
.commentHeader{
	padding: 16px;
}
table#tbl-comment tr td:first-child{
	width: 585px;
}
table#tbl-comment tr td:last-child{
	width: 115px;
	text-align: right;
}
.commentContent1{
	padding-left: 15px;
}
.commentContent2{
	padding-left: 35px;
}
.input-group{
	background: white;
}
</style>
<script>
$(()=>{
	$("[name=commentContent]").click(()=>{
		if(${memberLoggedIn==null}){
			alert("로그인을 해주세요!");
			location.href="${pageContext.request.contextPath}/user/loginClick.do";
		}
	});
	
	$(".btn-reply").on("click",(e)=>{
		//로그인 여부에 따라 분기
		if(${memberLoggedIn==null}){
			alert("로그인을 해주세요!");
			return;
		}
			//로그인한 경우	
			var div = $("<div></div>");
			var html = "<form action='${pageContext.request.contextPath}/tip/tipCommentUp.do' method='post'>";
			html += "<div class='input-group'>";
			html += "<input type= 'hidden' name='tipBoardNo' value='${tip.tipBoardNo }'/>";
			html += "<input type= 'hidden' name='userEmail' value='${memberLoggedIn.userEmail}'/>";
			html += "<input type= 'hidden' name='userNickname' value='${memberLoggedIn.userNickname}'/>";
			html += "<input type= 'hidden' name='commentLevel' value='2'/>";
			html += "<input type= 'hidden' name='commentRef' value='"+e.target.value+"'/>";
			html += "<textarea name='commentContent' cols='60' rows='1'></textarea>";
			html += "<div class='input-group-append' style='background-color: #da7f84; border-radius: 0.2em;'>";
			html += "<button type='submit' class='btn btn-outline-secondary' style='color: white; border:0px solid transparent;'>등록</button>";
			html += "</div>";
			html += "</div>";
			html += "</form>";
			
			div.html(html);
			
			//클릭한 버튼이 속한 tr 다음에 tr을 추가
			div.insertAfter($(e.target).parent().parent())
				.children("form").slideDown(800)//td가 0.8초동안 슬라이드가 밑으로 내려옴.
				.children("form").submit((e)=>{//form이 제출 될때
									//여기서 e는 form을 가리킴
									console.log($(e.target));
									var len = $(e.target).children("textarea")
														.val()
														.trim()
														.length;
									if(len == 0){
										e.preventDefault();
									}
			});
	});
	
	$(".btn-delete").on("click",(e)=>{
		if(!confirm("정말 삭제하시겠습니까?")){
			return;
		}
		location.href = "${pageContext.request.contextPath}/tip/tipCommentDel.do"
			+"?commentNo="+e.target.value+"&tipBoardNo=${tip.tipBoardNo }";
		
	});
	
	$( "#btnSendMsg" ).on("click", function() {
		if(${memberLoggedIn==null}){
			alert("로그인을 해주세요!");
			return;
		}
		var popup = "width=470,height=600,resizable=no,scrollbars=no,status=no";
		window.open( "${pageContext.request.contextPath}/message/messageSned?memberId=${memberLoggedIn.userEmail}&sendEmail=${tip.userEmail}&sendNickName=${tip.userNickName }", "", popup ).focus();
	});
	$( ".btnSendMsg2" ).on("click", function() {
		if(${memberLoggedIn==null}){
			alert("로그인을 해주세요!");
			return;
		}
		var popup = "width=470,height=600,resizable=no,scrollbars=no,status=no";
		window.open( "${pageContext.request.contextPath}/message/messageSned?memberId=${memberLoggedIn.userEmail}&sendEmail=" + $( this ).attr( "eId" ) + "&sendNickName=" + $( this ).attr( "nId" ), "", popup ).focus();
	});
});
$(document).on("click", ".btn-like", (e)=>{
	if(${memberLoggedIn==null}){
		alert("로그인을 해주세요!");
		return;
	}
	var tipboardNo = $("[name=tipBoardNo]").val();
	var userEmail = $("[name=userEmail]").val();
	$.ajax({
		url: "tipboardLike?tipboardNo="+tipboardNo+"&userEmail="+userEmail,
		type: "GET",
		dataType: "json",
		success: function(data){
			$(".btn-like span").text(" "+data.like);
			$(".like").text("추천 "+data.like);
		},
		error: function(err){
			console.log("실패!");
		}
	});
});
</script>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1024px;margin-top:175px; min-height: 768px;">
	<div class="boardContent">
		<div class="header">
			<div class="title">${tip.tipBoardTitle }</div><br />
			<div class="leftInfo">
				<a href="${pageContext.request.contextPath}/tip/tipList.do" class="boardType">팁</a>
				<span class="date">${tip.tipBoardDate }</span>
				<div class="w3-button" id="btnSendMsg" title="쪽지보내기" >
				${tip.userNickName } 
				</div>
			</div>
			<div class="rightInfo">
				<span>조회 ${tip.tipBoardViews }</span>
				<span class="comment">댓글 ${commentNumber }</span>
				<span class="like">추천 ${tip.tipBoardLike }</span>
			</div>
		</div>
	<br />
		<div class="content">
			<c:if test="${!empty tip.attachList }">
				<c:forEach items="${tip.attachList}" var="a" varStatus="vs">
					<img src="${pageContext.request.contextPath}/resources/upload/board/${a.renamedFileName}" alt="" style="width: 400px;"/>
				</c:forEach>
			</c:if>
			<br />
			<c:if test="${!empty tip.YL}">
				<iframe width="400" height="315" src="//www.youtube.com/embed/${tip.YL }" frameborder="0" allowfullscreen></iframe>
			</c:if>
			<br />
			${tip.tipBoardContent }
		</div>
	<br />
		<div class="vote">
			<button class="btn-like btn btn-small btn-pink"><img src="https://image.flaticon.com/icons/svg/686/686308.svg" width="30px" height="30px"><span> ${tip.tipBoardLike }</span></button>
		</div>
	</div>
	<br />
	<div class="boardComment">
		<div class="commentHeader">
			<h2 style="font-size: 18px; display: inline;">댓글</h2>
			<span> ${commentNumber }개</span>
		</div>
	<form action="${pageContext.request.contextPath}/tip/tipCommentUp.do"
					name="boardCommentFrm" method="post">
		<div class="input-group mb-3">
				<input type="hidden" name="tipBoardNo" value="${tip.tipBoardNo }"/>
				<input type="hidden" name="userEmail" value="${memberLoggedIn.userEmail}"/>
				<input type="hidden" name="userNickname" value="${memberLoggedIn.userNickname}"/>
				<input type="hidden" name="commentLevel" value="1"/> <!-- 댓글인 경우 1 -->
				<input type="hidden" name="commentRef" value="0"/> <!-- 댓글인 경우 참조댓글이 없으므로 0으로 초기화 -->
				<textarea name="commentContent" class="form-control" cols="60" rows="1"></textarea>
				<div class="input-group-append" style="background-color: #da7f84; border-radius: 0.2em;" >
				<button type="submit" class="btn btn-outline-secondary" style="color: white; border:0px solid transparent;">등록</button>
				</div>
		</div>
	</form>
	<table id="tbl-comment" class="list-group">
				<c:forEach items="${commentList }" var="c">
					<c:choose>
						<c:when test="${c.commentLevel == 1}">
						<tr class="level1 list-group-item">
							<td>
								<sub class="comment-writer">
								<div class="w3-button btnSendMsg2" title="쪽지보내기" eId="${c.userEmail }" nId="${c.userNickname }" >
								${c.userNickname }
								</div>
								</sub> 
								
								<sub class="comment-date">${c.date }</sub><br /><br />
								<span class="commentContent1">${c.commentContent }</span>
							</td>
							<td>
								<button class="btn-reply btn btn-small btn-pink" value="${c.commentNo }">답글</button>
								<c:if test="${memberLoggedIn.userEmail == c.userEmail }">
									<button class="btn-delete btn btn-small btn-gray" value="${c.commentNo }">삭제</button>
								</c:if>
							</td>
						</tr>
						</c:when>
						
						<c:when test="${c.commentLevel == 2}">
							<tr class="level2 list-group-item">
							<td style="padding-left: 20px">
								└<sub class="comment-writer">
								<div class="w3-button btnSendMsg2" title="쪽지보내기" eId="${c.userEmail }" nId="${c.userNickname }" >
								${c.userNickname }
								</div>
								</sub> 
								<sub class="comment-date">${c.date }</sub><br /><br />
								<span class="commentContent2">${c.commentContent }</span>
							</td>
							<td>
								<c:if test="${memberLoggedIn.userEmail == c.userEmail }">
									<button class="btn-delete btn btn-small btn-gray" value="${c.commentNo }">삭제</button>
								</c:if>
							</td>
						</tr>
						</c:when>
					</c:choose>
		</c:forEach>
		</table>
	</div>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>