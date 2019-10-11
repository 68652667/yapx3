<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page import="java.net.URL"%>
<%@page import="java.net.HttpURLConnection"%>
<%@page import="com.kh.yapx3.search.model.vo.*"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>

<%

	String summonerName = (String)request.getAttribute("summonerName");
	String summonerId = (String)request.getAttribute("summonerId");
	
	
%>


<script src="https://cdn.jsdelivr.net/npm/chart.js@2.8.0"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath }/resources/js/jquery.oLoader.min.js"></script>

<style>

	a{
	cursor: pointer;
	}

	ul{
	list-style: none;
	}
	ol{
	list-style: none;
	}
	
	/* 	승률테이블 */
	
	#winloseResult{
	 display:inline; 
	 border: hidden; 
	 margin-left: 50px;
	 
	
	}
	
	#winloseResult td{
	padding: 20px;	 
	
	}
	#WinloseText{
	margin: 20px;
	font-size: 18px;
	}
	
	
/* 	소환사 메인컨테이너 */

	.summonerContainer{
	margin-left: 66px;
	}
	
	.GameContainerWin td, .GameContainerFail td{
		border: none;
	}
	.GameContainerWin{
		background-color: #a3cfec; border-color: #99b9cf;
		margin-bottom: 20px;
		width: 917px;
/* 		float: left; */
	}
	.GameContainerFail{
		background-color: #e2b6b3; border-color: #cea7a7;
		margin-bottom: 20px;
		width: 917px;
/* 		float: left; */
	}
	.myTeamTable{
		border: none;
	    cursor: pointer;
	}
	
	
	
/* 	더보기 페이지 패배시, 승리시 */
	
	
  	.GameDetailContainer{ 
  	display: none; 
  	}  
	
	.GameDetailResult_true{
	background-color: #a3cfec; border-color: #99b9cf;
	margin-bottom: 20px;
	width: 917px;
	}
	.GameDetailResult_false{
	background-color: #e2b6b3; border-color: #cea7a7;
	margin-bottom: 20px;
	width: 917px;
	}
	
	.GameDetailResult_true table tbody th{
		padding: 15px;
		text-align: center;
	}
	
	.GameDetailResult_false table tbody th{
		padding: 15px;
		text-align: center;
	}
	
	.GameDetailResult_true table tbody tr td{
		padding: 11px;
	}
	
	.GameDetailResult_false table tbody tr td{
		padding: 11px;
	}
	
	.more_total{
	
	background: #007bc3;
    border-color: #007bc3;
    color: #fff;
	min-width: 45px;
    height: 25px;
    line-height: 22px;
    padding: 0 9px;
    font-size: 13px;
    font-weight: 300;
	margin-bottom: 15px;
	
	}

	.more_build{
	
	background: #007bc3;
    border-color: #007bc3;
    color: #fff;
	min-width: 45px;
    height: 25px;
    line-height: 22px;
    padding: 0 9px;
    font-size: 13px;
    font-weight: 300;
    margin-left: 26px;
	
	}
	
    
	
/* 	빌드페이지 - 숨겨주기 */
	.myBuild{
		display: none;
	}
	
/* 	소환사 프로필(사진, 아이디, 랭킹) */
	
	#summonerProfile {
    border: 3px solid #4d636f;
    width: 955px;
    height: 247px;
    margin: 36px;
    position: static;
	}
	
	.SummonerLevel{
	
    position: absolute;
    top: 39%;
    left: 16%;
/*     margin-top: -14px; */
/*     margin-left: -22px; */
    width: 44px;
    height: 24px;
    padding-top: 3px;
    box-sizing: border-box;
    background: url(${pageContext.request.contextPath}/resources/images/Level.jpg); 
    background-size: 100%;
    line-height: 17px;
    font-family: Helvetica,AppleSDGothic,"Apple SD Gothic Neo",AppleGothic,Arial,Tahoma;
    font-size: 14px;
    text-align: center;
    color: #eabd56;
	
	}

	
	#profileIcon {
		padding: 35px;
		position: absolute;
		left: 87px;
		top: 162px;
		width: 200px;
		height: 200px;
		background-position: center bottom;
		background-repeat: no-repeat;
	}
	
	
	#name{
	position: absolute;
	left: 326px;
	top: 208px;
	font-size: 35px;
	font-weight: bold;
	margin-left: 5px;
	vertical-align: middle;
	}
	
	#favorite{
	position: absolute;
	left: 567px;
	top: 215px;
	
	}
	
	#SummonerViewBtn{
	    margin-left: 30%;
	    border: 1px solid gray;
	}
	
	#InGameBtn{
		margin-left: 150px;
		border: 1px solid gray;
	}

/* 소환사 상세정보 페이지	 */
.Container{
overflow: hidden;

}

/* 	상세정보 컨테이너 - 사이드*/


.TierBox{
    display: table;
    position: relative;
    padding: 8px 0;
	margin-left: 55px;
	left: 527px;
    top: 36px;
}

#TierBoxImg{
	float: left;
}

#TierBoxImg img{
	width: 104px;
    height: 104px;
    margin: -5px 27px -10px 0;

}

#TierInfo{
	float: right;
    display: table-cell;
    vertical-align: middle;
    font-size: 12px;
    line-height: 1.5;
    text-align: left;

}

#RankType{
	font-size: 11px;
    color: #879292;
}

#TierRank{
	font-size: 15px;
    font-weight: bold;
    color: #1f8ecd;
}

#TierView{


}

#Death{
	color: red;
}
.GameList{
    text-align: center;
	font-size: 17px;
}
#Top3{
	font-size: 17px;
}



/* 상세정보 - 아이템빌드 */

.more{
	
	
display: inline-block;
    padding: 8px 16px;
    vertical-align: middle;
    overflow: hidden;
    text-decoration: none;
    color: inherit;
    background-color: inherit;
    text-align: center;
    cursor: pointer;
    white-space: nowrap;

border: 1px solid gray;

}

.title{

	padding: 7px 14px 9px;
    background: #fff;
    border-bottom: 1px solid #cdd2d2;
	font-size: 12px;
    line-height: 16px;
    color: #333;
    margin-top: 40px;
    margin-bottom: 40px;
    width: 917px;
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
    margin: 0 0 23px;
}
.Items{
display: flex;
}
.ItemTime{
margin-left: 46px;
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
/* 페이지바 */
#pagedivider{
width: 1px;
height: 200px;
/* background-color: #ddd; */
background-color: black;
margin: 0 8px;
}

/* 인게임정보  */

.InGameContainer{
	display: none;
}

.SpectatorSummoner{
	margin-left: 20px;
	margin-top: 25px;
}


.team-100{

	width: 100%;
	
								

}

.SpectatorBar{
	margin-top: 25px;
}

.team-200{

	width: 100%;
	margin-bottom: 20px;

}

.InGameCham{
    width: 40px;
    height: 40px;
}
.InGameSpell{
	width: 25px;
    height: 25px;
}

.SpectatorCell_BlueTeamName{
	padding-left: 15px;
    text-align: left;
    font-size: 12px;
    font-weight: bold;
    color: Blue;
     padding: 9px 0 8px 0;
    border-bottom: 1px solid #cdd2d2;
    background-color: #ededed;
}

.SpectatorCell_RedTeamName{
	padding-left: 15px;
    text-align: left;
    font-size: 12px;
    font-weight: bold;
    color: Red;
    padding: 9px 0 8px 0;
    border-bottom: 1px solid #cdd2d2;
    background-color: #ededed;
}

 .team-100 .SpectatorCell{ 
 	padding: 9px 0 8px 0; 
    border-bottom: 1px solid #cdd2d2; 
   background-color: #ededed;
 } 

 .team-200 .SpectatorCell{ 
 	padding: 9px 0 8px 0; 
    border-bottom: 1px solid #cdd2d2; 
   	background-color: #ededed;
 } 


	
</style>
<style>
	img.spell{width:32px;}
	img.chap{width:64px;}
	img.item{width:20px;}
	img.mini{width:20px;}
	img.minispell{width:20px;}
	img.miniitem{width:20px;}
	img.moreCham{width:35px;}
	/* tr.more{display:none;} */
	#summonerRank img {width:35px; height: 30px;}
	
/* 	#summonerStatus img{width: } */
</style>

<br />
<br />
<br />
<br />
<br />
	
<input type="hidden" name="summonerName" id="summonerName" value="<%=summonerName%>"/>
<input type="hidden" name="summonerId" id="summonerId" value="<%=summonerId%>"/>

	<!-- 프로필 사진 소환사 아이디, 레벨 -->
	<div id="summonerProfile">
		<div id="face">
			<div id="icon"> <!-- 아이콘아미지 -->
				<span class="SummonerLevel"></span> <!-- 레벨 text -->
			</div>
		</div>
		<div id="profile">
			<div id="information">
			<span id="name"></span>
			</div>
		</div>
		<div id="ranking">
			<h3 id="rankingText"></h3>
		</div>
		
		<div class="TierBox">
			<div id="TierBoxView">
				<div id="TierBoxImg">
				
				</div>	
				<div id="TierInfo">
					<div id="TierType">
					
					</div>
					<div id="TierRank">
					
					</div>
					<div id="TierView">
						
						<span id="LeaguePoints">
						</span>
						<span id="WinLose">
							<span id="wins"></span>
							<span id="losses"></span>
							<br />
							<span id="winratio"></span>
						</span>
						
					</div>
				</div>
			</div>
		</div>
		
		
	</div>
	
	<button class="w3-button" id="SummonerViewBtn">소환사정보</button>
	<button class="w3-button" id="InGameBtn" data-toggle="InGameBtnTooltip">인게임정보</button>
	<hr class="Separator"/>
	
	<div class="Container">
	<!-- 티어 이미지, 티어 표시 -->
		

<!-- 게임종류, 승패여부, 사용한 챔피언,아이템,팀원 -->	
<div class="MainContainer">

<div id="WinRatio" style="border: hidden; margin-left: 10%;">
	<table id="winloseResult">
		<tr>
			<td style="border: hidden; margin: 10px; font-size: 15px;">
				<div id="WinloseText">
					<span></span>전				
					<span></span>승			
					<span></span>패				
				</div>
			</td>
		</tr>
		<tr>
			<td>
			<div>
			<canvas id="myChart" width="150" height="150"></canvas>
			</div>
			</td>
			<td>
				<div class="GameList" >
			<div id="KDA">
				<span id="Kill"></span> /
				<span id="Death"></span> /
				<span id="Assist"></span>
			</div>
			<div id="KDARatio"  style="margin: 15px;">
				<span id="KDARatioText"></span>평점
			</div>
			<div id="Status">
				<div id="Status_Level"></div>
				<div id="Status_CS"><span></span></div>
				<div id="Status_Kill"></div>
				<div id="Status_MMR"><span></span><br /><b></b></div>
			</div>
</div>	
			</td>
			
			<td style="border: hidden;">
			<ul id="top3">
				<li>
					<div id="top3Container">
						<div id="top3Image"></div>
						<div id="top3Champion"></div>
						<div id="top3WonLose">
						</div>
					</div>
				</li>
				<li>
					<div id="top3Container">
						<div id="top3Image"></div>
						<div id="top3Champion"></div>
						<div id="top3WonLose">
						</div>
					</div>
				</li>
				<li>
					<div id="top3Container">
						<div id="top3Image"></div>
						<div id="top3Champion"></div>
						<div id="top3WonLose">
						</div>
					</div>
				</li>
			</ul>
			</td>
		</tr>
			
	</table>
		

</div>
<hr class="Separator"/>


<div class="summonerContainer">
	<div id="summonerInfo">
	</div>
</div>
<div class="MatchBuild">
	<div class="ItemBuild">
		<ul>
			<li></li>
			<li></li>
		</ul>
	</div>
	
	
	
</div>
</div>

</div>

<!-- 인게임정보 -->
<div class="InGameContainer">
	<div class="Spectator">
		<div class="SpectatorTitle">
			<div class="Title"></div>
			<div class="MapName"></div>
			<div class="Time"></div>
		</div>
		<div class="SpectatorSummoner">
		<table class="team-100">
			<thead>
			<tr>
				<th class="SpectatorCell_BlueTeamName" colspan="2">블루팀</th>
				<th class="SpectatorCell" colspan="2">스펠/룬</th>
				<th class="SpectatorCell">소환사</th>
				<th class="SpectatorCell"  colspan="4">S9</th>
				<th class="SpectatorCell" >밴리스트</th>
			</tr>
			</thead>
			<tbody id="SPteam-100">
			</tbody>
		</table>
		<div class="SpectatorBar"></div>
		<table class="team-200">
			<thead>
			<tr>
				<th class="SpectatorCell_RedTeamName"  colspan="2">레드팀</th>
				<th class="SpectatorCell" colspan="2">스펠/룬</th>
				<th class="SpectatorCell">소환사</th>
				<th class="SpectatorCell"  colspan="4">S9</th>
				<th class="SpectatorCell" >밴리스트</th>
			</tr>
			</thead>
			<tbody id="SPteam-200">
			</tbody>
		</table>
		</div>
	</div>
	
</div>
	
	<script>
	
	
	$(()=>{
		
			var summonerName = $("#summonerName").val().replace(/ /g,"%20");
			var Name = $("#summonerName").val();
			var summonerId = $("#summonerId").val();
			var win = 0;
			var lose = 0;
			var kill = 0;
			var death = 0;
			var assist = 0;
			var winloseTotal = 0;
			var killratioTotal = 0;	
			var mechap = new Array();
			var mechapSplit = new Array();
			var t1 = new Array();
			
				  
			$.ajax({
				
				url : "${pageContext.request.contextPath}/summoner/searchView?summonerName="+summonerName,
				type :"GET",
				dataType : "json",
				success : function(data){
						console.log(data);
					
					for(var i in data){

						var me;
						var myteam;
						var enemyteam;
						var gamemin = parseInt((data[i].gameDuration%3600)/60);
						var gamesec = data[i].gameDuration%60;
						var winLose;

						var gameType;
						var html;
						
						if(data[i].queueId == 420){
							gameType = "솔로랭크";
						}
						else if(data[i].queueId == 430){
							gameType = "자유랭크";
						}
						else if(data[i].queueId == 900){
							gameType = "일반게임";
						}
						else {
							gameType = "특별게임모드";
						}
						
						<% for(int i=1; i<11; i++) {%>
						if(data[i].participants<%=i%>.summonerName == Name){
							me = data[i].participants<%=i%>;
						}
						<%} %>
						
						<% for(int i=1; i<3; i++) {%>
						if(data[i].team<%=i%>.teamId == me.teamId){
							myteam = data[i].team<%=i%>;
							
						}
						
						
						<%} %>
						
						//아이템빌드
			 			var itemPur = new Array();
			 			var itemDes = new Array();
			 			var itemPurTime = new Array();
			 			
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
			 			
			 			
						
						mechap.push(me.championId+","+myteam.win+","+((Number(me.kills) + Number(me.assists)) / Number(me.deaths)).toFixed(1));
						t1.push(me.championId);
							
						html ="<div class='GameContainer"+myteam.win+"'>"+"<table style='border: none;'><tr>";
						
						if(myteam.win == 'Win'){
						html += "<td style='padding: 20px;'><table style='border: none;'><div>"+gameType+"</div><br /><div style='color:blue;'>"+(myteam.win == 'Win' ? '승리' : '패배')+"</div><br /><div>"+gamemin+"분"+gamesec+"초</div></td></table>";
							
						}
						else{
							html += "<td style='padding: 20px;'><table style='border: none;'><div>"+gameType+"</div><br /><div style='color:red;'>"+(myteam.win == 'Win' ? '승리' : '패배')+"</div><br /><div>"+gamemin+"분"+gamesec+"초</div></td></table>";
							
						}
						html += "<td style='padding-right: 11px;'><a href='${pageContext.request.contextPath}/champion/championInfo?championId="+me.championIdNum+"'><img class='chap' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+me.championId+".png'/></a><div class='championKO'>"+me.championKO+"</div></td>";
						html += "<td style='padding-right: 11px;'><table style='border: none;'><tr><img class='spell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+me.spell1Id+".png'/></tr>";
						html += "<tr><img class='spell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+me.spell2Id+".png'/></tr>";
						html += "<tr><img class='spell' src='//opgg-static.akamaized.net/images/lol/perk/"+me.perk0+".png'/></tr>";
						html += "<tr><img class='spell' src='//opgg-static.akamaized.net/images/lol/perkStyle/"+me.perkSubStyle+".png'/></tr>";
						
						html +="</table></td>";
						html += "<td style='padding-right: 11px;'>"+me.kills+" / "+me.deaths+" / "+me.assists+"</br>("+((Number(me.kills) + Number(me.assists)) / Number(me.deaths)).toFixed(1)+")</td>";
						html += "<td style='padding-right: 11px;'>"+me.champLevel+"레벨</td>";
						html += "<td style='padding-right: 11px;'><table style='border: none;'>";
						html += "<tr>"+(me.item0 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item0+".png'/>")+"</tr>";
						html += "<tr>"+(me.item1 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item1+".png'/>")+"</tr>";
						html += "<tr>"+(me.item2 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item2+".png'/>")+"</tr><br />";
						html += "<tr>"+(me.item3 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item3+".png'/>")+"</tr>";
						html += "<tr>"+(me.item4 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item4+".png'/>")+"</tr>";
						html += "<tr>"+(me.item5 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item5+".png'/>")+"</tr>";
						html += "<tr>"+(me.item6 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item6+".png'/>")+"</tr><tr><tr/></table></td>";
						html += "<td style='padding-left: 13px; padding-right: 1%;' ><table class='myTeamTable'>";
						
						<% for(int i=1; i<6; i++) {%>
						html += "<tr>";
						html += "<td><img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].participants<%=i%>.championId+".png'/> <a class='myTeamName' href='http://localhost:9090/yapx3/summoner/summonerView?Name="+data[i].participants<%=i%>.summonerName+"'>"+data[i].participants<%=i%>.summonerName+"</a></td>";
						html += "<td><img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].participants<%=i+5%>.championId+".png'/> <a class='myTeamName' href='http://localhost:9090/yapx3/summoner/summonerView?Name="+data[i].participants<%=i+5%>.summonerName+"'>"+data[i].participants<%=i+5%>.summonerName+"</a></td>";
						html += "</tr>";
						<%} %>
						
						
						
						
						html += "</table></td><td><button class='more' >더보기</button></td>";
						html += "</tr></table></div>";
						
						

						
						/* 더보기 1팀 */
						html += "<div class='GameDetailContainer'>";
						html += "<button class='more_total'>종합</button>  <button class='more_build'>빌드</button>";
						html += "<div class='GameDetailResult_"+data[i].participants1.win+"'>";
						html += "<tr class='more'><td colspan='8'><table>";
						html += "<tr><th>챔피언</th><th>스펠</th><th>닉네임</th><th>KDA</th><th>레벨</th><th>피해량</th><th>CS</th><th>아이템</th></tr>";
						<% for(int i=1; i<6; i++) {%>
						if(data[i].participants<%=i%>.summonerName != Name){
						html += "<tr>";
						}
						else{
						html +="<tr style='background-color: white; border-color: white;'>";	
						}
						html += "<td style='padding-left:25px;'><a href='${pageContext.request.contextPath}/champion/championInfo?championId="+data[i].participants<%=i%>.championIdNum+"'><img class='moreCham' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].participants<%=i%>.championId+".png'/></a>"+data[i].participants<%=i%>.championKO+"</td>";
						html += "<td><table style='border: none;'><tr>";
						html += "<img class='minispell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[i].participants<%=i%>.spell1Id+".png'/>";
						html += "</tr><tr>";
						html += "<img class='minispell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[i].participants<%=i%>.spell2Id+".png'/>";
						html += "</tr><tr>";
						html += "<img class='minispell' src='//opgg-static.akamaized.net/images/lol/perk/"+data[i].participants<%=i%>.perk0+".png'/>";
						html += "</tr><tr>"
						html += "<img class='minispell' src='//opgg-static.akamaized.net/images/lol/perkStyle/"+data[i].participants<%=i%>.perkSubStyle+".png'/>";
						html += "</table></td>";
						
						html += "<td style='text-align: center;'>"+data[i].participants<%=i%>.summonerName+"</td>";
						//킬관여율
						if(<%=i%><6){
						html += "<td>"+data[i].participants<%=i%>.kills+" / "+data[i].participants<%=i%>.deaths+" / "+data[i].participants<%=i%>.assists+"</br>("+
								((Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / Number(data[i].participants<%=i%>.deaths)).toFixed(1)+
								")</br>"+(( (Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / (Number(data[i].participants6.deaths)
								 + Number(data[i].participants7.deaths)	
								 + Number(data[i].participants8.deaths)	
								 + Number(data[i].participants9.deaths)	
								 + Number(data[i].participants10.deaths)) )*100).toFixed(1)+"%</br>"+"</td>";
								 
								 if(data[i].participants<%=i%>.summonerName == Name){
									 killratioTotal += Number( (( (Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / (Number(data[i].participants6.deaths)
											 + Number(data[i].participants7.deaths)	
											 + Number(data[i].participants8.deaths)	
											 + Number(data[i].participants9.deaths)	
											 + Number(data[i].participants10.deaths)) )*100).toFixed(1) );
								 }
						}
						else if(<%=i%>>5){
							html += "<td>"+data[i].participants<%=i%>.kills+" / "+data[i].participants<%=i%>.deaths+" / "+data[i].participants<%=i%>.assists+"</br>("+
									((Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / Number(data[i].participants<%=i%>.deaths)).toFixed(1)+
									")</br>"+(( (Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / ( Number(data[i].participants1.deaths)
											 + Number(data[i].participants2.deaths)	
											 + Number(data[i].participants3.deaths)	
											 + Number(data[i].participants4.deaths)	
											 + Number(data[i].participants5.deaths) ) )*100).toFixed(1) +"%</br></td>";	
											 
							if(data[i].participants<%=i%>.summonerName == Name){
								 killratioTotal += Number ((( (Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / (Number(data[i].participants6.deaths)
										 + Number(data[i].participants2.deaths)	
										 + Number(data[i].participants3.deaths)	
										 + Number(data[i].participants4.deaths)	
										 + Number(data[i].participants5.deaths)) )*100).toFixed(1));
							 }
						}
						html += "<td>"+data[i].participants<%=i%>.champLevel+"</td>";
						html += "<td>"+data[i].participants<%=i%>.totalDamageTaken+" / </td>";
						html += "<td>"+data[i].participants<%=i%>.totalMinionsKilled+"</td>";
						html += "<td>";
						<%for(int j=0; j<7; j++){%>
						html += (data[i].participants<%=i%>.item<%=j%> == 0 ? "" : "<img class='miniitem' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+data[i].participants<%=i%>.item<%=j%>+".png'/>");
						<%} %>
						html += "</td>";
						html += "</tr>";
						<%} %>
						html += "</table></td></tr></div>";
						/*더보기2팀*/
						html += "<div class='GameDetailResult_"+data[i].participants6.win+"'>";
						html += "<tr class='more'><td colspan='8'><table>";
						html += "<tr><th>챔피언</th><th>스펠</th><th>닉네임</th><th>KDA</th><th>레벨</th><th>피해량</th><th>CS</th><th>아이템</th></tr>";
						<% for(int i=6; i<11; i++) {%>
						if(data[i].participants<%=i%>.summonerName != Name){
							html += "<tr>";
						}
						else{
							html +="<tr style='background-color: white; border-color:white;'>";	
						}
						html += "<td style='padding-left:25px;'><a href='${pageContext.request.contextPath}/champion/championInfo?championId="+data[i].participants<%=i%>.championIdNum+"'><img class='moreCham' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].participants<%=i%>.championId+".png'/></a>"+data[i].participants<%=i%>.championKO+"</td>";
						html += "<td><table style='border: none;'><tr>";
						html += "<img class='minispell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[i].participants<%=i%>.spell1Id+".png'/>";
						html += "</tr><tr>";
						html += "<img class='minispell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[i].participants<%=i%>.spell2Id+".png'/>";
						html += "</tr><tr>";
						html += "<img class='minispell' src='//opgg-static.akamaized.net/images/lol/perk/"+data[i].participants<%=i%>.perk0+".png'/>";
						html += "</tr><tr>"
						html += "<img class='minispell' src='//opgg-static.akamaized.net/images/lol/perkStyle/"+data[i].participants<%=i%>.perkSubStyle+".png'/>";
						html += "</table></td>";
						
						html += "<td style='text-align: center;'>"+data[i].participants<%=i%>.summonerName+"</td>";
						//킬관여율
						if(<%=i%><6){
						html += "<td>"+data[i].participants<%=i%>.kills+" / "+data[i].participants<%=i%>.deaths+" / "+data[i].participants<%=i%>.assists+"</br>("+
								((Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / Number(data[i].participants<%=i%>.deaths)).toFixed(1)+
								")</br>"+(( (Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / (Number(data[i].participants6.deaths)
								 + Number(data[i].participants7.deaths)	
								 + Number(data[i].participants8.deaths)	
								 + Number(data[i].participants9.deaths)	
								 + Number(data[i].participants10.deaths)) )*100).toFixed(1)+"%</br>"+"</td>";
								 
								 if(data[i].participants<%=i%>.summonerName == Name){
									 killratioTotal += Number( (( (Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / (Number(data[i].participants6.deaths)
											 + Number(data[i].participants7.deaths)	
											 + Number(data[i].participants8.deaths)	
											 + Number(data[i].participants9.deaths)	
											 + Number(data[i].participants10.deaths)) )*100).toFixed(1) );
								 }
						}
						else if(<%=i%>>5){
							html += "<td>"+data[i].participants<%=i%>.kills+" / "+data[i].participants<%=i%>.deaths+" / "+data[i].participants<%=i%>.assists+"</br>("+
									((Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / Number(data[i].participants<%=i%>.deaths)).toFixed(1)+
									")</br>"+(( (Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / ( Number(data[i].participants1.deaths)
											 + Number(data[i].participants2.deaths)	
											 + Number(data[i].participants3.deaths)	
											 + Number(data[i].participants4.deaths)	
											 + Number(data[i].participants5.deaths) ) )*100).toFixed(1) +"%</br></td>";	
											 
							if(data[i].participants<%=i%>.summonerName == Name){
								 killratioTotal += Number ((( (Number(data[i].participants<%=i%>.kills) + Number(data[i].participants<%=i%>.assists)) / (Number(data[i].participants6.deaths)
										 + Number(data[i].participants2.deaths)	
										 + Number(data[i].participants3.deaths)	
										 + Number(data[i].participants4.deaths)	
										 + Number(data[i].participants5.deaths)) )*100).toFixed(1));
							 }
						}
						html += "<td>"+data[i].participants<%=i%>.champLevel+"</td>";
						html += "<td>"+data[i].participants<%=i%>.totalDamageTaken+"</td>";
						html += "<td>"+data[i].participants<%=i%>.totalMinionsKilled+"</td>";
						html += "<td>";
						<%for(int j=0; j<7; j++){%>
						html += (data[i].participants<%=i%>.item<%=j%> == 0 ? "" : "<img class='miniitem' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+data[i].participants<%=i%>.item<%=j%>+".png'/>");
						<%} %>
						html += "</td>";
						html += "</tr>";
						<%} %>
						html += "</table></td></tr></div>";
						
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
		 						html +="</br><div class='ItemTime' style='position: absolute;'>"+times+"분</div>";
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
			 				
// 			 				var Line8000_1 = [9101,9111,8009];
// 			 				var Line8000_2 = [9104,9105,9103];
// 			 				var Line8000_3 = [8014,8017,8299];
			 				
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
						html += "</div>"; // GameDetailContainer 
						
						
						$("#summonerInfo").append(html); 
						//더보기 끝
						
						
						
						
						// 전적계산 전 승 패 /평점
						
						winloseTotal = ($(".GameContainerWin").length + $(".GameContainerFail").length);
						
						if(myteam.win == 'Win'){
							win++;
						}
						
						kill += Number(me.kills);
			 			death += Number(me.deaths);
			 			assist += Number(me.assists);
			 			
						lose = winloseTotal-win;
			 			$("#winloseResult tr>td>div>span:first").text(winloseTotal);
			 			$("#winloseResult tr>td>div>span:eq(1)").text(win);
			 			$("#winloseResult tr>td>div>span:eq(2)").text(lose);
			 			
						
			 			
			 			

					}// data[i] for문끝 
					
					//chart js 원형차트 설정
					
					var ctx = document.getElementById("myChart").getContext('2d');
					var winLoseChart = new Chart(ctx,{
						type: "doughnut",
						data:{
								labels:["승","패"], 
							datasets:[{
								data:[win,lose],
							
							backgroundColor:[
				                'rgba(54, 162, 235, 0.2)',
								'rgba(255, 99, 132, 0.2)'
							],
							borderColor:[
				                'rgba(54, 162, 235, 0.2)',
								'rgba(255, 99, 132, 0.2)'
							],
							borderWidth: 1
							
							}]
						},
						options: {
							cutoutPercentage: 65,
							legend:{
								display: false
							}
							
						}
					});
					
					
					//더보기 눌렀을때 슬라이드다운 다시누르면 슬라이드업
					$(".more").click(function(){
						var sub = $(this).closest("div").next();
						if(sub.is(":visible")){
							sub.slideUp();
						}
						else{
							sub.slideDown();
						}
					});
					
 					//더보기 - 종합
 					$(".more_total").click(function(){
						var more_total = $(this).parent().children().eq(2);
						var more_total2 = $(this).parent().children().eq(3);
						
						var more_build = $(this).parent().children().eq(4);
						
						$(more_total).css("display","block");
						$(more_total2).css("display","block");
						
						$(more_build).css("display","none");
						
 					});
					
 					//더보기 - 빌드 
 					$(".more_build").click(function(){
 						var more_total = $(this).parent().children().eq(2);
						var more_total2 = $(this).parent().children().eq(3);
						
 						var more_build = $(this).parent().children().eq(4);
 						$(more_total).css("display","none");
						$(more_total2).css("display","none");
						
						$(more_build).css("display","block");
 						
					});
 					
					
					var killResult = (kill/winloseTotal).toFixed(1);
					var deathResult = (death/winloseTotal).toFixed(1);
					var assistResult = (assist/winloseTotal).toFixed(1);
					
					var totalGrade =( (Number(kill)+Number(assist))/Number(death) ).toFixed(1);
					
	
					var totalkillratio =( Number(killratioTotal)/Number(winloseTotal)).toFixed(1);
					
					$("#Kill").text(killResult);
					$("#Death").text(deathResult);
					$("#Assist").text(assistResult);
					$("#KDARatioText").text(totalGrade);
					$("#Status_Kill").text("킬관여율 : "+totalkillratio+"%");
					
					var mechapTop3 = new Array();
					
					for(var i in mechap){
						mechapSplit.push(mechap[i].split(","));
					}
					
					
				//중복된 영웅이름 받아서 중복된영웅들끼리 배열로 묶기
   				var t1Result = {};
  				 for (var i in t1) {
       			if (!(t1[i] in t1Result))
       				t1Result[t1[i]] = [];
       				t1Result[t1[i]].push(t1[i]);
   				}
  				 
				var t1Top3 = new Array();
				var t1Top3Name = new Array();
				var t1Sort = new Array();
				
				//한개이상 쓴 챔피언이름 배열로받기
				for(var i in t1Result){
					if(t1Result[i].length >1){
						t1Top3.push(t1Result[i]);
					}
				}
				// 배열 길이순으로 내림차순정렬 
				t1Top3.sort(function(a,b){
					return b.length - a.length;
				});
				
				//많이쓴 챔피언 TOP3
				
				
				var Top1 = new Array();
				var Top2 = new Array();
				var Top3 = new Array();
				
				Top1.push(t1Top3[0][0]);
				Top1.push(t1Top3[0].length);
				if(t1Top3.length <=1){
					
				}
				else{
				Top2.push(t1Top3[1][0]);
				Top2.push(t1Top3[1].length);
				Top3.push(t1Top3[2][0]);
				Top3.push(t1Top3[2].length);
					
				}
				
				
				var Top1Grade = 0;
				var Top2Grade = 0;
				var Top3Grade = 0;
				
				var Top1Victory = 0;
				var Top2Victory = 0;
				var Top3Victory = 0;
				
				
				// top3 등급, 승리횟수 계산
				for(var it in mechapSplit){
					if(mechapSplit[it][0] == Top1[0]){
						Top1Grade += Number(mechapSplit[it][2]);
						if(mechapSplit[it][1] == 'Win'){
							Top1Victory++;
						}
					}
					else if(mechapSplit[it][0] == Top2[0]){
						Top2Grade += Number(mechapSplit[it][2]);
						if(mechapSplit[it][1] == 'Win'){
							Top2Victory++;
						}
						
					}
					else if(mechapSplit[it][0] == Top3[0]){
						Top3Grade += Number(mechapSplit[it][2]);
						if(mechapSplit[it][1] == 'Win'){
							Top3Victory++;
						}
					}
				}
				//top3 배열에 승리횟수 등급 추가해주기
				Top1.push(Top1Victory);
				Top1.push(Top1[1]-Top1Victory);
				Top1.push(Top1Grade/Top1[1]);
				
				Top2.push(Top2Victory);
				Top2.push(Top2[1]-Top2Victory);
				Top2.push(Top2Grade/Top2[1]);
				
				Top3.push(Top3Victory);
				Top3.push(Top3[1]-Top3Victory);
				Top3.push(Top3Grade/Top3[1]);
				
				
				//Top3 추가
				
				if(t1Top3.length<=1){
					
					$("#top3 li:eq(0) div div#top3Image").append("<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+Top1[0]+".png'/>");
					$("#top3 li:eq(0) div div#top3Image").append(Top1[0]);
					$("#top3 li:eq(0) div div#top3WonLose").append("<b style='color: red;'>"+((Top1[2]/Top1[1])*100).toFixed(1)+"%   </b>"+"<span id='win' style='margin-right: 5px;'>("+Top1[2]+"승</span>"+"<span id='lose' style='margin-right: 5px;'>"+Top1[3]+"패)</span>"+"<span>"+(Top1[4].toFixed(1))+"평점</span>");
				}
				else{
					
					$("#top3 li:eq(0) div div#top3Image").append("<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+Top1[0]+".png'/>");
					$("#top3 li:eq(0) div div#top3Image").append(Top1[0]);
					$("#top3 li:eq(0) div div#top3WonLose").append("<b style='color: red;'>"+((Top1[2]/Top1[1])*100).toFixed(1)+"%   </b>"+"<span id='win' style='margin-right: 5px;'>("+Top1[2]+"승</span>"+"<span id='lose' style='margin-right: 5px;'>"+Top1[3]+"패)</span>"+"<span>"+(Top1[4].toFixed(1))+"평점</span>");
					$("#top3 li:eq(1) div div#top3Image").append("<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+Top2[0]+".png'/>");
					$("#top3 li:eq(1) div div#top3Image").append(Top2[0]);
					$("#top3 li:eq(1) div div#top3WonLose").append("<b style='color: red;'>"+((Top2[2]/Top2[1])*100).toFixed(1)+"%   </b>"+"<span id='win' style='margin-right: 5px;'>("+Top2[2]+"승</span>"+"<span id='lose' style='margin-right: 5px;'>"+Top2[3]+"패)</span>"+"<span>"+(Top2[4].toFixed(1))+"평점</span>");
					$("#top3 li:eq(2) div div#top3Image").append("<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+Top3[0]+".png'/>");
					$("#top3 li:eq(2) div div#top3Image").append(Top3[0]);
					$("#top3 li:eq(2) div div#top3WonLose").append("<b style='color: red;'>"+((Top3[2]/Top3[1])*100).toFixed(1)+"%   </b>"+"<span id='win' style='margin-right: 5px;'>("+Top3[2]+"승</span>"+"<span id='lose' style='margin-right: 5px;'>"+Top3[3]+"패)</span>"+"<span>"+(Top3[4].toFixed(1))+"평점</span>");
					
				}
				
				
				$("#InGameBtn").attr("title","현재 게임중이 아닙니다");
				$('[data-toggle="InGameBtnTooltip"]').tooltip(); 
				
										
				},
				
				error : function(err){
					console.log("fail");
				},
				
				beforeSend: function () {
		              var width = 0;
		              var height = 0;
		              var left = 350;
		              var top = 300;

		              width = 1024;
		              height = 768;


		              if($("#div_ajax_load_image").length != 0) {
		                     $("#div_ajax_load_image").css({
		                            "top": top+"px",
		                            "left": left+"px"
		                     });
		                     $("#div_ajax_load_image").show();
		              }
		              else {
		                     $('body').append('<div id="div_ajax_load_image" style="position:absolute; top:' + top + 'px; left:' + left + 'px; width:' + width + 'px; height:' + height + 'px; z-index:9999; filter:alpha(opacity=50); opacity:alpha*0.5; margin:auto; padding:0;"><img src="${pageContext.request.contextPath}/resources/images/loading.gif"></div>');
		              }

		       }
		       , complete: function () {
		                     $("#div_ajax_load_image").hide();
		       }
				
			});
			
			var summonerId;
			
			$.ajax({
				url : "${pageContext.request.contextPath}/summoner/summonerProfile?summonerName="+Name,
				type : "GET",
				dataType : "json",
				success : function( data ){
					console.log(data);
					
					$("#icon").html("<img id='profileIcon' src='//opgg-static.akamaized.net/images/profile_icons/profileIcon"+ data.profileIconId +".jpg'><span class='SummonerLevel' title='레벨' data-toggle='summonerLevelTooltip'></span>");
					$(".SummonerLevel").text(data.summonerLevel);
					$("#name").text(data.name);
				},
				error : function( xhr, txtStatus, err ){
					console.log( xhr, txtStatus, err );
					alert("없는 소환사 입니다.");
					location.href = "${pageContext.request.contextPath}/";
				}
			});
			
			$('[data-toggle="summonerLevelTooltip"]').tooltip();  
			
			$.ajax({
 				url : "${pageContext.request.contextPath}/summoner/summonerRank?summonerId=" + summonerId,
				type : "GET",
				async : false,
				dataType : "json",
				success : function( data ){
					console.log(data);
					for(var i in data){
						if( data[i].queueType != "RANKED_TFT" ){
						   if( data[i].queueType == "RANKED_FLEX_SR" ){
							   
							   $("#TierType").text("자유5:5랭크");
							   
						   }else if( data[i].queueType == "RANKED_SOLO_5x5" ){
							   
							   $("#TierType").text("솔로랭크");
						   }
						   if( data[i].tier == "IRON" ){
							   $("#TierBoxImg").html("<img src='${pageContext.request.contextPath}/resources/images/tier/IRON.png'>");
						   }else if( data[i].tier == "BRONZE" ){
							   $("#TierBoxImg").html("<img src='${pageContext.request.contextPath}/resources/images/tier/BRONZE.png'>");
						   }else if( data[i].tier == "SILVER" ){
							   $("#TierBoxImg").html("<img src='${pageContext.request.contextPath}/resources/images/tier/SILVER.png'>");
						   }else if( data[i].tier == "GOLD" ){
							   $("#TierBoxImg").html("<img src='${pageContext.request.contextPath}/resources/images/tier/GOLD.png'>");
						   }else if( data[i].tier == "PLATINUM" ){
							   $("#TierBoxImg").html("<img src='${pageContext.request.contextPath}/resources/images/tier/PLATINUM.png'>");
						   }else if( data[i].tier == "DIAMOND" ){
							   $("#TierBoxImg").html("<img src='${pageContext.request.contextPath}/resources/images/tier/DIAMOND.png'>");
						   }else if( data[i].tier == "MASTER" ){
							   $("#TierBoxImg").html("<img src='${pageContext.request.contextPath}/resources/images/tier/MASTER.png'>");
						   }else if( data[i].tier == "GRANDMASTER" ){
							   $("#TierBoxImg").html("<img src='${pageContext.request.contextPath}/resources/images/tier/GRANDMASTER.png'>");
						   }else if( data[i].tier == "CHALLENGER" ){
							   $("#TierBoxImg").html("<img src='${pageContext.request.contextPath}/resources/images/tier/CHALLENGER.png'>");
						   }
						   
						   $("#TierRank").text(data[i].tier+"  "+data[i].rank);
						   $("#LeaguePoints").text(data[i].leaguePoints+"LP");
						   $("#wins").text(data[i].wins+"승");
						   $("#losses").text(data[i].losses+"패");
						   $("#winratio").text("승률 : "+Math.round(( data[i].wins/( data[i].wins + data[i].losses ) )*100)+"%");
						    

						}
					}
				},
				error : function( xhr, txtStatus, err ){
					console.log( xhr, txtStatus, err );
				}
			});
			 
			
			//인게임정보 ajax
			$.ajax({
				url: "${pageContext.request.contextPath}/summoner/summonerInGame?summonerId=" + summonerId,
				type: "GET",
				async: false,
				dataType : "json",
				success : function( data ){
					console.log(data);
					$("#InGameBtn").css("background-color","green");
					$("#InGameBtn").removeAttr('title');
					$("#InGameBtn").attr("title","현재 게임중입니다 클릭하시면 인게임데이터를 볼 수 있습니다!");
					$('[data-toggle="InGameBtnTooltip"]').tooltip(); 
					
					$("#InGameBtn").click(function(){
						
						$(".Container").css("display","none");
						$(".InGameContainer").css("display","block");
						
					});
						var SpRed;
						var SpBlue;
						var spRedTier;
						var spBlueTier;
						var banRed = new Array();
						var banBlue = new Array();
						
						for(var a = 0; a<10; a++){
							if(data[0].banned[a].teamId == 100){
								if(data[0].banned[a].bannedchampion != null){
									banRed.push(data[0].banned[a].bannedchampion);
									}
							}
							else if(data[0].banned[a].teamId == 200){
								if(data[0].banned[a].bannedchampion != null){
								banBlue.push(data[0].banned[a].bannedchampion);
								}
							}
							
						}
						
						
						for(var i =0; i<10; i++){
							
							if(i<=4){
							SpRed += "<tr>";
							SpRed += "<td class='SPChampionImage' colspan='2'><img class='InGameCham' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[0].participant[i].championId+".png'></td>";
							SpRed += "<td class='SPSummonerSpell'><div class='spell1'><img class='InGameSpell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[0].participant[i].spell1+".png'/></div>";
							SpRed += "<div class='spell2'><img class='InGameSpell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[0].participant[i].spell2+".png'/></div></td>";
							SpRed +="<td class='Runes'><div class='Rune1'><img class='InGameSpell' src='//opgg-static.akamaized.net/images/lol/perk/"+data[0].participant[i].perks.myArrayList[0]+".png'/></div>";
							SpRed +="<div class='Rune2'><img class='InGameSpell' src='//opgg-static.akamaized.net/images/lol/perkStyle/"+data[0].participant[i].perkSubStyle+".png'/></td>";
							SpRed += "<td class='SpName'>"+data[0].participant[i].summonerName+"</td>";
							
							
							if( data[0].participant[i].tier == "IRON" ){
								SpRed += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/IRON.png'></td>";
							   }else if( data[0].participant[i].tier == "BRONZE" ){
								   SpRed += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/BRONZE.png'></td>";
							   }else if( data[0].participant[i].tier == "SILVER" ){
								   SpRed += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/SILVER.png'></td>";
							   }else if( data[0].participant[i].tier == "GOLD" ){
								   SpRed += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/GOLD.png'></td>";
							   }else if( data[0].participant[i].tier == "PLATINUM" ){
								   SpRed += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/PLATINUM.png'></td>";
							   }else if( data[0].participant[i].tier == "DIAMOND" ){
								   SpRed += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/DIAMOND.png'></td>";
							   }else if( data[0].participant[i].tier == "MASTER" ){
								   SpRed += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/MASTER.png'></td>";
							   }else if( data[0].participant[i].tier == "GRANDMASTER" ){
								   SpRed += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/GRANDMASTER.png'></td>";
							   }else if( data[0].participant[i].tier == "CHALLENGER" ){
								   SpRed += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/CHALLENGER.png'></td>";
							   }
							   else{
								   SpRed +="<td></td>";
							   }
							
							SpRed += "<td class='SpTierRed' colspan='2'>"+data[0].participant[i].tier+" "+data[0].participant[i].rank+" ("+ data[0].participant[i].LP+" LP)</td>";
							if(data[0].banned[i].teamId == 100){
								if(data[0].banned[i].bannedchampion != null){	
							SpRed +="<td><img class='spell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[0].banned[i].bannedchampion+".png'></td>";
								
							}
						}
							
							SpRed += "</tr>";
								
							}
							else if(5<=i){
								SpBlue += "<tr>";
								SpBlue += "<td class='SPChampionImage' colspan='2'><img class='InGameCham' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[0].participant[i].championId+".png'></td>";
								SpBlue += "<td class='SPSummonerSpell'><div class=''><img class='InGameSpell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[0].participant[i].spell1+".png'/></div>";
								SpBlue += "<div class='spell2'><img class='InGameSpell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[0].participant[i].spell2+".png'/></div></td>";
								SpBlue +="<td class='Runes'><div class='Rune1'><img class='InGameSpell' src='//opgg-static.akamaized.net/images/lol/perk/"+data[0].participant[i].perks.myArrayList[0]+".png'/></div>";
								SpBlue +="<div class='Rune2'><img class='InGameSpell' src='//opgg-static.akamaized.net/images/lol/perkStyle/"+data[0].participant[i].perkSubStyle+".png'/></td>";
								SpBlue += "<td class='SpName'>"+data[0].participant[i].summonerName+"</td>";
								
								if( data[0].participant[i].tier == "IRON" ){
									SpBlue += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/IRON.png'></td>";
								   }else if( data[0].participant[i].tier == "BRONZE" ){
									   SpBlue += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/BRONZE.png'></td>";
								   }else if( data[0].participant[i].tier == "SILVER" ){
									   SpBlue += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/SILVER.png'></td>";
								   }else if( data[0].participant[i].tier == "GOLD" ){
									   SpBlue += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/GOLD.png'></td>";
								   }else if( data[0].participant[i].tier == "PLATINUM" ){
									   SpBlue += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/PLATINUM.png'></td>";
								   }else if( data[0].participant[i].tier == "DIAMOND" ){
									   SpBlue += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/DIAMOND.png'></td>";
								   }else if( data[0].participant[i].tier == "MASTER" ){
									   SpBlue += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/MASTER.png'></td>";
								   }else if( data[0].participant[i].tier == "GRANDMASTER" ){
									   SpBlue += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/GRANDMASTER.png'></td>";
								   }else if( data[0].participant[i].tier == "CHALLENGER" ){
									   SpBlue += "<td class='tier'><img class='spell' src='${pageContext.request.contextPath}/resources/images/tier/CHALLENGER.png'></td>";
								   }
								   else{
									   SpBlue +="<td></td>";
								   }
								
								
								SpBlue  += "<td class='SpTierBlue' colspan='2'>"+data[0].participant[i].tier+" "+data[0].participant[i].rank+" ("+ data[0].participant[i].LP+" LP)</td>";
								if(data[0].banned[i].teamId == 200){
									if(data[0].banned[i].bannedchampion != null){
								SpBlue +=	"<td><img class='spell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[0].banned[i].bannedchampion+".png'></td>";
										
									}
								}
								
								
								SpBlue += "</tr>";
							}
						}
						
							$("#SPteam-100").append(SpRed);
							$("#SPteam-200").append(SpBlue);
							
					
					
					$("#SummonerViewBtn").click(function(){
						$(".InGameContainer").css("display","none");
						$(".Container").css("display","block");
					});
					
				},
				error : function( xhr, txtStatus, err ){
					console.log("현재 게임중이 아닙니다");
					
				}
				
			});
		
	});
	</script>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	


