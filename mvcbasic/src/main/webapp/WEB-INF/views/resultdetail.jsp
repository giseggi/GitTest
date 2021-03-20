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

조회수 : ${dto.views}<br>
No : ${dto.no }<br>
아이디 : ${dto.c_id }<br>
잡은총몬스터수 : ${dto.hunting_count }<br>
총획득골드 : ${dto.gold }G<br>
캐릭터 생성일 : ${dto.reg_date }<br>
최종 수정일 : ${dto.mod_date }<br>

<a href="./">뒤로가기</a>
<a href="movemodcharinfo?id=${dto.c_id }">수정하기</a>
</body>
</html>