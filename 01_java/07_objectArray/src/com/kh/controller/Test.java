package com.kh.controller;


import com.kh.exam.model.vo.Cat;
import com.kh.exam.model.vo.Dog;

public class Test {

	public static void main(String[] args) {
		Cat[] arr = new Cat[3];

		arr[0] = new Cat("³Ä¿ËÀÌ");
		arr[1] = new Cat("²¥¿ËÀÌ");
		arr[2] = new Cat("´ô¿ËÀÌ");

		for (int i = 0; i < arr.length; i++) {
			System.out.println(arr[i].information());
		}

		Dog[] arr2 = new Dog[2];

		arr2[0] = new Dog("º¹½ÇÀÌ", 3.4, 50.0);
		arr2[1] = new Dog("Çã½ºÅ°", 10.3, 130.4);

		for (int i = 0; i < arr2.length; i++) {
			System.out.println(arr2[i].information());
		}

	}

}
