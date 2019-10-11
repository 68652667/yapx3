<%@ page language="java" contentType="text/html; charset=UTF-8"
   pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<link rel="stylesheet" href="https://unpkg.com/tippy.js@5/dist/backdrop.css" />
<script src="https://unpkg.com/popper.js@1"></script>
<script src="https://unpkg.com/tippy.js@5"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/handlebars.js/3.0.1/handlebars.js"></script>
<link href="https://fonts.googleapis.com/css?family=Nanum+Pen+Script&display=swap&subset=korean" rel="stylesheet">
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.em3but {height: 3em;}

.championHeaderInfo{
	width: 800px;
	height: 300px;
	background: #292e38;
	padding: 30px;
	position: relative;
	font-family: 'Nanum Pen Script', cursive;
	font-size: 30px;
}
.championInfoBody{
	font-family: 'Nanum Pen Script', cursive;
	font-size: 30px;
}
.championHeaderImg{
	color: white;
	text-align: center;
	display: inline-block;
}
.championHeaderImg img{
	width: 150px;
	height: 150px;
}
.championHeaderSkillInfo{
	position: absolute;
	bottom: 0px;
}
.championHeaderSkill img{
	width: 50px;
	height: 50px;
	display: inline-block;
}
.itemImg{
	margin-left: 25px;
}

.championHeaderSkill{
	display: inline;
	float: right;
}
#nickName{
	margin-top: 0px;
	display: inline-block;
	position: absolute;
}
.championSkill{
	display: inline;
	position: relative;
	float: left;
	margin-top: 100px;
	margin-left: 15px;
}
.championSkill span{
	z-index: 100;
	position: absolute;
	color: white;
	font-size: 24px;
	font-weight: bold;
	right: 5px;
	float:left;
}
.percent{
	font-size: 30px;
}
.championPosition{
	background: #2e7fdd;
	width:200px;
	font-size: 20px;
}
.championPosition img{
	height: 30px;
	width: 30px;
}
h2{
	font-family: 'Nanum Pen Script', cursive;
}
ul {
	margin-left: 10px;
    list-style:none;
    margin:0;
    padding:0;
}
li {
	color: white;
	width: 70px;
	text-align: center;
	margin-top: 15px;
    border : 1px;
    float: left;
    font-size: 20px;
}
.chapmpionTipCount{
   	text-align: -webkit-left;
}
.chapmpionTipCount span, .chapmpionTipCount h3{
	display: inline-block;
}
.championTipWriteDiv{
	display: block;
	width:800px;
}
.championTipList{
	width: 800px;
	height: auto;
	position: relative;
	background: white;
	margin-top: 50px;
}
.championTipList ul{
	width: 800px;
	height: auto;
}
.championTipContent{
	color: black;
	margin-top: -46px;
}
.championTipList .championTip  {
	width:800px;
	text-align: left;
}
.championTipList .championTipContent{
	margin-left: 30px;
}
.writerUser{
	margin-top: -50px;
	text-align: left;
}
.writerContent{
	width: 500px;
	height: 70px;
	text-align: left;
}
.championTipList .championTipExtra{
	float: right;
	margin-top: 30px;
}
.menu ul li:hover{
	border-bottom: 3px solid skyblue;
	cursor: pointer;
	color: skyblue;
}
#tipFrm{
	background: white;
	height:auto;
}
.tirg{
	font-size: 20px;
}
.menu{	
	position: absolute;
	float: right;
	bottom: 0px;
	right: 0px;
	font-size: 20px;
}
.like{
	border: 0;
	outline: 0;
	text-align: left;
	
}
#content{
	margin-left: 100px;
	width: 530px;
}
[name=tipWriter]{
	height: 20px;
	margin-top: 10px;
}
[name=itemImg], [name=spell]{
	margin-left: 25px;
}

</style>
<script>


	$(()=>{
		var memberLoggedIn = "${memberLoggedIn.userEmail}";
        console.log( "${memberLoggedIn.userEmail}" );
        $("[name=content]").on( "click", function(){
            if( memberLoggedIn == "" ){
                alert("로그인후 사용가능합니다 !")
                location.href="${pageContext.request.contextPath}/user/loginClick.do";
            }
        });

		$(".championLaneInfo ul li:gt(0)").css('margin-left','10px');
		$("#championTipLi").on("click", ()=>{
			$(".championInfoBody").css("display", "none");
			$(".championTipBody").css("display", "block");
		});
		$("#championInfoLi").on("click", ()=>{
			$(".championTipBody").css("display", "none");
			$(".championInfoBody").css("display", "block");
		});
		
		$(".itemImg").mouseenter(function(e){
			var id = $(e.target).attr("itemkey");
			var ssss;
			$.ajax({
				url: "${pageContext.request.contextPath}/champion/itemInfo?itemId=" + id,
				type: "GET",
				success:function(data){
					tippy('#item'+id, {
					  	content: "<div class='tirg'>"+data+"</div>",
					});
				},
				error: function(err){
					console.log("fail");
				}
			});
		});
		
		$("[name=itemImg]").mouseenter(function(e){
			var id = $(e.target).attr("start");
			$.ajax({
				url: "${pageContext.request.contextPath}/champion/itemInfo?itemId=" + id,
				type: "GET",
				success:function(data){
					tippy('.start1'+id, {
					  	content: "<div class='tirg'>"+data+"</div>",
					});
					tippy('.start2'+id, {
					  	content: "<div class='tirg'>"+data+"</div>",
					});
					tippy('.start3'+id, {
					  	content: "<div class='tirg'>"+data+"</div>",
					});
				},
				error: function(err){
					console.log("fail");
				}
			});
			
		});
		
		$("[name=spell]").mouseenter(function(e){
		var spell = $(e.target).attr("class");
			$.ajax({
				url: "${pageContext.request.contextPath}/champion/summonerInfo?spellName=" + spell,
				type: "GET",
				success:function(data){
					console.log(data);
					tippy("#spell1"+spell, {
					  	content: "<div class='tirg'>"+data+"</div>",
					});
					tippy("#spell2"+spell, {
					  	content: "<div class='tirg'>"+data+"</div>",
					});
				},
				error: function(err){
					console.log("fail");
				}
			});
			
		});
		tippy('#passive', {
		  	content: "<div class='tirg'>'${championSkillToolTip.passivSkillTolltip}'</div>",
		});
		tippy('#qskill', {
		  	content: "<div class='tirg'>'${championSkillToolTip.qSkillTolltip}'</div>",
		});
		tippy('#wskill', {
		  	content: "<div class='tirg'>'${championSkillToolTip.wSkillTolltip}'</div>",
		});
		tippy('#eskill', {
		  	content: "<div class='tirg'>'${championSkillToolTip.eSkillTolltip}'</div>",
		});
		tippy('#rskill', {
		  	content: "<div class='tirg'>'${championSkillToolTip.rSkillTolltip}'</div>",
		});
		
		
		$(".like").on("click", (e)=>{
			var tipNo = $(e.target).val();
			var likeType = $(e.target).attr("id");
			var userEmail = $(e.target).attr("userEmail");
			var like = $(e.target).attr("like");
			location.href="${pageContext.request.contextPath}/champion/championTipLike?tipNo="+tipNo+"&likeType="+likeType+"&userEmail="+userEmail+"&like="+like;
		});
	});
	function check(){
		var content = $("[name=content]").val();
		
		if(content == ""){
			alert("내용을 입력하세요");
			return false;
		}
		return true;
	}
</script>
<div class="w3-container w3-content" style="max-width:1400px;margin-top:115px; min-height: 768px;text-align: -webkit-center;">
	<div class="championHeaderInfo">
		<div class="championLaneInfo">
			<ul>
				<c:forEach items="${championLaneList }" var="lane">
					<c:choose>
						<c:when test="${lane.championLane eq '탑'}">
							<li class="championPosition" >
								<img src="//opgg-static.akamaized.net/images/site/champion/position-top-over@2x.png" alt=""/>
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
				<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/${championSkillInfo.championId }.png"/>
				<h2>${championSkillInfo.championName }</h2>
			</div>
			<div class="championHeaderSkill">
			<!-- 챔피언 스킬 -->
				<div class="championSkill">
				<!-- 스킬 이미지 -->
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/passive/${championSkillInfo.passive }" id="passive">
					<span>P</span>
				</div>
				<div class="championSkill">
				<!-- 스킬 이미지 -->
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/${championSkillInfo.qSkill }" id="qskill" >
					<span>Q</span>
				</div>
				<div class="championSkill">
				<!-- 스킬 이미지 -->
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/${championSkillInfo.wSkill }" id="wskill">
					<span>W</span>
				</div>
				<div class="championSkill">
				<!-- 스킬 이미지 -->
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/${championSkillInfo.eSkill }" id="eskill" >
					<span>E</span>
				</div>
				<div class="championSkill">
				<!-- 스킬 이미지 -->
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/${championSkillInfo.rSkill }" id="rskill" >
					<span>R</span>
				</div>
			</div>
		</div>
		<div class="menu">
			<ul>
				<li id="championInfoLi">챔피언 정보</li>
				<li id="championTipLi">챔피언 팁</li>
			</ul>
		</div>
	</div>
	<div class="championInfoBody">
		<div class="menuSelectInfo">
			<table class="table table-bordered" style="width:800px; " >
				
				<tr><th >소환사 주문</th><th style="text-align: center; width:40px;">픽률</th><th style="text-align: center; width:40px;">승률</th></tr>
					<c:forEach items="${summonerSkillList }" var="spell">
						<tr>
							<td><img src="//opgg-static.akamaized.net/images/lol/spell/${spell.summonerSpell1id }.png?image=w_42&v=15354684000" name="spell" id="spell1${spell.summonerSpell1id }" class="${spell.summonerSpell1id }"/>
								<img src="//opgg-static.akamaized.net/images/lol/spell/${spell.summonerSpell2id }.png?image=w_42&v=15354684000" name="spell" id="spell2${spell.summonerSpell2id }" class="${spell.summonerSpell2id }"/></td>
							<td style="text-align:center; font-size:20px;">${spell.summonerSpellCountStr }</td>
							<td style="text-align:center; font-size:20px;">${spell.summonerSpellWinCountStr }</td>
						</tr>
					</c:forEach>
			</table>
			<table class="table table-bordered" style="width:800px; ">
				<tr><th>시작 아이템</th><th style="text-align: center; width:40px;">픽률</th></tr>
					<tr>
						<td><img src="//opgg-static.akamaized.net/images/lol/item/${championItemListSum.startItem1 }.png?image=w_42&v=1" name="itemImg" start="${championItemListSum.startItem1 }" class="start1${championItemListSum.startItem1 }" alt="" /> 
							<img src="//opgg-static.akamaized.net/images/lol/item/${championItemListSum.startItem2 }.png?image=w_42&v=1" name="itemImg" start="${championItemListSum.startItem2 }"  class="start2${championItemListSum.startItem2 }"alt="" /></td>
							<td style="text-align:center; font-size:20px;" class="percent">${championItemListSum.itemStartPercent1 }</td>
					</tr>
					<tr>
						<td><img src="//opgg-static.akamaized.net/images/lol/item/${championItemListSum.startItem1 }.png?image=w_42&v=1" name="itemImg" start="${championItemListSum.startItem1 }" class="start1${championItemListSum.startItem1 }" alt="" /> 
							<img src="//opgg-static.akamaized.net/images/lol/item/${championItemListSum.startItem3 }.png?image=w_42&v=1" name="itemImg" start="${championItemListSum.startItem3 }" class="start3${championItemListSum.startItem3 }"alt="" /></td>
							<td style="text-align:center; font-size:20px;"class="percent">${championItemListSum.itemStartPercent2 }</td>
					</tr>
			</table>
			<table class="table table-bordered" style="width:800px; ">
				<tr><th>최종 아이템</th></tr>
				<c:set var="i" value="0"/>
				<c:set var="j" value="6"/>
				<c:forEach var="entry" items="${itemCountList }">
					<c:if test="${i % j == 0}">
						<tr>
							<td>
					</c:if>
							<img src="//opgg-static.akamaized.net/images/lol/item/${entry }.png?image=w_42&v=1"name="items" class="itemImg" itemkey="${entry }" id="item${entry }" alt="" /> 
					<c:if test="${i%j == j-1 }">
							</td>
						</tr>
					</c:if>
					<c:set var="i" value="${i+1}"/>
				</c:forEach>
			</table>
		</div>
		<jsp:include page="/WEB-INF/views/common/championInfoTable.jsp"/>
	</div>
	<div class="championTipBody" style="display: none;">
		<div class="chapmpionTipCount" style="width: 800px; margin-left:0px;">
			<span>등록된 팁</span>
			<h3>${championTipListCount }</h3>
		</div>
		<div class="championTipWriteDiv">
			<form action="${pageContext.request.contextPath }/champion/championTipWrite" id="tipFrm" method="post" onsubmit="return check();">
				<input type="hidden" name="email" value="${memberLoggedIn.userEmail}"/>
				<input type="hidden" name="tipWriter" value="${memberLoggedIn.userNickname }"/>
				<div class="form-group">
				    <span class="badge badge-secondary" style="width: 70px; height: 20px; float: left;">${memberLoggedIn.userNickname }</span>
				    <textarea class="form-control" id="exampleFormControlTextarea1" rows="3"  name="content"  style="resize: none; border:0; background:clear;" placeholder="내용을 입력하세요"></textarea>
					<input type="submit" class="btn btn-success" style="float:right;" value="등록" />
			    </div>
			</form>
			<div class="championTipList">
				<div class="form-group">
					<c:forEach items="${championTipList }" var="tip">
						<ul>
							<div class="championTip" id="${tip.champTipNo }">
							<input type="hidden" id="${tip.champTipNo }">
							<button value="${tip.champTipNo }" like="${tip.champTipLike }" userEmail="${tip.userEmail }" class="like" id="up">&and;</button>
							<br>
								<span class="badge badge-pill badge-info" style="font-size: 12px;">${tip.champTipLike }</span>
							<br>
							</div>
							<div class="championTipContent">
							<span class="badge badge-secondary" style="width: 70px; height: 20px; float: left;">${tip.userNickName }</span>
								<textarea class="form-control" id="exampleFormControlTextarea1" rows="3"  name="tipContent"  style="resize: none; border:0; background:clear;" readonly="readonly" placeholder="내용을 입력하세요">${tip.champTipContent }</textarea>
							</div>
						</ul>
					</c:forEach>
				</div>
			</div>
		</div>
	</div>
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"/> 