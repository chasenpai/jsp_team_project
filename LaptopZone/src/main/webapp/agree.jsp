<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>약관동의</title>
<style>
	* {
		padding: 0;
		margin: 0;
	}
	
	h1 {
		text-align: center;
		margin-bottom: 30px;
	}
	
	#wrap {
		margin: 50px auto;
		padding-top: 15px;
		width: 500px;
		height: 850px;
		background-color: lightgray;
		padding-top: 25px;
		border: 1px solid black;
	}
	
	.agree {
		width: 450px;
		height: 320px;
		overflow: scroll;
		margin: 0 auto;
		background-color: white;
		border: 1px solid black;
	}
	
	input[type="checkbox"] {
		margin-top: 10px;
		margin-left: 25px;
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
</style>
</head>
<body>
	<div id="wrap">
		<h1>약관동의</h1>
		<form>
			<div class="agree">
				<p>약관1</p>
			</div>
			<input type="checkbox" name="agree1"> 약관에 동의합니다 <br>
			<br>
			<div class="agree">
				<p>약관2</p>
			</div>
			<input type="checkbox" name="agree2"> 약관에 동의합니다<br> <input
				type="button" value="다음" onclick="location.href='join.jsp'">
			<input type="button" value="취소" onclick="location.href='index.jsp'">
		</form>
	</div>
</body>
</html>