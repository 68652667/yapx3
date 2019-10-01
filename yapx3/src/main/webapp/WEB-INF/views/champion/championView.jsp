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
#championList{
	test-align: center;
	padding: 0, 4;
	width: 800px;
}
#championAll{
	margin-left:10px; 
	margin-right:10px; 
	width: 800px;
}
#championLaneTitle{
	width: 800px;
	height: 50px;
	float: left;
}
#championSearch{
	margin-right: 25px;
	float: right;
	width: 250px;
	height: 50px;
}
ul {
	margin-left: 10px;
    list-style:none;
    margin:0;
    padding:0;
}
li {
	color: gray;
	width: 70px;
	text-align: center;
    margin: 0 0 0 0;
    padding: 0 0 0 0;
    border : 1px;
    float: left;
    font-size: 20px;
}
li:hover{
	border-bottom: 3px solid skyblue;
	cursor: pointer;
	color: skyblue;
}
</style>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:115px; min-height: 768px;">
<div id = "championList">
	<div id = "championLaneTitle">
		<ul>
			<li>전체</li>
			<li>탑</li>
			<li>미드</li>
			<li>정글</li>
			<li>바텀</li>
			<li>로테이션</li>
		</ul>
		<div id="championSearch">
			<input type="text"style="height:45px; width:200px; float:right;" placeholder="챔피언 검색 (가렌, ㄱㄹ, ...)"></input>
		</div>
	</div>
	<div id = "championAll">
		
	</div>
</div>
	
	<button id="getGameIdAllBtn">게임 아이디 전부 불러오기</button>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
<script>

function info(id){
	location.href = "${pageContext.request.contextPath}/champion/championInfo?championId=" + id;
}
	$(()=>{
		//챔피언 전부 불러오는 ajax
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
		
		$("#getGameIdAllBtn").on("click", ()=>{
			$.ajax({
				url:"${pageContext.request.contextPath}/match/gameMatch",
				type:"GET",
				dataType:"json",
				success: function(data){
					console.log(data);
					
				},
				error: function(err){
					console.log("sss");
				}
			});
		});
	});
</script>
</html>