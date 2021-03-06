<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="join.css">
<title>Welcome to Scuby.Doo!</title>
</head>

<body>
	<a href="../index.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 170px;"></a>
    <span class="upper_menu"><a href="../index.jsp" >메인페이지 </a>  >  <a href="login.do">회원가입</a></span>
	<br><br>
	<hr>
	
	<img alt="seaSports" src="../images/seaSports5.jpg" style="width: 35%;" class="joinImg">
	
	<form action="joinProc.do" method="post">
	
	<table>
	<tr>
	<th>이름</th>
	<td><input type="text" name="name" class="tBox"/></td>
	</tr>
	<tr>
	<th>생년월일</th>
	<td><input type="text" value="년도" name="year" class="bBox"/>
	<input type="text" value="월" name="month" class="bBox"/>
	<input type="text" value="일" name="day" class="bBox"/>
	</td>
	</tr>
	<tr>
	<th>성별/나이</th>
	<td>
	<input type="checkbox" name="gender" value="female"/> 여 
	<input type="checkbox" name="gender" value="male"/> 남
	&nbsp&nbsp&nbsp
	<input type="text" name="age" class="bBox"/>
	</td>
	</tr>
	<tr>
	<td colspan="2" style="font-size: 13px;">이름, 생년월일, 성별은 가입완료 이후에 수정할 수 없으니 정확한 정보를 입력해주시기 바랍니다.</td>
	</tr>
	</table>
	
	<hr>
	
	<table>
	<tr>
	<th>아이디</th>
	<td><input type="text" name="mid" class="tBox"/>
	<input type="button" value="중복확인" name="idCheck"/><br>
	<span style="font-size: 13px;">영문(대,소문자),숫자,특수문자(_)(-)만 사용하여 4자 이상 12자 이하</span></td>
	<tr>
	<th>비밀번호</th>
	<td><input type="password" name="pwd" class="tBox"/><br>
	<span style="font-size: 13px;">영문(대/소문자),숫자,특수문자 중 2종류 이상으로 구성하여 8자 이상</span>
	</td></tr>
	<tr>
	<th>비밀번호 확인</th>
	<td><input type="password" name="pwdCheck" class="tBox"/>
	</td>
	</tr>
	<tr>
	<th>집 주소</th>
	<td><input type="text" name="address" class="tBox" style="width: 400px;"/></td>
	</tr>
	<tr>
	<th>휴대폰번호</th>
	<td><input type="text" name="phone" class="tBox"/></td>
	</tr>
	<tr>
	<th>이메일</th>
	<td><input type="text" name="email" class="tBox"/></td>
	</tr>
	</table>
	
	<hr>
	
	<table>
	<tr>
	<th>관심 종목</th>
	<td>
	<input type="checkbox" name="proper" value="스쿠버다이빙"/> 스쿠버다이빙 
	<input type="checkbox" name="proper" value="수상스키"/> 수상스키
	<input type="checkbox" name="proper" value="서핑"/> 서핑
	<input type="checkbox" name="proper" value="바나나보트"/> 바나나보트<br>
	<input type="checkbox" name="proper" value="스노쿨링"/> 스노쿨링
	<input type="checkbox" name="proper" value="카약"/> 카약
	<input type="checkbox" name="proper" value="웨이크보드"/> 웨이크보드
	<input type="checkbox" name="proper" value="블롭점프"/> 블롭점프<br>
	<span style="font-size: 13px;">다중선택 가능</span></td>
	</tr>
	<tr>
	<th>메일 수신여부</th>
	<td>
	<input type="checkbox" name="mail" value="mailYes"/> 네 
	<input type="checkbox" name="mail" value="mailNo"/> 아니오
	</td></tr>
	<tr>
	<th>호스트 여부</th>
	<td>
	<input type="checkbox" name="dist" value="호스트"/> 호스트 
	<input type="checkbox" name="dist" value="게스트"/> 게스트
	
	</td></tr>
	</table>

	
	
	<div id="buttonLine">
	<input type="submit" value="가입하기"/>
	</div>
	
	</form>
	<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<br><br><br><br><br><br><br><br>
	
	<div class="footerBox">
 	 <p class="footer">제작자 : 노소영<br>
 	 이메일 : scarlett_sso@naver.com.<br>
 	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
	</div>
	
</body>
</html>