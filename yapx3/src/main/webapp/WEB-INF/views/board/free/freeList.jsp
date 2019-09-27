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
function makeFree() {
	location.href = "${pageContext.request.contextPath}/free/freeBoardWrite.do?userEmail="+"nana@gmail.com"+"&userNickname="+"나나";
}
$(()=>{
	$("tr[freeBoardNo]").click(function(){
		var freeBoardNo = $(this).attr("freeBoardNo");
		location.href = "${pageContext.request.contextPath}/free/freeBoardView.do?freeBoardNo="+freeBoardNo;
	});
});
</script>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1024px;margin-top:175px; min-height: 768px;">
<p style="text-align: right;"><button type="button" class="btn btn-secondary btn-sm" id="makeFree" onclick="makeFree();">글쓰기</button></p>    
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
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>