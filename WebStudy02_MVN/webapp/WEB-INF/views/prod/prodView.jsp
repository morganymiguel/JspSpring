<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="kr.or.ddit.vo.BuyerVO"%>
<%@page import="kr.or.ddit.vo.ProdVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ProdVO prod = (ProdVO) request.getAttribute("prod");
%>    
<table class="table table-bordered">
	<tr>
		<th>상품명</th>
		<td><%=prod.getProdName()%></td>
	</tr>
	<tr>
		<th>분류명</th>
		<td><%=prod.getLprodNm()%></td>
	</tr>
	<th>거래처</th>
	<td>
		<table class="table table-bordered">
			<thead>
				<tr>
					<th>거래처명</th>
					<th>소재지</th>
					<th>담당자명</th>
					<th>연락처</th>
					<th>거래은행명</th>
					<th>은행계좌</th>
				</tr>
			</thead>
			<tbody>
				<%
					BuyerVO buyer = prod.getBuyer();
				%>
				<tr>
					<td><%=buyer.getBuyerName() %></td>
					<td><%=buyer.getBuyerAdd1() %></td>
					<td><%=buyer.getBuyerCharger() %></td>
					<td><%=buyer.getBuyerComtel() %></td>
					<td><%=buyer.getBuyerBankname() %></td>
					<td><%=buyer.getBuyerBankno() %></td>
				</tr>
			</tbody>
		</table>
	</td>
	<tr>
		<th>구매가</th>
		<td><%=prod.getProdCost()%></td>
	</tr>
	<tr>
		<th>판매가</th>
		<td><%=prod.getProdPrice()%></td>
	</tr>
	<tr>
		<th>세일가</th>
		<td><%=prod.getProdSale()%></td>
	</tr>
	<tr>
		<th>개요</th>
		<td><%=prod.getProdOutline()%></td>
	</tr>
	<tr>
		<th>상세정보</th>
		<td><%=prod.getProdDetail()%></td>
	</tr>
	<tr>
		<th>상품이미지</th>
		<td><%=prod.getProdImg()%></td>
	</tr>
	<tr>
		<th>총재고</th>
		<td><%=prod.getProdTotalstock()%></td>
	</tr>
	<tr>
		<th>입고일</th>
		<td><%=prod.getProdInsdate()%></td>
	</tr>
	<tr>
		<th>적정재고</th>
		<td><%=prod.getProdProperstock()%></td>
	</tr>
	<tr>
		<th>크기</th>
		<td><%=prod.getProdSize()%></td>
	</tr>
	<tr>
		<th>색상</th>
		<td><%=prod.getProdColor()%></td>
	</tr>
	<tr>
		<th>배송방법</th>
		<td><%=prod.getProdDelivery()%></td>
	</tr>
	<tr>
		<th>단위</th>
		<td><%=prod.getProdUnit()%></td>
	</tr>
	<tr>
		<th>입고량</th>
		<td><%=prod.getProdQtyin() %></td>
	</tr>
	<tr>
		<th>판매량</th>
		<td><%=prod.getProdQtysale() %></td>
	</tr>
	<tr>
		<th>마일리지</th>
		<td><%=prod.getProdMileage() %></td>
	</tr>
	<tr>
		<th>구매자 정보</th>
		<td>
			<table>
			<thead>
			<tr>
			<th>아이디</th><th>이름</th><th>지역</th><th>마일리지</th>
			</tr>
			</thead>
			<tbody>
			<%
				for(MemberVO member : prod.getMemberList()){
									
			%>
				<tr>
				<td><%=member.getMemId() %></td>
				<td><%=member.getMemName() %></td>
				<td><%=member.getMemAdd1() %></td>
				<td><%=member.getMemMileage() %></td>
			</tr>
			<%
				}
			%>
			</tbody>
			</table>
		</td>
	</tr>
</table>












