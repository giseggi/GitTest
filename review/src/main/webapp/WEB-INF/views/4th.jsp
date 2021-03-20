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
		<th>No</th>
		<th>제목</th>
		<th>작성자</th>
		<th>조회수</th>
		<th>작성일</th>
		<th>권한</th>			
	</tr>
	
	<c:forEach items="${dtoList }" var="dto" varStatus="i">
		<tr>
			<td>${dto.no }</td>
			<td>${dto.title }</td>
			<td>${dto.u_name }</td>
			<td>${dto.hit }</td>
			<td>${dto.reg_date }
		    <td>${dto.auth }</td>	
			
			
			<!-- if, else if, else -->
			<!-- 
	 		<td>
				<c:choose>
					<c:when test='${dto.auth == "0" }'>예비회원</c:when>  
					<c:when test='${dto.auth == "1" }'>일반회원</c:when>  
					<c:when test='${dto.auth == "2" }'>우등회원</c:when>   
					<c:when test='${dto.auth == "3" }'>관리자</c:when> 
					<c:when test='${dto.auth == "4" }'>KIMSCHOOL</c:when> 
					<c:otherwise></c:otherwise>  
				</c:choose>
			</td>
			 -->
			 
			 
			<!-- 
			<c:if test='${dto.auth == "0" }'>
				<td>예비회원</td>
			</c:if>
			
			<c:if test='${dto.auth == "1" }'>
				<td>일반회원</td>
			</c:if>
			
			<c:if test='${dto.auth == "2" }'>
				<td>우등회원</td>
			</c:if>
			
			<c:if test='${dto.auth == "3" }'>
				<td>관리자</td>
			</c:if>
			
			<c:if test='${dto.auth == "4" }'>
				<td>KIMSCHOLL</td>
			</c:if>
			 -->
			
		</tr>
		
	
	
	</c:forEach>
	


</table>
<a href="movewritetestboard">글쓰기로 이동</a>

</body>
</html>
