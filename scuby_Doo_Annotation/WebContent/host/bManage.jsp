<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" 
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" 
	crossorigin="anonymous">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../myPage/myPage.css">
<title>Welcome to Scuby.Doo!</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
window.addEventListener("load", function(){
	var bAddLink = document.getElementById("bAddLink");
	bAddLink.onclick = function(){
		if(${!empty b.name}){
			alert("계정당 한 업체만 등록 가능합니다.");
		}else{
			location.href = "businessAdd.do";
		}
	}
	
	var bAddLink = document.getElementById("bEditLink");
	bEditLink.onclick = function(){
		if(${!empty b.name}){
			location.href = "businessEdit.do";
		}else{
			alert("업체를 등록해주세요.");
		}
	}
	
	var bListLink = document.getElementById("bListLink");
	bListLink.onclick = function(){
		if(${!empty b.name}){
			location.href = "../reserve/rsvList.do?hitOn=on";
		}else{
			alert("업체를 등록해주세요.");
		}
	}
	
	$("#logoutBtn").click(function(){
		if (confirm("로그아웃하시겠습니까?")) {
			location.href = "..logoutProc.do";
		} else {
		   
		}

	});
});
</script>

</head>
<body>

<a href="../joinus/loginIndex.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
<span class="upper_menu"><a href="../joinus/loginIndex.do" >메인페이지 </a>  >  <a href="myPage.do">마이페이지</a>
&nbsp &nbsp ${m.mid}님 환영합니다!(${m.dist}) <span id="logoutBtn" class="pure-button">로그아웃</span></span>
<br><br>
<hr>
<br><br><br><br>
<div class="memberBox">
<table class=memberTable>
	<tr>
	<td colspan="2">
	<center>
		<img alt="memberImg" src="../images/profile_pictures.png" style="width: 120px;"><br><br><br>
	</center>
	</td>
	</tr>
	<tr>
	<th>이름</th>
	<td>${m.name}</td>
	</tr>
	<tr>
	<th>아이디</th>
	<td>${m.mid}</td>
	</tr>
	<tr>
	<th>주소</th>
	<td>${m.address}</td>
	</tr>
	<tr>	
	<th>업체명</th>
	<c:if test="${b.name!=null}">
	<td>
	${b.name} &nbsp <input type="button" id="bDelBtn"value="삭제하기"/>
	</td>
	</c:if>
	<c:if test="${b.name==null}">
	<td>업체를 등록해주세요.</td>
	</c:if>
	</tr>
	<tr>
	<th>선호스포츠<br><br></th>
	<td>${m.proper}<br><br></td>
	</tr>	
</table>
</div>

<div class="bManageIndex">
<br>
<ul>
	<li><span id="bAddLink">나의 업체 등록</span></li>
	<li><span id="bEditLink">업체 정보 수정</span></li>
	<li><span id="bListLink">예약리스트</span></li>
	<li><a href="">메시지</a></li>
</ul>
</div>

<br><br><br><br><br><br><br><br>
<div class="footerBox">
	 <p class="footer">제작자 : 노소영<br>
	 이메일 : scarlett_sso@naver.com.<br>
	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
</div>
</body>
</html>