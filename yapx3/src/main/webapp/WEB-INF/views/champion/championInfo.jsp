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
.championHeaderInfo{
	width: 800px;
	height: 400px;
	background: #292e38;
	padding: 30px;
	position: relative;
}
.championHeaderSkillInfo{
	position: absolute;
	bottom: 0px;
}
.subPerkRow img{
	width: 25px;
}
.championPosition{
	background: #2e7fdd;
	width:200px;
}
.championPosition img{
	height: 30px;
	width: 30px;
}
ul {
	margin-left: 10px;
    list-style:none;
    margin:0;
    padding:0;
}
li {
	color: white;
	width: 200px;
	text-align: center;
    border : 1px;
    float: left;
    font-size: 10px;
}
</style>
<script>
	$(()=>{
		$(".championLaneInfo ul li:gt(0)").css('margin-left','10px');
		
	});
</script>
<div class="w3-container w3-content" style="max-width:1400px;margin-top:115px; min-height: 768px;">
<div class="championHeaderInfo">
	<div class="championLaneInfo">
		<ul>
			<c:forEach items="${championLaneList }" var="lane">
				<c:choose>
					<c:when test="${lane.championLane eq '탑'}">
						<li class="championPosition" >
							<img src="//opgg-static.akamaized.net/images/site/champion/position-top-over@2x.png" alt="" />
							<span>${lane.championLane }</span>
							<span>${lane.championLaneCount }</span>
						</li>
					</c:when>
					<c:when test="${lane.championLane eq '미드'}">
						<li class="championPosition" >
							<img src="//opgg-static.akamaized.net/images/site/champion/position-mid-over@2x.png" alt="" />
							<span>${lane.championLane }</span>
							<span>${lane.championLaneCount }</span>
						</li>
					</c:when>
					<c:when test="${lane.championLane eq '바텀'}">
						<li class="championPosition" >
							<img src="//opgg-static.akamaized.net/images/site/champion/position-adc-over@2x.png" alt="" />
							<span>${lane.championLane }</span>
							<span>${lane.championLaneCount }</span>
						</li>
					</c:when>
					<c:when test="${lane.championLane eq '정글'}">
						<li class="championPosition" >
							<img src="//opgg-static.akamaized.net/images/site/champion/position-jun-over@2x.png" alt="" />
							<span>${lane.championLane }</span>
							<span>${lane.championLaneCount }</span>
						</li>
					</c:when>
				</c:choose>
			</c:forEach>
		</ul>
	</div>
	<div class="championHeaderSkillInfo">
		<div class="championHeaderImg">
			<img src="" alt="" />
			<h2>챔피언 이름</h2>
		</div>
		<div class="championHeaderSkill">
		<!-- 챔피언 스킬 -->
			<c:forEach items="" var="skill">
				<div class="championSkill">
				<!-- 스킬 이미지 -->
					<img src="" alt="" />
					<span>Q</span>
				</div>
			</c:forEach>
		</div>
	</div>
</div>
<table class="table table-bordered" style="width:800px; " >
	<tr><th >소환사 주문</th><th style="text-align: center; width:40px;">픽률</th><th style="text-align: center; width:40px;">승률</th></tr>
		<c:forEach items="${summonerSkillList }" var="spell">
			<tr>
				<td><img src="//opgg-static.akamaized.net/images/lol/spell/${spell.summonerSpell1id }.png?image=w_42&v=15354684000"/>
					<img src="//opgg-static.akamaized.net/images/lol/spell/${spell.summonerSpell2id }.png?image=w_42&v=15354684000"/></td>
				<td style="text-align:center; font-size:20px;">${spell.summonerSpellCountStr }</td>
				<td style="text-align:center; font-size:20px;">${spell.summonerSpellWinCountStr }</td>
			</tr>
		</c:forEach>
</table>
<table class="table table-bordered" style="width:800px; ">
	<tr><th>시작 아이템</th><th style="text-align: center; width:40px;">픽률</th><th style="text-align: center; width:40px;">승률</th></tr>
		<c:forEach items="${championItemListSum }" var="item">
			<tr>
				<td><img src="//opgg-static.akamaized.net/images/lol/item/${item.startItem1 }.png?image=w_42&v=1" alt="" /> 
					<img src="//opgg-static.akamaized.net/images/lol/item/${item.startItem2 }.png?image=w_42&v=1" alt="" /></td>
					<td style="text-align:center; font-size:20px;">${item.itemStartPercent }</td>
			</tr>
		</c:forEach>
</table>

	<jsp:include page="/WEB-INF/views/common/championInfoTable.jsp"/>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/> 