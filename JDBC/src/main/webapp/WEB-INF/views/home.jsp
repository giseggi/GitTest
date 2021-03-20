<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>
<head>
	<title>로그인 화면</title>
</head>
<body>
<h1>
	Hello world!  
</h1>

<form action="loginCheck" method="post">
	아이디: <input type="text" name="id"><br>
	비밀번호: <input type="password" name="password"><br> 
	
	<input type="submit" value="로그인">

</form>
<span>${msg}</span>

</body>
</html>
