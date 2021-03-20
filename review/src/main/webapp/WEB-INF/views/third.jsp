<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<table border="1"> 
	<tr>
		<th>아이디</th>
		<th>레벨</th>
		<th>클래스</th>		
	</tr>
	
	<c:forEach items="${dtoList }" var="dto" varStatus="i">
		<tr>
			<td>${dto.c_id }</td>
			<td>${dto.c_lv }</td>
			<td>${dto.c_class }</td>
		</tr>
		
	
	
	</c:forEach>
	


</table>

</body>
</html>
