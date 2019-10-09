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
function makeGontip() {
	location.href = "${pageContext.request.contextPath}/gontip/gontipBoardWrite.do?userEmail=${memberLoggedIn.userEmail}&userNickname=${memberLoggedIn.userNickname}";
}
$(()=>{
	$("tr[gontipBoardNo]").click(function(){
		var gontipBoardNo = $(this).attr("gontipBoardNo");
		location.href = "${pageContext.request.contextPath}/gontip/gontipBoardView.do?gontipBoardNo="+gontipBoardNo;
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
      <th scope="col">챔피언</th>
      <th scope="col">제목</th>
      <th scope="col">글쓴이</th>
      <th scope="col">작성일</th>
      <th scope="col">조회수</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list }" var="b">
		<tr gontipBoardNo="${b.gontipBoardNo }" >
			<td scope="row">${b.gontipBoardLike }</td>
			<td>
				<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/${b.champion }.png" alt="" />
			</td>
			<td>${b.gontipBoardTitle }</td>
			<td>${b.userNickName }</td>
			<td>${b.gontipBoardDate }</td>
			<td>${b.gontipBoardViews }</td>				
		</tr>
	</c:forEach>
  </tbody>
</table>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>