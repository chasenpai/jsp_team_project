<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>장바구니</title>
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

#main:visited {
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
	width: 420px;
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
	width: 170px;
	height: 200px;
}

.chk {
	width: 70px;
	height: 200px;
}

input[type="button"] {
	width: 80px;
	height: 26px;
	border: 1px solid black;
}

input[type="button"]:hover {
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

#btn {
	width: 400px;
	height: 26px;
	margin: 0px;
	margin-bottom: 10px;
	margin-top: 10px;
}

p {
	font-size: 110%;
	text-align: center;
	font-weight: bold;
}
#plzLogin{
	margin-top: 300px;
}
</Style>
</head>
<body>

	<div id="wrap">
		<nav>
			<h1 id="header">
				<a id="main" href="index.jsp">LAPTOP<br />ZONE
				</a>
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
				<li><a href="categoryAll.jsp">노트북 전체</a></li>
				<li><a href="categoryApple.jsp">애플 맥북</a></li>
				<li><a href="categoryUltra.jsp">울트라북</a></li>
				<li><a href="categoryGaming.jsp">게이밍 노트북</a></li>
				<li><a href="categoryOffice.jsp">사무용 노트북</a></li>
				<li><a href="categoryEtc.jsp">노트북 주변기기</a></li>
				<li><p class="menu01">BOARD</p></li>
				<li><a href="notice.jsp">공지사항</a></li>
				<li><a href="board.jsp">자유 게시판</a></li>
				<li><a href="qna.jsp">Q&#38;A</a></li>
			</ul>
		</nav>

		<section>
			<c:choose>
				<c:when test="${memberId ne null }">
					<div>
						<h1>장바구니</h1>



						<div id="btn">
							<input type="button" value="전체 선택"> <input type="button"
								value="전체 삭제"> <input type="button" value="선택 구매">
							<input type="button" value="선택 삭제">
						</div>
						<table>
							<tr>
								<td class="img" rowspan="3"><img src="" alt="노트북 이미지" /></td>
								<td class="name"><a href="#">노트북 명</a></td>
								<td class="price" rowspan="3">가격</td>
								<td class="chk" rowspan="3"><input type="checkbox"
									name="select"></td>
							</tr>
							<tr>
								<td class="spec">노트북스펙</td>
							</tr>
							<tr>
								<td class="regdate">등록일자</td>
							</tr>
						</table>
						<br>
						<p>총 선택상품금액 = ????? + 총 배송비 = ????? - 할인금액 = ????? = 총 주문금액 =
							?????</p>
					</div>
				</c:when>
				<c:otherwise>
					<h1 id="plzLogin">로그인을 해주세요.</h1>
				</c:otherwise>
			</c:choose>

		</section>
	</div>
</body>
</html>