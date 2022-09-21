package kr.or.ddit.commons.exception;

public class UserNotFoundException extends PKNotFoundException{
	
	private String memId;
	
	public UserNotFoundException(String pk) {
		this.memId = memId;
	}
	
	//재정의
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return String.format("%s 아이디 회원이 존재하지 않음.", this.memId);
	}
	
}
