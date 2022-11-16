<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<pre>
inner : ${inner }
outer : ${outer }
</pre>
<form:form modelAttribute="outer" method="post">
	<form:input path="outProp1" placeholder="outProp1"/>
	<form:errors path="outProp1"/>
	<form:input path="outProp2" placeholder="outProp2"/>
	<form:errors path="outProp2"/>
	<input type="submit" value="전송" />
</form:form>