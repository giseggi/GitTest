<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
​<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	유저등록
</h1>

<form action="regcharinfo">

	<h2>기본정보</h2>
	아이디 : <input type="text" name="c_id"> <br>	
	레벨 : <input type="number" name="c_lv"> <br>	
	직업 : <input type="text" name="c_class"> <br>	
	
	<hr>
	<h2>상세정보</h2>
	골드 : <input type="number" name="gold"> <br>
	사냥횟수 : <input type="number" name="hunting_count"> <br>
	<input type="submit" value="등록">

</form>
<a href="./">돌아가기</a>

	

</body>
</html>
