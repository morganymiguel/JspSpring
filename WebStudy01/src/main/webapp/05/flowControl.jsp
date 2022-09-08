<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%! public static String temp = "TEMP"; %>//전역변수로는 데이터 공유를 못한다. 이걸 알아야 기본객체와 스쿼프 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>05/flowControl.jsp</title>
</head>
<body>
<h4>흐름 제어(페이지 이동 구조)</h4>
<pre>
	1. Request Dispatch : 이동 과정에서 최초의 요청을 가지고 분기함.
	 1) Forward : 요청 -> A 페이지 -> B 페이지 -> 응답 , Model2 Architecture
	 2) Include : 요청 -> A 페이지 -> B 페이지 -> A 페이지로 복귀(B 데이터 일부) -> 응답, 페이지 모듈화
	<%
// 		request.getRequestDispatcher(path).forward(request, response);
// 	 	최초로 받은 걸 넘겨준다.
		String path="/02/standard.jsp";//서버가 사용하기에 서버 사이드 방식으로 경로를 써준다.
// 		request.getRequestDispatcher(path).forward(request, response);
// 		request.getRequestDispatcher(path).include(request, response);
	%>
	
	요청을 하면 요청1에 해당되는 1:1구조가 생기지만 그 요청에 응답을 보내는게 아니라 B로 보내고 그거에 대한 응답을 c에 보내서 계속 남아있는다.
	2. Redirect: 이동 과정에서 최초의 요청에 대한 응답이 먼저 전송됨.
		최초의 요청(명령)에 대한 처리가 완료되어 더이상 저장할 필요가 없음.
		요청1 -> 응답1(Line(302), Header(Location)) -> 클라이언트 -> 요청2(Location) -> 응답2(Body Contents)
	include구조;?;절대경로?상대경로?
	HTTP 0 c.l, s.l.
	<%
		response.sendRedirect(request.getContextPath() + path);

	%>		
</pre>
</body>
</html>