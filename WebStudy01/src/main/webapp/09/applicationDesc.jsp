<%@page import="java.io.BufferedOutputStream"%>
<%@page import="java.io.FileOutputStream"%>
<%@page import="java.io.BufferedInputStream"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>09/applicationDesc.jsp</title>
</head>
<body>
<h4>application(ServletContext)</h4>
CAC(Context Aware Computing)
<pre>
   application hashcode : <%=application.hashCode() %>
   <a href = "../08/sessionTimer.jsp">세션 타이머</a>
   <a href ="<%=application.getContextPath() %>/desc">desc servlet</a>
   1. 서버의 정보를 가져올 떄.
      - 서버를 식별할 떄. <%=application.getServerInfo() %>
                  <%=application.getMajorVersion() %>,<%=application.getMinorVersion() %>
      - Mime Type 확인할 때. getMimeType(file_name)
   2. context 정보를 가져올 때. 
      - 초기화 파라미터 획득.  getInitParameter      (web.xml -> context-param 이라는 element이용)
            <%=application.getInitParameter("imageFolderPath") %>
      - 현재 context의 web resource 확보
      <%
      
         String url = "/resources/images/cat4.png";
         String saveUrl = "/09/cat4.png";
         //이렇게만 하면 file 객체를 생성할 수 없음, 절대경로가 필요함. 
         //그런데 절대경로는 서버가 어디서 도느냐에 따라서 다 달라짐. 이런 경우에 application 사용
         
         String path = application.getRealPath(url);
         String savePath = application.getRealPath(saveUrl);
               
//         File file(url);
         File file = new File(path);
         File saveFile = new File(savePath);
         
         // ---여기까지는 매체를 생성하는 과정
         
         try(
         
            FileInputStream fis = new FileInputStream(file);
            InputStream is = application.getResourceAsStream(url);
            BufferedInputStream bis = new BufferedInputStream(fis);
            
            FileOutputStream fos = new FileOutputStream(saveFile);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
         ){
            int temp = -1;
            while((temp = bis.read())!= -1){
               bos.write(temp);
            }
         }
         
      %>
      url : <%=url %>
      path : <%=path %>
      file : <%=file.getCanonicalPath() %>
      
   3. 로그 기록 <% application.log("메시지 기록");  %>
</pre>
<img src="<%=request.getContextPath()%>/09/cat4.png">


</body>
</html>