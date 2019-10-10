<%@page import="com.kh.yapx3.ranking.controller.RankingController"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<!-- Page Container -->
<script src="${pageContext.request.contextPath }/resources/js/jquery.oLoader.min.js"></script>
<script src="https://unpkg.com/popper.js@1"></script>
<script src="https://unpkg.com/tippy.js@5"></script>
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
table tr:not(:first-child):hover{
	cursor: pointer;
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

.champmastertop3{
	float: left;
    position: relative;
    background-color: #ededed;
    border: solid 1px #cdd2d2;
    text-align: center;
    box-sizing: border-box;
    width: 210px;
    margin-left: 24px;
}

.champmastertop3:first-child{
	margin-left: 0;
}

.champmastertop3_rank{
	position: absolute;
    top: 0;
    padding: 3px 0;
    width: 30px;
    line-height: 24px;
    font-size: 21px;
    color: #fff;
    background: #c1c1c1;
    text-align: center;
}

.champmastertop3_footer{
	border-top: 1px solid #cdd2d2;
    margin-top: 9px;
    padding: 4px 5px 3px;
}

.picon{
    display: block;
    margin: 12px auto 0;
    width: 50px;
    height: 50px;
    border-radius: 25%;
}

.info:hover{
	cursor: pointer;
}

/* 상세정보 - 아이템빌드 */
.title{
	padding: 7px 14px 9px;
    background: #fff;
    border-bottom: 1px solid #cdd2d2;
	font-size: 12px;
    line-height: 16px;
    color: #333;
    margin-top: 20px;
    margin-bottom: 20px;
}
.myItemBuild .title{
	margin-top: 0;
}

.myItemBuild{
	padding-top: 8px;
}
.List>.Item:first-child {
    margin-left: 10px;
}
.Item{
	position: relative;
    display: inline-block;
    margin: 0 5px 23px;
}
.Items{
	display: flex;
    padding: 4px;
    background-color: #d7d7d7;
    border-radius: 3px;
    vertical-align: top;
}
.ItemTime{
	position: absolute;
    bottom: -18px;
    font-size: 10px;
    color: #777;
    left: 0;
    right: 0;
    text-align: center;
    white-space: nowrap;
}

.ItemList{
	padding-left: 10px;
}

/* 상세정보 - 스킬빌드 */

#mySkillBuildTable{
	margin: 0 auto;
}

.SKBQ td, .SKBW td, .SKBE td, .SKBR td{
	width: 35px;
	border: 1px solid white;
	text-align: center;
	
}

/* - 룬페이지 - */
.perk-wrap{
	display: flex;
	justify-content: center;
	padding: 10px;
	text-align: center;
    align-items: flex-end;
}

/* 룬 - 첫번째룬 (프라이머리) */
.perk-page{
	display: inline-block;
	
}

#perk-page_row_mark img{
	margin-top: 10px; 
	margin-bottom: 10px;
	margin-left: 70%;
}

#perk-page_row{
	margin-top: 10px; 
	margin-bottom: 10px;
}

/* 룬 - 가운데 룬 (서브) */

.perk-page2{
	display: inline-block;
	margin-left: 113px;
	margin-right: 102px;
}

/* 룬 - 맨 오른쪽 룬(스탯)  */
.fragment-page{
	display: flex;
}
.fragment-row1, .fragment-row2, .fragment-row3{
	display: flex;
}

#fragment1, #fragment2, #fragment3{
	margin-left: 10px;
	display: flex;
	
}

/* 첫번째,두번째 룬 아이콘 크기 */

#perk-page_row div img{
	width: 35px;
}

/* 오른쪽 룬 아이콘 크기 */
#fragment1 img, #fragment2 img , #fragment3 img{
	width: 25px;
}

img.spell{width:32px;}
img.chap{width:64px;}
img.item{width:20px;}
img.mini{width:20px;}
img.minispell{width:20px;}
img.miniitem{width:20px;}
ul{list-style: none;}
ol{
	list-style: none;
	padding-left: 20px;
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
		<div id="realcontent" style="float: right; width: 678px; height:650px; vertical-align: top;">
		챔피언을 선택해주세요!
		</div>
	</div>
</div>
<script>
$(document).on("click", ".info", function(e){
	var summonerName = $(e.target).parent().children().eq(2).text();
	location.href = "${pageContext.request.contextPath}/summoner/summonerView?Name=" + summonerName;
});
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
				console.log(data.length);
				html += "<div style='margin-top: 20px;'>";
				for(var x=0;x<3;x++){
					html += "<div class='champmastertop3'>";
					html += "<div class='champmastertop3_rank'>"+data[x].RANK+"</div>";
					html += "<img src='http://ddragon.leagueoflegends.com/cdn/9.19.1/img/profileicon/"+data[x].PICONID+"' class='picon info'>";
					html += "<div class='champmastertop3_summonerName info'>"+data[x].SUMMONER_NAME+"</div>";
					html += "<div class='champmastertop3_tier'>"+data[x].TIER+"</div>";
					html += "<div class='champmastertop3_play'>"+numberWithCommas(data[x].PLAY)+" 게임</div>";
					html += "<div class='champmastertop3_footer'>";
					html += "<button class='champbuild'>빌드</button>";
					html += "</div>";
					html += "</div>";
				}
				html += "</div>";
				html += "<table class='w3-table-all w3-card-4' style='margin-top: 230px;'><tr>";
				html += "<th>순위</th>";
				html += "<th>소환사명</th>";
				html += "<th>현재 티어</th>";
				html += "<th>플레이</th></tr>";
				for(var i=3;i<data.length;i++){
					html += "<tr>";
					html += "<td>"+data[i].RANK+"</td>";
					html += "<td>"+data[i].SUMMONER_NAME+"</td>";
					html += "<td>"+data[i].TIER+"</td>";
					html += "<td>"+numberWithCommas(data[i].PLAY)+"</td>";
					html += "</tr>";
				}
				html += "</table><br />";
				html += "<span class='text' style='font-size: 0.8em;'>※닉네임을 변경한 경우 순위에서 누락될 수 있습니다!</span>";
				$("#realcontent").html(html);
				$("#realcontent").oLoader('hide');
				var summonerName = "";
				var url = "";
				$(".champbuild").on("click", function(e){
					summonerName = $(e.target).parent().siblings().eq(2).text();
					console.log(summonerName);
					url = "${pageContext.request.contextPath}/summoner/searchView?summonerName="+summonerName;
				});
				tippy(".champbuild", {
					content: 'Loading...',
					trigger: 'click',
					maxWidth: '692px',
					flipOnUpdate: true,
					onCreate(instance){
						instance.ajaxState = {
							isFetching: false,
							canFetch: true,
						};
					},
					onShow(instance){
						if($(".w3-content").css("min-height") == "768px"){
							$(".w3-content").css("min-height", "975px");
						}
						fetch(url)
						.then((res)=>{
							if(res.status === 200 || res.status === 201){
								res.json().then(function(data){
									var html = "";
									var me;
									for(var i in data){
										<% for(int i=1; i<11; i++) {%>
										if(data[i].participants<%=i%>.summonerName == summonerName && data[i].participants<%=i%>.win == 'true' && data[i].participants<%=i%>.championId == champName_en){
											me = data[i].participants<%=i%>;
											break;
										}
										<%} %>
									}
									console.log(me);
									//해당 장인의 해당 챔피언 마지막 승리 빌드
									if(me!==undefined){
										var itemPur = new Array();
							 			var itemDes = new Array();
							 			var itemPurTime = new Array();
										//아이템빌드
										for(var z=0; z<me.myItemBuild.length; z++ ){
							 				if(me.myItemBuild[z].type == "ITEM_PURCHASED"){
							 					itemPur.push(me.myItemBuild[z].itemId);
						 						itemPurTime.push(((me.myItemBuild[z].timeStamp)/60000).toFixed(1));
							 				}
							 				else if(me.myItemBuild[z].type == "ITEM_SOLD"){
							 					itemDes.push(me.myItemBuild[z].itemId);
							 				}
							 			}
										
										//내 아이템빌드 - 3개씩 쪼개서 배열만들기
							 			var itemLen = itemPur.length;
							 			var itemCnt = Math.floor(itemLen/3)+(Math.floor(itemLen%3)>0?1:0);
							 			var itemRe =[];
							 			var timeLen = itemPur.length;
							 			var timeCnt = Math.floor(timeLen/3)+(Math.floor(timeLen%3)>0?1:0);
							 			var timeRe =[];
							 			for(var ib =0; ib<itemCnt; ib++){
							 				itemRe.push(itemPur.splice(0,3));
							 			}
							 			for(var ic =0; ic<itemCnt; ic++){
							 				timeRe.push(itemPurTime.splice(0,3));
							 			}
							 			//내 스킬빌드 - skillSlot만 나눠서 배열에 담아주기 
							 			var mySkillSlot = new Array();
							 			
							 			for(var skb = 0; skb<me.mySkillBuild.length; skb++){
							 				mySkillSlot.push(me.mySkillBuild[skb].skillSlot);
							 			}
							 			var skbqCnt = 0;
							 			var skbwCnt = 0;
							 			var skbeCnt = 0;
							 			var skbrCnt = 0;
							 			//내 아이템, 스킬, 룬 빌드 
										html += "<div class='myBuild'>"
										
										//내 아이템빌드 
										html += "<div class='myItemBuild' style='display: inline;'>";
							 			html += "<div class='title'>아이템 빌드</div>";
										html +="<ul class='ItemList' style=''>";
										var times;
							 			//내 아이템빌드 - 이미지삽입
							 			for(var zz1 = 0; zz1<itemRe.length; zz1++){
							 				
							 					 html +="<li class='Item'>";
							 					 html +="<div class='ItemBar' style=''></div>";
							 					 html +="<ol class='Items'>";
							 				for(var yy1 = 0; yy1<itemRe[zz1].length; yy1++){
							 					 html +="<li><img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+itemRe[zz1][yy1]+".png'/></li>";
							 					
							 						
							 				}
							 				html +="</ol>";
							 				
							 				for(var yy1 = 0; yy1<itemRe[zz1].length; yy1++){
							 				if(yy1%3==0){
							 						 times = (Number(timeRe[zz1][yy1]).toFixed(0));
						 						html +="<div class='ItemTime' style='position: absolute;'>"+times+"분</div>";
						 					}
							 				}
											
							 			}
										
										
										html += "</div>"; //myItemBuild
										
										//mySkillBuild
										html +="<div class='mySkillBuild'>";
										html += "<div class='title'>스킬 빌드</div>";
										html +="<table id='mySkillBuildTable'>";
										html +="<tbody id='SKBContainer'>";
										html +="<tr class=SKBQ>";
										html +="<td>Q</td>";
										//스킬슬롯의 길이만큼 tr밑에 td만들어주기
										//스킬슬롯 [skbr]번째 값이 1이면 q 2면 w 3이면 e 4이면 r에 1씩 늘어나는 숫자로 담아주기, 5번째(마스터)마다색깔변경
										for(var skbT = 0; skbT<mySkillSlot.length; skbT++){
											
										if(mySkillSlot[skbT]==1){
						 					
						 					++skbqCnt;
						 					if(skbqCnt != 5){
						 					html += "<td style='background-color:skyblue;'>"+(skbT+1)+"</td>";
						 						
						 					}
						 					else{
					 						html += "<td style='background-color:#249069;'>"+(skbT+1)+"</td>";
						 					}
						 					
						 				}
										else{
										html += "<td style='background-color:gray;'></td>";
											
										}
											
										}
										html +="</tr>"; 
										html +="<tr class=SKBW>";
										html +="<td>W</td>";
										for(var skbT = 0; skbT<mySkillSlot.length; skbT++){
											if(mySkillSlot[skbT]==2){
							 					++skbwCnt;
												
							 						if(skbwCnt != 5){
								 					html += "<td style='background-color:skyblue;'>"+(skbT+1)+"</td>";
								 						
								 					}
								 					else{
							 						html += "<td style='background-color:#249069;'>"+(skbT+1)+"</td>";
								 					}
							 					
							 				}
											else{
											html += "<td style='background-color:gray;'></td>";
												
											}
												
										}
										html +="</tr>";
										
										html +="<tr class=SKBE>";
										html +="<td>E</td>";
										for(var skbT = 0; skbT<mySkillSlot.length; skbT++){
											if(mySkillSlot[skbT]==3){
							 					++skbeCnt;
												
							 						if(skbeCnt != 5){
								 					html += "<td style='background-color:skyblue;'>"+(skbT+1)+"</td>";
								 						
								 					}
								 					else{
							 						html += "<td style='background-color:#249069;'>"+(skbT+1)+"</td>";
								 					}
							 				
							 					
							 				}
											else{
												
											html += "<td style='background-color:gray;'></td>";
											}
												
										}
										
										html +="</tr>";
										html +="<tr class=SKBR>";
										html +="<td>R</td>";
										for(var skbT = 0; skbT<mySkillSlot.length; skbT++){
											
											if(mySkillSlot[skbT]==4){
							 					++skbrCnt;
												
							 						if(skbqCnt != 3){
								 					html += "<td style='background-color:skyblue;'>"+(skbT+1)+"</td>";
								 						
								 					}
								 					else{
							 						html += "<td style='background-color:#249069;'>"+(skbT+1)+"</td>";
								 					}
							 					
							 					
							 				}
											else{
											html += "<td style='background-color:gray;'></td>";
												
											}
												
										}
							 			html+="</tr>";
							 			html+="</tbody>";
							 			html+="</table>";
										html += "</div>"; //mySkillBuild
										
										
				//myRuneBuild
										html += "<div class='myRuneBuild'>";
										html += "<div class='title'>룬 빌드</div>";
										html += "<div class='perk-wrap'>";
										html +="<div class='perk-page'>";
										
										
										//룬페이지 - 왼쪽 룬
							 			
							 			var PrimaryNum1 = 0;
							 			var PrimaryNum2 = 0;
							 			var PrimaryNum3 = 0;
							 			var PrimaryNum4 = 0;
							 				
							 			//정밀 - 8000
							 			if(me.perkPrimaryStyle == 8000){
							 				
							 				html += "<div id='perk-page_row_mark' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8000.png'></div></div>";
							 				//1줄
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8005.png";
							 				if(me.perk0 == 8005){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8008.png";
							 				if(me.perk0 == 8008){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8021.png";
							 				if(me.perk0 == 8021){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8010.png";
							 				if(me.perk0 == 8010){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				html += "</div>";
							 				
							 				//2줄
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9101.png";
							 				if(me.perk1 == 9101){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9111.png";
							 				if(me.perk1 == 9111){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8009.png";
							 				if(me.perk1 == 8009){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//3줄
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9104.png";
							 				if(me.perk2 == 9104){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9105.png";
							 				if(me.perk2 == 9105){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9103.png";
							 				if(me.perk2 == 9103){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//4줄
							 				
							 				PrimaryNum1 = 8014; 
							 				PrimaryNum2 = 8017; 
							 				PrimaryNum3 = 8299;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk3 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk3 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				if(me.perk3 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				
							 			}
							 			//지배 - 8100
							 			if(me.perkPrimaryStyle == 8100){
							 				
							 				html += "<div id='perk-page_row_mark' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8100.png'></div></div>";
							 				//1줄
							 				
							 				PrimaryNum1 = 8112; 
							 				PrimaryNum2 = 8124;
							 				PrimaryNum3 = 8128;
							 				PrimaryNum4 = 9923;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk0 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk0 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk0 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum4+".png";
							 				if(me.perk0 == PrimaryNum4){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				html += "</div>";
							 				
							 				//2줄
							 				PrimaryNum1 = 8126; 
							 				PrimaryNum2 = 8139;
							 				PrimaryNum3 = 8143;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk1 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk1 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk1 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//3줄
							 				
							 				PrimaryNum1 = 8136; 
							 				PrimaryNum2 = 8120;
							 				PrimaryNum3 = 8138;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk2 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk2 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk2 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//4줄
							 				
							 				PrimaryNum1 = 8135; 
							 				PrimaryNum2 = 8124;
							 				PrimaryNum3 = 8105;
							 				PrimaryNum4 = 8106;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk3 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk3 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk3 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum4+".png";
							 				
							 				if(me.perk3 == PrimaryNum4){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				
							 			}
							 			//마법 - 8200
							 			if(me.perkPrimaryStyle == 8200){
							 				
							 				html += "<div id='perk-page_row_mark' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8200.png'></div></div>";
							 				// 1줄
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8214.png";
							 				if(me.perk0 == 8214){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8229.png";
							 				if(me.perk0 == 8229){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8230.png";
							 				if(me.perk0 == 8230){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				html += "</div>";
							 				//2줄
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8224.png";
							 				if(me.perk1 == 8224){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8226.png";
							 				if(me.perk1 == 8226){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8275.png";
							 				if(me.perk1 == 8275){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				html += "</div>";
							 				
							 				//3줄
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8210.png";
							 				if(me.perk2 == 8210){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8234.png";
							 				if(me.perk2 == 8234){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8233.png";
							 				if(me.perk2 == 8233){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				html += "</div>";
							 				
							 				
							 				//4줄
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8237.png";
							 				if(me.perk3 == 8237){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8232.png";
							 				if(me.perk3 == 8232){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8236.png";
							 				if(me.perk3 == 8236){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				html += "</div>";
							 				
							 				
							 				
							 				
							 			}
							 			
							 			//8300 영감
							 			if(me.perkPrimaryStyle == 8300){
							 				
							 				html += "<div id='perk-page_row_mark' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8300.png'></div></div>";
							 				//1줄
							 				
							 				PrimaryNum1 = 8351; 
							 				PrimaryNum2 = 8359;
							 				PrimaryNum3 = 8360;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk0 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk0 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk0 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//2줄
							 				PrimaryNum1 = 8306; 
							 				PrimaryNum2 = 8304;
							 				PrimaryNum3 = 8313;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk1 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk1 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk1 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//3줄
							 				
							 				PrimaryNum1 = 8321; 
							 				PrimaryNum2 = 8316;
							 				PrimaryNum3 = 8345;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk2 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk2 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk2 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//4줄
							 				
							 				PrimaryNum1 = 8347; 
							 				PrimaryNum2 = 8410;
							 				PrimaryNum3 = 8352;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk3 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk3 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk3 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 			}
							 			// 8400 결의
							 			if(me.perkPrimaryStyle == 8400){
							 				
							 				html += "<div id='perk-page_row_mark' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8400.png'></div></div>";
							 				//1줄
							 				
							 				PrimaryNum1 = 8437; 
							 				PrimaryNum2 = 8439;
							 				PrimaryNum3 = 8465;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk0 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk0 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk0 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//2줄
							 				PrimaryNum1 = 8446; 
							 				PrimaryNum2 = 8463;
							 				PrimaryNum3 = 8401;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk1 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk1 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk1 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//3줄
							 				
							 				PrimaryNum1 = 8429; 
							 				PrimaryNum2 = 8444;
							 				PrimaryNum3 = 8473;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk2 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk2 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk2 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				
							 				//4줄
							 				
							 				PrimaryNum1 = 8451; 
							 				PrimaryNum2 = 8453;
							 				PrimaryNum3 = 8242;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk3 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk3 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk3 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 			}
							 			
							 			html+= "</div>";
				//룬페이지 - 왼쪽 룬 끝 //
							 			
										html +="<div class='page-divider'></div>";
										html +="<div class='perk-page2'>";
										
				//룬페이지 - 가운데 룬(서브)
							 			
							 			var SubNum1 = 0;
							 			var SubNum2 = 0;
							 			var SubNum3 = 0;
							 			var SubNum4 = 0;
							 			
							 			var SubSelect4;
							 			var SubSelect5;
							 			
							 			//정밀 - 8000
							 			if(me.perkSubStyle == 8000){
							 				
//				 			 				var Line8000_1 = [9101,9111,8009];
//				 			 				var Line8000_2 = [9104,9105,9103];
//				 			 				var Line8000_3 = [8014,8017,8299];
							 				
							 				html += "<div id='perk-page_row_mark' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8000.png'></div></div>";
							 				
							 				//2줄
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9101.png";
							 				if(me.perk4 == 9101|| me.perk5 == 9101){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9111.png";
							 				if(me.perk4 == 9111|| me.perk5 == 9111){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8009.png";
							 				if(me.perk4 == 8009|| me.perk5 == 8009){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				html += "</div>";
							 				
							 				
							 				//3줄
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9104.png";
							 				if(me.perk4 == 9104|| me.perk5 == 9104){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9105.png";
							 				if(me.perk4 == 9105|| me.perk5 == 9105){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9103.png";
							 				if(me.perk4 == 9103|| me.perk5 == 9103){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//4줄
							 				
							 				PrimaryNum1 = 8014; 
							 				PrimaryNum2 = 8017; 
							 				PrimaryNum3 = 8299;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk4 == PrimaryNum1|| me.perk5 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk4 == PrimaryNum2|| me.perk5 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				if(me.perk4 == PrimaryNum3|| me.perk5 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				
							 			}
							 			//지배 - 8100
							 			if(me.perkSubStyle == 8100){
							 				
							 				html += "<div id='perk-page_row_mark' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8000.png'></div></div>";
							 				
							 				
							 				//2줄
							 				PrimaryNum1 = 8126; 
							 				PrimaryNum2 = 8139;
							 				PrimaryNum3 = 8143;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk4 == PrimaryNum1|| me.perk5 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk4 == PrimaryNum2|| me.perk5 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk4 == PrimaryNum3|| me.perk5 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//3줄
							 				
							 				PrimaryNum1 = 8136; 
							 				PrimaryNum2 = 8120;
							 				PrimaryNum3 = 8138;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk4 == PrimaryNum1|| me.perk5 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk4 == PrimaryNum2|| me.perk5 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk4 == PrimaryNum3|| me.perk5 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//4줄
							 				
							 				PrimaryNum1 = 8135; 
							 				PrimaryNum2 = 8124;
							 				PrimaryNum3 = 8105;
							 				PrimaryNum4 = 8106;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk4 == PrimaryNum1|| me.perk5 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk4 == PrimaryNum2|| me.perk5 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk4 == PrimaryNum3|| me.perk5 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum4+".png";
							 				
							 				if(me.perk4 == PrimaryNum4|| me.perk5 == PrimaryNum4){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				
							 			}
							 			//마법 - 8200
							 			if(me.perkSubStyle == 8200){
							 				
							 				html += "<div id='perk-page_row_mark' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8200.png'></div></div>";
							 				
							 				//2줄
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8224.png";
							 				if(me.perk4 == 8224|| me.perk5 == 8224){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8226.png";
							 				if(me.perk4 == 8226|| me.perk5 == 8226){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8275.png";
							 				if(me.perk4 == 8275|| me.perk5 == 8275){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				html += "</div>";
							 				
							 				//3줄
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8210.png";
							 				if(me.perk4 == 8210|| me.perk5 == 8210){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8234.png";
							 				if(me.perk4 == 8234|| me.perk5 == 8234){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8233.png";
							 				if(me.perk4 == 8233|| me.perk5 == 8233){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				html += "</div>";
							 				
							 				
							 				//4줄
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8237.png";
							 				if(me.perk4 == 8237|| me.perk5 == 8237){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8232.png";
							 				if(me.perk4 == 8232|| me.perk5 == 8232){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/8236.png";
							 				if(me.perk4 == 8236|| me.perk5 == 8236){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				html += "</div>";
							 				
							 				
							 				
							 				
							 			}
							 			
							 			//8300 영감
							 			if(me.perkSubStyle == 8300){
							 				
							 				html += "<div id='perk-page_row_mark' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8300.png'></div></div>";
							 				
							 				//2줄
							 				PrimaryNum1 = 8306; 
							 				PrimaryNum2 = 8304;
							 				PrimaryNum3 = 8313;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk4 == PrimaryNum1|| me.perk5 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk4 == PrimaryNum2|| me.perk5 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk4 == PrimaryNum3|| me.perk5 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//3줄
							 				
							 				PrimaryNum1 = 8321; 
							 				PrimaryNum2 = 8316;
							 				PrimaryNum3 = 8345;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk4 == PrimaryNum1|| me.perk5 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk4 == PrimaryNum2|| me.perk5 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk4 == PrimaryNum3|| me.perk5 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//4줄
							 				
							 				PrimaryNum1 = 8347; 
							 				PrimaryNum2 = 8410;
							 				PrimaryNum3 = 8352;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk4 == PrimaryNum1|| me.perk5 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk4 == PrimaryNum2|| me.perk5 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk4 == PrimaryNum3|| me.perk5 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 			}
							 			// 8400 결의
							 			if(me.perkSubStyle == 8400){
							 				
							 				html += "<div id='perk-page_row_mark' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8400.png'></div></div>";
							 				
							 				//2줄
							 				PrimaryNum1 = 8446; 
							 				PrimaryNum2 = 8463;
							 				PrimaryNum3 = 8401;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk4 == PrimaryNum1|| me.perk5 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk4 == PrimaryNum2|| me.perk5 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk4 == PrimaryNum3|| me.perk5 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//3줄
							 				
							 				PrimaryNum1 = 8429; 
							 				PrimaryNum2 = 8444;
							 				PrimaryNum3 = 8473;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk4 == PrimaryNum1|| me.perk5 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk4 == PrimaryNum2|| me.perk5 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk4 == PrimaryNum3|| me.perk5 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 				//4줄
							 				
							 				PrimaryNum1 = 8451; 
							 				PrimaryNum2 = 8453;
							 				PrimaryNum3 = 8242;
							 				
							 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum1+".png";
							 				if(me.perk4 == PrimaryNum1|| me.perk5 == PrimaryNum1){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum2+".png";
							 				if(me.perk4 == PrimaryNum2|| me.perk5 == PrimaryNum2){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/"+PrimaryNum3+".png";
							 				
							 				if(me.perk4 == PrimaryNum3|| me.perk5 == PrimaryNum3){
							 					html +=	"'></div>";
							 				}
							 				else{
							 					html += "?image=e_grayscale&v=1'></div>";
							 				}
							 				
							 				html += "</div>";
							 				
							 			}
							 			
							 			html +="</div>";
				//룬페이지 - 가운데 룬(서브) 끝//
										
										
				//룬페이지 - 오른쪽 룬
							 			var htmlR1_1 = "<img src='//opgg-static.akamaized.net/images/lol/perkShard/5008.png";
							 			var htmlR1_2 = "<img src='//opgg-static.akamaized.net/images/lol/perkShard/5005.png";
							 			var htmlR1_3 = "<img src='//opgg-static.akamaized.net/images/lol/perkShard/5007.png";
							 			
							 			var htmlR2_1 = "<img src='//opgg-static.akamaized.net/images/lol/perkShard/5008.png";
							 			var htmlR2_2 = "<img src='//opgg-static.akamaized.net/images/lol/perkShard/5002.png";
							 			var htmlR2_3 = "<img src='//opgg-static.akamaized.net/images/lol/perkShard/5003.png";
							 			
							 			var htmlR3_1 = "<img src='//opgg-static.akamaized.net/images/lol/perkShard/5001.png";
							 			var htmlR3_2 = "<img src='//opgg-static.akamaized.net/images/lol/perkShard/5002.png";
							 			var htmlR3_3 = "<img src='//opgg-static.akamaized.net/images/lol/perkShard/5003.png";
										
							 			html +="<div class='page-divider'></div>";
										html +="<div class='fragment-page'>";
										
										html +="<div class='fragment-detail'>";
										
										html +="<div class='fragment-row1'>";
							 			html +="<div id='fragment1'><img src='//opgg-static.akamaized.net/images/lol/perkShard/5008.png"+(me.statPerk0 == 5008?"'>":"?image=e_grayscale&v=1'>")+"</div>";
							 			html +="<div id='fragment2'><img src='//opgg-static.akamaized.net/images/lol/perkShard/5005.png"+(me.statPerk0 == 5005?"'>":"?image=e_grayscale&v=1'>")+"</div>";
							 			html +="<div id='fragment3'><img src='//opgg-static.akamaized.net/images/lol/perkShard/5007.png"+(me.statPerk0 == 5007?"'>":"?image=e_grayscale&v=1'>")+"</div>";
							 			html +="</div>";
										
										html +="<div class='fragment-row2'>";
							 			html +="<div id='fragment1'><img src='//opgg-static.akamaized.net/images/lol/perkShard/5008.png"+(me.statPerk1 == 5008?"'>":"?image=e_grayscale&v=1'>")+"</div>";
							 			html +="<div id='fragment2'><img src='//opgg-static.akamaized.net/images/lol/perkShard/5002.png"+(me.statPerk1 == 5002?"'>":"?image=e_grayscale&v=1'>")+"</div>";
							 			html +="<div id='fragment3'><img src='//opgg-static.akamaized.net/images/lol/perkShard/5003.png"+(me.statPerk1 == 5003?"'>":"?image=e_grayscale&v=1'>")+"</div>";
							 			html +="</div>";
						
							 			html +="<div class='fragment-row3'>";
							 			html +="<div id='fragment1'><img src='//opgg-static.akamaized.net/images/lol/perkShard/5001.png"+(me.statPerk2 == 5001?"'>":"?image=e_grayscale&v=1'>")+"</div>";
							 			html +="<div id='fragment2'><img src='//opgg-static.akamaized.net/images/lol/perkShard/5002.png"+(me.statPerk2 == 5002?"'>":"?image=e_grayscale&v=1'>")+"</div>";
							 			html +="<div id='fragment3'><img src='//opgg-static.akamaized.net/images/lol/perkShard/5003.png"+(me.statPerk2 == 5003?"'>":"?image=e_grayscale&v=1'>")+"</div>";
							 			html +="</div>";
							 			
							 			html +="</div>";
							 			html +="</div>";
						 				
				//오른쪽 룬 끝	
										
										
										html +="</div>"; //perk-wrap
										html += "</div>";//myRunBuild
										
										html += "</div>"; //myBuild	
									}
									//해당 장인이 해당 챔피언을 최근 20게임동안 한 판도 플레이 하지 않았을 경우
									else{
										html = "<strong><span style='color: red;'>최근 20게임동안 "+champName_kr+"을(를) 플레이한적이 없습니다!</span></strong>";
									}
									instance.setContent(html);
								});
							} else{
								console.log(res.statusText);
							}
						}).catch(err=>alert("잠시후 다시 시도해주세요!"));
					},
					onHidden(instance){
						$(".w3-content").css("min-height", "748px");
						instance.ajaxState.canFetch = true;
					},
				});
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
			for(var j in data){
				html += "<div id='"+data[j].champName_kr+" "+data[j].champName_en+"' class='champion' style='margin: 10px 8px 0;'>";
				html += "<div style='position: relative;'>";
				if(checkedChamp==data[j].champName_kr){
				html += "<img class='checked' src='https://image.flaticon.com/icons/svg/1271/1271380.svg' width='50px' height='50px' style='display: inline;'/>";
				}
				else{
				html += "<img class='checked' src='https://image.flaticon.com/icons/svg/1271/1271380.svg' width='50px' height='50px'/>";
				}
				html += "<img src='http://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/"+data[j].champImg+"' width='50px' height='50px'/>";
				html += "<div class='championName'>"+data[j].champName_kr+"</div>";
				html += "<input type='hidden' id='champName_en' value='"+data[j].champName_en+"'>";
				html += "<input type='hidden' id='champName_kr' value='"+data[j].champName_kr+"'>";
				html += "</div></div>";
			}
			$(".selectChampion").html(html);
		},
		error: function(err){
			console.log("실패");
		}
	});
});
$(document).on({
    mouseenter: function (e) {
        $(this).css("background-color", "rgba(0,123,255,.25)");
    },
    mouseleave: function (e) {
        $(this).css("background-color", "");
    }
}, 'tr:not(:first-child)');
$(document).on("click", "tr:not(:first-child)", function(e){
	var summonerName = $(e.target).parent("tr").children().eq(1).text();
	if(summonerName!=''){
		location.href = "${pageContext.request.contextPath}/summoner/summonerView?Name=" + summonerName;
	}
});
function numberWithCommas(x) {
    return x.toString().replace(/\B(?=(\d{3})+(?!\d))/g, ",");
}
</script>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>