<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>  
<form:form method="post" modelAttribute="board">  
<table>
	<tr>
		<th><spring:message code="board.boTitle"/></th>
		<td>
			<form:input path="boTitle" required="true" />
			<form:errors path="boTitle" element="span" cssClass="error" />
		</td>
	</tr>
	<tr>
		<th><spring:message code="board.boWriter" /></th>
		<td>
			<form:input path="boWriter"/>
			<form:errors path="boWriter" element="span" class="error"/>
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<form:button type="submit" class="btn btn-success">전송</form:button>
		</td>
	</tr>
</table>
</form:form>
