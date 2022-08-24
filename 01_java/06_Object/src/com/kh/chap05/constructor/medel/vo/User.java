package com.kh.chap05.constructor.medel.vo;

public class User {
//	 �ʵ��
	private String userId;
	private String userPwd;
	private String userName;
	private int age;
	private char gender;

//	 �޼ҵ��
	public void setUserId(String userId) {
		this.userId = userId;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	
	
//	�����ں�
	/*
	 * *������
	 * �޼ҵ���� Ŭ������� �����ϰ� ���� �ڷ����� ���� public �޼ҵ�
	 * ��ü�� ������ �� (new ���� ����) ȣ��Ǵ� �޼ҵ��̴�.
	 * 
	 * [ǥ����]
	 * public Ŭ������(�Ű����� => ��������) {
	 * 		��ü�� ������ �� ���� �����ϰ��� �ϴ� �ڵ�;
	 * 		(���� ���ϴ� ������ �ʵ带 �ʱ�ȭ �ϴ� �ڵ带 �ַ� ����)
	 * }
	 * 
	 * �����ڸ� �ۼ��ϴ� ����
	 * 1. ��ü�� �������ֱ� ���� ����
	 * 2. ��ü ���� �� �ƴ϶� �Ű������� ���޵� ���� ��ٷ� �ʵ忡 �ʱ�ȭ�� ����
	 * 
	 * ������ �ۼ� �� ���ǻ���
	 * 1. �ݵ�� Ŭ������� �̸��� �����ؾ��� (��ҹ��� ����)
	 * 2. ��ȯ���� �������� �ʴ´�. (�޼ҵ�� �����ϰ� ���ܼ� �򰥸� ���� �����Ƿ�)
	 * 3. ������ �ۼ��� ���������� �Ű������� �ߺ��Ǹ� �ȵȴ�. (�̸��� �ߺ������ϳ�, �Ű������� �ٸ��� �����ش� => �����ε�)
	 * 4. �Ű������� ���� �⺻�����ڴ� �ۼ����� �ʴ´ٸ� JVM�� ���� �ڵ����� �������
	 *    ��, �ٸ� �����ڵ��̶� ���� �ۼ��� ��쿡�� �Ű������� ���� �⺻�����ڸ� �� ����������!
	 * 
	 * 
	 */
	
//	���� �⺻���� ������ ������ : �⺻������
//	=> �Ű������� ���� ����
//	=> �ۼ����� �ʴ´ٸ� JVM�� ���ؼ� �ڵ����� ������
	
	
	public User() {
//		�⺻������ == �Ű������� ���� ������
//		���� ��ü�� ���� (������ Ȯ��) ���� �������� �� �� ���
//		=> �׷��� ������ ���� �ƹ� �ڵ嵵 �ۼ������� ����
//		�⺻ �����ڸ� �����ϴ� ��� => ������ ���� �ʰ�, ��ü��  �����ϴµ� ������ ������
//						    => �׵��� �˰Ը𸣰� JVM�� �ڵ����� ����� ��� ������ ����
// 		��, JVM�� �Ź� �⺻ �����ڸ� ������ִ� ���� �ƴϰ�
//		�Ű������� �ִ� �ٸ� �����ڸ� ���� ���������� �ۼ����� ������ JVM�� �⺻ �����ڸ� ��������� ���� 
//		=> ��, ����ƴ� ���� �⺻�����ڴ� �׻� �ۼ��ϴ� ������ ������!!
		
//		System.out.println("�� ����� �ǳ�?");
	}
	
	
//	�Ű������� �ִ� ������ : �ʵ尪�� "���� ���ϴ� ������" �ʱ�ȭ�ϰ��� �Ҷ� �ַ�  ����
	public User(String userId) { // ��ü ������ ���ÿ� userId�ʵ忡�� ���� ���� ���ϴ� ���·� �ʱ�ȭ�� ����
		this.userId = userId;
	}
	
//	��ü ������ ���ÿ� userId, userPwd, userName �ʵ常 �ʱ�ȭ���ִ� ������
	public User(String UserId, String userPwd, String userName) {
//		���ʻ� �Ű����� �������� �Ű����� �� �����ϰ� �ʵ��� ��ġ �����ְԲ� �ۼ��Ѵ�.
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
	}
	
//	��ü ������ ���ÿ� ��� �ʵ忡 ���ؼ� ���� ���ϴ� ������ �ѹ��� �ʱ�ȭ���� ���� �� �ִ� ������
	public User(String userId, String userPwd, String userName, int age, char gender) {
//		�ʼ��� �ƴ����� ������ ���ϹǷ� �� �����!! 
		
		/*
		this.userId = userId;
		this.userPwd = userPwd;
		this.userName = userName;
		*/
		
//		���� ���� �ߺ��Ǵ� ������ �ʱ�ȭ�ϴ� ������ ���� ���
//		�ش� �ڵ带 ��ü�� �� �ִ� �����ڸ� ȣ�� ������
//		=> this �����ڸ� ȣ���ϸ� ��
//		���ǻ��� : this ������ ȣ��ÿ��� �ݵ�� ������ ���� ù�ٿ� ����ؾ���
		this(userId, userPwd, userName);
		
		this.age = age;
		this.gender = gender;
	}
		
	
//	�޼ҵ��
	public String getUserId() {
		return userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public int getAge() {
		return age;
	}

	public char getGender() {
		return gender;
	}

	public String information() {
		return  "UserId : " + userId + " / userPwd : " + userPwd + " / userName : "
	+ userName + " / age : " + age + " / gender : " + gender;
	}

}
