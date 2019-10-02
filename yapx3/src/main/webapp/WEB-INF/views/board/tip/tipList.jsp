<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<style>
#makeFree{
	margin-bottom: -8px;
}
</style>
<script>
function makeTip() {
	location.href = "${pageContext.request.contextPath}/tip/tipBoardWrite.do?userEmail=${memberLoggedIn.userEmail}&userNickname=${memberLoggedIn.userNickname}";
}
$(()=>{
	$("tr[tipBoardNo]").click(function(){
		var tipBoardNo = $(this).attr("tipBoardNo");
		location.href = "${pageContext.request.contextPath}/tip/tipBoardView.do?tipBoardNo="+tipBoardNo;
	});
});
</script>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1024px;margin-top:175px; min-height: 768px;">
<c:if test="${memberLoggedIn!=null}">
	<p style="text-align: right;"><button type="button" class="btn btn-secondary btn-sm" id="makeTip" onclick="makeTip();">글쓰기</button></p>
</c:if>
    
   <table class="table table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">좋아요</th>
      <th scope="col">이미지</th>
      <th scope="col">제목</th>
      <th scope="col">글쓴이</th>
      <th scope="col">작성일</th>
      <th scope="col">조회수</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list }" var="b">
		<tr tipBoardNo="${b.tipBoardNo }" >
			<td scope="row">${b.tipBoardLike }</td>
			<td>
				<c:if test="${b.fileCount>0 }">
					<img src='<c:url value="/resources/images/file.png"/>' 
						 width="16" alt="첨부파일" />
				</c:if>
			</td>
			<td>${b.tipBoardTitle }</td>
			<td>${b.userNickName }</td>
			<td>${b.tipBoardDate }</td>
			<td>${b.tipBoardViews }</td>				
		</tr>
	</c:forEach>
  </tbody>
</table>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>