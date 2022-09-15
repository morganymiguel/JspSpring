<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<jsp:include page="/includee/preScript.jsp"/>
<title>Insert title here</title>
<script type="text/javascript">
function timeArea(time){
	var time = time;
	var txt = document.querySelector("#timerArea");
	var hour = parseInt(time/3600);
	
	var min = parseInt((time%3600)/60);
	var sec = time%60;
	
	var times = "";
	if(hour== 0 ){
		times = min+":" + sec;
	}else{
		times = hour+":"+min+":" + sec;
	}
	txt.textContent= times;
	
}

window.onload = function() {
	<% 
		session.setMaxInactiveInterval(60+59);
	%>
	var time = <%= session.getMaxInactiveInterval() %>

	for(var i = 0; i<200; i++){
		
		setTimeout(timeArea(time), 1000);
		
	}
};

</script>
</head>
<body>
<h4>세션 타이머</h4>
<div id="timerArea">1:59</div>
<div id = "msgArea">
	세션 만료 시간이 1분 남았음. 연장챙겨!
	<input type ="button" value="YES" class = "ctrlBtn"/>
	<input type ="button" value="NO" class = "ctrlBtn"/>
	1. jsp폈을때, session를 저장하고 카운트. 
	2. 1분이 남았을때, 물어보고 연장,
		연장을 할 경우 비동기 get방식으로 세션만 늘려준다.
	3. no를 선택했을때 그대로 시간이 흘러가고 세션종료. 
	
	
	1. session timeout 초기값으로 갖는 타이머 출력.
	2. 1초를 주기로 타이머를 디스카운트.setInterval
		->타이머가 0이 되면, 디스카운트 중단.
	
	3. "Timeout - 60" 동안 대기한 후 메시지 창(modal)디스플레이
	
	4.1. No 버튼 클릭. 메시지창 닫기
	
	4-2. Yes 버튼 클릭,
	1) 서버의 세션을 연장하기 위한 비동기 요청. : response body가 없도록 method설정(body의 정보를 요청하지 않는 형태.)
	2) 타이머 리셋
	3) 메시지 창 닫기.
	 
</div>
<jsp:include page="/includee/postScript.jsp"/>
</body>
</html>