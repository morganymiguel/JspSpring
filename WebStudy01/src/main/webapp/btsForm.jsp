<%@page import="java.util.Map"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page="/includee/preScript.jsp" />
</head>
<body>
<form action="<%=request.getContextPath() %>/bts/getContent">
<!-- <action에서는 클라이언트방식이 필요. -->
<!-- 	<select name="member" onchange="this.form.submit();"> 자동으로 바꿀때 마다 값을 바꿔줌. -->
	<select name="member" onchange="$(this.form).submit()">
<!-- or	<select name="member" onchange="this.form.requestsubmit()"> -->
		<%
			Map<String, String[]> btsDB = (Map)application.getAttribute("btsDB");
			StringBuffer options = new StringBuffer();
			
			btsDB.forEach((k,v)->{
				options.append(
					String.format("<option value='%s'>%s</option>\n",k,v[0])
				);
//  		??format포맷팅. parse?파싱
			});
			out.print(options);
		%>
	</select>
</form>
	
<script type="text/javascript">
	$(document).on("submit",'form:first',function(event){
		event.preventDefault();
		let form = this;
		let url = this.action;
		let method = this.method;
		let data = $(this).serialize();
		
		$.ajax({
			url : url,
			method : method,
			data : data,
			dataType: "html",
			success : function(resp) {
				$(form).after(resp);

			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
		});
		return false;
	});
</script>
</body>
</html>