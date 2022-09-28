package kr.or.ddit.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {
	private Integer empno; //사원번호
	private String ename; //사원명
	private String job; //직무
	private Integer mgr; //사수사원번호
	private String hiredate; //고용날짜
	private Integer sal; //급여
	private Integer comm; //보너스급여
	private Integer deptno; //부서번호
	
	private String strmgr; //사수명
	private DeptVO dept; //부서정보
}
