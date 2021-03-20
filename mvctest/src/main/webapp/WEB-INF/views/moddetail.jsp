<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
​<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	유저 수정화면
</h1>
<form action="modcharinfo">
	
	No : ${dto.no } <br>
	ID : ${dto.c_id } <br>
	<input type="hidden" name="id" value='${dto.c_id }'>
	골드획득량 : <input type="number" value='${dto.gold }' name="gold"> <br>
	사냥횟수 : <input type="number" value='${dto.hunting_count }' name="hunting_count"> <br>
	캐릭터생성일 : ${dto.reg_date }<br>
	최종수정일 : ${dto.mod_date }<br>
	<input type="submit" value="수정">

</form>	



	

</body>
</html>
