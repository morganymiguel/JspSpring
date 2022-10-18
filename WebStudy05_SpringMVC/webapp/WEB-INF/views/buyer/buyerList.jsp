<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>    
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>    
<table class="table table-bordered">
	<thead>
		<tr>
			<th><spring:message code="buyer.rnum"/></th>
			<th><spring:message code="buyer.buyerName"/></th>
			<th><spring:message code="buyer.buyerLgu"/></th>
			<th><spring:message code="buyer.buyerAdd1"/></th>
			<th><spring:message code="buyer.buyerComtel"/></th>
			<th><spring:message code="buyer.buyerCharger"/></th>
			<th><spring:message code="buyer.prodCount"/></th>
		</tr>
	</thead>
	<tbody>
		<c:set var="buyerList" value="${pagingVO.dataList }" />
		<c:choose>
			<c:when test="${not empty buyerList }">
				<c:forEach items="${buyerList }" var="buyer">
					<c:url value="/buyer/buyerView.do" var="viewURL">
						<c:param name="what" value="${buyer.buyerId }" />
					</c:url>
					<tr>
						<td>${buyer.rnum }</td>
						<td>
							<a href="${viewURL }">${buyer.buyerName }</a>
						</td>
						<td>${buyer.lprodNm }</td>
						<td>${buyer.buyerAdd1 }</td>
						<td>${buyer.buyerComtel }</td>
						<td>${buyer.buyerCharger }</td>
						<td>${buyer.prodCount }</td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan="7">조건에 맞는 거래처 없음.</td>
				</tr>
			</c:otherwise>
		</c:choose>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="7">
				<div class="pagingArea mb-3">
					${pagingVO.pagingHTML }
				</div>
				<div id="searchUI" class="row g-3 justify-content-center">
					<div class="col-auto">
						<select name="buyerLgu" class="form-select" data-buyer-lgu="${pagingVO.detailCondition.buyerLgu}">
							<option value>거래처분류</option>
							<c:forEach items="${lprodList }" var="lprod">
								<option value="${lprod.lprodGu }"
									${lprod.lprodGu eq detailCondition.buyerLgu ? "selected" :"" }
								>${lprod.lprodNm }</option>
							</c:forEach>
						</select>
					</div>
					<div class="col-auto">
						<input type="text" name="buyerName" placeholder="거래처명"
							class="form-control"  value="${detailCondition.buyerName }"
							onchange="$(this).closest('#searchUI').find('#searchBtn').click();"
						/>
					</div>
					<div class="col-auto">
						<input type="button" value="검색" id="searchBtn"
							class="btn btn-primary"
						/>
					</div>
				</div>
			</td>
		</tr>
</tfoot>
</table>
<form id="searchForm">
	<input type="hidden" name="page" />
	<input type="hidden" name="buyerLgu" value="${pagingVO.detailCondition.buyerLgu }"/>
	<input type="hidden" name="buyerName"  value="${pagingVO.detailCondition.buyerName }"/>
</form>
<script src="<c:url value='/resources/js/buyer/buyerList.js'/>"></script>    
    