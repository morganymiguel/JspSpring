<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
   
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/js/bootstrap-5.1.3-dist/css/bootstrap.min.css">    
<link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.9.1/font/bootstrap-icons.css">
<link rel="stylesheet" href="${pageContext.request.contextPath }/resources/js/DataTables/datatables.min.css">
<style type="text/css">
	.error{
		color: red;
	}
	.invalid{
		border-color: red;
	}
	.thumbnail{
		width: 100px;
		height: 100px;
	}
	.delAtt{
		width: 10px;
		height: 10px;
	}
	.matched{
		display: none;
	}
</style>

<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-3.6.1.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery.form.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-validation-1.19.2/jquery.validate.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/jquery-validation-1.19.2/additional-methods.min.js"></script>
<script type="text/javascript">
	const CONTEXTPATH = "${pageContext.request.contextPath }";
	$(document).ajaxError(function( event, jqXHR, ajaxSettings, thrownError){
		console.log(thrownError);		
	});
	<c:if test="${not empty message }">
			alert("${message}");
	</c:if>
</script>