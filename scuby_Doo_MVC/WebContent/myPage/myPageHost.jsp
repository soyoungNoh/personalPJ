<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="myPage.css">
<title>Welcome to Scuby.Doo!</title>
<script type="text/javascript">
	window.addEventListener("load", function(){
		var bAddLink = document.getElementById("bDelBtn");
		bDelBtn.onclick = function(){
			location.href = "../host/businessDelProc.do";
			}
		});


</script>
</head>
<body>

    <a href="../joinus/loginIndex.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
    <span class="upper_menu"><a href="../joinus/loginIndex.jsp" >메인페이지 </a>  >  <a href="myPage.do">마이페이지</a>&nbsp &nbsp ${m.mid}님 환영합니다!(${m.dist})</span>
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
<br><br>
<div class="myPageIndex">
<ul>
	<li><a href="editMember.do">회원정보 수정</a></li>
	<li><a href="delMem.do">회원 탈퇴</a></li>
	<li><a href="../host/bManage.do">나의 업체 관리</a></li>
</ul>
</div>

<br><br><br><br><br><br><br><br><br><br>

<div class="footerBox">
	 <p class="footer">제작자 : 노소영<br>
	 이메일 : scarlett_sso@naver.com.<br>
	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
</div>

</body>
</html>