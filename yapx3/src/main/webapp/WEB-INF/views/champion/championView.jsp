<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<style>
#championList{
	test-align: center;
	padding: 0, 4;
	width: 800px;
}
#championAll{
	margin-left:10px; 
	margin-right:10px; 
	width: 600px;
}
#championAll img{
	width: 100px;
	padding: 4px;
}
#championLaneTitle{
	width: 800px;
	height: 50px;
	text-align: center;
	float: left;
}
#championSearch input{
	height:45px;
	width:186px; 
	float:left;
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
	margin-top: 15px;
    border : 1px;
    float: left;
    font-size: 10px;
}
li:hover{
	border-bottom: 3px solid skyblue;
	cursor: pointer;
	color: skyblue;
}
.allChampion:hover{
	cursor: pointer;
}

</style>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:115px; min-height: 768px;">
<div id = "championList">
	<div id = "championLaneTitle">
		<ul>
			<li id="all" value="전체">전체</li>
			<li id="TOP" value="탑">탑</li>
			<li id="MIDDLE" value="미드">미드</li>
			<li id="JUNGLE" value="정글">정글</li>
			<li id="BOTTOM" value="바텀">바텀</li>
			<li id="LOTATION" value="로테이션">로테이션</li>
		</ul>
		<div id="championSearch">
			<input type="text" placeholder="챔피언 검색 (가렌, ㄱㄹ, ...)" id="searchName"></input>
		</div>
	</div>
	<div id = "championAll">
		
	</div>
</div>
	
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>
<script>

function info(id){
	location.href = "${pageContext.request.contextPath}/champion/championInfo?championId=" + id;
	//location.href = "${pageContext.request.contextPath}/match/matchList/" + id;
}
	$(()=>{
		//챔피언 전부 불러오는 ajax
		$.ajax({
			url: "${pageContext.request.contextPath}/champion/allChampion",
			type : "GET",
			dataType : "json",
			success : function(data){
				console.log(data);
				$.each(data, function(index, value){
					var html = "<input type='hidden' id='champId' name='hidden' value=" + value.championId + ">" +
							   "<img class='allChampion' onclick=info('"+value.championKey+"'); title="+value.championName+"  id="+ value.championKey +" src = 'http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+value.championId+".png'/>"
					$("#championAll").append(html);
				});
			}, error: function(err){
				console.log("sssss");
			}
		});
		
		$("#searchName").keyup(()=>{
			var text = $("#searchName").val();
			if(text == ""){
				$.ajax({
					url: "${pageContext.request.contextPath}/champion/allChampion",
					type : "GET",
					dataType : "json",
					success : function(data){
						$("#championAll").empty();
						$.each(data, function(index, value){
							var html = "<input type='hidden' id='champId' name='hidden' value=" + value.championId + ">" +
									   "<img class='allChampion' onclick=info('"+value.championKey+"'); title="+value.championName+"  id="+ value.championKey +" src = 'http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+value.championId+".png'/>"
							$("#championAll").append(html);
						});
					}, error: function(err){
						console.log("sssss");
					}
				});
				
			}else{
				$.ajax({
					url:"${pageContext.request.contextPath}/champion/searchChampion?searchChampionName=" +text,
					type:"GET",
					dataType:"json",
					contentType:'application/x-www-form-urlencoded; charset=utf-8',
					success: function(data){
						$("#championAll").empty();
						$.each(data, function(index, value){
							//var html = "<a href='${pageContext.request.contextPath}/api/champion/info?championId='"+id+"'><img class='allChampion' src = 'http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+id+".png'/></a>";
							if(value != null){
								console.log(value);
								var html = "<input type='hidden' id='champId' name='hidden' value=" + value.championId + ">" +
										   "<img class='allChampion' onclick=info('"+value.championKey+"'); title="+value.championName+"  id="+ value.championId +" src = 'http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+value.championId+".png'/>"
								$("#championAll").append(html);
							}
						});
					},
					error: function(err){
						console.log("fail");
					}
				});
			}
		
		});
		
		$("ul li").on("click", (e)=>{
			var title = $(e.target).attr("value");
			$.ajax({
				url:"${pageContext.request.contextPath}/champion/allChampion",
				type:"GET",
				dataType:"json",
				success: function(data){
					$("#championAll").empty();
					$.each(data, function(index, value){
						//var html = "<a href='${pageContext.request.contextPath}/api/champion/info?championId='"+id+"'><img class='allChampion' src = 'http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+id+".png'/></a>";
						if(title == value.lane1 || title == value.lane2){
							var html = "<input type='hidden' id='champId' name='hidden' value=" + value.championId + ">" +
									   "<img class='allChampion' onclick=info('"+value.championKey+"'); title="+value.championName+"  id="+ value.championId +" src = 'http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+value.championId+".png'/>"
							$("#championAll").append(html);
						}else if(title == "전체"){
							var html = "<input type='hidden' id='champId' name='hidden' value=" + value.championId + ">" +
									   "<img class='allChampion' onclick=info('"+value.championKey+"'); title="+value.championName+"  id="+ value.championId +" src = 'http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+value.championId+".png'/>"
							$("#championAll").append(html);
						}
					});
				},
				error: function(err){
					console.log("fail");
				}
			})
		});
	});
</script>
</html>