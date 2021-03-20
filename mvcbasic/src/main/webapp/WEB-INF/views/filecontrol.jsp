<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
​<%@ page pageEncoding="UTF-8" %>

<html>
<head>
	<title>filecontrol</title>
</head>
<body>
<h1>
	자료실
</h1>


<table border="1">

	<tr>
		<th>no</th>
		<th>타이틀</th>
		<th>작성자</th>
		<th>작성일</th>
		<th>파일</th>	
	</tr>
	
</table>

<form action="upload" method="post" enctype="multipart/form-data" accept-charset="UTF-8">
	<input type="file" name="upfile"><br>
	타이틀<input type="text" name="title"><br>
	작성자<input type="text" name="writter"><br>
	<input type="submit" value="업로드">
</form>

</body>
</html>
