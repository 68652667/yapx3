<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<!-- Page Container -->
<script src="${pageContext.request.contextPath }/resources/js/jquery.oLoader.min.js"></script>
<div class="w3-container w3-content" style="max-width:1400px;margin-top:115px; min-height: 768px;">
<style>
.w3-table td, .w3-table th, .w3-table-all td, .w3-table-all th{
	text-align: center;
}
.searchBar{
	display: inline-block;
	float: right;
}
table{
	border: 1px solid;
	margin-top: 20px;
}
table tr, th, td{
	border-bottom: 1px solid;
	text-align: center;
}
table tr:not(:first-child):hover{
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

.winratio-graph {
    position: relative;
    display: inline-block;
    width: 150px;
    height: 20px;
    vertical-align: middle;
}

.winration-graph{
    position: relative;
    display: inline-block;
    width: 150px;
    height: 20px;
    vertical-align: middle;
}

.winratio-graph__fill--left {
    background: #3d95e5;
    border-top-right-radius: 0;
    border-bottom-right-radius: 0;
    z-index: 1;
}

.winratio-graph__fill {
    position: absolute;
    left: 0;
    top: 0;
    height: 100%;
    border-radius: 4px;
}

.winratio-graph__text--left {
    left: 9px;
    text-align: left;
    z-index: 1;
}
.winratio-graph__text {
    position: absolute;
    top: 3px;
    height: 100%;
    line-height: 15px;
    font-size: 12px;
    color: #fff;
    font-weight: bold;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

.winratio-graph__fill--right {
    width: 100%;
    background: #ee5a52;
}

.winratio-graph__fill {
    position: absolute;
    left: 0;
    top: 0;
    height: 100%;
    border-radius: 4px;
}

.winratio-graph__text--right {
    right: 8px;
    text-align: right;
}
.winratio-graph__text {
    position: absolute;
    top: 3px;
    height: 100%;
    line-height: 15px;
    font-size: 12px;
    color: #fff;
    font-weight: bold;
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
}

.pill-nav a {
  display: inline-block;
  color: black;
  text-align: center;
  padding: 14px;
  text-decoration: none;
  font-size: 2em;
}

.pill-nav a:hover {
  color: black;
  border-bottom: 1px solid black;
}

.pill-nav a.active {
  color: black;
  font-weight: bold;
  border-bottom: 1px solid black;
}
</style>
<div class="Menu">
	<div class="MenuList">
		<div class="pill-nav">
		  <a class="active" href="${pageContext.request.contextPath}/ranking/ladder.do?page=1">랭킹</a>
		  <a href="${pageContext.request.contextPath}/ranking/champions.do">챔피언</a>
		</div>
	</div>
	<div class="searchBar">
		<form action="${pageContext.request.contextPath }/ranking/summonerSearch.do" method="get" style="text-align: right;">
			<input type="text" class="w3-border w3-padding" name="searchName" placeholder="소환사명" value="${equalsName }" required/>
			<button type="submit" class="w3-button w3-theme">랭킹검색</button>
		</form>
	</div>
</div>
<div style="margin-top: 10px;">현재 챌린저/그랜드마스터/마스터의 총 인원은 <fmt:formatNumber value="${totalRanker }" pattern="#,###"/>명 입니다.</div>
	<table class="w3-table-all w3-card-4">
		<tr>
			<th>순위</th>
			<th>소환사명</th>
			<th>티어</th>
			<th>리그포인트</th>
			<th>승률</th>
		</tr>
		<c:forEach items="${list }" var="s" varStatus="vs">
		<fmt:parseNumber value="${s.wins }" var="win"/>
		<fmt:parseNumber value="${s.losses }" var="loss"/>
			<tr>
				<td>${(page-1)*50+vs.count }위</td>
				<td>${s.summonerName }</td>
				<td>${s.tier }</td>
				<td><fmt:formatNumber value="${s.leaguePoints }" pattern="#,###"/>LP</td>
				<td style="text-align: center;">
					<div class="winratio">
						<div class="winratio-graph">
							<div class="winratio-graph__fill winratio-graph__fill--left" style="width: <fmt:formatNumber value="${win/(win+loss)}" type="percent"/>;"></div>
							<div class="winratio-graph__text winratio-graph__text--left">${s.wins }</div>
							<div class="winratio-graph__fill winratio-graph__fill--right"></div>
							<div class="winratio-graph__text winratio-graph__text--right">${s.losses }</div>
						</div>
						<span class="winratio__text"><fmt:formatNumber value="${win/(win+loss)}" type="percent"/></span>
					</div>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div class="pageBar">
		<div class="pagination">
			${pageBar }
		</div>
	</div>
	<script>
	$(()=>{
		$(".active, .none").click(function(){
			return false;
		});
		if(${equalsName==''}){
			$("#container").html("");
			alert("찾는 소환사가 없습니다!\n없는 소환사거나 챌린저/그랜드마스터/마스터 티어가 아닙니다.");
			history.go(-1);
		}
		else if(${equalsName!=''}){
			var equalsName = "${equalsName}";
			$("td:contains("+equalsName+")").parent().css("background-color", "#738e9c");
			var scrollPosition = $("td:contains("+equalsName+")").offset().top;
			console.log(scrollPosition);
			console.log($("html").height());
			$("html, body").animate({
				scrollTop: scrollPosition - $(window).height()/2
			}, 500);
		}
		$("tr:not(:first-child)").hover(function(e){
			$(e.target).parent("tr").css("background-color", "#D8ECEA");
		}, function(e){
			$("td:contains("+equalsName+")").parent().css("background-color", "#738e9c");
			$(e.target).parent("tr").css("background-color", "");
		});
		$("tr:not(:first-child)").on("click", function(e){
			var summonerName = $(e.target).parent("tr").children().eq(1).text();
			if(summonerName!=''){
				location.href = "${pageContext.request.contextPath}/summoner/summonerView?Name=" + summonerName;
			}
		});
	});
	</script>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>