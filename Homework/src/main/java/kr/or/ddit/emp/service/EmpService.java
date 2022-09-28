package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.EmpVO;

public interface EmpService {
	public List<EmpVO> retrieveEmpList();
	public EmpVO retrieveEmp(int empNo);
	public ServiceResult createEmp(EmpVO emp);
	public ServiceResult modifyEmp(EmpVO emp);
	public ServiceResult removeEmp(int empNo);
}
