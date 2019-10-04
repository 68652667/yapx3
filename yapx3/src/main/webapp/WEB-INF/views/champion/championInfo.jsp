<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.em3but {height: 3em;}
.championPerkPage{
	display:inline;
}
.championPerkPage img{
	width: 35px;
}
</style>
<div class="w3-container w3-content" style="max-width:1400px;margin-top:115px; min-height: 768px;">

	<c:forEach items="${championLaneList }" var="lane">
		${lane.championLane }
		${lane.championLaneCount }
	</c:forEach>
	<hr />
	<c:forEach items="${championSpellList }" var="spell">
		${spell.summonerSpell1id }
		${spell.summonerSpell2id }
		${spell.summonerSpellCountStr }
		<hr />
	</c:forEach>
	<br />
		
	<jsp:include page="/WEB-INF/views/common/championInfoTable.jsp"/>
	
	<br />
</div>

<jsp:include page="/WEB-INF/views/common/footer.jsp"/> 