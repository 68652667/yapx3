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
	$(()=>{
		$( ".disagree" ).on( "click",function() {
			if( confirm( "정말 회원을 삭제 하시겠습니까?" ) ){	
				var email = $( this ).parent().parent().find("*").first().text();
				location.href = "${pageContext.request.contextPath}/user/memberDelete?memberId=" + email;
			}
		});
	});
</script>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1024px;margin-top:125px; min-height: 700px;">

    
   <table class="table table-hover">
  <thead class="thead-dark">
    <tr>
      <th scope="col">eMail</th>
      <th scope="col">닉네임</th>
      <th scope="col">회원가입일</th>
      <th scope="col">회원탈퇴</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${list }" var="b" varStatus="vs" >
		<tr>
			<td>${b.userEmail }</td>
			<td>${b.userNickname }</td>
			<td>${b.userEnrollDate }</td>		
			<td>
				<button type="button" class="btn btn-outline-danger my-2 my-sm-0 disagree" >삭제</button>
			</td>
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