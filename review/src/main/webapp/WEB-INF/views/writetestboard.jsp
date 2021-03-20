<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>테스트게시판 작성</title>
</head>
<body>

<form action="writetestboard">

<input type = "text" name = "u_name" placeholder="작성자 입력"><br><br>
<input type = "text" name = "title" placeholder="제목을 입력하세요."><br><br>
<input type = "number" name = "hit" placeholder="조회수를 입력하세요."><br><br>
<textarea name = "content" placeholder="내용을 입력하세요." cols="100" rows="20"></textarea><br><br>
<input type = "submit" value = "등록">
</form>
<a href = "db2">뒤로가기</a>

</body>
</html>