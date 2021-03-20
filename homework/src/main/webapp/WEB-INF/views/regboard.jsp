<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	게시물 등록
</h1>

	<form action="reg">
	
		제목: <input type="text" name="title"><br>
		작성자: <input type="text" name="u_name"><br>
		본문: <input type="text" name="contents" style="width:200px; height:50px;"><br><br> 
		<input type="submit" value="등록">
	
	</form>

	<a href="./">돌아가기</a>
	

</body>
</html>
