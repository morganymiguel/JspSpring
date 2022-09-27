<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- // 상품아이디, 상품명, 판매가, 구매가, 마일리지.  -->
<!-- // + 분류명, 거래처명, 해당 상품의 구매자수(mem_count) -->
<table class="table table-bordered table-striped">
	<thead class="table-dark">
		<tr>
			<th>상품명</th>
			<th>분류명</th>
			<th>판매가</th>
			<th>구매가</th>
			<th>마일리지</th>
			<th>거래처명</th>
			<th>구매자수</th>
		</tr>
	</thead>
	<tbody>
		<%
			List<ProdVO> prodList = (List)request.getAttribute("prodList");
			if(prodList.isEmpty()){
				%>
				<tr>
					<td colspan="7">상품 없음.</td>
				</tr>
				<%
			}else{
				for(ProdVO prod : prodList){
				%>
					<tr>
						<td><a href="<%=request.getContextPath() %>/prod/prodView.do?what=<%=prod.getProdId()%>"><%=prod.getProdName() %></a></td>
						<td><%=prod.getLprodNm() %></td>
						<td><%=prod.getProdPrice() %></td>
						<td><%=prod.getProdCost() %></td>
						<td><%=prod.getProdMileage() %></td>
						<td><%=prod.getBuyer().getBuyerName() %></td>
						<td><%=prod.getMemCount() %></td>
					</tr>
				<%
				}
			}
		%>
	</tbody>
</table>











