<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<h4>등록 및 수정 양식</h4>
<spring:eval expression="@appInfo['profile.image']" var="profileImage" />
<form:form modelAttribute="alba" method="post" id="albaForm" enctype="multipart/form-data">
<form:hidden path="alId"  />
	<table class="table table-bordered">
			<tr>
				<th>이름</th>
				<td>
					<div class="input-group">
					<form:input path="alName" required="required" cssClass="form-control" maxlength="20" />
					<form:errors path="alName" element="span" cssClass="error form-control-plaintext" />
					</div>
				</td>
			</tr>
			<tr>
				<th>나이</th>
				<td>
					<div class="input-group">
						<form:input type="number" path="alAge" required="required" cssClass="form-control" />
						<form:errors path="alAge" element="span" cssClass="error form-control-plaintext" />
					</div>
				</td>
			</tr>
			<tr>
				<th>사진</th>
				<td>
					<input type="file" name="alImage" id="alImage" class="border-0" />
					<c:if test="${empty alba.alImg }">
						<img style="width: 100px; height: 100px; display: none" class="alImage"/>
					</c:if>
					<c:if test="${not empty alba.alImg }">
						<img src="${pageContext.request.contextPath }${profileImage }/${alba.alImg }" class="alImage thumbnail" />
					</c:if>
					<form:errors path="alImage" element="span" cssClass="error form-control-plaintext" />
				</td>
			</tr>
			<tr>
				<th>우편번호</th>
				<td>
					<div class="input-group">
						<form:input cssClass="form-control" required="required" path="alZip" 
								maxLength="7" pattern="[0-9]{3}-[0-9]{3}" readonly="true"
								data-msg-required="우편번호 필수" data-msg-pattern="형식확인"/>
						<input type="button" id="zipSearchBtn" class="btn btn-info ml-3" value="우편번호 검색" />
						<form:errors path="alZip" element="span" cssClass="error form-control-plaintext" />
					</div>
				</td>
			</tr>
			<tr>
				<th>주소1</th>
				<td>
					<div class="input-group">
						<form:input cssClass="form-control" required="required" path="alAdd1" 
								maxLength="200" readonly="true"  data-msg="주소 필수" />
						<form:errors path="alAdd1" element="span" cssClass="error form-control-plaintext" />
					</div>		
				</td>
			</tr>
			<tr>
				<th>주소2</th>
				<td>
					<div class="input-group">
						<form:input cssClass="form-control" required="required" path="alAdd2" 
								maxLength="200" readonly="true"  data-msg="주소 필수" />
						<form:errors path="alAdd2" element="span" cssClass="error form-control-plaintext" />
					</div>
				</td>
			</tr>
			<tr>
				<th>휴대폰</th>
				<td>
					<div class="input-group">
						<form:input path="alHp" required="required" class="form-control" maxlength="15" value="${alba.alHp }" />
						<form:errors path="alHp" element="span" cssClass="error form-control-plaintext" />
					</div>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
				<div class="input-group">
				<div class="form-check form-check-inline">
					<form:radiobutton path="alGen" id="alGen_m" value="M" cssClass="form-check-input"/>
					<label for="alGen_m"  class="form-check-label">남</label>
				</div>			
				<div class="form-check form-check-inline">
					<form:radiobutton path="alGen" id="alGen_f" value="F" cssClass="form-check-input"/>
					<label for="alGen_f" class="form-check-label">여</label>
				</div>
				<span class="error">${errors["alGen"] }</span>
				</div>
				</td>
			</tr>
			<tr>
				<th>이메일</th>
				<td><div class="input-group"><form:input path="alMail" required="required"  class="form-control" maxlength="100" value="${alba.alMail }" />
				<form:errors path="alMail" element="span" cssClass="error form-control-plaintext" /></div></td>
			</tr>
			<tr>
				<th>최종학력</th>
				<td><div class="input-group">
					<select name="grCode"  class="form-control">
						<option value="">학력선택</option>
						<c:forEach items="${grades }" var="grade">
							<option value="${grade.grCode }" ${grade.grCode eq alba.grCode ? "selected":"" }>${grade.grName }</option>
						</c:forEach>
					</select>
					<script>
						$("[name='grCode']").val("${alba.grCode }");
					</script>
				<form:errors path="grCode" element="span" cssClass="error form-control-plaintext" /></div></td>
			</tr>
			<tr>
				<th>자격증</th>
				<td>
				<div class="input-group mb-3">
					<c:forEach items="${alba.licenseList }" var="licAlba" varStatus="vs">
						&nbsp;
						<c:if test="${not empty licAlba.licCode }">
							<span id="${licAlba.licCode }"  class="input-group-text">
								${licAlba.licName } &nbsp;
								<input type="button" class="btn btn-danger delBtn" value="삭제" 
										data-code="${licAlba.licCode }"/>
							</span>
						</c:if>
					</c:forEach>
				</div>	
				<div id="licenseArea">	
					<div class="input-group">
						<select name="licCodes" class="form-control" multiple size="6">
							<c:forEach items="${licenses }" var="license">
								<c:set var="matched" value="${false }"/>
								<c:forEach items="${alba.licenseList }" var="licAlba">
									<c:if test="${licAlba.licCode eq license.licCode }">
										<c:set var="matched" value="${true }"/>
									</c:if>
								</c:forEach>
								<option value="${license.licCode }" class="${matched?'matched':'normal' }">${license.licName }</option>
							</c:forEach>
						</select>
						<form:errors path="licCodes" element="span" cssClass="error form-control-plaintext" />
					</div>
				</div>
				</td>
			</tr>
			<tr>
				<th>경력사항</th>
				<td><div class="input-group"><textarea  name="alCareer"  class="form-control" maxlength="200">${alba.alCareer }</textarea>
				<form:errors path="alCareer" element="span" cssClass="error form-control-plaintext" /></div></td>
			</tr>
			<tr>
				<th>특기사항</th>
				<td><div class="input-group"><textarea  name="alSpec"  class="form-control" maxlength="500">${alba.alSpec }</textarea>
				<form:errors path="alSpec" element="span" cssClass="error form-control-plaintext" /></div></td>
			</tr>
			<tr>
				<th>비고</th>
				<td><div class="input-group"><textarea  name="alDesc"  class="form-control" maxlength="500">${alba.alDesc }</textarea>
				<form:errors path="alDesc" element="span" cssClass="error form-control-plaintext" /></div></td>
			</tr>
			<tr>
			<td colspan="2">
				<button type="submit" class="btn btn-primary">등록</button>
				<button type="reset" class="btn btn-warning">취소</button>
				<button type="button" onclick="location.href='<c:url value="/alba/albaList.do"/>';" class="btn btn-info">목록으로</button>
				<button type="button" onclick="history.back();" class="btn btn-secondary">뒤로가기</button>
			</td>
		</tr>
	</table>
</form:form>
<script src="${pageContext.request.contextPath }/resources/js/DataTables/datatables.min.js"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/searchZip.js?${System.currentTimeMillis() }"></script>
<script type="text/javascript" src="${pageContext.request.contextPath }/resources/js/alba/albaForm.js?${System.currentTimeMillis() }"></script>


















