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



<style>

	ul{
	list-style: none;
	}
	ol{
	list-style: none;
	}
	
/* 	게임승리시 파란색 패배시 붉은색으로 컨테이너 표시 */
	
	.GameContainerWin td, .GameContainerFail td{
		border: none;
	}
	.GameContainerWin{
		background-color: #a3cfec; border-color: #99b9cf;
		margin-bottom: 20px;
/* 		float: left; */
	}
	.GameContainerFail{
		background-color: #e2b6b3; border-color: #cea7a7;
		margin-bottom: 20px;
/* 		float: left; */
	}
	.myTeamTable{
		border: none;
	}
	
/* 	더보기 페이지 패배시, 승리시 */
	
	
  	.GameDetailContainer{ 
  	display: none; 
  	}  
	
	.GameDetailResult_true{
	background-color: #a3cfec; border-color: #99b9cf;
	margin-bottom: 20px;
	}
	.GameDetailResult_false{
	background-color: #e2b6b3; border-color: #cea7a7;
	margin-bottom: 20px;
	}
	
/* 	소환사 프로필(사진, 아이디, 랭킹) */
	
	#summonerProfile {
		border: 1px solid black;
		width: 1000px;
		height: 200px;
		margin: 55px;
		position: static;
	}
	
	#profileIcon {
		padding: 35px;
		position: absolute;
		left: 87px;
		top: 46px;
		width: 150px;
		height: 150px;
		background-position: center bottom;
		background-repeat: no-repeat;
	}
	
	#name{
	position: absolute;
	left: 326px;
	top: 88px;
	font-size: 35px;
	font-weight: bold;
	margin-left: 5px;
	vertical-align: middle;
	}
	
	#favorite{
	position: absolute;
	left: 567px;
	top: 97px;
	
	}

/* 소환사 상세정보 페이지	 */
.Container{
overflow: hidden;

}

/* 	상세정보 컨테이너 - 사이드*/
.SideContent{
    width: 300px;
    font-size: 12px;
    vertical-align: top;
    margin-bottom: 40px;
}

.TierBox{
    display: table;
    position: relative;
    padding: 8px 0;
	margin-left: 55px;
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

/* 상세정보 - 스킬빌드 */

.SKBQ td, .SKBW td, .SKBE td, .SKBR td{
	width: 35px;
	border: 1px solid white;
	text-align: center;
	
}

/* 상세정보 - 아이템빌드 */
.title{

	padding: 7px 14px 9px;
    background: #fff;
    border-bottom: 1px solid #cdd2d2;
	font-size: 12px;
    line-height: 16px;
    color: #333;
    margin-top: 40px;
    margin-bottom: 40px;
}

.myItemBuild{
	padding-top: 8px;
}

.ItemTime{
	margin-left: 60px;
}

.ItemList{
	margin-top: 8px;
	margin-bottom: 8px;
}


/* 룬 - 맨 오른쪽 룬 마진값 */

#fragment1, #fragment2, #fragment3{
	margin-left: 10px;
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


	
</style>
<style>
	img.spell{width:32px;}
	img.chap{width:64px;}
	img.item{width:20px;}
	img.mini{width:20px;}
	img.minispell{width:20px;}
	img.miniitem{width:20px;}
	/* tr.more{display:none;} */
	#summonerRank img {width:35px; height: 30px;}
	
/* 	#summonerStatus img{width: } */
</style>
	
<input type="hidden" name="summonerName" id="summonerName" value="<%=summonerName%>"/>
<input type="hidden" name="summonerId" id="summonerId" value="<%=summonerId%>"/>
	
	<!-- 프로필 사진 소환사 아이디, 레벨 -->
	<div id="summonerProfile">
		<div id="face">
			<div id="icon"> <!-- 아이콘아미지 -->
				<span id="level"></span> <!-- 레벨 text -->
			</div>
		</div>
		<div id="profile">
			<div id="information">
			<span id="name"></span>
			<img src="${pageContext.request.contextPath}/resources/images/star.png" id="favorite" />
			</div>
		</div>
		<div id="ranking">
			<h3 id="rankingText"></h3>
		</div>
	</div>
	
	<div class="Container">
	<!-- 티어 이미지, 티어 표시 -->
	<div class="SideContent" style="float: left;">	
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

<!-- 게임종류, 승패여부, 사용한 챔피언,아이템,팀원 -->	
<div class="MainContainer">

<div id="WinRatio" style="border: hidden;">
	<table id="winloseResult" style="display:inline; border: hidden; margin-left: 50px;">
		<tr>
			<td style="border: hidden;">
				<div>
					<span></span>전				
					<span></span>승			
					<span></span>패				
				</div>
			</td>
		</tr>
	</table>
	<table style="display:inline; margin-left: 30px; border: hidden;">
		<tr>
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

<div class="GameList" >
	<div id="GameListWrap">
		<div id="WrapContainer">
			<div id="GameStatus">
				<div id="GameType"></div>
				<div id="TimeStamp"></div>
				<div id="GameResult"></div>
				<div id="GameLength"></div>
			</div>
			<div id="GameSettingInfo">
				<div id="ChampionImage">
					<a href=""><img src=""/></a>
				</div>
				<div id="SummonerSpell">
					<div id="Spell"></div>
					<div id="Spell"></div>
				</div>
				<div id="Runes">
					<div id="Rune"></div>
					<div id="Rune"></div>
				</div>
				<div id="ChampionName">
					<a href=""></a>
				</div>
			</div>
			<div id="KDA">
				<span id="Kill"></span> /
				<span id="Death"></span> /
				<span id="Assist"></span>
			</div>
			<div id="KDARatio">
				<span id="KDARatioText"></span>평점
			</div>
			<div id="Status">
				<div id="Status_Level"></div>
				<div id="Status_CS"><span></span></div>
				<div id="Status_Kill"><span></span></div>
				<div id="Status_MMR"><span></span><br /><b></b></div>
			</div>
			<div id="Items">
				<div id="ItemList">
					<div id="Item"></div>
					<div id="Item"></div>
					<div id="Item"></div>
					<div id="Item"></div>
					<div id="Item"></div>
					<div id="Item"></div>
					<div id="Item"></div>
				</div>
			</div>
			<div id="MemberList">
				<div id="Team1">
					<div id="Summoner"></div>
					<div id="Summoner"></div>
					<div id="Summoner"></div>
					<div id="Summoner"></div>
					<div id="Summoner"></div>
				</div>
				<div id="Team2">
					<div id="Summoner"></div>
					<div id="Summoner"></div>
					<div id="Summoner"></div>
					<div id="Summoner"></div>
					<div id="Summoner"></div>
				</div>
			</div>
			
		</div>	
	</div>
</div>	

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
						
					
						console.log(data[i]);
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
			 				else if(me.myItemBuild[z].type == "ITEM_DESTROYED"){
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
						
						html += "<td><table style='border: none;'><tr>"+gameType+"</tr><br /><tr>"+(myteam.win == 'Win' ? '승리' : '패배')+"</tr><br /><tr>"+gamemin+"분"+gamesec+"초</tr></td></table>";
						html += "<td><img class='chap' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+me.championId+".png'/></td>";
						html += "<td><table style='border: none;'><tr><img class='spell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+me.spell1Id+".png'/></tr>";
						html += "<tr><img class='spell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+me.spell2Id+".png'/></tr>";
						html += "<tr><img class='spell' src='//opgg-static.akamaized.net/images/lol/perk/"+me.perk0+".png'/></tr>";
						html += "<tr><img class='spell' src='//opgg-static.akamaized.net/images/lol/perkStyle/"+me.perkSubStyle+".png'/></tr>";
						
						html +="</table></td>";
						html += "<td>"+me.kills+"/"+me.deaths+"/"+me.assists+"</br>("+((Number(me.kills) + Number(me.assists)) / Number(me.deaths)).toFixed(1)+")</td>";
						html += "<td>"+me.champLevel+"레벨</td>";
						html += "<td><table style='border: none;'>";
						html += "<tr>"+(me.item0 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item0+".png'/>")+"</tr>";
						html += "<tr>"+(me.item1 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item1+".png'/>")+"</tr>";
						html += "<tr>"+(me.item2 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item2+".png'/>")+"</tr><br />";
						html += "<tr>"+(me.item3 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item3+".png'/>")+"</tr>";
						html += "<tr>"+(me.item4 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item4+".png'/>")+"</tr>";
						html += "<tr>"+(me.item5 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item5+".png'/>")+"</tr>";
						html += "<tr>"+(me.item6 == 0 ? "" : "<img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+me.item6+".png'/>")+"</tr><tr><tr/></table></td>";
						html += "<td><table class='myTeamTable'>";
						
						<% for(int i=1; i<6; i++) {%>
						html += "<tr><td>";
						html += "<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].participants<%=i%>.championId+".png'/> "+data[i].participants<%=i%>.summonerName;
						html += "</td><td>";
						html += "<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].participants<%=i+5%>.championId+".png'/> "+data[i].participants<%=i+5%>.summonerName;
						html += "</td></tr>";
						<%} %>
						html += "</table></td><td><button class='more' >더보기</button></td>";
						html += "</tr></table></div>";
						
						

						
						/* 더보기 1팀 */
						html += "<div class='GameDetailContainer'>";
						html += "<button style=''>종합</button>  <button style=''>빌드</button>";
						html += "<div class='GameDetailResult_"+data[i].participants1.win+"'>";
						html += "<tr class='more'><td colspan='8'><table>";
						html += "<tr><th>챔피언</th><th>스펠</th><th>닉네임</th><th>KDA</th><th>피해량</th><th>CS</th><th>아이템</th></tr>"
						<% for(int i=1; i<6; i++) {%>
						if(data[i].participants<%=i%>.summonerName != Name){
						html += "<tr>";
						}
						else{
						html +="<tr style='background-color: white; border-color: white;'>";	
						}
						html += "<td>"+data[i].participants<%=i%>.champLevel+"<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].participants<%=i%>.championId+".png'/></td>";
						html += "<td><table style='border: none;'><tr>";
						html += "<img class='minispell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[i].participants<%=i%>.spell1Id+".png'/>";
						html += "</tr><tr>";
						html += "<img class='minispell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[i].participants<%=i%>.spell2Id+".png'/>";
						html += "</tr><tr>";
						html += "<img class='minispell' src='//opgg-static.akamaized.net/images/lol/perk/"+data[i].participants<%=i%>.perk0+".png'/>";
						html += "</tr><tr>"
						html += "<img class='minispell' src='//opgg-static.akamaized.net/images/lol/perkStyle/"+data[i].participants<%=i%>.perkSubStyle+".png'/>";
						html += "</table></td>";
						
						html += "<td>"+data[i].participants<%=i%>.summonerName+"</td>";
						//킬관여율
						if(<%=i%><6){
						html += "<td>"+data[i].participants<%=i%>.kills+"/"+data[i].participants<%=i%>.deaths+"/"+data[i].participants<%=i%>.assists+"</br>("+
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
							html += "<td>"+data[i].participants<%=i%>.kills+"/"+data[i].participants<%=i%>.deaths+"/"+data[i].participants<%=i%>.assists+"</br>("+
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
						/*더보기2팀*/
						html += "<div class='GameDetailResult_"+data[i].participants6.win+"'>";
						html += "<tr class='more'><td colspan='8'><table>";
						html += "<tr><th>챔피언</th><th>스펠</th><th>닉네임</th><th>KDA</th><th>피해량</th><th>CS</th><th>아이템</th></tr>"
						<% for(int i=6; i<11; i++) {%>
						if(data[i].participants<%=i%>.summonerName != Name){
							html += "<tr>";
						}
						else{
							html +="<tr style='background-color: white; border-color:white;'>";	
						}
						html += "<td>"+data[i].participants<%=i%>.champLevel+"<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].participants<%=i%>.championId+".png'/></td>";
						html += "<td><table style='border: none;'><tr>";
						html += "<img class='minispell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[i].participants<%=i%>.spell1Id+".png'/>";
						html += "</tr><tr>";
						html += "<img class='minispell' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/spell/"+data[i].participants<%=i%>.spell2Id+".png'/>";
						html += "</tr><tr>";
						html += "<img class='minispell' src='//opgg-static.akamaized.net/images/lol/perk/"+data[i].participants<%=i%>.perk0+".png'/>";
						html += "</tr><tr>"
						html += "<img class='minispell' src='//opgg-static.akamaized.net/images/lol/perkStyle/"+data[i].participants<%=i%>.perkSubStyle+".png'/>";
						html += "</table></td>";
						
						html += "<td>"+data[i].participants<%=i%>.summonerName+"</td>";
						//킬관여율
						if(<%=i%><6){
						html += "<td>"+data[i].participants<%=i%>.kills+"/"+data[i].participants<%=i%>.deaths+"/"+data[i].participants<%=i%>.assists+"</br>("+
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
							html += "<td>"+data[i].participants<%=i%>.kills+"/"+data[i].participants<%=i%>.deaths+"/"+data[i].participants<%=i%>.assists+"</br>("+
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
			 			
			 			//내 아이템빌드 - 이미지삽입
			 			
			 			for(var zz1 = 0; zz1<itemRe.length; zz1++){
			 					 html +="<li class='Item' style='display: inline-block;'>";
			 					 html +="<div class='ItemBar' style=''></div>";
			 					 html +="<ol class='Items' style='display: flex;'>";
			 				for(var yy1 = 0; yy1<itemRe[zz1].length; yy1++){
			 					 html +="<li><img class='item' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/item/"+itemRe[zz1][yy1]+".png'/></li>";
			 					
			 						
			 				}
			 				html +="</ol>";
			 				
			 				for(var yy1 = 0; yy1<itemRe[zz1].length; yy1++){
			 				if(zz1!=0 && yy1%3==0){
//			 						var times = ((Number(timeRe[zz1][yy1])+Number(timeRe[zz1][yy1+1])+Number(timeRe[zz1][yy1+2]))/timeRe[zz1].length).toFixed(0);
			 						var times = (Number(timeRe[zz1][yy1]).toFixed(0));
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
						html += "<div class='perk-wrap' stlye='display:flex;'>";
						html +="<div class='perk-page'>";
						
						
						//룬페이지 - 왼쪽 룬
			 			
			 			var PrimaryNum1 = 0;
			 			var PrimaryNum2 = 0;
			 			var PrimaryNum3 = 0;
			 			var PrimaryNum4 = 0;
			 				
			 			//정밀 - 8000
			 			if(me.perkPrimaryStyle == 8000){
			 				
			 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8000.png'></div></div>";
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
			 				
			 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8100.png'></div></div>";
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
			 				
			 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8200.png'></div></div>";
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
			 				
			 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8300.png'></div></div>";
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
			 				
			 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8400.png'></div></div>";
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
			 				
			 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8000.png'></div>";
			 				
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
			 				
			 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8000.png'></div>";
			 				
			 				
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
			 				
			 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8200.png'></div>";
			 				
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
			 				
			 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8300.png'></div>";
			 				
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
			 				
			 				html += "<div id='perk-page_row' style='display: table;'><div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perkStyle/8400.png'></div>";
			 				
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
			 			
			 			html +="</div></div>";
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
						
						html +="<div class='fragment-detail' style='display:flex;'>";
						
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
					
// 					//더보기 - 종합
// 					$("#").click(function(){
						
// 					});
					
// 					//더보기 - 빌드 
// 					$("#").click(function(){
						
// 					});
					
					var killResult = (kill/winloseTotal).toFixed(1);
					var deathResult = (death/winloseTotal).toFixed(1);
					var assistResult = (assist/winloseTotal).toFixed(1);
					
					var totalGrade =( (Number(kill)+Number(assist))/Number(death) ).toFixed(1);
					
	
					var totalkillratio =( Number(killratioTotal)/Number(winloseTotal)).toFixed(1);
					
					$("#Kill").text(killResult);
					$("#Death").text(deathResult);
					$("#Assist").text(assistResult);
					$("#KDARatioText").text(totalGrade);
					$("#Status_Kill").text(totalkillratio+"%");
					
					var mechapTop3 = new Array();
					
					for(var i in mechap){
						mechapSplit.push(mechap[i].split(","));
					}
					
					console.log(mechapSplit);
					
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
				console.log(t1Top3);
				
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
				for(var i in mechapSplit){
					if(mechapSplit[i][0] == Top1[0]){
						Top1Grade += Number(mechapSplit[i][2]);
						if(mechapSplit[i][1] == 'Win'){
							Top1Victory++;
						}
					}
					else if(mechapSplit[i][0] == Top2[0]){
						Top2Grade += Number(mechapSplit[i][2]);
						if(mechapSplit[i][1] == 'Win'){
							Top2Victory++;
						}
						
					}
					else if(mechapSplit[i][0] == Top3[0]){
						Top3Grade += Number(mechapSplit[i][2]);
						if(mechapSplit[i][1] == 'Win'){
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
				$("#top3 li:eq(0) div div#top3Image").append("<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+Top1[0]+".png'/>");
				$("#top3 li:eq(1) div div#top3Image").append("<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+Top2[0]+".png'/>");
				$("#top3 li:eq(2) div div#top3Image").append("<img class='mini' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+Top3[0]+".png'/>");
				
				$("#top3 li:eq(0) div div#top3Image").append(Top1[0]);
				$("#top3 li:eq(1) div div#top3Image").append(Top2[0]);
				$("#top3 li:eq(2) div div#top3Image").append(Top3[0]);
				
				$("#top3 li:eq(0) div div#top3WonLose").append("<b style='color: red;'>"+(Top1[2]/Top1[1])*100+"%   </b>"+"<span id='win' style='margin-right: 5px;'>("+Top1[2]+"승</span>"+"<span id='lose' style='margin-right: 5px;'>"+Top1[3]+"패)</span>"+"<span>"+(Top1[4].toFixed(1))+"평점</span>");
				$("#top3 li:eq(1) div div#top3WonLose").append("<b style='color: red;'>"+(Top2[2]/Top2[1])*100+"%   </b>"+"<span id='win' style='margin-right: 5px;'>("+Top2[2]+"승</span>"+"<span id='lose' style='margin-right: 5px;'>"+Top2[3]+"패)</span>"+"<span>"+(Top2[4].toFixed(1))+"평점</span>");
				$("#top3 li:eq(2) div div#top3WonLose").append("<b style='color: red;'>"+(Top3[2]/Top3[1])*100+"%   </b>"+"<span id='win' style='margin-right: 5px;'>("+Top3[2]+"승</span>"+"<span id='lose' style='margin-right: 5px;'>"+Top3[3]+"패)</span>"+"<span>"+(Top3[4].toFixed(1))+"평점</span>");
				
										
				},
				error : function(err){
					console.log("fail");
				}
			});
			
			var summonerId;
			
			$.ajax({
				url : "${pageContext.request.contextPath}/summoner/summonerProfile?summonerName="+Name,
				type : "GET",
				dataType : "json",
				success : function( data ){
					
					$("#icon").html("<img id='profileIcon' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/profileicon/"+ data.profileIconId +".png'>");
					$("#level").text(data.summonerLevel);
					$("#name").text(data.name);
				},
				error : function( xhr, txtStatus, err ){
					console.log( xhr, txtStatus, err );
				}
				
			});
			
			$.ajax({
 				url : "${pageContext.request.contextPath}/summoner/summonerRank?summonerId=" + summonerId,
				type : "GET",
				async : false,
				dataType : "json",
				success : function( data ){
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
		
	});
	</script>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
	


