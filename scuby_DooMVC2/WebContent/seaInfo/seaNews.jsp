<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="seaNews.css">
<title>Welcome to Scuby.Doo!</title>
</head>
<body>

<a href="../index.jsp"><img alt="scuby_logo" src="../scubyLogo3.png" style="margin: 0 20px; width: 120px;"></a>
<span class="upper_menu"><a href="../index.jsp" >메인페이지 </a>  >  <a href="seaNews.jsp">해양뉴스</a></span>
<br><br><br><br>

<form id="content-searchform" class="article-search-form" action="seaNews.jsp" method="get">
	<fieldset>
		<input type="hidden" name="pg" value="" />
		<label class="hidden" for="f"></label>
		<select name="f">
			<option value="TITLE" selected="selected" >제목</option>
			<option value="CONTENT">내용</option>
		</select>
		<label class="hidden" for="q"></label>
		<input type="text" name="q" class="tBox"/>
		<input type="submit" value="검색" class="sBox"/>
	</fieldset>
</form>
<br><br><br>
	
<center>

<table class="type04">

<%-- 	<% for(int i=0;i<list.size();i++)  {%> --%>
    <tr>
        <th scope="row">
        <img width="256" height="150" src="pressImg/<%-- <%=list.get(i).getImgnum%>.png --%>20171005_1.png">
        </th>
        <td><p><b>
        <a href="<%-- <%=list.get(i).getUrl()%> --%>http://www.yonhapnews.co.kr/bulletin/2017/09/28/0200000000AKR20170928188700051.HTML?input=1195m">
        	<%-- <%=list.get(i).getTitle()%> --%>세계해양포럼 18일 개막…새로운 해양가치 창출 모색</a></b></p>
        	<p><%-- <%=list.get(i).getSubtitle()%> --%>국내 최대 규모의 해양전문 토론의 장인 세계해양포럼이 오는 18일 부산에서 개막한다고 포럼사무국이 5일 밝혔다.</p>
        	<p style="color: #666666"><%-- <%=list.get(i).getRegdate()%> --%>2017-10-05</p></td>
        <td><%-- <%=list.get(i).getHit()%> --%>0</td>
    </tr>
    <%-- <%}%> --%>
    <tr>
        <th scope="row">
		 <img width="256" height="150" src="pressImg/20171005_2.png">
		</th>
        <td class="even"><p><b>
	        <a href="http://www.yonhapnews.co.kr/bulletin/2017/09/29/0200000000AKR20170929183400030.HTML?input=1195m">
	       	 이달 해양생물에 '청정해역 바로미터' 금빛나팔돌산호</a></b></p>
	       	<p>해양수산부는 제주 마라도 청정해역에 서식하는 황금빛 꽃다발 모양의 산호인 '금빛나팔돌산호'를 이달의 해양생물로 선정했다고 1일 밝혔다.</p>
	       	<p style="color: #666666">2017-10-05</p></td>
       	<td>0</td>
    </tr>
        <tr>
        <th scope="row">
		 <img width="256" height="150" src="pressImg/20171005_3.png"></th>
        <td><p><b>
        <a href="http://mbn.mk.co.kr/pages/news/newsView.php?category=mbn00009&news_seq_no=3352218">
       	'세월호 참사' 이후에도 해양사고 매년 증가…"사고 분석·예방 대책 필요"</a></b></p>
       	<p>'세월호 참사' 이후에도 해양사고 매년 증가…지난해 63%↑...2014년 세월호 참사 이후에도 해양 사고가 매년 증가한 것으로 나타났습니다.</p>
       	<p style="color: #666666">2017-10-05</p></td>
       	<td>0</td>
    </tr>
        </tr>
        <tr>
        <th scope="row">
		 <img width="256" height="150" src="pressImg/20171005_3.png"></th>
        <td><p><b>
        <a href="http://mbn.mk.co.kr/pages/news/newsView.php?category=mbn00009&news_seq_no=3352218">
       	'세월호 참사' 이후에도 해양사고 매년 증가…"사고 분석·예방 대책 필요"</a></b></p>
       	<p>'세월호 참사' 이후에도 해양사고 매년 증가…지난해 63%↑...2014년 세월호 참사 이후에도 해양 사고가 매년 증가한 것으로 나타났습니다.</p>
       	<p style="color: #666666">2017-10-05</p></td>
       	<td>0</td>
    </tr>
        </tr>
        <tr>
        <th scope="row">
		 <img width="256" height="150" src="pressImg/20171005_3.png"></th>
        <td><p><b>
        <a href="http://mbn.mk.co.kr/pages/news/newsView.php?category=mbn00009&news_seq_no=3352218">
       	'세월호 참사' 이후에도 해양사고 매년 증가…"사고 분석·예방 대책 필요"</a></b></p>
       	<p>'세월호 참사' 이후에도 해양사고 매년 증가…지난해 63%↑...2014년 세월호 참사 이후에도 해양 사고가 매년 증가한 것으로 나타났습니다.</p>
       	<p style="color: #666666">2017-10-05</p></td>
       	<td>0</td>
    </tr>
</table>
				
</center>
<br><br><br><br><br><br><br><br><br><br><br><br><br><br><br>
<div class="footerBox">
	<p class="footer">제작자 : 노소영<br>
	이메일 : scarlett_sso@naver.com.<br>
	저작권© 1996–2017 ScoubyDoo.com™. 모든 권리 보유.</p>
</div>
	
</body>
</html>