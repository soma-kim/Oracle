package com.hw1.model.vo;

//	�ڽ�Ŭ���� 
public class Employee extends Person {
//	�ʵ��
	private int salary;
	private String dept;

//	�����ں�
	public Employee() {
		
	}
	public Employee(String name,int age, double height, double weight, int salary, String dept) {
		super(name, age, height, weight);
		this.salary = salary;
		this.dept = dept;
	}

//	�޼ҵ��
	public int getSalary() {
		return salary;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

//	toString
	@Override
	public String toString() {
		return super.toString() +", salary=" + salary + ", dept=" + dept + "]";
	}

}
