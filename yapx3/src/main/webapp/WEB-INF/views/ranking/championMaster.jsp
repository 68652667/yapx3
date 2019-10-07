<%@page import="com.kh.yapx3.ranking.controller.RankingController"%>
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
table{
	margin-top: 20px;
}
table th, tr, td{
	text-align: center;
}
#asdf{
	display: block;
	margin-top: 20px;
}
.championName{
	padding-top: 7px;
    color: #9b9b9b;
    line-height: 15px;
    font-size: 12px;
    text-align: center;
    overflow: hidden;
    text-overflow: ellipsis;
    white-space: nowrap;
}
.selectChampion{
	height: 601px; 
	overflow-y: scroll; 
	padding: 2px 0 0; 
	text-align: center;
	margin-top: 10px;
}
.champion{
	display: inline-block; 
	width: 50px; 
	padding: 0px;
	cursor: pointer;
	margin: 8px 4px 0;
}
.checked{
	display: none;
	position: absolute;
    padding: 14px 0 0 14px;
    text-align: left;
}
#realcontent h1{
	display: inline;
    line-height: 29px;
    font-size: 24px;
    color: #444b4b;
    font-weight: normal;
    vertical-align: middle;
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
<div>
	<div class="MenuList">
		<div class="pill-nav">
		  <a href="${pageContext.request.contextPath}/ranking/ladder.do?page=1">랭킹</a>
		  <a class="active" href="${pageContext.request.contextPath}/ranking/champions.do">챔피언</a>
		</div>
	</div>
	<div class="pageDescription">
		<span class="text">장인 랭킹의 정렬 기준은 riot제공 api기준 + 마스터 이상(10월 1일 기준) + 게임을 많이 한 순서로 제공합니다.</span>
		<br />
		<span class="text" style="font-size: 0.8em;">※닉네임을 변경한 경우 순위에서 누락될 수 있습니다!</span>
	</div>
</div>
<div id="asdf">
	<div style="width: 970px; margin: 0 auto; min-height: 500px;">
		<div style="float: left; width: 282px;">
			<div style="z-index: auto; position: static; top: auto;">
				<div class="searchChampion" style="text-align: center;">
					<input type="text" class="w3-border w3-padding searchInput" placeholder="챔피언 이름"/>
				</div>
				<div class="selectChampion">
					<c:forEach items="${champ }" var="c">
						<div id="${c.champName_kr } ${c.champName_en}" class="champion">
							<div style="position: relative;">
								<img class="checked" src="https://image.flaticon.com/icons/svg/1271/1271380.svg" width="50px" height="50px"/>
								<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/${c.champImg }" width="50px" height="50px"/>
								<div class="championName">${c.champName_kr }</div>
								<input type="hidden" id="champName_en" value="${c.champName_en }"/>
								<input type="hidden" id="champName_kr" value="${c.champName_kr }"/>
							</div>
						</div>
					</c:forEach>
				</div>
			</div>
		</div>
		<input type="hidden" id="checkedChamp"/>
		<div id="realcontent" style="float: right; width: 678px; vertical-align: top;">
		챔피언을 선택해주세요!
		</div>
	</div>
</div>
<script>
$(document).on("click", ".champion", function(e){
	$("#realcontent").oLoader({
		  backgroundColor: '#000',
		  fadeInTime: 500,
		  fadeLevel: 0.4,
		  style: "<div style='position:absolute;left:10px;bottom:10px;background:#000;color:#fff;padding:5px;border-radius:4px'>Loading...</div>"
		});
	var champName_en = $(e.target).siblings().eq(2).val();
	var champName_kr = $(e.target).siblings().eq(3).val();
	$("#checkedChamp").val(champName_kr);
	$(".checked").hide();
	var html = "<img src='http://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/"+champName_en+".png' width='30px' height='30px' style='margin-right:5px;'/>";
		html += "<h1>"+champName_kr+"</h1>"
	if($(e.target).siblings(0).css("display")=="none"){
		$(e.target).siblings(0).show();
		$.ajax({
			url: "champMaster?champName="+champName_en,
			type: "GET",
			dataType: "json",
			success: function(data){
				html += "<table class='w3-table-all w3-card-4'><tr>";
				html += "<th>순위</th>";
				html += "<th>소환사명</th>";
				html += "<th>현재 티어</th>";
				html += "<th>플레이</th></tr>";
				for(var i in data){
					html += "<tr>";
					html += "<td>"+data[i].RANK+"</td>";
					html += "<td>"+data[i].SUMMONER_NAME+"</td>";
					html += "<td>"+data[i].TIER+"</td>";
					html += "<td>"+data[i].PLAY+"</td>";
					html += "</tr>";
				}
				$("#realcontent").html(html);
				$("#realcontent").oLoader('hide')
			},
			error: function(err){
				console.log("실패");
			}
		});
	}
	else{
		$("#checkedChamp").val("");
		html = "챔피언을 선택해주세요!";
		$("#realcontent").html(html);
		$("#realcontent").oLoader('hide');
	}
});
$(".searchInput").keyup(e=>{
	var checkedChamp = $("#checkedChamp").val();
	var srchName = $(e.target).val();
	$.ajax({
		url: "champSearch?srchName="+srchName,
		type: "GET",
		dataType: "json",
		success: function(data){
			var html = "";
			for(var i in data){
				html += "<div id='"+data[i].champName_kr+" "+data[i].champName_en+"' class='champion' style='margin: 10px 8px 0;'>";
				html += "<div style='position: relative;'>";
				if(checkedChamp==data[i].champName_kr){
				html += "<img class='checked' src='https://image.flaticon.com/icons/svg/1271/1271380.svg' width='50px' height='50px' style='display: inline;'/>";
				}
				else{
				html += "<img class='checked' src='https://image.flaticon.com/icons/svg/1271/1271380.svg' width='50px' height='50px'/>";
				}
				html += "<img src='http://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/"+data[i].champImg+"' width='50px' height='50px'/>";
				html += "<div class='championName'>"+data[i].champName_kr+"</div>";
				html += "<input type='hidden' id='champName_en' value='"+data[i].champName_en+"'>";
				html += "<input type='hidden' id='champName_kr' value='"+data[i].champName_kr+"'>";
				html += "</div></div>";
			}
			$(".selectChampion").html(html);
		},
		error: function(err){
			console.log("실패");
		}
	});
});
</script>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>