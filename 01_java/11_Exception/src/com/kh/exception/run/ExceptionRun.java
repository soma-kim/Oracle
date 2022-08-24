package com.kh.exception.run;

import java.io.IOException;

import com.kh.exception.controller.A_UncheckedException;
import com.kh.exception.controller.B_CheckedException;

public class ExceptionRun {
	// main 메소드에서 throws로 예외처리를 떠넘기게 되면 JVM에 의해 예외처리가 됨 !
	// => JVM이 어떻게 예외를 처리해줄지 모르기 때문에
	//    내가 직접 try~catch문으로 예외처리 구문을 작성해주는 것을 권장함
	public static void main(String[] args) throws IOException { // JVM이 알아서 예외처리를 해줌
		/*
		 * * 에러(오류) 종류
		 * - 시스템 에러: 컴퓨터의 오작동으로 인해 발생하는 에러
		 * 				=> 소스코드로 해결안됨 (심각한 에러)
		 * - 컴파일 에러: 소스코드상의 문법적인 문제로 발생하는 에러
		 * 				=> 소스코드 수정으로 해결 가능 (이클립스가 애초에 빨간 밑줄로 알려주는 에러)
		 * - 런타임 에러: 소스코드상으로는 문제가 없는데 프로그램 실행 도중 발생하는 에러
		 * 				=> 사용자의 잘못일수도 있고, 개발자가 예측 가능한 경우를 제대로 처리 안해놓은 잘못 일수도 있음
		 * - 논리 에러 : 소스코드 상의 문법적인 문제도 없고 실행했을 때도 굳이 문제가 되진 않지만
		 * 			   내가 짠 프로그램 의도상 반대로 작동하는 에러
		 * 
		 * => 시스템 에러를 제외한 컴파일 에러, 런타임 에러, 논리 에러와 같은 비교적 덜 심각한 것들을 가지고 작업
		 * 	  이런 것들을 "예외"라고 한다. (Exception)
		 * 
		 * => 이러한 "예외"들이 "발생"했을 경우에 대비해서 미리 "처리"하는 방법을 정의해두는 것을 "예외처리"라고 한다.
		 * 
		 * 예외처리를 하는 이유 : 예외 발생 시 프로그램이 비정상적으로 종료되는 것을 막기 위함! 반드시 해야함!
		 * 
		 * 예외처리 방법
		 * 1. try ~ catch문을 이용
		 * 2. throws를 이용 (떠넘기기, 위임하기)

		 */
		
		A_UncheckedException a = new A_UncheckedException();
//		a.method1();
//		a.method2();
//		a.method3();
		
		B_CheckedException b = new B_CheckedException();
		/*
		try {
			b.method1();
		} catch (IOException e) {
			System.out.println("예외 발생됨");
		}
		*/
		b.method1();
		
		
	}

}
