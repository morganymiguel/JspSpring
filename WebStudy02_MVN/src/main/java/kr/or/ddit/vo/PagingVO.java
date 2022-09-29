package kr.or.ddit.vo;

import java.util.List;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class PagingVO<T> {
	
	public PagingVO(int screenSize, int blockSize) {
		super();
		this.screenSize = screenSize;
		this.blockSize = blockSize;
	}

	private int totalRecord;
	private int currentPage;
	private int screenSize=10;
	private int blockSize=5;
	private int totalPage;
	
	private int startRow;
	private int endRow;
	private int startPage;
	private int endPage;
	
	private SearchVO simpleCondition;
	private T detailCondition;
	
	private List<T> dataList;
	
	public void setDetailCondition(T detailCondition) {
		this.detailCondition = detailCondition;
	}
	
	public void setSimpleCondition(SearchVO simpleCondition) {
		this.simpleCondition = simpleCondition;
	}
	
	public void setTotalRecord(int totalRecord) {
		this.totalRecord = totalRecord;
		totalPage = (totalRecord+(screenSize-1)) / screenSize;
	}
	
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
		endRow = currentPage * screenSize;
		startRow = endRow - (screenSize - 1);
		endPage = blockSize * ((currentPage + (blockSize - 1)) / blockSize);
		startPage = endPage - (blockSize - 1);
	}
	
	public void setDataList(List<T> dataList) {
		this.dataList = dataList;
	}
	
	String pattern = "<a href='#' data-page='%d'>%s</a>";
	public String getPagingHTML() {
		StringBuffer html = new StringBuffer();
		
		endPage = endPage > totalPage ?  totalPage : endPage;
		
		if(startPage > blockSize) {
			html.append(
				String.format(pattern, startPage-blockSize, "이전")	
			);
		}
		
		for(int page = startPage; page <= endPage; page++) {
			if(page == currentPage) {
				html.append(page);
			}else {
				html.append(
					String.format(pattern, page, page)
				);
			}
		}
		
		if(endPage < totalPage) {
			html.append(
				String.format(pattern, endPage+1, "다음")	
			);
		}
		
		return html.toString();
	}
	
//	<nav aria-label="Page navigation example">
//	  <ul class="pagination justify-content-center">
//	    <li class="page-item disabled">
//	      <a class="page-link">Previous</a>
//	    </li>
//	    <li class="page-item"><a class="page-link" href="#">1</a></li>
//	    <li class="page-item active"><a class="page-link" href="#">2</a></li>
//	    <li class="page-item"><a class="page-link" href="#">3</a></li>
//	    <li class="page-item">
//	      <a class="page-link" href="#">Next</a>
//	    </li>
//	  </ul>
//	</nav>
	
//	public String getPagingHTMLBS
}



















