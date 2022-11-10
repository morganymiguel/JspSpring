let listBody = $("#listBody");
let pagingArea = $(".pagingArea");
let searchUI = $("#searchUI");
searchUI.on("change", ":input[name]", function(){
	searchUI.find("#searchBtn").click();
});
let searchForm = $("#searchForm").paging({
	listBody:listBody
	, pagingArea:pagingArea
	, searchUI:searchUI
	, searchBtn:"#searchBtn"
	, success : function(resp) {
			listBody.empty();
			pagingArea.empty();
			searchForm[0].page.value="";
			let list = resp.dataList;
			let trTags = [];
			if( list.length>0 ){
				$.each(list, function(idx, alba){
					trTags.push(
						$("<tr>").append(
							$("<td>").html(
									$("<a>").text(alba.alName+"("+ alba.alGen +")")
											.attr("href", CONTEXTPATH+"/alba/albaView.do?who="+alba.alId)
							),
							$("<td>").text(alba.alAge),
							$("<td>").text(alba.grName),
							$("<td>").text(alba.alAdd1),
							$("<td>").text(alba.alHp),
							$("<td>").text(alba.alMail)
						)
					);
					
				});
			}else{
				trTags.push($("<tr>").html($("<td colspan='6'>").text("조건에 맞는 상품이 없음.")));
			}
			listBody.html(trTags);
			pagingArea.html( resp.pagingHTML );
		}
});