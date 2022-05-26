<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>공지사항</title>
<Style>
	* {
		padding: 0;
		margin: 0;
	}
	img {
		display: block;
	}
	
	li {
		list-style: none;
	}
	
	body {
		background-color: #4d4d4d;
	}
	
	#wrap {
		width: 1600px;
		overflow: hidden;
		margin: 0 auto;
		position: relative;
	}
	
	nav {
		width: 200px;
		height: 100%;
		position: fixed;
		background-color: #000;
	}
	
	section {
		width: 1400px;
		height: 980px;
		position: relative;
		background-color: lightgray;
		/*float: right;*/
		top: 0;
		left: 200px;
		overflow: hidden;
	}
	
	#header {
		color: white;
		text-align: center;
		margin: 35px;
		font-size: 30px;
	}
	
	ul {
		margin-left: 35px;
		margin-top: 20px
	}
	
	ul a {
		display: inline-block;
		text-decoration: none;
		color: silver;
		font-size: 15px;
		font-weight: bold;
		margin-bottom: 20px;
	}
	
	ul a:hover {
		color: white;
	}
	
	.menu01 {
		color: white;
		display: inline-block;
		font-size: 22px;
		font-weight: bold;
		margin-bottom: 20px;
	}
	
	#main:link {
		text-decoration-line: none;
	}
	#main:visited{
		color: white;
	}
	
	section div {
		width: 700px;
		margin: 200px auto;
	}
	
	h1 {
		font-size: 250%;
		text-align: center;
		margin-bottom: 50px;
	}
	
	table, th, td {
		border: 1px solid black;
		border-collapse: collapse;
		background-color: white;
		text-align: center;
	}
	
	.num {
		width: 75px;
	}
	
	.title {
		width: 250px;
	}
	
	.writer {
		width: 125px;
	}
	
	.regdate {
		width: 175px;
	}
	
	.views {
		width: 75px;
	}
	
	input[type="button"] {
		width: 100px;
		height: 27px;
		border: 1px solid black;
	}
	
	input[type="button"]:hover {
		background-color: darkgray;
	}
</Style>
</head>

<body>
	<div id="wrap">
		<nav>
			<h1 id="header"><a id="main" href="index.jsp">LAPTOP<br />ZONE</a></h1>
			<ul>
				<c:choose>
					<c:when test="${memberId ne null}">
						<li><a href="memberLogout">로그아웃</a></li>
					</c:when>
					<c:otherwise>
						<li><a href="login.jsp">로그인</a></li>
						<li><a href="agree.jsp">회원가입</a></li>
					</c:otherwise>
				</c:choose>
				<c:choose>
					<c:when test="${memberId eq 'admin' }">
						<li><a href="#">회원관리</a>
					</c:when>
					<c:otherwise>
						<li><a href="cart.jsp">장바구니</a></li>
						<li><a href="order.jsp">주문목록</a></li>
						<li><a href="userInfo.jsp">회원정보</a></li>
					</c:otherwise>
				</c:choose>
				<li><p class="menu01">CATEGORY</p></li>
				<li><a href="categoryAll.jsp">노트북 전체</a></li>
				<li><a href="categoryApple.jsp">애플 맥북</a></li>
				<li><a href="categoryUltra.jsp">울트라북</a></li>
				<li><a href="categoryGaming.jsp">게이밍 노트북</a></li>
				<li><a href="categoryOffice.jsp">사무용 노트북</a></li>
				<li><a href="categoryEtc.jsp">노트북 주변기기</a></li>
				<li><p class="menu01">BOARD</p></li>
				<li><a href="notice.jsp">공지사항</a></li>
				<li><a href="qna.jsp">Q&#38;A</a></li>
			</ul>
		</nav>

		<section>
			<div>
				<h1>공지사항</h1>

				<table>
					<tr>
						<th class="num">번호</th>
						<th class="title">제목</th>
						<th class="writer">작성자</th>
						<th class="regdate">작성시간</th>
						<th class="views">조회수</th>
					</tr>
					<tr>
						<td class="num">1</td>
						<td class="title">공지1</td>
						<td class="writer">관리자1</td>
						<td class="regdate">2022.05.22</td>
						<td class="views">10</td>
					</tr>
				</table>
				<br>
				<c:if test="${memberId eq 'admin' }">
					<input type="button" value="글쓰기" onclick="">
				</c:if>
			</div>
		</section>
	</div>
</body>
</html>