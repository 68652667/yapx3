<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<style>
.championPerkPage, .championSubPerkPage, .subPerkPage{
	display: block;
	text-align: -webkit-center;
	padding: 0px;
}
.championPerkPage img, .championSubPerkPage img{
	width: 35px;
	margin-top: 10px;
	margin-left: 10px;
}
.perkRow{
	text-align: -webkit-center;
}
.perkSubTitle{
	display: inline-block;
}
.subPerkPage img{
	width: 25px;
	margin-top:20px;
	margin-left: 10px;
}
.championPerkDiv{
	text-align: center;
}
.subPerk{
	margin-bottom: -500px;
}

</style>
<table class="table table-bordered" style="width:800px; ">
	<thead>
      <tr>
      	<th colspan="3">룬</th>
      	<th style="text-align: center; width:40px;">픽률</th>
      </tr>
    </thead>
	<c:forEach items="${championPerkList}" var="perk">
		<tr>
			<td>
					<div class="championPerkPage">
						<!-- 룬 8000 -->
						<c:if test="${perk.perkPrimaryStyle == 8000 }">
							<div id="perk8000">
								<div class="perkPraimaryTitle"><img src="//opgg-static.akamaized.net/images/lol/perkStyle/${perk.perkPrimaryStyle}.png"></div>
								<div class="perkRow">
									<div class="rowPerk1_0">
										<c:if test="${perk.perk0 == 8005}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8005.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8008.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8021.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8010.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk0 == 8008}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8005.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8008.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8021.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8010.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk0 == 8021}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8005.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8008.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8021.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8010.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk0 == 8010}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8005.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8008.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8021.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8010.png"></div>
										</c:if>
									</div>
								</div>
							
								<div class="perkRow">
									<div class="rowPerk1_1">
										<c:if test="${perk.perk1 == 9101}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9101.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9111.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8009.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk1 == 9111}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9101.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9111.png?"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8009.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk1 == 8009}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9101.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9111.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8009.png"></div>
										</c:if>
									</div>
								</div>
								<div class="perkRow">
									<div class="rowPerk1_2">
										<c:if test="${perk.perk2 == 9104}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9104.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9105.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9103.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk2 == 9105}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9104.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9105.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9103.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk2 == 9103}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9104.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9105.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9103.png"></div>
										</c:if>
									</div>
								</div>
								<div class="perkRow">
									<div class="rowPerk1_3">
										<c:if test="${perk.perk3 == 8014}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8014.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8017.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8299.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk3 == 8017}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8014.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8017.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8299.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk3 == 8299}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8014.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8017.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8299.png"></div>
										</c:if>
									</div>
								</div>
							</div>
						</c:if>
						<!-- 룬 8100 -->
						<c:if test="${perk.perkPrimaryStyle == 8100 }">
							<div id="perk8100">
								<div class="perkPraimaryTitle"><img src="//opgg-static.akamaized.net/images/lol/perkStyle/${perk.perkPrimaryStyle}.png"></div>
								<div class="perkRow">
									<div class="rowPerk1_0">
										<c:if test="${perk.perk0 == 8112}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8112.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8124.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8128.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9923.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk0 == 8124}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8112.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8124.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8128.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9923.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk0 == 8128}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8112.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8124.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8128.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9923.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk0 == 9923}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8112.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8124.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8128.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9923.png"></div>
										</c:if>
									</div>
								</div>
							
								<div class="perkRow">
									<div class="rowPerk1_1">
										<c:if test="${perk.perk1 == 8126}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8126.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8139.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8143.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk1 == 8139}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8126.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8139.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8143.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk1 == 8143}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8126.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8139.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8143.png"></div>
										</c:if>
									</div>
								</div>
								<div class="perkRow">
									<div class="rowPerk1_2">
										<c:if test="${perk.perk2 == 8136}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8136.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8120.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8138.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk2 == 8120}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8136.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8120.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8138.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk2 == 8138}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8136.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8120.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8138.png"></div>
										</c:if>
									</div>
								</div>
								<div class="perkRow">
									<div class="rowPerk1_3">
										<c:if test="${perk.perk3 == 8135}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8135.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8134.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8105.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8106.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk3 == 8134}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8135.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8134.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8105.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8106.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk3 == 8105}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8135.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8134.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8105.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8106.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk3 == 8106}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8135.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8134.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8105.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8106.png"></div>
										</c:if>
									</div>
								</div>
							</div>
						</c:if>
						<!-- 룬 8200 -->
						<c:if test="${perk.perkPrimaryStyle == 8200 }">
							<div id="perk8200">
								<div class="perkPraimaryTitle"><img src="//opgg-static.akamaized.net/images/lol/perkStyle/${perk.perkPrimaryStyle}.png"></div>
								<div class="perkRow">
									<div class="rowPerk1_0">
										<c:if test="${perk.perk0 == 8214}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8124.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8229.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8230.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk0 == 8229}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8124.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8229.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8230.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk0 == 8230}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8124.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8229.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8230.png"></div>
										</c:if>
									</div>
								</div>
							
								<div class="perkRow">
									<div class="rowPerk1_1">
										<c:if test="${perk.perk1 == 8224}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8224.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8226.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8275.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk1 == 8226}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8224.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8226.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8275.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk1 == 8275}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8224.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8226.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8275.png"></div>
										</c:if>
									</div>
								</div>
								<div class="perkRow">
									<div class="rowPerk1_2">
										<c:if test="${perk.perk2 == 8210}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8210.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8234.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8233.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk2 == 8234}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8210.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8234.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8233.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk2 == 8233}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8210.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8234.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8233.png"></div>
										</c:if>
									</div>
								</div>
								<div class="perkRow">
									<div class="rowPerk1_3">
										<c:if test="${perk.perk3 == 8237}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8237.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8232.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8236.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk3 == 8232}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8237.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8232.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8236.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk3 == 8236}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8237.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8232.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8236.png"></div>
										</c:if>
									</div>
								</div>
							</div>
						</c:if>
						<!-- 룬 8300 -->
						<c:if test="${perk.perkPrimaryStyle == 8300 }">
							<div id="perk8300">
								<div class="perkPraimaryTitle"><img src="//opgg-static.akamaized.net/images/lol/perkStyle/${perk.perkPrimaryStyle}.png"></div>
								<div class="perkRow">
									<div class="rowPerk1_0">
										<c:if test="${perk.perk0 == 8351}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8351.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8359.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8360.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk0 == 8359}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8351.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8359.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8360.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk0 == 8360}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8351.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8359.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8360.png"></div>
										</c:if>
									</div>
								</div>
							
								<div class="perkRow">
									<div class="rowPerk1_1">
										<c:if test="${perk.perk1 == 8306}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8306.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8304.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8313.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk1 == 8304}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8306.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8304.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8313.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk1 == 8313}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8306.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8304.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8313.png"></div>
										</c:if>
									</div>
								</div>
								<div class="perkRow">
									<div class="rowPerk1_2">
										<c:if test="${perk.perk2 == 8321}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8321.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8316.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8345.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk2 == 8316}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8321.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8316.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8345.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk2 == 8345}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8321.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8316.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8345.png"></div>
										</c:if>
									</div>
								</div>
								<div class="perkRow">
									<div class="rowPerk1_3">
										<c:if test="${perk.perk3 == 8347}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8347.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8410.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8352.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk3 == 8410}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8347.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8410.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8352.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk3 == 8352}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8347.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8410.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8352.png"></div>
										</c:if>
									</div>
								</div>
							</div>
						</c:if>
						<!-- 룬 8400 -->
						<c:if test="${perk.perkPrimaryStyle == 8400 }">
						<div id="perk8400">
							<div class="perkPraimaryTitle"><img src="//opgg-static.akamaized.net/images/lol/perkStyle/${perk.perkPrimaryStyle}.png"></div>
							<div class="perkRow">
								<div class="rowPerk1_0">
									<c:if test="${perk.perk0 == 8437}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8437.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8439.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8465.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk0 == 8439}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8437.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8439.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8465.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk0 == 8465}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8437.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8439.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8465.png"></div>
									</c:if>
								</div>
							</div>
						
							<div class="perkRow">
								<div class="rowPerk1_1">
									<c:if test="${perk.perk1 == 8446}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8446.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8463.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8401.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk1 == 8463}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8446.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8463.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8401.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk1 == 8401}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8446.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8463.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8401.png"></div>
									</c:if>
								</div>
							</div>
							<div class="perkRow">
								<div class="rowPerk1_2">
									<c:if test="${perk.perk2 == 8429}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8429.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8444.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8473.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk2 == 8444}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8429.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8444.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8473.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk2 == 8473}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8429.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8444.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8473.png"></div>
									</c:if>
								</div>
							</div>
							<div class="perkRow">
								<div class="rowPerk1_3">
									<c:if test="${perk.perk3 == 8451}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8451.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8453.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8242.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk3 == 8453}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8451.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8453.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8242.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk3 == 8242}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8451.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8453.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8242.png"></div>
									</c:if>
								</div>
							</div>
						</div>
					</c:if>
					</div>
				</td>
		<!-- 서브룬 코드 -->
				<td>
					<div class="championSubPerkPage">
						<!-- 서브 룬 8000 -->
						<c:if test="${perk.perkSubStyle == 8000}">
							<div id="subPerk800">
								<div class="perkSubTitle"><br /><img src="//opgg-static.akamaized.net/images/lol/perkStyle/${perk.perkSubStyle}.png"></div>
								<div class="perkRow">
							<!-- 첫번째 라인 -->
									<div class = "rowPerk2_1">
										<c:if test="${perk.perk4 == 9101 or perk.perk5 == 9101}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9101.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9111.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8009.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 9111 or perk.perk5 == 9111}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9101.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9111.png?"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8009.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8009 or perk.perk5 == 8009}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9101.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9111.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8009.png"></div>
										</c:if>
										<!--1번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 9101 and perk.perk4 != 9111 and perk.perk4 != 8009 and perk.perk5 != 9101 and perk.perk5 != 9111 and perk.perk5 != 8009}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9101.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9111.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8009.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
										<!-- 2번째 라인 -->
									<div class="rowPerk2_1">
										<c:if test="${perk.perk4 == 9104  or perk.perk5 == 9104}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9104.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9105.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9103.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 9105 or perk.perk5 == 9105}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9104.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9105.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9103.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 9103 or perk.perk5 == 9103}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9104.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9105.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9103.png"></div>
										</c:if>
										<!--2번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 9104 and perk.perk4 != 9105 and perk.perk4 != 9103 and perk.perk5 != 9104 and perk.perk5 != 9105 and perk.perk5 != 9103}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9104.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9105.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/9103.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
										<!-- 3번째 라인 -->
									<div class="rowPerk2_3">
										<c:if test="${perk.perk4 == 8014 or perk.perk5 == 8014}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8014.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8017.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8299.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8017 or perk.perk5 == 8017}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8014.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8017.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8299.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8299 or perk.perk5 == 8299}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8014.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8017.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8299.png"></div>
										</c:if>
										<!--3번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8014 and perk.perk4 != 8017 and perk.perk4 != 8299 and perk.perk5 != 8014 and perk.perk5 != 8017 and perk.perk5 != 8299}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8014.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8017.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8299.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
								</div>
							</div>
						</c:if>
						<!-- 서브 룬 8100 -->
						<c:if test="${perk.perkSubStyle == 8100}">
							<div id="subPerk8100">
								<div class="perkSubTitle"><br /><img src="//opgg-static.akamaized.net/images/lol/perkStyle/${perk.perkSubStyle}.png"></div>
								<div class="perkRow">
								<!-- 첫번째 라인 -->
									<div class="rowPerk2_1">
										<c:if test="${perk.perk4 == 8126 or perk.perk5 == 8126}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8126.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8139.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8143.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8139 or perk.perk5 == 8139}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8126.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8139.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8143.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8143 or perk.perk5 == 8143}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8126.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8139.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8143.png"></div>
										</c:if>
										<!--1번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8126 and perk.perk4 != 8139 and perk.perk4 != 8143 and perk.perk5 != 8126 and perk.perk5 != 8139 and perk.perk5 != 8143}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8126.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8139.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8143.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
										<!-- 2번째 라인 -->
									<div class="rowPerk2_2">
										<c:if test="${perk.perk4 == 8136  or perk.perk5 == 8136}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8136.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8120.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8138.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8120 or perk.perk5 == 8120}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8136.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8120.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8138.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8138 or perk.perk5 == 8138}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8136.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8120.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8138.png"></div>
										</c:if>
										<!--2번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8136 and perk.perk4 != 8120 and perk.perk4 != 8138 and perk.perk5 != 8136 and perk.perk5 != 8120 and perk.perk5 != 8138}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8136.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8120.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8138.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
								</div>
									<!-- 3번째 라인 -->
								<div class="rowPerk2_3">
									<c:if test="${perk.perk4 == 8135 or perk.perk5 == 8135}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8135.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8134.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8105.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8106.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk4 == 8134 or perk.perk5 == 8134}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8135.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8134.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8105.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8106.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk4 == 8105 or perk.perk5 == 8105}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8135.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8134.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8105.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8106.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.perk4 == 8106 or perk.perk5 == 8106}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8135.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8134.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8105.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8106.png"></div>
									</c:if>
									<!--3번째 라인 해당 값이 없을때 -->
									<c:if test="${perk.perk4 != 8135 and perk.perk4 != 8134 and perk.perk4 != 8105 and perk.perk4 != 8106 and perk.perk5 != 8135 and perk.perk5 != 8134 and perk.perk5 != 8105 and perk.perk5 != 8106}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8135.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8134.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8105.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8106.png?image=e_grayscale&v=1"></div>
										<br />
									</c:if>
								</div>
							</div>
						</c:if>
						<!-- 서브 룬 8200 -->
						<c:if test="${perk.perkSubStyle == 8200}">
							<div id="subPerk8200">
								<div class="perkSubTitle"><br /><img src="//opgg-static.akamaized.net/images/lol/perkStyle/${perk.perkSubStyle}.png"></div>
								<div class="perkRow">
									<!-- 첫번째 라인 -->
									<div class="rowPerk2_1">
										<c:if test="${perk.perk4 == 8224 or perk.perk5 == 8224}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8224.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8226.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8275.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8226 or perk.perk5 == 8226}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8224.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8226.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8275.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8275 or perk.perk5 == 8275}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8224.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8226.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8275.png"></div>
										</c:if>
										<!--1번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8224 and perk.perk4 != 8226 and perk.perk4 != 8275 and perk.perk5 != 8224 and perk.perk5 != 8226 and perk.perk5 != 8275}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8224.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8226.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8275.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
									<!-- 2번째 라인 -->
									<div class="rowPerk2_2">
										<c:if test="${perk.perk4 == 8210 or perk.perk5 == 8210}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8210.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8234.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8233.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8234 or perk.perk5 == 8234}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8210.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8234.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8233.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8233 or perk.perk5 == 8233}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8210.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8234.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8233.png"></div>
										</c:if>
										<!--2번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8210 and perk.perk4 != 8234 and perk.perk4 != 8233 and perk.perk5 != 8210 and perk.perk5 != 8234 and perk.perk5 != 8233}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8210.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8234.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8233.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
									<!-- 3번째 라인 -->
									<div class="rowPerk2_3">
										<c:if test="${perk.perk4 == 8237 or perk.perk5 == 8237}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8237.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8232.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8236.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8232 or perk.perk5 == 8232}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8237.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8232.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8236.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8236 or perk.perk5 == 8236}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8237.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8232.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8236.png"></div>
										</c:if>
										<!--3번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8237 and perk.perk4 != 8232 and perk.perk4 != 8236 and perk.perk5 != 8237 and perk.perk5 != 8232 and perk.perk5 != 8236}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8237.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8232.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8236.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
								</div>
							</div>
						</c:if>
						<!-- 서브 룬 8300 -->
						<c:if test="${perk.perkSubStyle == 8300}">
							<div id="subPerk8300">
								<div class="perkSubTitle"><br /><img src="//opgg-static.akamaized.net/images/lol/perkStyle/${perk.perkSubStyle}.png"></div>
								<div class="perkRow">
								<!-- 첫번째 라인 -->
									<div class="rowPerk2_1">
										<c:if test="${perk.perk4 == 8306 or perk.perk5 == 8306}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8306.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8304.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8313.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8304 or perk.perk5 == 8304}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8306.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8304.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8313.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8313 or perk.perk5 == 8313}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8306.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8304.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8313.png"></div>
										</c:if>
										<!--1번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8306 and perk.perk4 != 8304 and perk.perk4 != 8313 and perk.perk5 != 8306 and perk.perk5 != 8304 and perk.perk5 != 8313}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8306.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8304.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8313.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
										<!-- 2번째 라인 -->
									<div class="rowPerk2_2">
										<c:if test="${perk.perk4 == 8321 or perk.perk5 == 8321}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8321.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8316.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8345.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8316 or perk.perk5 == 8316}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8321.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8316.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8345.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8345 or perk.perk5 == 8345}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8321.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8316.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8345.png"></div>
										</c:if>
										<!--2번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8321 and perk.perk4 != 8316 and perk.perk4 != 8345 and perk.perk5 != 8321 and perk.perk5 != 8316 and perk.perk5 != 8345}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8321.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8316.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8345.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
										<!-- 3번째 라인 -->
									<div class="rowPerk2_3">
										<c:if test="${perk.perk4 == 8347 or perk.perk5 == 8347}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8347.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8410.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8352.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8410 or perk.perk5 == 8410}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8347.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8410.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8352.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8352 or perk.perk5 == 8352}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8347.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8410.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8352.png"></div>
										</c:if>
										<!--3번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8347 and perk.perk4 != 8410 and perk.perk4 != 8352 and perk.perk5 != 8347 and perk.perk5 != 8410 and perk.perk5 != 8352}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8347.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8410.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8352.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
								</div>
							</div>
						</c:if>
						<!-- 서브 룬 8400 -->
						<c:if test="${perk.perkSubStyle == 8400}">
						<div id="subPerk8400">
								<div class="perkSubTitle"><br /><img src="//opgg-static.akamaized.net/images/lol/perkStyle/${perk.perkSubStyle}.png"></div>
								<div class="perkRow">
								<!-- 첫번째 라인 -->
									<div class="rowPerk2_1">
										<c:if test="${perk.perk4 == 8446 or perk.perk5 == 8446}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8446.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8463.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8401.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8463 or perk.perk5 == 8463}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8446.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8463.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8401.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8401 or perk.perk5 == 8401}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8446.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8463.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8401.png"></div>
										</c:if>
										<c:if test="${perk.perk4 != 8446 and perk.perk4 != 8463 and perk.perk4 != 8401 and perk.perk5 != 8446 and perk.perk5 != 8463 and perk.perk5 != 8401}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8446.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8463.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8401.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
										<!-- 2번째 라인 -->
									<div class="rowPerk2_2">
										<c:if test="${perk.perk4 == 8429 or perk.perk5 == 8429}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8429.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8444.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8473.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8444 or perk.perk5 == 8444}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8429.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8444.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8473.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8473 or perk.perk5 == 8473}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8429.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8444.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8473.png"></div>
										</c:if>
										<!--2번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8429 and perk.perk4 != 8444 and perk.perk4 != 8473 and perk.perk5 != 8429 and perk.perk5 != 8444 and perk.perk5 != 8473}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8429.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8444.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8473.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
										<!-- 3번째 라인 -->
									<div class="rowPerk2_3">
										<c:if test="${perk.perk4 == 8451 or perk.perk5 == 8451}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8451.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8453.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8242.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8453 or perk.perk5 == 8453}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8451.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8453.png"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8242.png?image=e_grayscale&v=1"></div>
										</c:if>
										<c:if test="${perk.perk4 == 8242 or perk.perk5 == 8242}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8451.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8453.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8242.png"></div>
										</c:if>
										<!--3번째 라인 해당 값이 없을때 -->
										<c:if test="${perk.perk4 != 8451 and perk.perk4 != 8453 and perk.perk4 != 8242 and perk.perk5 != 8451 and perk.perk5 != 8453 and perk.perk5 != 8242}">
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8347.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8410.png?image=e_grayscale&v=1"></div>
											<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8352.png?image=e_grayscale&v=1"></div>
										</c:if>
									</div>
								</div>
							</div>
						</c:if>
					</div>
				</td>
		<!-- 보조룬 -->
				<td>
					<div class="subPerkPage">
						<div id="subPerk" style="bottom: -100px;">
							<div class="subPerkRow">
								<div class="rowSubPerk0">
								<br />
									<c:if test="${perk.statPerk0 == 5008}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5008.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5005.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5007.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.statPerk0 == 5005}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5008.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5005.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5007.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.statPerk0 == 5007}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5008.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5005.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5007.png"></div>
									</c:if>
									<br />
								</div>
							</div>
							<div class="subPerkRow">
								<div class="rowSubPerk1">
									<c:if test="${perk.statPerk1 == 5008}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5008.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5002.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5003.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.statPerk1 == 5002}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5008.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5002.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5003.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.statPerk1 == 5003}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5008.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5002.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5003.png"></div>
									</c:if>
									<br />
								</div>
							</div>
							<div class="subPerkRow">
								<div class="rowSubPerk2">
									<c:if test="${perk.statPerk2 == 5001}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5001.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5002.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5003.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.statPerk2 == 5002}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5008.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5005.png"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5007.png?image=e_grayscale&v=1"></div>
									</c:if>
									<c:if test="${perk.statPerk2 == 5003}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5008.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5005.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perkShard/5007.png"></div>
									</c:if>
								</div>
							</div>
						</div>
					</div>
				</td>
				<td style="text-align:center; font-size:20px; padding-top: 100px;">
					<div class="perkPickDiv">
						<div class="perkPickScore"> ${perk.championRunePercenter } </div>
					</div>
				</td>
			</tr>
	</c:forEach>
</table>

</body>
</html>