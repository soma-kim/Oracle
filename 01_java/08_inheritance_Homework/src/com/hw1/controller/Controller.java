package com.hw1.controller;

import com.hw1.model.vo.Person;

public class Controller {
//	�ʵ��
	private Person[] p = new Person[3];
	private Person [] p2 = new Person[10];
	
//	�޼ҵ��
	public void insert(Person any, int index) {
		p[index] = any;
	}
	public void insert2(Person any, int index) {
		p2[index] = any;
	}
	public Person[] select() {
		return p;
	}
	public Person[] select2() {
		return p2;
	}

}

