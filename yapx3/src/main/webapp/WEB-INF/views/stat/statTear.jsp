<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<script src="${pageContext.request.contextPath }/resources/js/Chart.js"></script>
<%-- <script src="${pageContext.request.contextPath }/resources/js/Chart.min.js"></script> --%>
<script src="${pageContext.request.contextPath }/resources/js/utils.js"></script>
<style>
canvas {
	-moz-user-select: none;
	-webkit-user-select: none;
	-ms-user-select: none;
}
</style>
<!-- Page Container -->
<div class="w3-container w3-content" style="max-width:1024px; margin-top:115px; min-height: 950px;">    
    <div style="width: 60%; display: inline-block; height: 915px;">
		<canvas id="canvas"></canvas>
		<canvas id="chart-area" style="margin-top: 65px"></canvas>
	</div>
	<div style="width: 37%; display: inline-block; margin-left: 18px; height: 915px;">
		<table class="w3-table-all w3-hoverable" >
		    <thead>
		      <tr class="w3-light-grey">
		        <th>티어</th>
		        <th>소환사수</th>
		        <th>누계</th>
		      </tr>
		    </thead>
		    <tbody style="font-size: 11px;">
			    <tr>
			      <td>Challenger I</td>
			      <td>300 (0.0083%)</td>
			      <td>300 (0.0083%)</td>
			    </tr>
			    <tr>
			      <td>Grandmaster I</td>
			      <td>700 (0.02%)</td>
			      <td>1,000 (0.03%)</td>
			    </tr>
			    <tr>
			      <td>Master I</td>
			      <td>1,568 (0.04%)</td>
			      <td>2,568 (0.07%)</td>
			    </tr>
			    <tr>
			      <td>Diamond I</td>
			      <td>6,409 (0.18%)</td>
			      <td>8,977 (0.25%)</td>
			    </tr>
			    <tr>
			      <td>Diamond II</td>
			      <td>13,647 (0.38%)</td>
			      <td>22,624 (0.62%)</td>
			    </tr>
			    <tr>
			      <td>Diamond III</td>
			      <td>30,089 (0.83%)</td>
			      <td>52,713 (1.45%)</td>
			    </tr>
			    <tr>
			      <td>Diamond IV</td>
			      <td>86,938 (2.39%)</td>
			      <td>139,651 (3.85%)</td>
			    </tr>
			    <tr>
			      <td>Platinum I</td>
			      <td>66,981 (1.85%)</td>
			      <td>206,632 (5.69%)</td>
			    </tr>
			    <tr>
			      <td>Platinum II</td>
			      <td>74,645 (2.06%)</td>
			      <td>281,277 (7.75%)</td>
			    </tr>
			    <tr>
			      <td>Platinum III</td>
			      <td>117,133 (3.23%)</td>
			      <td>398,410 (11.0%)</td>
			    </tr>
			    <tr>
			      <td>Platinum IV</td>
			      <td>308,779 (8.51%)</td>
			      <td>707,189 (19.5%)</td>
			    </tr>
			    <tr>
			      <td>Gold I</td>
			      <td>155,922 (4.30%)</td>
			      <td>863,111 (23.8%)</td>
			    </tr>
			    <tr>
			      <td>Gold II</td>
			      <td>253,681 (6.99%)</td>
			      <td>1,116,792 (31%)</td>
			    </tr>
			    <tr>
			      <td>Gold III</td>
			      <td>301,989 (8.32%)</td>
			      <td>1,418,781 (39%)</td>
			    </tr>
			    <tr>
			      <td>Gold IV</td>
			      <td>518,190 (14.3%)</td>
			      <td>1,936,971 (53%)</td>
			    </tr>
			    <tr>
			      <td>Silver I</td>
			      <td>245,896 (6.77%)</td>
			      <td>2,182,867 (60%)</td>
			    </tr>
			    <tr>
			      <td>Silver II</td>
			      <td>306,117 (8.43%)</td>
			      <td>2,488,984 (69%)</td>
			    </tr>
			    <tr>
			      <td>Silver III</td>
			      <td>266,599 (7.34%)</td>
			      <td>2,755,583 (76%)</td>
			    </tr>
			    <tr>
			      <td>Silver IV</td>
			      <td>324,503 (8.94%)</td>
			      <td>3,080,086 (85%)</td>
			    </tr>
			    <tr>
			      <td>Bronze I</td>
			      <td>189,773 (5.23%)</td>
			      <td>3,269,859 (90%)</td>
			    </tr>
			    <tr>
			      <td>Bronze II</td>
			      <td>131,456 (3.62%)</td>
			      <td>3,401,315 (94%)</td>
			    </tr>
			    <tr>
			      <td>Bronze III</td>
			      <td>93,978 (2.59%)</td>
			      <td>3,495,293 (96%)</td>
			    </tr>
			    <tr>
			      <td>Bronze IV</td>
			      <td>75,061 (2.07%)</td>
			      <td>3,570,354 (98%)</td>
			    </tr>
			    <tr>
			      <td>Iron I</td>
			      <td>28,570 (0.79%)</td>
			      <td>3,598,924 (99%)</td>
			    </tr>
			    <tr>
			      <td>Iron II</td>
			      <td>20,505 (0.56%)</td>
			      <td>3,619,429 (100%)</td>
			    </tr>
			    <tr>
			      <td>Iron III</td>
			      <td>9,124 (0.25%)</td>
			      <td>3,628,553 (100%)</td>
			    </tr>
			    <tr>
			      <td>Iron IV</td>
			      <td>1,658 (0.05%)</td>
			      <td>3,630,211 (100%)</td>
			    </tr>
		    </tbody>
		</table>
	</div>
<!-- End Page Container -->
</div>
	<script>
		var barChartData = {
			labels: ['Iron', 'Bronze', 'Silver', 'Gold', 'Platinum', 'Diamond', 'Master', 'Grand Master', 'Challenger'],
			datasets: [{
				label: 'I',
				backgroundColor: window.chartColors.yellow,
				data: [
					28570,
					189773,
					245896,
					155922,
					66981,
					6409,
					1568,
					700,
					300
				]
			}, {
				label: 'II',
				backgroundColor: window.chartColors.green,
				data: [
					20505,
					131456,
					306117,
					253681,
					74645,
					13647,
					0,
					0,
					0
				]
			}, {
				label: 'III',
				backgroundColor: window.chartColors.orange,
				data: [
					9124,
					93978,
					266599,
					301989,
					117133,
					30089,
					0,
					0,
					0
				]
			}, {
				label: 'IV',
				backgroundColor: window.chartColors.blue,
				data: [
					1658,
					75061,
					324503,
					518190,
					308779,
					86938,
					0,
					0,
					0
				]
			}]

		};

		var config = {
			type: 'pie',
			data: {
				datasets: [{
					data: [
						31287,
						490268,
						1143115,
						1229782,
						630538,
						137083,
						2568
					],
					backgroundColor: [
						window.chartColors.red,
						window.chartColors.orange,
						window.chartColors.yellow,
						window.chartColors.green,
						window.chartColors.blue,
						window.chartColors.purple,
						window.chartColors.grey
					],
					label: 'Dataset 1'
				}],
				labels: [
					'Iron',
					'Bronze',
					'Silver',
					'Gold',
					'Platinum',
					'Diamond',
					'Master, GrandMaster, Challenger'
				]
			},
			options: {
				responsive: true,
				legend: {
					labels: {
						fontSize: 15
					}
				}				
			}
		};

		window.onload = function() {
			var ctx = document.getElementById('chart-area').getContext('2d');
			window.myPie = new Chart(ctx, config);
			
			var ctx = document.getElementById('canvas').getContext('2d');
			window.myBar = new Chart(ctx, {
				type: 'bar',
				data: barChartData,
				options: {
					title: {
						display: true,
						text: '티어 점유율 막대 그래프'
					},
					tooltips: {
						mode: 'index',
						intersect: false
					},
					responsive: true,
					scales: {
						xAxes: [{
							stacked: true,
						}],
						yAxes: [{
							stacked: true
						}]
					}
				}
			});
			
			$("#canvas").css("height", "400px");
		};
	</script>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>