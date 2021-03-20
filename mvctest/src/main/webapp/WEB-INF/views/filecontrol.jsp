<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
​<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<title>FileControl</title>
</head>
<body>
<h1>
	자료실  
</h1>

<table border="1">

	<tr>
		<th>no</th>
		<th>파일명</th>
		<th>파일크기</th>
		<th>파일경로</th>
		<th>등록일</th>
	</tr>
	<c:forEach items="${dtoList }" var="dto" varStatus="i">
		<tr>
			<td>${i.count }</td>
			<td>${dto.filename }</td>
			<td>${dto.filesize }</td>
			<td>${dto.filepath }</td>
			<td>${dto.reg_date }</td>
		</tr>
	
	</c:forEach>
		

</table>

<form action="upload" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
	<input type="file" name="upfile"><br>
	타이틀 : <input type="text" name="title"><br>
	작성자 : <input type="text" name="writter"><br>
	<input type="submit" value="업로드">
</form>

<a href="./">뒤로가기</a>

</body>
</html>
