<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>제품 상세</title>
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

table {
	width: 900px;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
	background-color: white;
	text-align: center;
	clear: both;
}

.img {
	width: 500px;
	height: 500px;
}

.name {
	width: 400px;
	height: 100px;
}

td {
	height: 80px;
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

input[type="button"] {
	width: 100px;
	height: 27px;
	margin: 0px;
	border: 1px solid black;
}

input[type="button"]:hover {
	background-color: darkgray;
}

#detail {
	height: 50px;
}

.detail {
	height: 800px;
}

#review {
	height: 50px;
}

#num {
	width: 80px;
}

#title {
	width: 400px;
}

#writer {
	width: 150px;
}

#regdate {
	width: 230px;
}

#views {
	width: 80px;
}
</Style>
</head>

<body>
	<div id="wrap">
		<nav>
			<h1 id="header"><a id="main" href="index.jsp">LAPTOP<br />ZONE</a>
			</h1>
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
				<li><a href="category_all.html">노트북 전체</a></li>
				<li><a href="category_apple.html">애플 맥북</a></li>
				<li><a href="category_ultra.html">울트라북</a></li>
				<li><a href="category_gaming.html">게이밍 노트북</a></li>
				<li><a href="category_office.html">사무용 노트북</a></li>
				<li><a href="category_etc.html">노트북 주변기기</a></li>
				<li><p class="menu01">BOARD</p></li>
				<li><a href="notice.html">공지사항</a></li>
				<li><a href="q&a.html">Q&#38;A</a></li>
			</ul>

		</nav>

		<section>
			<div>
				<table>
					<tr>
						<td class="img" rowspan="6"><img src="" alt="노트북 이미지" /></td>
						<td class="name"><a href="#">노트북 명</a></td>
					</tr>
					<tr>
						<td>가격</td>
					</tr>
					<tr>
						<td>혜택</td>
					</tr>
					<tr>
						<td>배송</td>
					</tr>
					<tr>
						<td>수량 <input type="number" name="amount" value="1"></td>
					</tr>
					<tr>
						<td><input type="button" value="바로구매"> <input
							type="button" value="장바구니"></td>
					</tr>
				</table>
				<br> <br>
				<table>
					<tr>
						<th id="detail">제품상세</th>
					</tr>
					<tr>
						<td class="detail"><img src="#" alt="대체이미지" /></td>
					</tr>
				</table>
				<br> <br>
				<table>
					<tr>
						<th colspan="5" id="review">리뷰</th>
					</tr>
					<tr>
						<th id="num">번호</th>
						<th id="title">제목</th>
						<th id="writer">작성자</th>
						<th id="regdate">작성일자</th>
						<th id="views">조회수</th>
					</tr>
				</table>
				<br> <input type="button" value="글쓰기">
			</div>
		</section>
	</div>
</body>
</html>