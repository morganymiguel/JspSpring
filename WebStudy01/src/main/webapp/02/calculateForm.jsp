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
Send Data Type
<input type ="radio" name="sendDataType" value="json" checked/>JSON
<input type ="radio" name="sendDataType" value="parameter" />Parameter
<hr>
<!-- 이항 연산자로 4칙 연산 처리.  -->
Receive Data Type
<input type="radio" name ="receiveDataType" value ="xml"/>XML
<input type="radio" name ="receiveDataType" value ="json"checked/>JSON

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
	let makeSendData = function(settings){
		let inputs = calForm.find(":input[name]");
		let data = {};
		$.each(inputs, function(index, input){
			let name = this.name;
			let value = $(this).val();
			let type = this.type;
// 			data.leftObj = 23;
// 			data['leftObj'] = 23;
			if(type=='number'){
				data[name] = parseInt(value);				
			}else{
			data[name] = value;
			}
			
		});
		console.log(data);
		let sendDataType = $("[name=sendDataType]:checked").val();
		if(sendDataType == 'json'){
			settings.data = JSON.stringify(data);
			settings.contentType = "application/json;charset=UTF-8";
		}else{
			settings.data = data;
		}
	}
	let makeReceiveDataType = function(settings){
		let receiveDataType = $("[name=receiveDataType]:checked").val();
		let dataType = receiveDataType;
		settings.dataType = dataType;
		
		
	}
	let calForm = $(document.calForm).on("submit", function(event){
		
		event.preventDefault();
		let url = this.action;
		let method = this.method;
// // 		let data = $(this).serialize(); //QueryString
// 		let jsObj = {
// 			leftOp : 23, 
// 			rightOp : 34,
// 			operator : "PLUS"
// 					};
// 		let json = JSON.stringify(jsObj);
		
		let settings = ({
			url : url,
			method : method,
// 			contentType: "application/json;charset=UTF-8",
// 			data : json,
// 			datType : "json", 
// 			request(Accept) | response(Content-Type)
			success : function(resp) {
				console.log(resp);
				calForm.after(resp.expression);
				
			},
			error : function(errorResp) {
				alert(errorResp.status);
				console.log(errorResp.status);
			}
		})
		
		makeSendData(settings);
		makeReceiveDataType(settings);

		$.ajax(settings);
		return false;
	});
</script>
</body>
</html>