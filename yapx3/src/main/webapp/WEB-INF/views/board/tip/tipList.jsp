<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<style>
tr[tipBoardNo]:hover {
	cursor: pointer;
}
#makeFree{
	margin-bottom: -8px;
}

.pageBar {
  text-align: center;
  margin: 20px;
}

.pagination {
  display: inline-block;
}

.pagination a {
  color: black;
  float: left;
  padding: 8px 16px;
  text-decoration: none;
  transition: background-color .3s;
  border: 1px solid #cdd2d2;
}

.pagination a.active {
  background-color: #4d636f;
  color: white;
  border: 1px solid #4d636f;
}

.pagination a:hover:not(.active) {background-color: #ddd;}

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
<div class="w3-container w3-content" style="max-width:1024px;margin-top:175px; min-height: 660px;">
<h2>팁/공략 게시판</h2>
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
<div class="pageBar">
	<div class="pagination">
	${pageBar }
	</div>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>