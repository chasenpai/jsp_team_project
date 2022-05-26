<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>노트북 전체</title>
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
		width: 900px;
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
		clear: both;
	}
	
	.img {
		width: 220px;
		height: 220px;
	}
	
	.name {
		width: 460px;
		height: 30px;
	}
	
	.spec {
		width: 420px;
		height: 140px;
	}
	
	.regdate {
		width: 420px;
		height: 30px;
	}
	
	.price {
		width: 200px;
		height: 200px;
	}

	
	#category {
		width: 510px;
		display: inline-block;
		margin-left: 0px;
	}
	
	#category li {
		float: left;
		width: 100px;
		height: 25px;
		border: 1px solid black;
		background-color: white;
		text-align: center;
		margin-bottom: 10px;
	}
	
	#category a {
		color: black;
	}
	
	#right {
		float: right;
		width: 300px;
		height: 30px;
		display: inline-block;
		margin: 0px;
	}
	
	#right input[type="text"] {
		float: right;
		margin-right: 15px;
		height: 23px;
		margin-top: 24px;
		border:1px solid black;
	}
	
	#right input[type="button"] {
		float: right;
		width: 40px;
		height: 25px;
		margin-top: 24px;
		border:1px solid black;
	}
	
	#right input[type="button"]:hover {
		background-color: darkgray;
	}
	
	table a {
		font-weight: bold;
		color: black;
	}
	
	table a:link {
		text-decoration-line: none;
	}
	
	table a:visited {
		color: black;
	}
	
	#reg{
		float: right;
		width: 40px;
		height: 26px;
		margin-top: 24px;
	}
	#reg:hover {
		background-color: darkgray;
	}
	
</Style>
</head>

<body>
	<div id="wrap">
		<nav>
			<h1 id="header"><a id="main" href="index.jsp">LAPTOP<br />ZONE</a></h1>
			<ul>
				<li><p class="menu01">MEMBER</p></li>
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
				<h1>노트북 전체</h1>
				<ul id="category">
					<li><a href="#">신상품</a></li>
					<li><a href="#">인기상품</a></li>
					<li><a href="#">최저가</a></li>
					<li><a href="#">최고가</a></li>
				<c:if test="${memberId eq 'admin' }">
					<li><a href="#">상품등록</a></li>	
				</c:if>
				</ul>
				<div id="right">
					<input type="text" name="search"> 
					<input type="button"value="검색">
				</div>
				
				<c:choose>
					<c:when test="${memberId eq 'admin' }">
						<table>
							<tr>
								<td class="img" rowspan="3"><img src="" alt="노트북 이미지" /></td>
								<td class="name"><a href="#">노트북 명</a></td>
								<td class="price" rowspan="2">가격</td>
								
							</tr>
							<tr>
								<td class="spec">노트북스펙</td>
							</tr>
							<tr>
								<td class="regdate">등록일자</td>
								<td class="delete"><a href="#">삭제</a></td>
							</tr>
						</table>
					</c:when>
					<c:otherwise>
						<table>
							<tr>
								<td class="img" rowspan="3"><img src="" alt="노트북 이미지" /></td>
								<td class="name"><a href="product.jsp">노트북 명</a></td>
								<td class="price" rowspan="3">가격</td>
							</tr>
							<tr>
								<td class="spec">노트북스펙</td>
							</tr>
							<tr>
								<td class="regdate">등록일자</td>
							</tr>
						</table>
					</c:otherwise>	
				</c:choose>
			</div>
		</section>
	</div>
</body>
</html>