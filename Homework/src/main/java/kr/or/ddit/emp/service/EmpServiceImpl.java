package kr.or.ddit.emp.service;

import java.util.List;

import kr.or.ddit.emp.dao.EmpDAO;
import kr.or.ddit.emp.dao.EmpDAOImpl;
import kr.or.ddit.enumpkg.ServiceResult;
import kr.or.ddit.vo.EmpVO;

public class EmpServiceImpl implements EmpService {
	private EmpDAO dao = new EmpDAOImpl();
	
	public List<EmpVO> retrieveEmpList() {
		List<EmpVO> list = dao.selectEmpList();
		return list;
	}

	public EmpVO retrieveEmp(int empNo) {
		EmpVO vo = dao.selectEmp(empNo);
		return vo;
	}

	public ServiceResult createEmp(EmpVO emp) {
		ServiceResult result = null;
		try {
			retrieveEmp(emp.getEmpno());
			result = ServiceResult.PKDUPLICATED;
		} catch (Exception e) {
			int rowcnt = dao.insertEmp(emp);
			result = rowcnt > 0 ? ServiceResult.OK : ServiceResult.FAIL;
		}
		return result;
	}

	public ServiceResult modifyEmp(EmpVO emp) {
		ServiceResult result = ServiceResult.FAIL;
		int rowcnt = dao.updateEmp(emp);
		if(rowcnt>0) result = ServiceResult.OK;
		
		return result;
	}

	public ServiceResult removeEmp(int empNo) {
		ServiceResult result = ServiceResult.FAIL;
		try {
			int rowcnt = dao.deleteEmp(empNo);
			if(rowcnt > 0) result = ServiceResult.OK;
		} catch (Exception e) {
			result = ServiceResult.USERNOTFOUND;
		}
		return result;
	}

}
