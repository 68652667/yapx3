<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<jsp:include page="/WEB-INF/views/common/header.jsp"></jsp:include>
<!-- Page Container -->
<style>
div#board-container{width:400px; margin:0 auto; text-align:center;}
div#board-container input{margin-bottom:15px;}
/* 부트스트랩 : 파일라벨명 정렬*/
div#board-container label.custom-file-label{text-align:left;}
#txt{min-height: 200px;}
#body{
margin: 0;
    padding: 3;
    border: 1px solid #ced4da;
    border-radius: 1px solid #ced4da;
    background-color: #FFFFFF;
    font-size: 9pt;
    font-family: 굴림;
    line-height: 1.4;
    overflow-y: scroll;
    word-wrap: break-word;
    min-height: 200px;
    text-align: left;
}
#iconDiv{
	display: none;
}
#iconDiv img{width: 32px;}
#iconDiv #champImg{
	height: 348px;
	overflow-y: scroll;
    background-color: #ededed;
    padding: 2px 0 0;
    text-align: center;
    display: none;
}
#iconDiv #skillImg{
	height: 348px;
	overflow-y: scroll;
    background-color: #ededed;
    padding: 2px 0 0;
    text-align: center;
    display: none;
}
</style>
<script>
function validate(){
	var content = $("[name=boardContent]").val();
	if(content.trim().length==0){
		alert("내용을 입력하세요");
		return false;
	}
	return true;
}

$(()=>{
	//부트스트랩bug : input:file변경시 파일명보이기
	$("[name=upFile]").on("change", function(){
		if($(this).prop('files')[0] === undefined){
			$(this).next(".custom-file-label").html('파일을 선택하세요');			
		}
		
		var fileName = $(this).prop('files')[0].name;
		$(this).next(".custom-file-label").html(fileName);
	});
	
});

function chk_file_type(obj) {
	
	var file_kind = obj.value.lastIndexOf('.');
	var file_name = obj.value.substring(file_kind+1,obj.length);
	var file_type = file_name.toLowerCase();

	var check_file_type = ['jpg','gif','png','jpeg','bmp'];

	if(check_file_type.indexOf(file_type)==-1){
		alert('이미지 파일만 선택할 수 있습니다.');
		var parent_Obj=obj.parentNode
		var node=parent_Obj.replaceChild(obj.cloneNode(true),obj);
		return false;
	} else {
		
		if($(obj).prop('files')[0] === undefined){
			$(obj).next(".custom-file-label").html('파일을 선택하세요');
		}
		var fileName = $(obj).prop('files')[0].name;
		$(obj).next(".custom-file-label").html(fileName);
		
	}
	
}
function ULCheck() {
	var yl = $("[name=YL]").val();
	html = "<iframe width='400' height='250' src='//www.youtube.com/embed/"+yl+"' frameborder='0' allowfullscreen></iframe>";
	$("#ULSection").html(html);
}
function txt(e) {
	var body = $("#body").html();
	$("#txtfield").html(body);
}

var iconsum = 1;
function showIcon(){
	if(iconsum == 1){
		$("#iconDiv").css("display", "inline");
		iconsum = 0;
	} else {
		$("#iconDiv").css("display", "none");
		$("#champImg").css("display", "none");
		$("#skillImg").css("display", "none");
		iconsum = 1;
	}
}
function champ() {
	$(".imgcon").css("display", "none");
	$("#champImg").css("display", "inline");
}
function skills() {
	$(".imgcon").css("display", "none");
	$("#skillImg").css("display", "inline");
}
function addImg(e) {
	var src = $(e).attr("src");
	var img = document.createElement("img");
	img.setAttribute("src", src);
	img.setAttribute("height", "32");
	img.setAttribute("width", "32");
	document.getElementById("body").appendChild(img);
	var body = $("#body").html();
	$("#txtfield").html(body);
}
</script>
<div class="w3-container w3-content" style="max-width:1024px;margin-top:175px; min-height: 768px;">    
	<div id="board-container" >
		<form name="boardFrm" 
			  action="${pageContext.request.contextPath}/tip/tipBoardWriteEnd.do" 
			  method="post" 
			  onsubmit="return validate();"
			  enctype="multipart/form-data">
			<input type="text" class="form-control" placeholder="제목" 
					name="tipBoardTitle" id="boardTitle" required>
			<input type="text" class="form-control" 
					name="userEmail" value="${memberLoggedIn.userEmail}" readonly required>
			<input type="text" class="form-control" 
					name="userNickName" value="${memberLoggedIn.userNickname}" readonly required>
			<div class="input-group mb-3" style="height: 35.74px;">
			  <div class="input-group-prepend" style="height: 35.74px;">
			    <span class="input-group-text" id="basic-addon3">https://youtu.be/</span>
			  </div>
			  <input type="text" class="form-control" id="basic-url" aria-describedby="basic-addon3" name="YL" style="height: 35.74px;">
			  <div class="input-group-append" style="height: 35.74px;">
    			<span class="input-group-text" style="height: 35.74px;" onclick="ULCheck();">링크확인</span>
  			  </div>
			</div>
			<div id="ULSection"></div>
			<!-- input:file소스 : https://getbootstrap.com/docs/4.1/components/input-group/#custom-file-input -->
			<div class="input-group mb-3" style="padding:0px;">
			  <div class="input-group-prepend" style="padding:0px;">
			    <span class="input-group-text">첨부파일1</span>
			  </div>
			  <div class="custom-file">
			    <input type="file" class="custom-file-input" 
			    	   name="upFile" id="upFile1" onchange="chk_file_type(this);">
			    <label class="custom-file-label" for="upFile1">파일을 선택하세요</label>
			  </div>
			</div>
			<div class="input-group mb-3" style="padding:0px;">
			  <div class="input-group-prepend" style="padding:0px;">
			    <span class="input-group-text">첨부파일2</span>
			  </div>
			  <div class="custom-file">
			    <input type="file" class="custom-file-input" 
			    	   name="upFile" id="upFile2" onchange="chk_file_type(this);">
			    <label class="custom-file-label" for="upFile2">파일을 선택하세요</label>
			  </div>
			</div>
		    <textarea id="txtfield" class="form-control" name="tipBoardContent" placeholder="내용" required></textarea>
		    <br />
		    <div id="body" contenteditable="true" onkeyup="txt();">
		    </div>
			<br />
			<div>
				<p style="text-align: right;">
					<button type="button" class="btn btn-secondary btn-sm" onclick="showIcon();">롤 아이콘</button>
				</p>
			</div>
			<div id="iconDiv">
				<div>
					<span onclick="champ();">챔피언</span>
					<span onclick="skills();">스킬</span>
				</div>
				<div id="champImg" class="imgcon">
					<c:forEach items="${champList }" var="b">
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/champion/${b.id }.png" alt="" onclick="addImg(this);"/>
					</c:forEach>
				</div>
				<div id="skillImg" class="imgcon">
					<c:forEach items="${champList }" var="b">
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/passive/${b.passive }" alt="" onclick="addImg(this);"/>
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/${b.q }" alt="" onclick="addImg(this);"/>
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/${b.w }" alt="" onclick="addImg(this);"/>
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/${b.e }" alt="" onclick="addImg(this);"/>
					<img src="http://ddragon.leagueoflegends.com/cdn/9.19.1/img/spell/${b.r }" alt="" onclick="addImg(this);"/>
					</c:forEach>
				</div>
			</div>
			<br />
			<input type="submit" class="btn btn-outline-success" value="저장" >
		</form>
	</div>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>