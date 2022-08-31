<%@page import="java.io.PrintWriter"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
StringBuffer gugudan = new StringBuffer();
StringBuffer options = new StringBuffer();

String strMin = request.getParameter("minDan");
String strMax = request.getParameter("maxDan");

if(strMin == null|| strMin.isEmpty()) {
	strMin = "2";
}
if(strMax == null || strMax.isEmpty()) {
	strMax = "9";
}
if(!strMin.matches("[2-9]") || !strMax.matches("[2-9]") ) {
	response.sendError(HttpServletResponse.SC_BAD_REQUEST, "2단부터 9단까지 범위내 파라미터만 가능.");
	return;
	
}
//	if(strMin.matches("\\d")) 이거는 0부터 9까지

int min = Integer.parseInt(strMin);
int max = Integer.parseInt(strMax);

for(int i = 2; i<10; i++) {
	options.append(String.format("<option value='%d'>%d</option>",i,i));
}

for(int i =min; i<=max;i++) {
	gugudan.append("<tr>");
	for(int j = 1; j<10; j++) {
		gugudan.append(String.format("<td>%d * %d = %d</td>", i, j, i*j));
	}
	gugudan.append("</tr>");
}


// X-Requested-With: XMLHttpRequest, AJAX(Async Javascript And XMLHttpRequest)

String header = request.getHeader("X-Requested-With");
if("XMLHttpRequest".equals(header)	) {//비동기요청이면
	out.println(gugudan);
	return;//제어를 종료시키려면

//	out.close();try 안 괄호가 닫히면서 out.close()가 필요없어짐.
}else {//동기요청이면
	
}


%>
<!DOCTYPE html>
<html>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
	<head>
	<script src="https://code.jquery.com/jquery-3.6.1.min.js" integrity="sha256-o88AwQnZB+VDvE9tvIXrMQaPlFFSUTR+nldQm1LuPXQ=" crossorigin="anonymous"></script>
	</head>
	<body>
		<h4>구구단</h4>
		<pre>2단부터 9단까지의 구구단 랜더링.</pre>
		<pre>출력되는 구구단 text형식: "2 * 2 = 4"</pre>
		??파싱>??포맷팅??
		<form name ="gugudanForm">
		
			최소단 : <input type="number"  value ="<%=min %>" name ="minDan" min="2" max="9" required/>
			최대단 :
			<select name = "maxDan" required >
				<option value>최대단</option>			
				<%=options %>
			</select>
			<input type = "submit" value ="전송"/>
		</form>
		<table id ="gugudanTable">
			<%=gugudan %>			
		</table>
		<script type ="text/javascript">
//			document.gugudanForm.maxDan.value ="#maxDan#";
			
			$("[name='maxDan']").val("<%=max %>");
			$("form:first").on("submit",function(event){
				event.preventDefault(); 		
			  /*console.log(this);
				console.log(event.target);
				console.log($(this).attr("name")); */
				let url = this.action;
				let method = this.method;
				let data = $(this).serialize();//query string 생성
				
				$.ajax({
					url : url,
					method : method,
					data : data,
					dataType : "html",
					success : function(resp) {
						$("#gugudanTable").html(resp);
					},
					error : function(errorResp) {
						console.log(errorResp.status);
					}
				})
				return false;//첫번째 중간시키는 방법
				
			});
		</script>
	
	</body>
</html>