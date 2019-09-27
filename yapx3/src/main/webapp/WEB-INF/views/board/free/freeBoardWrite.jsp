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
</style>
<script>
/* textarea에도 required속성을 적용가능하지만, 공백이 입력된 경우 대비 유효성검사를 실시함. */
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
</script>
<div class="w3-container w3-content" style="max-width:1024px;margin-top:175px; min-height: 768px;">    
	<div id="board-container" >
		<form name="boardFrm" 
			  action="${pageContext.request.contextPath}/free/freeBoardWriteEnd.do" 
			  method="post" 
			  onsubmit="return validate();"
			  enctype="multipart/form-data">
			<input type="text" class="form-control" placeholder="제목" 
					name="freeBoardTitle" id="boardTitle" required>
			<input type="text" class="form-control" 
					name="userEmail" value="${member.userEmail}" readonly required>
			<input type="text" class="form-control" 
					name="userNickName" value="${member.userNickname}" readonly required>
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
		    <textarea id="txt" class="form-control" name="freeBoardContent" placeholder="내용" required></textarea>
			<br />
			<input type="submit" class="btn btn-outline-success" value="저장" >
		</form>
	</div>
<!-- End Page Container -->
</div>
<jsp:include page="/WEB-INF/views/common/footer.jsp"></jsp:include>