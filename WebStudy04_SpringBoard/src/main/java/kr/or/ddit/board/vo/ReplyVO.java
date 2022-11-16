package kr.or.ddit.board.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode
public class ReplyVO {
	private Integer repNo;
	private Integer boNo;
	private String repContent;
	private String repWriter;
	private String repMail;
	private String repPass;
	private String repDate;
	private Integer repParent;
}
