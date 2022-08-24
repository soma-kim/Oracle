package com.hw1.model.vo;

//	�ڽ�Ŭ���� 
public class Student extends Person {

	//	�ʵ��
	private int grade;
	private String major;

//	�����ں�
	public Student() {
		
	}
	public Student(String name, int age, double height, double weight, int grade, String major) {
		super(name, age, height, weight);
		this.grade = grade;
		this.major = major;
	}


	//	�޼ҵ��
	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}
	



//	toString
	@Override
	public String toString() {
		return "Student [name = " + name + ", age = " + super.getAge() + ", height = " + super.getHeight() + 
				", weight = " + super.getWeight() +
				"grade = " + grade + ", major=" + major + "]";
	}

	
	
}
