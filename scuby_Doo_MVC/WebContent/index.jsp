<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@page import="com.doo.dao.BusinessDAO"%>
<%@page import="com.doo.vo.Business"%>   
<%@page import="java.util.ArrayList"%>
<%
	request.setCharacterEncoding("utf-8");


	BusinessDAO dao = new BusinessDAO();
	
	ArrayList<Business> Alist = dao.getBList("스쿠버다이빙");
	ArrayList<Business> Blist = dao.getBList("수상종합레저");
	ArrayList<Business> Clist = dao.getBList("서핑");
	ArrayList<Business> Dlist = dao.getBList("수상스키");
	ArrayList<Business> Elist = dao.getBList("웨이크보드");
	ArrayList<Business> Flist = dao.getBList("블롭점프");
		
	String hitOn = "on";
	
	request.setAttribute("Alist", Alist);
	request.setAttribute("Blist", Blist);
	request.setAttribute("Clist", Clist);
	request.setAttribute("Dlist", Dlist);
	request.setAttribute("Elist", Elist);
	request.setAttribute("Flist", Flist);
	request.setAttribute("hitOn", hitOn);

%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="index.css">
<title>Welcome to Scuby.Doo!</title>
</head>

<body>
	<a href="index.jsp"><img alt="scuby_logo" src="scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
	<ul id="header">
		<li><a href="joinus/join.do" class="index_menu">회원가입</a></li>
    	<li><a href="joinus/login.do" class="index_menu">로그인</a></li>
    	<li><a href="myPage/memberList.do" class="index_menu">회원목록</a></li>
    	<li><a href="seaInfo/seaNews.jsp" class="index_menu">해양정보</a></li>
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
	    <option value="">레저 종류 선택</option>
	    <option value="스쿠버다이빙">스쿠버다이빙</option>
	    <option value="수상종합레저">수상종합레저</option>
	    <option value="서핑">서핑</option>
	    <option value="수상스키">수상스키</option>
	    <option value="웨이크보드">웨이크보드</option>
	    <option value="블롭점프">블롭점프</option>
		</select>
		<select name="location">
	    <option value="">장소 선택</option>
	    <option value="강원도">강원도</option>
	    <option value="경기도">경기</option>
	    <option value="경상남도">경상남도</option>
	    <option value="경상북도">경상북도</option>
	    <option value="광주광역시">광주광역시</option>
	    <option value="대구광역시">대구광역시</option>
	    <option value="대전광역시">대전광역시</option>
	    <option value="부산광역시">부산광역시</option>  
	    <option value="서울특별시">서울특별시</option>
	    <option value="제주특별자치도">세종특별자치시</option>
	    <option value="울산광역시">제주특별자치도</option>  
	    <option value="인천광역시">인천</option>
	    <option value="부산광역시">부산시</option>
	    <option value="전라남도">전라남도</option>
	    <option value="전라북도">전라북도</option>
	    <option value="제주특별자치도">제주특별자치도</option>  
	    <option value="충청남도">충청남도</option>
	    <option value="충청북도">충청북도</option>
		</select>
		<input type="text" name="member" value="인원 수" class="searchBox"/>
		<input type="text" name="date" value="날짜" class="searchBox"/>
		</form></center>
		<br><br><br><br>
		
		<div class="bListBox">
			<span style="font-size:40px; font-weight: bold; color:#4d4d4d; margin:10px;">스쿠버다이빙 </span><br>
			<span style="font-size:18px;" class="totalBtn" >전체보기></span><br>
		</div>	
		<div class="bListBox">
		<img style="width: 22px; float:left;" src="images/arrow_left.png">
		<c:forEach var="a" items="${Alist}">
			<span class="scubaD">
				<a href="host/businessDetail.do?mid=${a.mid}&hitOn=${hitOn}">
				<img src="host/upload/${a.fileSrc}"/></a>				
				<span class="bListExp">${a.name} &nbsp ₩${a.price}</span>
			</span>
		</c:forEach>
		<img style="width: 22px; float:left;" src="images/arrow_right.png">
		</div>
		
		<div class="bListBox">
			<span style="font-size:40px; font-weight: bold; color:#4d4d4d; margin:10px;">서핑 </span><br>
			<span style="font-size:18px;" class="totalBtn" >전체보기></span><br>
		</div>	
		<div class="bListBox">
		<img style="width: 22px; float:left;" src="images/arrow_left.png">
		<c:forEach var="c" items="${Clist}">
			<span class="scubaD">
				<a href="host/businessDetail.do?mid=${c.mid}&hitOn=${hitOn}">
				<img src="host/upload/${c.fileSrc}"/></a>				
				<span class="bListExp">${c.name} &nbsp ₩${c.price}</span>
			</span>
		</c:forEach>
		<img style="width: 22px; float:left;" src="images/arrow_right.png">
		</div>
		
		<div class="bListBox">
			<span style="font-size:40px; font-weight: bold; color:#4d4d4d; margin:10px;">수상스키 </span><br>
			<span style="font-size:18px;" class="totalBtn" >전체보기></span><br>
		</div>	
		<div class="bListBox">
		<img style="width: 22px; float:left;" src="images/arrow_left.png">
		<c:forEach var="d" items="${Dlist}">
			<span class="scubaD">
				<a href="host/businessDetail.do?mid=${c.mid}&hitOn=${hitOn}">
				<img src="host/upload/${d.fileSrc}"/></a>				
				<span class="bListExp">${d.name} &nbsp ₩${d.price}</span>
			</span>
		</c:forEach>
		<img style="width: 22px; float:left;" src="images/arrow_right.png">
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
 	 이메일 : scarlett_sso@naver.com<br>
 	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
	</div>
	
	
</body>
</html>