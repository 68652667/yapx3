<%@page import="com.kh.yapx3.user.model.vo.Member"%>
<%@page import="com.kh.yapx3.board.free.model.vo.FreeComment"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
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
			var html = "<form action='${pageContext.request.contextPath}/free/freeCommentUp.do' method='post'>";
			html += "<div class='input-group'>";
			html += "<input type= 'hidden' name='freeBoardNo' value='${free.freeBoardNo }'/>";
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
		location.href = "${pageContext.request.contextPath}/free/freeCommentDel.do"
			+"?commentNo="+e.target.value+"&freeBoardNo=${free.freeBoardNo }";
		
	});
	
	$( "#btnSendMsg" ).on("click", function() {
		var popup = "width=470,height=600,resizable=no,scrollbars=no,status=no";
		window.open( "${pageContext.request.contextPath}/message/messageSned?memberId=${memberLoggedIn.userEmail}&sendEmail=${free.userEmail}&sendNickName=${free.userNickName }", "", popup ).focus();
	});
	$( ".btnSendMsg2" ).on("click", function() {
		var popup = "width=470,height=600,resizable=no,scrollbars=no,status=no";
		window.open( "${pageContext.request.contextPath}/message/messageSned?memberId=${memberLoggedIn.userEmail}&sendEmail=" + $( this ).attr( "eId" ) + "&sendNickName=" + $( this ).attr( "nId" ), "", popup ).focus();
	});
});
</script>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1024px;margin-top:175px; min-height: 768px;">
	글번호 : ${free.freeBoardNo } <br />
	제목 : ${free.freeBoardTitle } <br />
	글쓴이 : 
	<div class="w3-button" id="btnSendMsg" title="쪽지보내기" >
	${free.userNickName } 
	</div>
	<br />
	<c:forEach items="${free.attachList}" var="a" varStatus="vs">
		<img src="${pageContext.request.contextPath}/resources/upload/board/${a.renamedFileName}" alt="" style="width: 400px;"/>
	</c:forEach>
	<br />
	<iframe width="400" height="315" src="//www.youtube.com/embed/${free.YL }" frameborder="0" allowfullscreen></iframe>
	<br />
	내용 : ${free.freeBoardContent }
	<br />
	<form action="${pageContext.request.contextPath}/free/freeCommentUp.do"
					name="boardCommentFrm" method="post">
		<div class="input-group mb-3">
				<input type="hidden" name="freeBoardNo" value="${free.freeBoardNo }"/>
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
						<tr class="level1, list-group-item">
							<td>
								<sub class="comment-writer">
								<div class="w3-button btnSendMsg2" title="쪽지보내기" eId="${c.userEmail }" nId="${c.userNickname }" >
								${c.userNickname }
								</div>
								</sub> 
								<sub class="comment-date">${c.date }</sub><br /><br />
								${c.commentContent }
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
							<tr class="level2, list-group-item">
							<td style="padding-left: 20px">
								ㄴ<sub class="comment-writer">
								<div class="w3-button btnSendMsg2" title="쪽지보내기" eId="${c.userEmail }" nId="${c.userNickname }" >
								${c.userNickname }
								</div>
								</sub> 
								<sub class="comment-date">${c.date }</sub><br /><br />
								${c.commentContent }
							</td>
							<td>
								<c:if test="${memberLoggedIn.userEmail == c.userEmail }">
									<button class="btn-delete btn btn-small btn-gray" value="${c.commentNo }">삭제</button>
								</c:if>
							</td>
						</tr>
						</c:when>
					</c:choose>
					
				<%-- <tr class="level1, list-group-item">
					<td> 
						<sub class="comment-writer"><%=bc.getBoardCommentWriter() %></sub> 
						<sub class="comment-date"><%=bc.getBoardCommentDate() %></sub><br /><br />
						<%=bc.getBoardCommentContent() %>
					</td>
					<td>
						<button class="btn-reply btn btn-small btn-pink" value="<%=bc.getBoardCommentNo()%>">답글</button>
						<c:if test="${memberLoggedIn. }"></c:if>
						 <%if(memberLoggedIn!=null&&
						 ("admin".equals(memberLoggedIn.getMemberId())||
								 memberLoggedIn.getMemberId().equals(bc.getBoardCommentWriter()))) {%>
						<button class="btn-delete btn btn-small btn-gray" value="<%=bc.getBoardCommentNo()%>">삭제</button>
						<%} %>
					</td>
				</tr>
				<%} 
				else{%>
				<tr class="level2, list-group-item">
					<td style="padding-left: 20px">
						<sub class="comment-writer">&nbsp;<%=bc.getBoardCommentWriter() %></sub> 
						<sub class="comment-date"><%=bc.getBoardCommentDate() %></sub> <br /><br />
						<%=bc.getBoardCommentContent() %>
					</td>
					<td>
						<%if(memberLoggedIn!=null&&
						 ("admin".equals(memberLoggedIn.getMemberId())||
								 memberLoggedIn.getMemberId().equals(bc.getBoardCommentWriter()))) {%>
						<button class="btn-delete btn btn-small btn-gray" value="<%=bc.getBoardCommentNo()%>">삭제</button>
						<%} %>
					</td>
				</tr> --%>
		</c:forEach>
		</table>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>