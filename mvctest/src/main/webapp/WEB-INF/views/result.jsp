<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page session="false" %>
​<%@ page pageEncoding="UTF-8" %>
<html>
<head>
	<title>Result</title>
</head>
<body>
<h1>
	결과페이지  
</h1>

ModelAndView로 전달받은 String : ${str}<BR>		
ModelAndView로 전달받은 int : ${num}<BR>
ModelAndView로 전달받은 boolean : ${bool}<BR>

<!-- ModelAndView로 전달받은 strarr : ${strarr}<BR> -->
ModelAndView로 전달받은 strarr :<BR>

<c:forEach items="${strarr}" var="arr" varStatus="i">
	${i.count }번쨰 값 : ${arr }<br>

</c:forEach>

<!-- ModelAndView로 전달받은 strlist : ${strlist}<BR> -->
ModelAndView로 전달받은 strlist :<BR>
<c:forEach items="${strlist }" var="list" varStatus="i">
	${i.count }번쨰 값  : ${list }<br>

</c:forEach>



ModelAndView로 전달받은 bean : ${bean}<BR>
${bean.name}<br>
${bean.age}<br>
${bean.married}<br>


ModelAndView로 전달받은 beanlist :<BR>
<c:forEach items="${beanlist }" var="beanl" varStatus="i">
	
	${i.count }번쨰 bean : ${beanl.name}<br>
	${i.count }번쨰 bean : ${beanl.age}<br>
	${i.count }번쨰 bean : ${beanl.married}<br>
	
	<br>	

</c:forEach>


</body>
</html>
