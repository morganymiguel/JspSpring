package kr.or.ddit.board.vo;

import java.util.UUID;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.springframework.web.multipart.MultipartFile;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@EqualsAndHashCode(of="attNo")
@NoArgsConstructor
public class AttatchVO {
	private MultipartFile adaptee;
	
	public AttatchVO(MultipartFile adaptee) {
		super();
		this.adaptee = adaptee;
		this.attFilename = adaptee.getOriginalFilename();
		this.attSavename = UUID.randomUUID().toString();
		this.attMime = adaptee.getContentType();
		this.attFilesize = adaptee.getSize();
		this.attFancysize = FileUtils.byteCountToDisplaySize(attFilesize);
	}
	
	@NotNull
	private Integer attNo;
	private Integer boNo;
	@NotBlank
	private String attFilename;
	@NotBlank
	private String attSavename;
	private String attMime;
	@NotNull
	private Long attFilesize;
	@NotBlank
	private String attFancysize;
	private Integer attDownload;
}
