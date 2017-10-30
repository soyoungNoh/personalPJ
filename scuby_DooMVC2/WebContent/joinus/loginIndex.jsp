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
<link rel="stylesheet" href="loginIndex.css">
<title>Welcome to Scuby.Doo!</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		$("#logoutBtn").click(function(){
			if (confirm("로그아웃하시겠습니까?")) {
				location.href = "../logoutProc.do";
			}

		});
	});

</script>
</head>

<body>
	<a href="loginIndex.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
    
    <ul id="loginIndex_menu">
		<li><a href="../myPage/myPage.do" class="loginIndex_menu">마이페이지</a></li>
    	<li><a href="../myPage/memberList.do" class="loginIndex_menu">회원목록</a></li>
    	<li><a href="../seaInfo/seaNews.jsp" class="loginIndex_menu">해양정보</a></li>
    	<li><a href="" class="loginIndex_menu">장비거래</a> </li>
    	<li><span class="loginIndex_menu">${mid}님 환영합니다.(${dist})</span></li>
    	<li><span id="logoutBtn" class="pure-button">로그아웃</span></li>
	</ul>
    
	<br><br><br><br>
	<div class="mainBox">
		<span class="title">SCUBY.DOO<br></span>
		<div class="subTitle">누구보다 쉽고 빠르게 검색하고<br>
		최고의 레저를 즐겨보세요.<br>
		</div>
		
		<br><br>
		<center>
		<form action="search.do" method="post">
		<select name="kind">
	    <option value="">스포츠 종류 선택</option>
	    <option value="스쿠버다이빙">스쿠버다이빙</option>
	    <option value="수상종합레저">수상종합레저</option>
	    <option value="서핑">서핑</option>
	    <option value="수상스키">수상스키</option>
	    <option value="웨이크보드">웨이크보드</option>
	    <option value="블롭점프">블롭점프</option>
		</select>
		<select name="location">
	    <option value="">장소 선택</option>
	    <option value="서울시">서울</option>
	    <option value="경기도">경기</option>
	    <option value="인천시">인천</option>
	    <option value="강원도">강원</option>
	    <option value="부산시">부산시</option>
	    <option value="충청남도">충청남도</option>
	    <option value="충청북도">충청북도</option>
	    <option value="경상북도">경상북도</option>
	    <option value="경상남도">경상북도</option>
	    <option value="전라북도">경상북도</option>
	    <option value="전라남도">경상남도</option>
	    <option value="제주시">제주시</option>  
		</select>
		<input type="text" name="member" value="인원 수" class="searchBox"/>
		<input type="text" name="date" value="날짜" class="searchBox"/>
		</form></center>
		<br><br><br><br><br><br>
		
		<div class="bListBox">
			<span style="font-size:40px; font-weight: bold; color:#4d4d4d; margin:10px;">스쿠버다이빙 </span><br>
			<span style="font-size:18px; float:right" class="totalBtn" >전체보기></span><br>
		</div>	
		<div class="bListBox">
		<img style="width: 22px; float:left;" src="../images/arrow_left.png">
		<c:forEach var="a" items="${Alist}">
			<span class="scubaD">
				<a href="../host/businessDetail.do?mid=${a.mid}&hitOn=${hitOn}">
				<img src="../host/upload/${a.fileSrc}"/></a>				
				<span class="bListExp">${a.name} &nbsp ₩${a.price}</span>
			</span>
		</c:forEach>
		<img style="width: 22px; float:left;" src="../images/arrow_right.png">
		</div>
		
		<div class="bListBox">
			<span style="font-size:40px; font-weight: bold; color:#4d4d4d; margin:10px;">서핑 </span><br>
			<span style="font-size:18px;" class="totalBtn" >전체보기></span><br>
		</div>	
		<div class="bListBox">
		<img style="width: 22px; float:left;" src="../images/arrow_left.png">
		<c:forEach var="c" items="${Clist}">
			<span class="scubaD">
				<a href="../host/businessDetail.do?mid=${c.mid}&hitOn=${hitOn}">
				<img src="../host/upload/${c.fileSrc}"/></a>				
				<span class="bListExp">${c.name} &nbsp ₩${c.price}</span>
			</span>
		</c:forEach>
		<img style="width: 22px; float:left;" src="../images/arrow_right.png">
		</div>
		
		<div class="bListBox">
			<span style="font-size:40px; font-weight: bold; color:#4d4d4d; margin:10px;">수상스키 </span><br>
			<span style="font-size:18px;" class="totalBtn" >전체보기></span><br>
		</div>	
		<div class="bListBox">
		<img style="width: 22px; float:left;" src="../images/arrow_left.png">
		<c:forEach var="d" items="${Dlist}">
			<span class="scubaD">
				<a href="../host/businessDetail.do?mid=${c.mid}&hitOn=${hitOn}">
				<img src="../host/upload/${d.fileSrc}"/></a>				
				<span class="bListExp">${d.name} &nbsp ₩${d.price}</span>
			</span>
		</c:forEach>
		<img style="width: 22px; float:left;" src="../images/arrow_right.png">
		</div>

	</div>
	
		<br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br>
	<br><br><br><br><br><br><br><br><br><br><br><br>
	<div class="footerBox">
 	 <p class="footer">제작자 : 노소영<br>
 	 이메일 : scarlett_sso@naver.com.<br>
 	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
	</div>
	
	
</body>
</html>