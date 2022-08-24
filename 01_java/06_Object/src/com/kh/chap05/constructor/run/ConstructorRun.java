package com.kh.chap05.constructor.run;

import com.kh.chap05.constructor.medel.vo.User;

public class ConstructorRun {

	public static void main(String[] args) {
//		User Ŭ������ �⺻�����ڸ� �̿��ؼ� ��ü ����
		User u1 = new User();
		u1.setUserId("user01");
		u1.setUserPwd("pass01");
		u1.setUserName("�踻��");
		u1.setAge(20);
		u1.setGender('��');
		
		System.out.println(u1.information()); // �⺻���� ��� 
		
//		User Ŭ������ String userId�� �ʱ�ȭ���ټ� �ִ� �Ű����� �����ڸ� �̿��ؼ� ��ü���� 
		User u2 = new User("user02");
	    u2.setUserPwd("pass02");      
	    u2.setUserName("�踻��");      
	    u2.setAge(21);      
	    u2.setGender('��');  
		
		System.out.println(u2.information()); // userId�� ���� ���ϴ� ������ �ʱ�ȭ
		
//		UserŬ������ userId, userPwd, userName�� �ʱ�ȭ���� �� �ִ� �Ű����� �����ڸ� �̿��ؼ� ��ü����
		
		User u3 = new User("user03", "pass03", "ȫ�浿");
		u3.setAge(22);      
	    u3.setGender('��');   

		
		System.out.println(u3.information());
		
//		User Ŭ������ ��� �ʵ忡 ���ؼ� ��ü ������ ���ÿ� ���� ���ϴ� ������ �ʱ�ȭ �� ���ִ�
//		�Ű����� �����ڸ� �̿��ؼ� ��ü ����
		User u4 = new User("user04", "pass04", "�ڰ���", 40, '��');
		
//		���࿡ �� �������� ��й�ȣ�� �ٲٰ� �ʹٸ� setter�޼ҵ带 ��߸� �Ѵ�.
//		=> setter �޼ҵ带 ��߸� �Ѵ�!!
		u4.setUserPwd("password04!");
//		�Ű����� �����ڰ� �ִ� �ϴ��� setter �޼ҵ�� �ݵ�� �ʿ��ϴ�!!
		
		System.out.println(u4.information());
	}

}
