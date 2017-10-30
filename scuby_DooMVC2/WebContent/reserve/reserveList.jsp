<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="reserveList.css">
<title>Welcome to Scuby.Doo!</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" 
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" 
	crossorigin="anonymous">
	
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function(){
		
		jQuery("#stateBtn1").click(function(){
			if (confirm("예약접수를 승인하시겠습니까?")) {
				var check = $("<span></span>").text("승인완료");
				var prevTxt = $("<span></span>").text("예약확정");
				var gMid = $("#gMid1").text();
				$(this).empty();
				$(this).removeClass("pure-button");
				$(this).append(check);
				$(this).prev().empty();
				
				location.href = "stateUpdateProc.do?gMid="+gMid;

				}
		});
		jQuery("#stateBtn2").click(function(){
			if (confirm("예약접수를 승인하시겠습니까?")) {
				var check = $("<span></span>").text("승인완료");
				var prevTxt = $("<span></span>").text("예약확정");
				$(this).empty();
				$(this).removeClass("pure-button");
				$(this).append(check);
				$(this).prev().empty();

				}
				//location.href = "redirect:stateUpdateProc.do";
		});
		jQuery("#stateBtn3").click(function(){
			if (confirm("예약접수를 승인하시겠습니까?")) {
				var check = $("<span></span>").text("승인완료");
				var prevTxt = $("<span></span>").text("예약확정");
				$(this).empty();
				$(this).removeClass("pure-button");
				$(this).append(check);
				$(this).prev().empty();
				}
				//location.href = "redirect:stateUpdateProc.do";
		});
		jQuery("#stateBtn4").click(function(){
			if (confirm("예약접수를 승인하시겠습니까?")) {
				var check = $("<span></span>").text("승인완료");
				var prevTxt = $("<span></span>").text("예약확정");
				$(this).empty();
				$(this).removeClass("pure-button");
				$(this).append(check);
				$(this).prev().empty();

				}
				//location.href = "redirect:stateUpdateProc.do";
		});
		jQuery("#stateBtn5").click(function(){
			if (confirm("예약접수를 승인하시겠습니까?")) {
				var check = $("<span></span>").text("승인완료");
				var prevTxt = $("<span></span>").text("예약확정");
				$(this).empty();
				$(this).removeClass("pure-button");
				$(this).append(check);
				$(this).prev().empty();
				}
				//location.href = "redirect:stateUpdateProc.do";
		});
	});

</script>


</head>
<body>
<a href="../joinus/loginIndex.do"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
<br><br>
<hr>
<br><br>

<div class="mainBox">
	<center>
	<h1>예약 현황</h1>
	<table class="type11">
    <thead>
    <tr>
        <th scope="cols">번호</th>
        <th scope="cols">아이디</th>
        <th scope="cols">예약날짜</th>
        <th scope="cols">예약시간</th>
        <th scope="cols">인원수</th>
        <th scope="cols">결제수단</th>
        <th scope="cols">접수일</th>
        <th scope="cols">승인상태</th>
        <th scope="cols">접수확인</th>  
    </tr>
    </thead>
    <tbody>
   		<c:forEach var="r" items="${rList}">
			<tr>
			   	<c:if test="${r.hit>1}">
				<td>${r.seq}</td>
  				</c:if>
  				<c:if test="${r.hit<=1}">
				<td>${r.seq}<br><img width="35px" src="../images/new.png"></td>
				</c:if>
				<td id="gMid${r.seq}">${r.GMid}</td>
				<td>${r.rsvDate}</td>
				<td>${r.rsvTime}</td>
				<td>${r.number}</td>
				<td>${r.paymth}</td>
				<td>${r.regdate}</td>
				<td>${r.state}</td>
				<c:if test="${r.state=='예약확정'}">
				<td>승인완료</td>
				</c:if>
				<c:if test="${r.state=='예약대기'}">
				<td><span id="stateBtn${r.seq}" class="pure-button">승인</span></td>
				</c:if>
			</tr>			
		</c:forEach>
    </tbody>
</table>
</center>

</div>


<br><br><br><br><br><br><br>
<div class="footerBox">
	 <p class="footer">제작자 : 노소영<br>
	 이메일 : scarlett_sso@naver.com.<br>
	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
</div>


</body>
</html>