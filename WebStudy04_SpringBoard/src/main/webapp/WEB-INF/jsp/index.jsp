<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<h4>Welcome page</h4>
<h4> model : ${now }</h4>
<security:authorize access="isAuthenticated()">
	<security:authentication property="principal" var="principal"/>
	<h4>인증객체 : ${principal }</h4>
	<h4>인증객체 타입 : ${principal.getClass() }</h4>
	<a href="#" onclick="logoutForm.submit();">로그아웃</a>
	<form id="logoutForm" action="${cPath }/login/logout.do" method="post">
		<security:csrfInput/>
	</form>
<%-- 	<form:form id="logoutForm" action="${cPath }/logout" method="post"></form:form> --%>
</security:authorize>
<security:authorize access="!isAuthenticated()">
	<a href="${cPath }/login">로그인</a>
</security:authorize>
<security:authorize access="isAnonymous()">
	<h4>익명사용자</h4>
</security:authorize>
<c:if test="${not empty sessionScope.authMember }">
	<h4>session scope authMember : ${authMember }</h4>
</c:if>
<a href="${cPath }/after/index.do"> 로그인한 후 authMember 테스트 링크 </a>
