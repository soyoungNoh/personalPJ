<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="BusinessDetail.css">
<title>Welcome to Scuby.Doo!</title>
<link rel="stylesheet" href="https://unpkg.com/purecss@1.0.0/build/pure-min.css" 
	integrity="sha384-nn4HPE8lTHyVtfCBi5yW9d20FjT8BJwUXyWZT9InLYax14RDjBj46LmSztkmNP9w" 
	crossorigin="anonymous">
	
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
$(document).ready(function(){
	$("#rsvBtn").click(function(){
		//alert("로그인을 해주세요.");

		if(${!empty mmid}){
			location.href = "../reserve/rsvPage.do?mid=${b.mid}";
		}else{
			alert("로그인을 해주세요.");
			location.href = "../joinus/login.do";
		}
	});
});
	


</script>
</head>
<body>

    <c:if test="${mid!=null}">
    <a href="../joinus/loginIndex.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
    </c:if>
    <c:if test="${mid==null}">
    <a href="../index.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
    </c:if><br><br>
<hr>
<br><br>
<div class="mainBox">
<span class="scubaD">
	<img style="float:right; width:100%" src="upload/${b.fileSrc}"/><br>	
	<p class="bLocation"><span style="font-weight:bold;">₩${b.price}</span>/1회 
	<span id="rsvBtn" class="pure-button">예약하기</span><br>
	후기 : 12개</p>
</span>
<span class="bName">${b.name}</span><br>
<span class="bLocation">${b.address}</span>
<hr class="dHr"><br><br>
<p class="bLocation">HOST  :  ${m.name}님<br>
KIND  :  ${b.dept}</p>
<hr class="dHr"><br><br>
<p class="bLocation">INTRO  : ${b.intro} </p>
<hr class="dHr"><br><br>
<p class="bLocation">후기 </p>


<br><br><br><br><br>
</div>





<br><br><br><br><br><br><br><br><br><br><br><br>
<div class="footerBox">
 	 <p class="footer">제작자 : 노소영<br>
 	 이메일 : scarlett_sso@naver.com<br>
 	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
	</div>
</body>
</html>