<%@page import="com.kh.yapx3.stat.model.vo.ChampStat"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%
	List<ChampStat> list = (List<ChampStat>)request.getAttribute("list");
	List<String> imgList = (List<String>)request.getAttribute("imgList");
%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<style>
.Progress{
	display: inline-block;
    max-width: 60%;
    height: 8px;
    border: 1px solid #b8bfbf;
    background-color: #c3c8c8;
}
.Progress.Blue{
	background-color: #1f8ecd;
    border-color: #1a78ae;
}
.Progress.Yellow{
	background-color: #f6af2e;
    border-color: #d3962b;
}
.Progress.Green{
	background-color: #2daf7f;
    border-color: #249069;
}
.champImg{width: 32px; border-radius: 50%}
</style>
<script>
function statWin() {
	$.ajax({
		url: "${pageContext.request.contextPath}/stat/champStatWin.do",
		type : "get",
		dataType : "json",
		success : function(data){
			var html = "<tr><th style='width: 200px;'>챔피언</th><th onclick='statWinB()'>승률</th><th onclick='statPick()'>픽률</th><th onclick='statBan()'>밴률</th></tr>";
			for(var i in data){
				var winRate = data[i].win/data[i].pick*100;
				var pickRate = data[i].pick/42028*100;
				var banRate = data[i].ban/27543*100;
				html += "<tr><td><a href=''><img class='champImg' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].championName+".png'></a> "+data[i].id+"</td>";
				if(winRate > 50){
					html += "<td><div class='Progress Blue' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				}
				if(pickRate > 10){
					html += "<td><div class='Progress Yellow' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				}
				if(banRate > 30){
					html += "<td><div class='Progress Green' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				} else {
					html += "<td><div class='Progress' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				}
			}
			$("#statTable").html(html);
		},
		error : function(err){
			console.log("ajax호출 실패");
		}
	});
}
function statWinB() {
	$.ajax({
		url: "${pageContext.request.contextPath}/stat/champStatWinB.do",
		type : "get",
		dataType : "json",
		success : function(data){
			var html = "<tr><th style='width: 200px;'>챔피언</th><th onclick='statWin()'>승률</th><th onclick='statPick()'>픽률</th><th onclick='statBan()'>밴률</th></tr>";
			for(var i in data){
				var winRate = data[i].win/data[i].pick*100;
				var pickRate = data[i].pick/42028*100;
				var banRate = data[i].ban/27543*100;
				html += "<tr><td><a href=''><img class='champImg' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].championName+".png'></a> "+data[i].id+"</td>";
				if(winRate > 50){
					html += "<td><div class='Progress Blue' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				}
				if(pickRate > 10){
					html += "<td><div class='Progress Yellow' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				}
				if(banRate > 30){
					html += "<td><div class='Progress Green' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				} else {
					html += "<td><div class='Progress' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				}
			}
			$("#statTable").html(html);
		},
		error : function(err){
			console.log("ajax호출 실패");
		}
	});
}
function statPick() {
	$.ajax({
		url: "${pageContext.request.contextPath}/stat/champStatPick.do",
		type : "get",
		dataType : "json",
		success : function(data){
			var html = "<tr><th style='width: 200px;'>챔피언</th><th onclick='statWin()'>승률</th><th onclick='statPickB()'>픽률</th><th onclick='statBan()'>밴률</th></tr>";
			for(var i in data){
				var winRate = data[i].win/data[i].pick*100;
				var pickRate = data[i].pick/42028*100;
				var banRate = data[i].ban/27543*100;
				html += "<tr><td><a href=''><img class='champImg' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].championName+".png'></a> "+data[i].id+"</td>";
				if(winRate > 50){
					html += "<td><div class='Progress Blue' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				}
				if(pickRate > 10){
					html += "<td><div class='Progress Yellow' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				}
				if(banRate > 30){
					html += "<td><div class='Progress Green' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				} else {
					html += "<td><div class='Progress' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				}
			}
			$("#statTable").html(html);
		},
		error : function(err){
			console.log("ajax호출 실패");
		}
	});
}
function statPickB() {
	$.ajax({
		url: "${pageContext.request.contextPath}/stat/champStatPickB.do",
		type : "get",
		dataType : "json",
		success : function(data){
			var html = "<tr><th style='width: 200px;'>챔피언</th><th onclick='statWin()'>승률</th><th onclick='statPick()'>픽률</th><th onclick='statBan()'>밴률</th></tr>";
			for(var i in data){
				var winRate = data[i].win/data[i].pick*100;
				var pickRate = data[i].pick/42028*100;
				var banRate = data[i].ban/27543*100;
				html += "<tr><td><a href=''><img class='champImg' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].championName+".png'></a> "+data[i].id+"</td>";
				if(winRate > 50){
					html += "<td><div class='Progress Blue' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				}
				if(pickRate > 10){
					html += "<td><div class='Progress Yellow' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				}
				if(banRate > 30){
					html += "<td><div class='Progress Green' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				} else {
					html += "<td><div class='Progress' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				}
			}
			$("#statTable").html(html);
		},
		error : function(err){
			console.log("ajax호출 실패");
		}
	});
}
function statBan() {
	$.ajax({
		url: "${pageContext.request.contextPath}/stat/champStatBan.do",
		type : "get",
		dataType : "json",
		success : function(data){
			var html = "<tr><th style='width: 200px;'>챔피언</th><th onclick='statWin()'>승률</th><th onclick='statPick()'>픽률</th><th onclick='statBanB()'>밴률</th></tr>";
			for(var i in data){
				var winRate = data[i].win/data[i].pick*100;
				var pickRate = data[i].pick/42028*100;
				var banRate = data[i].ban/27543*100;
				html += "<tr><td><a href=''><img class='champImg' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].championName+".png'></a> "+data[i].id+"</td>";
				if(winRate > 50){
					html += "<td><div class='Progress Blue' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				}
				if(pickRate > 10){
					html += "<td><div class='Progress Yellow' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				}
				if(banRate > 30){
					html += "<td><div class='Progress Green' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				} else {
					html += "<td><div class='Progress' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				}
			}
			$("#statTable").html(html);
		},
		error : function(err){
			console.log("ajax호출 실패");
		}
	});
}
function statBanB() {
	$.ajax({
		url: "${pageContext.request.contextPath}/stat/champStatBanB.do",
		type : "get",
		dataType : "json",
		success : function(data){
			var html = "<tr><th style='width: 200px;'>챔피언</th><th onclick='statWin()'>승률</th><th onclick='statPick()'>픽률</th><th onclick='statBan()'>밴률</th></tr>";
			for(var i in data){
				var winRate = data[i].win/data[i].pick*100;
				var pickRate = data[i].pick/42028*100;
				var banRate = data[i].ban/27543*100;
				html += "<tr><td><a href=''><img class='champImg' src='http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/"+data[i].championName+".png'></a> "+data[i].id+"</td>";
				if(winRate > 50){
					html += "<td><div class='Progress Blue' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+winRate+"%'></div> "+winRate.toFixed(2)+"%</td>";
				}
				if(pickRate > 10){
					html += "<td><div class='Progress Yellow' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				} else {
					html += "<td><div class='Progress' style='width: "+pickRate+"%'></div> "+pickRate.toFixed(2)+"%</td>";
				}
				if(banRate > 30){
					html += "<td><div class='Progress Green' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				} else {
					html += "<td><div class='Progress' style='width: "+banRate+"%'></div> "+banRate.toFixed(2)+"%</td></tr>";
				}
			}
			$("#statTable").html(html);
		},
		error : function(err){
			console.log("ajax호출 실패");
		}
	});
}
</script>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1400px;margin-top:115px; min-height: 768px; margin-bottom: 15px;">    
   <table class="w3-table-all w3-card-4" id="statTable">
   <tr>
      <th style="width: 200px;">챔피언</th>
      <th onclick="statWin()">승률</th>
      <th onclick="statPick()">픽률</th>
      <th onclick="statBan()">밴률</th>
    </tr>
    <%for(int i=0; i<list.size(); i++) {%>
    	<tr>
    		<td>
    			<a href=""><img class="champImg" src="http://ddragon.leagueoflegends.com/cdn/9.18.1/img/champion/<%=imgList.get(i) %>.png" alt="" /></a>
    			<%=list.get(i).getChampionName() %>
    		</td>
    		<td>
    			<div class="Progress <%=(list.get(i).getWin()*1.0 / list.get(i).getPick())*100 >= 50 ? "Blue" : "" %>" style="width: <%=(list.get(i).getWin()*1.0 / list.get(i).getPick())*100 %>%;"></div>
    			<fmt:formatNumber value="<%=(list.get(i).getWin()*1.0 / list.get(i).getPick())*100 %>" pattern="0.00" />%
    		</td>
    		<td>
    			<div class="Progress <%=(list.get(i).getPick()*1.0/42028)*100 >= 10 ? "Yellow" : "" %>" style="width: <%=(list.get(i).getPick()*1.0/42028)*100 %>%;"></div>
    			<fmt:formatNumber value="<%=(list.get(i).getPick()*1.0/42028)*100 %>" pattern="0.00" />%
    		</td>
    		<td>
    			<div class="Progress <%=(list.get(i).getBan()*1.0/27543)*100 >= 30 ? "Green" : "" %>" style="width: <%=(list.get(i).getBan()*1.0/27543)*100%>%;"></div>
    			<fmt:formatNumber value="<%=(list.get(i).getBan()*1.0/27543)*100%>" pattern="0.00" />%
    		</td>
    	</tr>
    <%} %>
  </table>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>