<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<pre>
inner : ${inner }
outer : ${outer }
</pre>

<form:form modelAttribute="inner" method="post">
	<form:input path="inProp1" placeholder="inProp1"/>
	<form:errors path="inProp1"/>
	<form:input path="inProp2" placeholder="inProp2"/>
	<form:errors path="inProp2"/>
	<input type="submit" value="전송" />
</form:form>