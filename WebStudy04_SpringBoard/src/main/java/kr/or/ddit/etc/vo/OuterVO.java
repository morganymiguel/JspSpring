package kr.or.ddit.etc.vo;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
public class OuterVO {
	@NotBlank
	private String outProp1;
	@NotBlank
	private String outProp2;
	@NotNull
	@Valid
	private InnerVO inner;
}
