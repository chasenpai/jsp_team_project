<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 정보</title>
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
	width: 700px;
	margin: 200px auto;
}

h1 {
	font-size: 250%;
	text-align: center;
	margin-bottom: 50px;
}

#info {
	margin: 0px auto;
	margin-top: 20px;
	width: 450px;
	height: 450px;
	background-color: white;
	border: 1px solid black;
}

input[type="button"] {
	float: right;
	margin-right: 25px;
	margin-top: 10px;
}

input[type="button"] {
	width: 100px;
	height: 28px;
	border: 1px solid black;
}

input[type="button"]:hover {
	background-color: darkgray;
}

#btn {
	margin-right: 123px;
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
				<li><a href="qna.jsp">Q&#38;A</a></li>
			</ul>
		</nav>

		<section>
			<c:choose>
				<c:when test="${memberId ne null }">
					<div>
						<h1>회원 정보</h1>
						<div id="info">
							<hr>
							<table>
								<tr>
									<td>아이디</td>
									<td></td>
								</tr>
								<tr>
									<td>비밀번호</td>
									<td></td>
								</tr>
								<tr>
									<td>이름</td>
									<td></td>
								</tr>
								<tr>
									<td>이메일</td>
									<td></td>

								</tr>
								<tr>
									<td>전화번호</td>
									<td></td>
								</tr>
								<tr>
									<td>생년월일</td>
									<td></td>
								</tr>
								<tr>
									<td>우편번호</td>
									<td></td>
								</tr>
								<tr>
									<td>주소</td>
									<td></td>
								</tr>
								<tr>
									<td>상세주소</td>
									<td></td>
								</tr>
								<tr>
									<td>기타</td>
									<td></td>
								</tr>
							</table>
							<hr>
						</div>
						<input id="btn" type="button" value="회원정보 수정"
							onclick="location.href='updateMember'"> <input
							type="button" value="회원 탈퇴"
							onclick="location.href='deleteMember'">

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