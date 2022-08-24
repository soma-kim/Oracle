package com.hw1.controller;

import com.hw1.model.vo.Person;

public class Controller {
//	필드부
	private Person[] p = new Person[3];
	private Person [] p2 = new Person[10];
	
//	메소드부
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

