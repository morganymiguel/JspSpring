<%@page import="kr.or.ddit.enumpkg.BrowserType"%>
<%@page import="java.util.Map.Entry"%>
<%@page import="java.util.LinkedHashMap"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>04/userAgent.jsp</title>
</head>
<body>
<h4>UserAgent</h4>

<%
	String browserName = BrowserType.searchBrowserName(request);
	out.println(
			String.format("당신의 브라우저는 '%s'입니다.", browserName)
			);
	
	
	
// 	Map<String, String> agentMap = new LinkedHashMap<>();
// 	agentMap.put("TRIDENT","IE");
// 	agentMap.put("EDG", "엣지");
// 	agentMap.put("CHROME", "크롬");
// 	agentMap.put("SAFARI", "사파리");
// 	agentMap.put("FIREFOX", "파이어폭스");
// 	agentMap.put("OTHER", "기타");
	
// 	String browserName = agentMap.get("OTHER");
// 	for(Entry<String, String> entry : agentMap.entrySet()){
// 		if(agent.indexOf(entry.getKey())>-1){
// 			browserName = entry.getValue();
// 			break;
// 		}
// 	}
	
// 	out.println(
// 			String.format("당신의 브라우저는 '%s'입니다.",browserName)
// 			);
	
%>

</body>
</html>