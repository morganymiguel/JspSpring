<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<table class="table table-bordered table-striped">
	<thead class="table-dark">
		<tr>
			<th>사원번호</th>
			<th>사원명</th>
			<th>직무</th>
			<th>사수사원번호</th>
			<th>사수사원명</th>
			<th>고용날짜</th>
			<th>급여</th>
			<th>보너스급여</th>
			<th>부서번호</th>
			<th>부서정보</th>
		</tr>
	</thead>
	<tbody>
		<c:choose>
			<c:when test="${not empty empList }">
				<c:forEach items="${empList }" var="emp">
					<c:url value="/emp/empView.do" var="viewURL">
						<c:param name="what" value="${emp.empId }" />
					</c:url>
					<tr>
						<td><a href="${viewURL }">${emp.empName }</a></td>
						<td>${emp.lempNm }</td>
						<td>${emp.empPrice }</td>
						<td>${emp.empCost }</td>
						<td>${emp.empMileage }</td>
						<td>${emp.buyer.buyerName }</td>
						<td>${emp.memCount }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="7">사원 없음.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
</table>











