<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="login.css">
<title>Welcome to Scuby.Doo!</title>
</head>
<body>

    <a href="../index.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
    
    <span class="upper_menu"><a href="../index.jsp" >메인페이지 </a>  >  <a href="login.do">로그인</a></span>
	<br><br><br><br><br><br><br>
	<center>

	<a href="../index.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="height: 120px;"></a>
	<br><br>
	
	<div class="loginBox2">
	<form action="loginProc.do" method="post">
	아이디 &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp     <input type="text" name="mid" class="loginBox"/><br><br>
	비밀번호 &nbsp&nbsp   <input type="password" name="pwd" class="loginBox"/><br><br>
	 
	 <span style="font-size: 13px;">
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp
	<input type="checkbox" name="checkIdSave"/>아이디 저장 &nbsp
	<input type="checkbox" name="checkLoginSave" />로그인 유지
	</span>
	<br><br><br>
	<input type="submit" value="로그인"/>
	</form>
	</div>
	</center>
	<br><br><br><br><br><br><br><br>



	<div class="footerBox">
 	 <p class="footer">제작자 : 노소영<br>
 	 이메일 : scarlett_sso@naver.com.<br>
 	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
	</div>
</body>
</html>