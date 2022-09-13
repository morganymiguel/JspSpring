<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>06/messageBundle.jsp</title>
<jsp:include page="/includee/preScript.jsp"/>

</head>
<body>
<input type="radio" name = "language" value="ko" checked/>한글
<input type="radio" name = "language" value="en" />영어
<button class="generate">버튼생성</button>
<button type ="button" data-data-type="json">JSON</button>
<button type ="button" data-data-type="xml">XML</button>
<span id ="resultArea"></span>
<script type="text/javascript">
// 	$("#json").on("click",function(){
// 		var datatype = "json";
// 		console.log(datatype)
// 		var language = $('input[name=language]:checked').val();
// 		var param = {language : language}		
// 		console.log(language)
// 		console.log(param)
// 		$.ajax({
<%-- 		url : "<%=request.getContextPath() %>/getMessage", --%>
// 		method : "get",
// 		data : param,
// 		datType : datatype
// 		success : function(resp) {

// 		},
// 		error : function(errorResp) {
// 			console.log(errorResp.status);
// 		}
// 		})
// 	})
// 	$('#xml').on("click",function(){
// 		var datatype = "xml";
// 		console.log(datatype)
// 	})
	$(".generate").on("click", function(){
		let newBtn  = $("<button>").text("HTML")
								   .data("dataType", "html");
		$("button:last").after(newBtn);
	})
	
// 	1. request 전송(front-end)
// 		1) 버튼(generate 버튼 제외, 동적 버튼 포함)click 이벤트 처리
// 		2) 비동기 요청 발생
// 			- 클릭이 발생한 버튼으로부터 data(data-type) 속성 확보 dataType
// 			- language 라디오 버튼의 값으로 파라미터 형성.
	let resultArea = $("#resultArea");
	let successFunctions = {
		json : function(resp){
			resultArea.html(resp.hello);
		},
		xml : function(resp){
			let text = $(resp).find("hello").text();
			resultArea.html(text);
			console.log(resp);			
		},
		html : function(resp){
			resultArea.html(resp);
						
		}
}
	$(document).on("click","button:not(.generate)",function(){
		resultArea.empty();
		let dataType = $(this).data('dataType');
		let settings ={

				url : "<%=request.getContextPath() %>/getMessage",
//	 			method : "get", get은 기본적으로 생략이 가능
				data : "",
				datType : "html",
				success : function(resp) {
					resp.hello
				},
				error : function(errorResp) {
					console.log(errorResp.status);
				}
		};
		settings['dataType'] = dataType ? dataType : "json";
		settings.success = successFunctions[settings.dataType]
		settings.data = {
				language : $("[name='language']:checked").val()
				};
		$.ajax(settings);
	})	
// 	2. response 생성(back-end)
// 		1) 메시지 번들 로딩(ResourceBundle)
// 		2) "hello"코드 메시지 확보
// 		3) 확보한 메시지를 컨텐츠화(accept 헤더에 따라 content-type 결정).
		
// 	3. response 수신 후 처리(front-end) : success function
		
</script>
</body>
</html>