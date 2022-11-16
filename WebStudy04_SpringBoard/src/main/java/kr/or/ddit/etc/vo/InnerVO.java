package kr.or.ddit.etc.vo;

import javax.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class InnerVO {
	@NotBlank
	private String inProp1;
	@NotBlank
	private String inProp2;
}
