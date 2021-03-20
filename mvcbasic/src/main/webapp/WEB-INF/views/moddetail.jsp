<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
​<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<title>detail</title>
</head>
<body>
<h1>
	유저 상세 정보 
</h1>
<form action="modcharinfo">
	No : ${dto.no }<br>
	아이디 : ${dto.c_id }<br>
	<input type="hidden" name="c_id" value='${dto.c_id }'>
	잡은총몬스터수 : <input type="number" value='${dto.hunting_count }' name="hunting_count"><br>
	총획득골드 : <input type="number" value='${dto.gold }' name="gold"><br>
	캐릭터 생성일 : ${dto.reg_date }<br>
	<input type="submit" value="수정">
</form>

<a href="./">뒤로가기</a>

</body>
</html>