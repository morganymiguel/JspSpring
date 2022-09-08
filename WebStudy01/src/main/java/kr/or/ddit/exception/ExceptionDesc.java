package kr.or.ddit.exception;

import java.io.IOException;

/**
 * 예외(exception, throwable object) 
 * Throwable 최상위 트리구조 형성.
 * 	- Error
 * 	- Exception : 비정상적인 상황이되, 직접 처리가 가능한 에외적 상황을 표현하는 객체.
 * 		checked exception : 예외 가능 상황에서 반드시 처리해야 하는 예외, 처리하지 않으면 compile error
 * 			ex) IOException, SQLException...
 * 		unChecked exception(RuntimeException 최상위에 이게 있다.) : 직접 처리하지 않더라도, 예외 제어권이 메소드 호출구조로 전달되는 예외.
 * 			ex) NullPointerException, IllegalArgumentException
 * 
 * 처리 방법
 * 직접 처리 : try~catch~finally, try~multi catch, try with resource
 * 위임 처리 : throws
 * 
 * Custom Exception 정의
 * 
 *
 */
public class ExceptionDesc {
	public static void main(String[] args) {
//		try {
//			method1();
//		} catch (IOException e) {
//			System.err.println(e.getMessage());
//			throw new RuntimeException(e);
////			발생한 예외를 다시 던지고 싶을 때 사용.
//		}
		try {
			String text = "a23";
			int number = method2(text);
			System.out.println(number);
		}catch (NumberFormatException e) {
//			System.out.println("asdfasdfasd");
			throw e;//버추러머신
			
		}
		
	
	}
	
	private static int method2(String text) {
		try {
			return Integer.parseInt(text);
		}catch (RuntimeException e) {
//			e.printStackTrace();
//			return -1;
			throw new CustomException(e);
		}
		
		
	}
	
	private static void method1() throws IOException {
		if(1==1)
			throw new IOException("강제 발생 예외");
		System.out.println("method1 호출");
	}
}
