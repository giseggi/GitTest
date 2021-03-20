<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
​<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>
<h1>
	This is dbtest  
</h1>

<form action="order">
	
	<select name="selected">
	
		<option value="c_id">아이디 오름차순</option>
		<option value="c_id desc">아이디 내림차순</option>
		<option value="c_lv">레벨 오름차순</option>
		<option value="c_lv desc">레벨 내림차순</option>
		<option value="c_class">직업 오름차순</option>
		<option value="c_class desc">직업 내림차순</option>
	
	</select>
	
	<input type="submit" value="정렬">
	
</form>

<table border="1" >
	<tr style="background-color: yellow">
		<th>번호</th>
		<th>아이디</th>
		<th>레벨</th>
		<th>클래스</th>
	</tr>
	
	<c:forEach items="${dtoList }" var="dto" varStatus="i">
	
		<tr>
			<td>${i.count }</td>
			<td><a href="dbdetail?id=${dto.c_id }">${dto.c_id }</a></td>
			<td>${dto.c_lv }</td>
			<td>${dto.c_class }</td>
		</tr>	
	
	
	</c:forEach>

</table>
<a href="moveregcharinfo">등록</a><br>

<form action="searchbycategory"> 

	<select name="category">
	
		<option value="c_id">아이디</option>
		<option value="c_lv">레벨</option>
		<option value="c_class">클래스</option>
		
	</select>
	
	<input type="text" name="search" placeholder="검색어를 입력하세요">
	<input type="submit" value="검색">

</form>


삭제할유저아이디 :<br>
<form action="delcharinfo">

	<input type="text" name="c_id">
	<input type="submit" value="삭제">

</form>

<a href="movefileupload">파일업로드화면으로 이동</a>	

</body>
</html>
