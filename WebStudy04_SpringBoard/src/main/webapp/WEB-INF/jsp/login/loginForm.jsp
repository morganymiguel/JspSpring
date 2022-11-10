<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<c:if test="${not empty SPRING_SECURITY_LAST_EXCEPTION }">
	<script>
		alert("아이디나 비밀번호 문제, 다시 로그인해야 함.");
	</script>
	<c:remove var="SPRING_SECURITY_LAST_EXCEPTION" scope="session"/>
</c:if>
</head>
<body>
<form:form action="${cPath }/login/loginCheck.do" method="post">
	<input type="text" name="memId" />
	<input type="password" name="memPass" />
	<input type="submit" value="로그인" />
</form:form>
</body>
</html>