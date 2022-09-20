<%@page import="java.util.ArrayList"%>
<%@page import="kr.or.ddit.props.vo.PropertyVO"%>
<%@page import="java.util.List"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.SQLException"%>
<%@page import="java.sql.ResultSetMetaData"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%!

	private Connection oracleConn;
	private Statement oracleStmt;
	private ResultSet rs;
	private ResultSetMetaData rsmd;
	
	public void init() throws ServletException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>10/jdbcDesc.jsp</title>
</head>
<body>
<h4>JDBC(JavaDataBaseConnectivity)</h4>
<pre>
	1. 드라이버 빌드 패스에 추가(vendor 제공)
	2. 드라이버 로딩(어플리케이션 시작 시점에 한번)
	3. Connection 수립
	4. 쿼리 객체
		 Statement
		 PreparedStatement(선컴파일된 쿼리 객체)
		 CallableStatement(프로시져나 함수와 같은 절차 코드 호출에 사용.)
	5. 쿼리 실행
		ResultSet executeQuery : SELECT
		int executeUpdate : INSERT/UPDATE/DELETE
	6. 쿼리 실행 결과 처리
	7. 자원 해제(***)
</pre>

<%
	try {
		Class.forName("oracle.jdbc.driver.OracleDriver");
	} catch (ClassNotFoundException e) {}

	String oracleURL = "jdbc:oracle:thin:@//localhost:1521/XE";
	String oracleUser = "ddit";
	String oraclePassword = "java";
	String sql = "SELECT PROPERTY_NAME, PROPERTY_VALUE, DESCRIPTION FROM DATABASE_PROPERTIES";
	
	List<PropertyVO> dataList = new ArrayList<>();
	String[] headers = null;
	
	
	try(
		Connection oracleConn = DriverManager.getConnection(oracleURL, oracleUser, oraclePassword);
		Statement oracleStmt = oracleConn.createStatement();
	) {
		rs = oracleStmt.executeQuery(sql);
		rsmd = rs.getMetaData();
		int count = rsmd.getColumnCount();
		headers = new String[count];
		for(int i = 1; i <= count; i++){
			headers[i-1] = rsmd.getColumnName(i);
		}
		while(rs.next()){
			PropertyVO vo = new PropertyVO();
			dataList.add(vo);
			vo.setPropertyName(rs.getString("PROPERTY_NAME"));
			vo.setPropertyValue(rs.getString("property_value"));
			vo.setDescription(rs.getString("DESCRIPTION"));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
%>

	<table border="1">
		<thead>
			<tr>
				<th><%=headers[0] %></th>
				<th><%=headers[1] %></th>
				<th><%=headers[2] %></th>
			</tr>
		</thead>
	
		<tbody>
<% 
		
		for(PropertyVO vo : dataList) {
%>
		<tr>
			<td><%=vo.getPropertyName() %></td>
			<td><%=vo.getPropertyValue() %></td>
			<td><%=vo.getDescription() %></td>
			
		</tr>
<%
		}
	
%>
	</tbody>
</table>
</body>
</html>
















