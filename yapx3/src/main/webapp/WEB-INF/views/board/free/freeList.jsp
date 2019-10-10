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
tr[freeBoardNo]:hover {
	cursor: pointer;
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
function makeFree() {
	location.href = "${pageContext.request.contextPath}/free/freeBoardWrite.do?userEmail=${memberLoggedIn.userEmail}&userNickname=${memberLoggedIn.userNickname}";
}
$(()=>{
	$("tr[freeBoardNo]").click(function(){
		var freeBoardNo = $(this).attr("freeBoardNo");
		location.href = "${pageContext.request.contextPath}/free/freeBoardView.do?freeBoardNo="+freeBoardNo;
	});
});
</script>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1024px;margin-top:175px; min-height: 660px;">
<c:if test="${memberLoggedIn!=null}">
	<p style="text-align: right;"><button type="button" class="btn btn-secondary btn-sm" id="makeFree" onclick="makeFree();">글쓰기</button></p>
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
  <c:forEach items="${list }" var="b" varStatus="vs">
		<tr freeBoardNo="${b.freeBoardNo }" >
			<td scope="row">${b.freeBoardLike }</td>
			<td>
				<c:if test="${b.fileCount>0 }">
					<img src='<c:url value="/resources/images/file.png"/>' 
						 width="16" alt="첨부파일" />
				</c:if>
			</td>
			<td>${b.freeBoardTitle }</td>
			<td>${b.userNickName }</td>
			<td>${b.freeBoardDate }</td>
			<td>${b.freeBoardViews }</td>				
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