<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
<%@ page contentType="text/html; charset=UTF-8" %>
<html>
<head>
	<title>Home</title>
</head>
<body>

<c:if test="${result == 1 }">
	
	<h1>
		${u_name }님 환영합니다.
	</h1>

</c:if>

<c:if test="${result == 0 }">
	
	<h1>
		아이디 또는 패스워드를 확인해주세요
	</h1>

</c:if>  


	
	

</body>
</html>
