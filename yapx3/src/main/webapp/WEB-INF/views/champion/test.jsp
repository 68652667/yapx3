<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<c:forEach items="${play }" var="play">
	<hr />
	${play.accountId }
	${play.lane} 
	${play.championId } 
	${play.gameId }
</c:forEach>
</body>
<script>
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
		
		html += "<div style='display: table-cell'><img src='//opgg-static.akamaized.net/images/lol/perk/9111.png";
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
</script>
</html>