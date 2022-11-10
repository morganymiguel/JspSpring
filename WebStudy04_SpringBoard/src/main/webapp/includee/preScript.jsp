<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
   
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/js/bootstrap-5.1.3-dist/css/bootstrap.min.css">    
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.6.1.min.js"></script>

<!-- <meta name="_csrf_parameter" content="_csrf" /> -->
<!-- <meta name="_csrf_header" content="X-CSRF-TOKEN" /> -->
<!-- <meta name="_csrf" content="f73ca75f-b406-49b3-ba99-9626e64bf609" /> -->


<script type="text/javascript">
<c:if test="${not empty message }">
		alert("${message}");
</c:if>

	let CSRFHEADERNAME = $("meta[name='_csrf_header']").attr("content");
	let CSRFPARAMNAME = $("meta[name='_csrf_parameter']").attr("content");
	let CSRFTOKEN = $("meta[name='_csrf']").attr("content");
	$.ajaxSetup({
		beforeSend:function(xhr, settings){
			console.log('before send')
			xhr.setRequestHeader(CSRFHEADERNAME, CSRFTOKEN);		
		}
	});
</script>
