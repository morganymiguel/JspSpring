package kr.or.ddit.designpattern.templatemethod.example1;

public class DerivedClass1 extends TemplateClass {

	@Override
	protected void stepTwo() {
		System.out.println("2단계의 case1");
	}

}
