<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
<style>
	* {
		padding: 0;
		margin: 0;
	}
	
	#wrap {
		margin: 200px auto;
		padding-top: 15px;
		width: 500px;
		height: 500px;
		background-color: lightgray;
		border: 1px solid black;
	}
	
	h1 {
		margin-top: 15px;
		text-align: center;
	}
	
	#wrap div {
		width: 450px;
		margin-left: 45px;
		margin-top: 30px;
	}
	
	table {
		font-weight: 700;
	}
	
	.btn01 {
		float: right;
		margin-right: 10px
	}
	
	input[type="text"], input[type="password"] {
		width: 200px;
		height: 25px;
		border: 1px solid black;
	}
	
	input[type="button"] {
		width: 100px;
		height: 27px;
		border: 1px solid black;
	}
	
	input[type="button"]:hover {
		background-color: darkgray;
	}
	
	input[type="date"] {
		width: 200px;
		height: 25px;
		border: 1px solid black;
	}
	
	select {
		width: 100px;
		height: 27px;
		border: 1px solid black;
	}
</style>
</head>

<body>
	<div id="wrap">
		<h1>회원가입</h1>
		<div>
			<form action="" method="post">
				<table>
					<tr>
						<td>아이디</td>
						<td><input type="text" name="id"></td>
						<td><input type="button" value="중복체크" onclick=""></td>
					</tr>
					<tr>
						<td>비밀번호</td>
						<td><input type="password" name="pwd"></td>
					</tr>
					<tr>
						<td>비밀번호 확인</td>
						<td><input type="password" name="pwdChk"></td>
					</tr>
					<tr>
						<td>이름</td>
						<td><input type="text" name="name"></td>
					</tr>
					<tr>
						<td>이메일</td>
						<td><input type="text" name="email1"></td>
						<td><select name="email2">
								<option value="@gmail.com">@gmail.com</option>
								<option value="@naver.com">@naver.com</option>
								<option value="@hanmail.net">@hanmail.net</option>
						</select></td>
					</tr>
					<tr>
						<td>전화번호</td>
						<td><input type="text" name="phone"></td>
					</tr>
					<tr>
						<td>생년월일</td>
						<td><input type="date" name="birth"></td>
					</tr>
					<tr>
						<td>우편번호</td>
						<td><input type="text" name="zipcode"></td>
					</tr>
					<tr>
						<td>주소</td>
						<td><input type="text" name="address"></td>
					</tr>
					<tr>
						<td>상세주소</td>
						<td><input type="text" name="addressDetail"></td>
					</tr>
					<tr>
						<td>기타</td>
						<td><input type="text" name="addressEtc"></td>
					</tr>
				</table>
				<br> <input class="btn01" type="button" value="회원가입" onclick="">
				<input class="btn01" type="button" value="취소"
					onclick="location.href='index.jsp'">
			</form>
		</div>
	</div>
</body>
</html>