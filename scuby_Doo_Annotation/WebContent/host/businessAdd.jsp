<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix ="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="businessAdd.css">
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
			}else if($("#address").val()==""){
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
<span class="upper_menu"><a href="../joinus/loginIndex.jsp" >메인페이지 </a>  >  <a href="myPage.do">마이페이지</a>  >  <a href="businessAdd.do">나의업체등록</a>&nbsp &nbsp ${mid}님 환영합니다!(${m.dist})</span>
<br><br>
<hr>
<br><br>

<img alt="seaSports" src="../images/seaSports1.jpg" style="width: 40%;" class="addBImg">
<h1 style="margin: 20px 55px;">업체 등록</h1>
<form action="businessAddProc.do" method="post" enctype="multipart/form-data">

<table class="mono_table">
    <tbody>
        <tr>
            <th scope="row">분류</th>
            <td>
			<select name="dept">
			    <option value="">분류</option>
			    <option value="스쿠버다이빙">스쿠버다이빙</option>
			    <option value="수상종합레저">수상종합레저</option>
			    <option value="서핑">서핑</option>
			    <option value="수상스키">수상스키</option>
			    <option value="웨이크보드">웨이크보드</option>
			    <option value="블롭점프">블롭점프</option>
			</select>
		</td>
        </tr>
        <tr>
            <th scope="row">상호명</th>
            <td><input type="text" name="bName" class="bBox"/></td>
        </tr>
        <tr>
            <th scope="row">가격</th>
            <td><input type="text" name="price" class="bBox"/></td>
        </tr>
        <tr>
            <th scope="row">주소지</th>
            <td>
			<select name="location">
			    <option value="">지역 선택</option>
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
			<input type="text" name="address" class="bBox"/>
			</td>
        </tr>
        <tr>
            <th scope="row">첨부파일</th>
            <td><input type="file" name="file"/></td>
        </tr>
         <tr>
            <th scope="row">소개글<br>(60자 이내)</th>
            <td><textarea name="intro" rows=5 cols=40></textarea></td>
        </tr>
    </tbody>
</table>
	<br><br><br>
<center>
	<div id="buttonLine">
	<span class="pure-button" id="addBtn">"등록하기"</span>
	</div>
</center>
	</form>

<br><br><br><br><br><br><br><br><br><br>
<div class="footerBox">
	 <p class="footer">제작자 : 노소영<br>
	 이메일 : scarlett_sso@naver.com.<br>
	 저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
</div>
</body>
</html>