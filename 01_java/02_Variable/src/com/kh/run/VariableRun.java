package com.kh.run;

import com.kh.variable.A_Variable; // 2. import
import com.kh.variable.B_KeyboardInput;
import com.kh.variable.C_Cast;
import com.kh.variable.D_Printf;

public class VariableRun {
	
	public static void main (String[] args) {
		
		// A_Variable 클래스의 printSalary 메소드를 호출
		
		// 1. A_Variable 클래스를 대변할이름을 하나 만들기
		A_Variable a = new A_Variable();
		
		// 3. printSalary 메소드 호출
		// a.printSalary();
		
		// a.declareVariable();
		
		// a.initVariable();
		
		// a.constant();
		
		B_KeyboardInput b = new B_KeyboardInput();
		
		// b.inputTest1();
		
		// b.inputTest2();
		
		// b.inputTest3();
		
		// b.inputTest4();
		
		// b.inputTest5();
		
		C_Cast c = new C_Cast();
		
		// c.autoCasting();
		
		// c.forceCasting();
		
		D_Printf d = new D_Printf();
		
		d.printfTest();
		
	}

}







