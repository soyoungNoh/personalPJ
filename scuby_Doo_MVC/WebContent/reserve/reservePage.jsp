<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<link rel="stylesheet" href="reservePage.css">
<title>Welcome to Scuby.Doo!</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" 
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" 
	crossorigin="anonymous">
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#addBtn").click(function(){
		
		if($("input").val()==""){
			alert("모든 정보를 입력하세요 !");
		}else if($("textarea").val()==""){
			alert("모든 정보를 입력하세요 !");
		}else if($("#bName").val()==""){
			alert("모든 정보를 입력하세요 !");
		}else if($("select").val()==""){
			alert("모든 정보를 입력하세요 !");
		}else if($(".payTool").val()==""){
			alert("모든 정보를 입력하세요 !");
		}else{
			var f = document.querySelector("form");
			f.method="post";
			f.submit();
		} 

	});
});

</script>
</head>
<body>
<a href="../joinus/loginIndex.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
<br><br>
<hr>
<br><br>
<div class="mainBox">


<div class="infoBox">
	<img style="float:right; width:100px;" src="../host/upload/${b.fileSrc}"/>
	<p class="subtilte" style="font-weight:bold">${b.name}<br>
HOST&nbsp&nbsp| &nbsp&nbsp${m.name}</p><br><br>
	<hr class="dHr2">
	<p class="subtilte">₩${b.price}&nbsp&nbspx&nbsp&nbsp1 명 <span class="subtilte" style="float:right">₩result</span><br>
	예약수수료 <span class="subtilte" style="float:right">₩3,000</span><br></p>
	<p class="subtilte">총합계 <span style="float:right">₩result</span></p>
	<hr class="dHr2">
	<p class="subtilte">환불정책</p>
	<span class="subtilte">결제 후 24시간 이내에 취소하면 전액환불됩니다.</span>
</div>

<p class="title">확인 및 결제</p><br>
<p class="subtilte" style="font-weight:bold">${b.name}&nbsp&nbsp &nbsp|&nbsp&nbsp &nbsp게스트 n명<br></p>
<p class="subtilte">${g.name}</p>
<hr class="dHr"><br><br>

<form action="rsvAddProc.do?bName=${b.name}&bMid=${b.mid}">
<p class="subtilte">인원 추가</p>
<p class="subtilte">아이  :  <input type="text" name="kidNum" class="add"/> &nbsp
어른  :  <input type="text" name="adultNum" class="add"/></p>
<hr class="dHr"><br><br>

<p class="subtilte">체험 날짜와 시간</p>
<p style="font-size : 24px;">2017 년 
<input type="text" name="month" class="add"/>월 &nbsp
<input type="text" name="day" class="add"/>일
<select name="time">
<option value="" style="font-size : 24px;  color:#737373;">TIME</option>
<option value="오전" style="font-size : 24px;  color:#737373;">오전</option>
<option value="오후" style="font-size : 24px;  color:#737373;">오후</option>
<option value="저녁" style="font-size : 24px;  color:#737373;">저녁</option>
</select></p>
<hr class="dHr"><br><br>

<p class="subtilte">결제 정보</p>
<p class="subtilte">결제 방법<br></p>
<select name="payTool" class="payTool">
<option value="신용카드">신용카드</option>
<option value="계좌이제">계좌이제</option>
</select><br><br>



	
<p class="subtilte">카드 번호</p>
<input type="text" name="cardNum" class="payTool"/><br><br><br>

<div class="cardForm">
	<p class="subtilte">만료일</p>
	<input type="text" class="cardBox" name="mm" value="MM"/>&nbsp&nbsp&nbsp
	<input type="text" class="cardBox" name="yy" value="YY"/>
</div>
<div class="cardForm2">
	<p class="subtilte">보안 코드<br></p>
	<input type="text" class="cardBox2" name="code"/><br>
</div>
<br><br><br><br><br><br><br><br><br>

<span id="addBtn" class="pure-button">예약하기</span><br>
</form>

<br><br><br><br><br><br>
</div>


<br><br><br><br><br><br><br>
<div class="footerBox">
	 <p class="footer">제작자 : 노소영<br>
	 이메일 : scarlett_sso@naver.com.<br>
	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
</div>
</body>
</html>