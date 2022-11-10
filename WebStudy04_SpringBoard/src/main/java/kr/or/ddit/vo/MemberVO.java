package kr.or.ddit.vo;

import java.util.List;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(of="memId")
public class MemberVO {

	private String memId;
	private String memName;
	private String memPass;
	
	private List<String> memRoles;
}
