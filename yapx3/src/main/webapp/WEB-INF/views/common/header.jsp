<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<title>YapYapYap</title>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
<link rel="stylesheet" href="https://www.w3schools.com/lib/w3-theme-blue-grey.css">
<link rel='stylesheet' href='https://fonts.googleapis.com/css?family=Open+Sans'>
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css" integrity="sha384-9gVQ4dYFwwWSjIDZnLEWnxCjeSWFphJiwGPXr1jddIhOegiu1FwO5qRGvFXOdJZ4" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
<script  src="http://code.jquery.com/jquery-latest.min.js"></script>
<style>
html, body, h1, h2, h3, h4, h5 {font-family: "Open Sans", sans-serif}
.em3but {height: 3em;}
</style>
<body class="w3-theme-l5">

<!-- Navbar -->
<div class="w3-top">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a class="w3-bar-item w3-button w3-hide-medium w3-hide-large w3-right w3-padding-large w3-hover-white w3-large w3-theme-d2" href="javascript:void(0);" onclick="openNav()"><i class="fa fa-bars"></i></a>
  <a href="${pageContext.request.contextPath}" class="w3-bar-item w3-button w3-padding-large w3-theme-d4 em3but">YapX3</a>
  <c:if test="${memberLoggedIn!=null}">
  	<a href="${pageContext.request.contextPath}/user/logoutClick.do" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">
	    로그아웃
	  </a>
  </c:if>
  <c:if test="${memberLoggedIn==null}">
	  <a href="${pageContext.request.contextPath}/user/loginClick.do" class="w3-bar-item w3-button w3-hide-small w3-right w3-padding-large w3-hover-white" title="My Account">
	    로그인
	  </a>
  </c:if>
 </div>
</div>
<div class="w3-top" style="top: 3em;">
 <div class="w3-bar w3-theme-d2 w3-left-align w3-large">
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white em3but" title="News">챔피언분석</a>
  <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large" title="Stat">통계</button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px;">
      <a href="${pageContext.request.contextPath}/stat/statChamp.do" class="w3-bar-item w3-button">챔피언별 통계</a>
      <a href="${pageContext.request.contextPath}/stat/statTear.do" class="w3-bar-item w3-button">티어별 통계</a>
    </div>
  </div>
  <a href="#" class="w3-bar-item w3-button w3-hide-small w3-padding-large w3-hover-white em3but" title="Messages">랭킹</a>
  <div class="w3-dropdown-hover w3-hide-small">
    <button class="w3-button w3-padding-large" title="Notifications">커뮤니티</button>     
    <div class="w3-dropdown-content w3-card-4 w3-bar-block" style="width:300px;">
      <a href="${pageContext.request.contextPath}/free/freeList.do" class="w3-bar-item w3-button">자유게시판</a>
      <a href="#" class="w3-bar-item w3-button">팁게시판</a>
      <a href="#" class="w3-bar-item w3-button">공략게시판</a>
      <a href="#" class="w3-bar-item w3-button">소환사 구인구직</a>
    </div>
  </div>
 </div>
</div>