<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="memberList.css">
<title>Welcome to Scuby.Doo!</title>
</head>
<body>
    <c:if test="${mid!=null}">
    <a href="../joinus/loginIndex.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
    </c:if>
    <c:if test="${mid==null}">
    <a href="../index.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
    </c:if>
    <span class="upper_menu">
    <c:if test="${mid!=null}">
    <a href="../joinus/loginIndex.do" >메인페이지 </a>
    </c:if>
    <c:if test="${mid==null}">
    <a href="../index.jsp" >메인페이지 </a>
    </c:if>
      >  <a href="memberList.do">회원목록</a></span>
	<br><br>
	<hr>
	<br><br>
	<center>
	<h1>회원 목록</h1>
	<table class="type11">
    <thead>
    <tr>
        <th scope="cols">아이디</th>
        <th scope="cols">이름</th>
        <th scope="cols">나이</th>
        <th scope="cols">생년월일</th>
        <th scope="cols">성별</th>
        <th scope="cols">주소</th>
        <th scope="cols">전화번호</th>
        <th scope="cols">이메일</th>
        <th scope="cols">관심 종목</th>
        <th scope="cols">구분</th>
    </tr>
    </thead>
    <tbody>
   		<c:forEach var="g" items="${gList}">
			<tr>
					<td>${g.mid}</td>
					<td>${g.name}</td>
					<td>${g.age}</td>
					<td>${g.birthday}</td>
					<td>${g.gender}</td>
					<td>${g.address}</td>
					<td>${g.phone}</td>
					<td>${g.email}</td>
					<td>${g.proper}</td>
					<td>${g.dist}</td>
			</tr>			
		</c:forEach>		
    
    </tbody>
</table>


<br><br><br><br>
	<table class="type11">
    <thead>
    <tr>
        <th scope="cols">아이디</th>
        <th scope="cols">이름</th>
        <th scope="cols">나이</th>
        <th scope="cols">생년월일</th>
        <th scope="cols">성별</th>
        <th scope="cols">주소</th>
        <th scope="cols">전화번호</th>
        <th scope="cols">이메일</th>
        <th scope="cols">관심 종목</th>
        <th scope="cols">구분</th>
    </tr>
    </thead>
    <tbody>
    	<c:forEach var="h" items="${hList}">
			<tr>
					<td>${h.mid}</td>
					<td>${h.name}</td>
					<td>${h.age}</td>
					<td>${h.birthday}</td>
					<td>${h.gender}</td>
					<td>${h.address}</td>
					<td>${h.phone}</td>
					<td>${h.email}</td>
					<td>${h.proper}</td>
					<td>${h.dist}</td>
			</tr>			
		</c:forEach>	
    </tbody>
</table>
<br><br><br><br><br><br>
</center>

	<div class="footerBox">
 	 <p class="footer">제작자 : 노소영<br>
 	 이메일 : scarlett_sso@naver.com.<br>
 	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
	</div>
</body>
</html>