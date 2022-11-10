<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<table class="table table-bordered" id="slotTbl">
	<tr id="row0">
		<td id="row0_col0"></td>
		<td id="row0_col1"></td>
	</tr>
	<tr id="row1">
		<td id="row1_col0"></td>
		<td id="row1_col1"></td>
	</tr>
</table>
<select id="caseSel">
	<c:forEach items="${caseIds }" var="caseId">
		<option>${caseId }</option>
	</c:forEach>
</select>
<input id="genBtn" type="button" value="genCSS" />
<script>
	let slotTbl = $("#slotTbl").css("min-height", "500px");
	let caseSel = $("#caseSel").on("change", function(){
		let caseId = $(this).val();
		let styleTag = $("#dynamicStyle");
		if(styleTag.length==0){
			styleTag = $("<link rel='stylesheet'>").prop("id", "dynamicStyle");
			$("head").append(styleTag);
		}
		console.log(styleTag);
		styleTag.attr("href", "${cPath}/dynamic/genStyle.css?caseId="+caseId);
	}).hide();
	
	let clickCount = 1;
	$("#genBtn").on("click", function(){
		let options = caseSel.find("option");
		let count = options.length;
		let idx = clickCount++%count;
		$(options[idx]).prop("selected", true);
		caseSel.trigger("change");
	});
</script>
