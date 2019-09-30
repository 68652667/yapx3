<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<style>
.allChampion{
	padding: 4px;
}
#championAll{
	width: 800px;
}
</style>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:115px; min-height: 768px;">    
<!-- 소환사 정보 -->
	<input type="text" name="summonerName" id="summonerName" />
	<button id="searchBtn">소환사검색</button>
	
	<div id="summonerInfo">
		<table id="summonerInfoResult">
			<tr>
				<th>닉네임</th>
				<th>소환사 레벨</th>
			</tr>
		</table>
	</div>
	<input type="text" name="searchMastery" id="searchMastery" />
	<button id="searchMasteryBtn">소환사검색(championMastery)</button>
	<div id="MasteryInfo">
		<table id="searchMasteryInfoResult">
			<tr>
				<th>챔피언</th>
				<th>숙련도 포인트</th>
			</tr>
		</table>
	</div>
<!-- 이번주 챔피언 로테이션 -->
	<input type="text" name="championLotation" id="championLotation" />
	<button id="championBtn">이번주 로테이션 챔피언 보기</button>
	<div id="championInfo">
		<table id="championTable">
			<tr>
				<th>번호</th>
			</tr>
		</table>
	</div>
	
	<!-- 챔피언 전부 불러오기 -->
	<button id="championAllBtn">모든 챔피언 보기</button>
	<div id = "championAll">
		
	</div>
	
	<!-- 디비에 저장되어있는 게임 아이디 불러오기 -->
	<button id="matchListAllBtn">게임 아이디 값 불러오기</button>
	<div id="matchAll">
		
	</div>
	
	<!-- item List -->
	<button id="itemListBtn">아이템 불러오기</button>
	<div id="itemListAll">
		ss
	</div>
	<!-- sql문 만들기 -->
	<button id="createSQL">sql문 만들기</button>
	
	<button id="participantCallBtn">participant데이터 가져오기</button>
	
	<button id="itemListCallBtn">아이템 리스트 가져오기</button>
	
	<button id="selectChampion">임의의 챔피언 태스트용</button>
	
	<button id="getGameIdAllBtn">게임 아이디 전부 불러오기</button>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
<script>

function info(id){
	location.href = "${pageContext.request.contextPath}/champion/championInfo?championId=" + id;
}
	$(()=>{
		$("#getGameIdAllBtn").on("click", ()=>{
			$.ajax({
				url: "${pageContext.request.contextPath}/match/gameMatch",
				type: "GET",
				dataType: "json",
				success: function(data){
					console.log(data);
				},
				error: function(err){
					console.log("sssss");
				}
			});
		});
		
		$("#selectChampion").on("click", ()=>{
			$.ajax({
				url: "${pageContext.request.contextPath}/match/matchList/"+266,
				type: "GET",
				dataType: "json",
				success: function(data){
					console.log("쉬고싶다")
					console.log(data);
				},
				error: function (err) {
					console.log("쉬발 줮같아서 못해먹겟네");
				}
			});
		});
		$("#itemListAll").click(function(){
			var champId = $("#champId").val();
			$.ajax({
				url: "${pageContext.request.contextPath}/match/matchList/"+champId,
				type: "GET",
				dataType: "json",
				success: function(data) {
					console.log(data);
				},
				error : function(err){
					console.log("ss");
				}
			});
		});
		$("#itemListCallBtn").on("click", ()=>{
			$.ajax({
				url: "${pageContext.request.contextPath}/match/itemList",
				type: "GET",
				dataType: "json",
				success: function(data){
					console.log(data);
				},
				error: function(err){
					console.log("sss");
				}
			});
		});
		
		//participant불러오기
		$("#participantCallBtn").on("click", ()=>{
			$.ajax({
				url: "${pageContext.request.contextPath}/items/participantCall",
				type: "GET",
				dataType : "json",
				success: function(data){
					console.log(data);
				},
				error: function(err){
					console.log("ssss");
				}
			});
		});
		
		$("#itemListBtn").on("click",()=>{
			$.ajax({
				url: "${pageContext.request.contextPath}/items/insertChampionName",
				type : "GET",
				dataType : "json",
				success: function(data){
					console.log(data);
				},
				error : function(err){
					console.log("에러");
				}
			});
		});
		
		$("#matchListAllBtn").on("click", ()=>{
			$.ajax({
				url: "${pageContext.request.contextPath}/match/matchList",
				type : "GET",
				dataType : "json",
				success: function(data){
					console.log(data);
					$("#matchAll").append(data);
				},
				error: function(err){
					console.log("실패");
				}
			});
		});
		
		//모든 챔피언 불러오는 버튼
		$("#championAllBtn").on("click", ()=>{
			$.ajax({
				url: "${pageContext.request.contextPath}/champion/allChampion",
				type : "GET",
				dataType : "json",
				success : function(data){
					console.log(data);
					$.each(data, function(d, id){
						//var html = "<a href='${pageContext.request.contextPath}/api/champion/info?championId='"+id+"'><img class='allChampion' src = 'http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+id+".png'/></a>";
						var html = "<input type='hidden' id='champId' name='hidden' value=" + id + ">" +
								   "<img class='allChampion' onclick=info('"+id+"');  id="+ d +" src = 'http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+d+".png'/>"
								   
						$("#championAll").append(html);
					});
				}, error: function(err){
					console.log("sssss");
				}
			});
			
		});
		
		
		
		
		$("#searchBtn").on("click", ()=>{
			var summonerName = $("#summonerName").val();
			
			$.ajax({
				url : "api/search?summonerName="+summonerName,
				//url: "https://kr.api.riotgames.com/lol/summoner/v4/summoners/by-name/"+summonerName+"?api_key=RGAPI-65b2e42a-3890-4260-a232-ddb56b611074",
				type :"GET",
				dataType : "json",
				headers: {
				   'Access-Control-Allow-Credentials' : true,
				   'Access-Control-Allow-Origin':'*',
				   'Access-Control-Allow-Methods':'GET,POST,PUT,DELETE',
				   'Access-Control-Allow-Headers':'application/json', 
				},
				
				success : function(data){
					console.log(data);
					var table = $("#summonerInfoResult");
					var html = "<tr>" +
							   "<td>" + data.name + "</td>"+
							   "<td>" + data.summonerLevel + "</td>"+
							   "</tr>";
					table.append(html);
					$("#summonerInfo").html(table);
				},
				error : function(err){
					console.log("fail");
				}
			});
		});
		
		$("#searchMasteryBtn").on("click", ()=>{
			var searchMastery = $("#searchMastery").val();
			//location.href = "${pageContext.request.contextPath}/api/mastery?searchMastery="+searchMastery;
			$.ajax({
				url: "${pageContext.request.contextPath}/api/mastery?searchMastery="+searchMastery,
				type : "get",
				dataType : "json",
				success : function(data){
					var html = "";
					$("#searchMasteryInfoResult tr:gt(0)").remove();
					var table = $("#searchMasteryInfoResult");
					console.log(data);
					$.each(data, function(img, point){
							html = "<tr>" +
								    "<td style='text-align: center;'><img src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/" + img +"'/></td>" +
								    "<td>" + point + "</td>" +
								    "</tr>";
							table.append(html);
						}); 
					$("#MasteryInfo").html(table);
				}
			})
		});
		
		/* $("#championBtn").on("click", ()=>{
			
			$.ajax({
				url: "${pageContext.request.contextPath}/test/allChampion",
				type : "get",
				dataType : "json",
				success : function(data){
					console.log(data);
					var table = $("#championTable");
					$.each(data, function(i, c){
					$("#championTable").append("<img src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+ c.championId +".png'/>");
						var html = "<tr>" +
								   "</tr>";
						table.append(html);
					}); 
					$("#championInfo").html(table);
				},
				error : function(err){
					console.log("ajax호출 실패");
				}
			});
		}); */
	});
</script>
</html>