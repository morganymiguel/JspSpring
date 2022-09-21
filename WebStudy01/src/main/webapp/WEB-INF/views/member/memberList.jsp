<%@page import="kr.or.ddit.vo.MemberVO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<table class="table table-bordered">
	<thead>
		<tr>
			<th>회원아이디</th>
			<th>회원명</th>
			<th>이메일</th>
			<th>휴대폰</th>
			<th>지역</th>
			<th>마일리지</th>
		</tr>
	</thead>
	<tbody>
		<%
			List<MemberVO> memberList = (List) request.getAttribute("memberList");
			if(memberList.isEmpty()){
				%>
				<tr>
					<td colspan="6">회원이 없음.</td>
				</tr>
				<%
			}else{
				for(MemberVO member : memberList){
					%>
					<tr data-who="<%=member.getMemId() %>"
					 data-bs-target="#exampleModal">
  >
						<td><%=member.getMemId() %></td>
						<td><%=member.getMemName() %></td>
						<td><%=member.getMemMail() %></td>
						<td><%=member.getMemHp() %></td>
						<td><%=member.getMemAdd1() %></td>
						<td><%=member.getMemMileage() %></td>
					</tr>
					<%
				}
			}
		%>
	
	</tbody>
</table>
<form id='viewForm' action="<%=request.getContextPath() %>/member/memberView.do">
	<input type='hidden' name='who'  />
</form>
<!-- Modal -->
<div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
  <div class="modal-dialog">
    <div class="modal-content">
      <div class="modal-header">
        <h5 class="modal-title" id="exampleModalLabel">Modal title</h5>
        <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
      </div>
      <div class="modal-body">
        ...
      </div>
      <div class="modal-footer">
        <button type="button" class="btn btn-secondary" data-bs-dismiss="modal">Close</button>
        <button type="button" class="btn btn-primary">Save changes</button>
      </div>
    </div>
  </div>
</div>
<script type="text/javascript">
	let viewModal = $("#exampleModal").on("hidden.bs.modal",function(event){
		$(this).find(".modal-body").empty();
	}).on("click",function(){	
	});
	let viewForm = $("#viewForm").on("submit", function(event){
		event.preventDefault();
		let url = this.action;
		let method = this.method;
		let data = $(this).serialize(); // ajaxForm 적용
		$.ajax({
			url : url,dd
			method : method,
			data : data,
			dataType : "html",
			success : function(resp) {
				viewModal.find(".modal-body").html(resp);
				viewModal.modal('show');
			},
			error : function(errorResp) {
				console.log(errorResp.status);
				viewModal.find(".modal-body").html(errorResp.responseText);
				viewModal.modal('show');
			}
		});
		return false;
	});
// 	$(document).on("click", '.dataTr', function(event){
// 		let who = $(this).data('who');
// 		viewForm.find('[name=who]').val(who);
// 		viewForm.submit();
// 		viewForm.get(0).reset();
<%-- <%-- 		location.href="<%=request.getContextPath() %>/member/memberView.do?who="+who; --%> --%>
// 	});
</script>














