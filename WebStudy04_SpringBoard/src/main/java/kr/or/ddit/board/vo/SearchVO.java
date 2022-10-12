package kr.or.ddit.board.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * 단순 키워드 검색에 활용.
 *
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SearchVO {
	private String searchType;
	private String searchWord;
}
