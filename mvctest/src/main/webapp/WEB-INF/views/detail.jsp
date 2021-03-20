<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
​<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	유저 상세 페이지
</h1>

조회수 : ${dto.views}<br>
No : ${dto.no }<br>
ID : ${dto.c_id } <br>
골드획득량 : ${dto.gold } <br>
사냥횟수 : ${dto.hunting_count } <br>
캐릭터생성일 : ${dto.reg_date }<br>
최종수정일 : ${dto.mod_date }<br>	

<a href="./">돌아가기</a>
<a href="movemodcharinfo?id=${dto.c_id }">수정하기</a>

	

</body>
</html>
