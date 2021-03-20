<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	테스트 게시판	 
</h1>
	
	<table border="1"> 
		
		<tr>
			<th>번호</th>
			<th>타이틀</th>
			<th>작성자</th>
			<th>조회수</th>
		</tr>
		
		<c:forEach items="${dtoList }" var="dto" varStatus="i">
			<tr>
				<td>${dto.no }</td>
				<td><a href="#">${dto.title }</a></td>
				<td>${dto.u_name }</td>
				<td>${dto.hit }</td>
			</tr>
		
		
		</c:forEach>
		
	
	
	</table>

</body>
</html>
