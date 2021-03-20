<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
​<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<title>Result</title>
</head>
<body>
<h1>
	Hello Result!  
</h1>


<form action="order">
	
	<select name="selected">
		<option value="c_id">아이디오름차순</option>
		<option value="c_id desc">아이디내림차순</option>
		<option value="c_lv">레벨오름차순</option>
		<option value="c_lv desc">레벨내림차순</option>
		<option value="c_class">직업오름차순</option>
		<option value="c_class desc">직업내림차순</option>	
	</select>
	<input type="submit" value="정렬">

</form>

<table border = "1">

	<tr style = "background-color: linen; color: tomato">
		<th>번호</th>	
		<th>아이디</th>
		<th>레벨</th>
		<th>클래스</th>
	</tr>
	
	<c:forEach items = "${dtoList }" var = "dto" varStatus = "i">
	
		<tr>
			<td>${i.count }</td>
			<td><a href="resultdetail?id=${dto.c_id }">${dto.c_id }</a> </td>
			<td>${dto.c_lv } </td>
			<td>${dto.c_class }</td>
		</tr>
		
	
	</c:forEach>



</table>

<a href="moveregcharinfo">등록</a><br>

<form action="searchbyid">
	<input type="text" name="search" placeholder="아이디로 검색">
	<input type="submit" value="검색">


</form>

<form action="searchbyclass">
	<input type="text" name="search" placeholder="직업으로 검색">
	<input type="submit" value="검색">


</form>

<a href="moveupload">파일업로드다운화면으로 이동</a>


</body>
</html>
