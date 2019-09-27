<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1024px;margin-top:175px; min-height: 768px;">
	글번호 : ${free.freeBoardNo } <br />
	제목 : ${free.freeBoardTitle } <br />
	글쓴이 : ${free.userNickName } 
	<br />
	<c:forEach items="${free.attachList}" var="a" varStatus="vs">
		<img src="${pageContext.request.contextPath}/resources/upload/board/${a.renamedFileName}" alt="" />
	</c:forEach>
	<br />
	내용 : ${free.freeBoardContent }
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>