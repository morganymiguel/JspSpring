<%@page import="kr.or.ddit.enumpkg.OperatorType"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type = "text/javascript" src ="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
</script>
</head>
<body>
<!-- 이항 연산자로 4칙 연산 처리.  -->
<form action="<%=request.getContextPath() %>/calculate" name = "calForm" method ="post">
	<input type = "number" name = "leftOp" />
	<select name ="operator">
	<%
		for(OperatorType single: OperatorType.values()){
		%>
			<option value ="<%=single.name() %>"><%=single.getSign() %></option>
		<%	
		}
		%>

	</select>
	<input type = "number" name = "rightOp" />
	<input type = "submit" value ="=">
	
</form>
<script type ="text/javascript">
	let calForm = $(document.calForm).on("submit", function(event){
		event.preventDefault();
		let url = this.action;
		let method = this.method;
// 		let data = $(this).serialize(); //QueryString
		let jsObj = {
			leftOp : 23, 
			rightOp : 34,
			operator : "PLUS"
					};
		let json = JSON.stringify(jsObj);
		
		
		
		$.ajax({
			url : url,
			method : method,
			contentType: "application/json;charset=UTF-8",
			data : json,
			datType : "json",
			success : function(resp) {
				console.log(resp);
				calForm.after(resp.expression);
				
			},
			error : function(errorResp) {
				console.log(errorResp.status);
			}
		})
		return false;
	});
</script>
</body>
</html>