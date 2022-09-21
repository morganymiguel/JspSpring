<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	MemberVO member = (MemberVO) request.getAttribute("member");
%>
<table>
	<tr>
		<th>회원아이디</th>
		<td><%= member.getMemId()%></td>
	</tr>
	<tr>
		<th>이름</th>
		<td><%= member.getMemName()%></td>
	</tr>
	<tr>
		<th>지역</th>
		<td><%= member.getMemAdd1()%></td>
	</tr>
	<tr>
		<th>전화버ㅏㄴ호</th>
		<td><%= member.getMemHp()%></td>
	</tr>
	<tr>
		<th>이메일</th>
		<td><%= member.getMemMail()%></td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td><%= member.getMemMileage()%></td>
	</tr>
	
</table>