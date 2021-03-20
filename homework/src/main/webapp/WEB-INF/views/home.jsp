<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	게시판 
</h1>

	<table border="1">
		<tr>		
			<th>번호</th>
			<th>제목</th>
			<th>작성자</th>
			<th>등록일</th>			
		</tr>
		
		<c:forEach items="${dtoList }" var="dto" varStatus="i">
		
			<tr>
				<td>${dto.no }</td>
				<td><a href="#">${dto.title }</a></td>
				<td>${dto.u_name }</td>
				<td>${dto.reg_date }</td>
			</tr>
		
		</c:forEach>
	
	
	</table>

	<a href="moveregboard">게시물 등록하기</a><br>
	<a href="movelogin">로그인화면</a>

</body>
</html>
