<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>	
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="security" %> 
<!doctype html>
<html>
	<head>
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<meta name="description" content="">
		<meta name="author" content="Mark Otto, Jacob Thornton, and Bootstrap contributors">
		<meta name="generator" content="Hugo 0.88.1">
		<meta name="theme-color" content="#7952b3">
		
		<security:csrfMetaTags/>

		<title><tiles:getAsString name="title" /></title>
		
		<tiles:insertAttribute name="preScript" />
		
		<style>
			.bd-placeholder-img {
				font-size: 1.125rem;
				text-anchor: middle;
				-webkit-user-select: none;
				-moz-user-select: none;
				user-select: none;
			}
			
			@media ( min-width : 768px) {
				.bd-placeholder-img-lg {
					font-size: 3.5rem;
				}
			}
		</style>
		
		<!-- Custom styles for this template -->
		<link href="${pageContext.request.contextPath }/resources/css/dashboard.css" rel="stylesheet">
	</head>
	<body class="d-flex flex-column vh-100">
		<header>
		
			<tiles:insertAttribute name="headerMenu" />
			
		</header>
	
		<div class="container-fluid">
			<div class="row">
			
				<tiles:insertAttribute name="leftMenu" />
				
				<main class="col-md-9 ms-sm-auto col-lg-10 px-md-4">
					<div class="flex-wrap flex-md-nowrap align-items-center pt-3 pb-2 mb-3 border-bottom">
					<!-- Toast 알림창 -->
					  <div class="position-fixed bottom-0 end-0 p-3" style="z-index: 11">
						  <div id="liveToast" class="toast bg-info" role="alert" aria-live="assertive" aria-atomic="true">
						    <div class="toast-header">
						      <i class="bi bi-info-square p-2"></i>
						      <strong class="me-auto">알림</strong>
						      <small>방금전</small>
						      <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
						    </div>
						    <div class="toast-body">
						    </div>
						  </div>
						</div>
					<!-- Main Content Area start -->
						<div class="border border-primary">
						
							<tiles:insertAttribute name="main" />
							
						</div>
					<!-- Main Content Area end -->
					</div>
				</main>
			</div>
		</div>
	
		<footer class="footer mt-auto py-3 bg-dark col-md-9 ms-sm-auto col-lg-10">
			
			<tiles:insertAttribute name="footer" />
			
		</footer>
		
		<tiles:insertAttribute name="postScript" />
	</body>
</html>














