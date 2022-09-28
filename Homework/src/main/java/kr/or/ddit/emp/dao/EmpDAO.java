package kr.or.ddit.emp.dao;

import java.util.List;

import kr.or.ddit.vo.EmpVO;

public interface EmpDAO {
	public List<EmpVO> selectEmpList();
	public EmpVO selectEmp(int empNo);
	public int insertEmp(EmpVO emp);
	public int updateEmp(EmpVO emp);
	public int deleteEmp(int empNo);
}

