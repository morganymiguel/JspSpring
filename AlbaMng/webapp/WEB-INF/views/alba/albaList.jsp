<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-striped table-bordered">
	<thead class="table-header thead-dark">
		<tr>
			<th>이름</th>
			<th>나이</th>
			<th>학력</th>
			<th>거주지</th>
			<th>휴대폰</th>
			<th>메일</th>
		</tr>
	</thead>
	<tbody id="listBody" data-view="${pageContext.request.contextPath }/alba/albaView.do">
		<c:set var="dataList" value="${pagingVO.dataList }" />
		<c:if test="${not empty dataList }">
			<c:forEach items="${dataList }" var="alba">
				<c:url value="/alba/albaView.do" var="albaViewURL">
					<c:param name="who" value="${alba.alId }" />
				</c:url>
				<tr>
					<td><a href="${albaViewURL }">${alba.alName }(${alba.alGen })</a></td>
					<td>${alba.alAge }</td>
					<td>${alba.grName }</td>
					<td>${alba.alAdd1 }</td>
					<td>${alba.alHp }</td>
					<td>${alba.alMail }</td>
				</tr>
			</c:forEach>
		</c:if>
		<c:if test="${empty dataList }">
			<tr>
				<td colspan="6">검색된 데이터가 없음.</td>
			</tr>
		</c:if>
	</tbody>
	<tfoot>
		<tr>
			<td colspan="6">
				<div id="searchUI" class="d-flex justify-content-center mb-3">
					<div class="d-inline mr-2">
						<select name="grCode" class="form-control">
							<option value>전체</option>
						</select>
					</div>
					<div class="d-inline mr-2">	
						<select name="licCodes" class="form-control">
							<option value>전체</option>
						</select>
					</div>
					<div class="d-inline mr-2">	
						<div class="form-check form-check-inline">
							<input type="radio" name="alGen" id="alGen_a" value="" class="form-check-input" checked/>
							<label for="alGen_a"  class="form-check-label">전체</label>
						</div>			
						<div class="form-check form-check-inline">
							<input type="radio" name="alGen" id="alGen_m" value="M" class="form-check-input"/>
							<label for="alGen_m"  class="form-check-label">남</label>
						</div>			
						<div class="form-check form-check-inline">
							<input type="radio" name="alGen" id="alGen_f" value="F" class="form-check-input"/>
							<label for="alGen_f" class="form-check-label">여</label>
						</div>
					</div>
					<div class="d-inline mr-2">
						<select name="searchType" class="form-control mr-2">
							<option value="name">이름</option>
							<option value="address">거주지</option>
							<option value="career">경력사항</option>
						</select>
					</div>
					<div class="d-inline mr-2">	
						<input type="text" name="searchWord"  class="form-control mr-2"
							value="${param.searchWord }"
						/>
					</div>	
					<div class="d-inline">
						<input type="button" value="검색" id="searchBtn" class="btn btn-primary mr-2"/>
						<a class="btn btn-primary" href="<c:url value='/alba/albaInsert.do'/>">신규등록</a>
					</div>
				</div>	
				<div class="d-flex justify-content-center pagingArea" aria-label="Pagination">
					${pagingVO.pagingHTMLBS }
				</div>
			</td>
		</tr>
	</tfoot>
</table>
<form id="searchForm" action="${pageContext.request.contextPath }/alba/albaList.do">
	<input type="hidden" name="page" />
	<input type="hidden" name="searchType" />
	<input type="hidden" name="searchWord" />
	<input type="hidden" name="grCode" />
	<input type="hidden" name="licCodes" />
	<input type="hidden" name="alGen" />
</form>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/alba/codeSelect.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/paging.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/alba/albaList.js"></script>
