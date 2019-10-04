<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<table class="table table-bordered">
	<thead>
      <tr>
      	<th><h2>룬</h2></th>
      </tr>
    </thead>
	<c:forEach items="${championPerkList}" var="perk">
		<c:if test="${perk.perkPrimaryStyle == 8000 }">
			<tr>
				<td>
					<div class="championPerkDiv">
						<div class="championPerkPage">
							<div class="perkPraimaryTitle"><img src="//opgg-static.akamaized.net/images/lol/perkStyle/8000.png"></div>
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
						<div class="championPerkPage">
							<c:if test="${perk.perkSubStyle == 8300}">
								<div class="perkSubTitle"><br /><img src="//opgg-static.akamaized.net/images/lol/perkStyle/8300.png"></div>
								<div class="perkRow">
								<!-- 첫번째 라인 -->
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
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8313.png"></div>
									</c:if>
									<!-- 2번째 라인 -->
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
									<!-- 3번째 라인 -->
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
									<c:if test="${perk.perk4 != 8352 and perk.perk4 != 8352 and perk.perk4 != 8410 and perk.perk5 != 8352 and perk.perk5 != 8352 and perk.perk5 != 8410}">
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8347.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8410.png?image=e_grayscale&v=1"></div>
										<div style="display: table-cell"><img src="//opgg-static.akamaized.net/images/lol/perk/8352.png?image=e_grayscale&v=1"></div>
									</c:if>
								
								</div>
							</c:if>
						</div>
					</div>
				</td>
			</tr>
		</c:if>
		<hr />
	</c:forEach>
</table>

</body>
</html>