<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	로그인 화면 
</h1>

	<form action="logincheck">
		ID: <input type="text" name="u_name"><br>
		Password: <input type="password" name="password">
		<input type="submit" value="로그인">
	
	</form>
	

</body>
</html>
