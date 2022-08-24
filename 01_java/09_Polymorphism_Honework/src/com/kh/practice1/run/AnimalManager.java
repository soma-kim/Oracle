package com.kh.practice1.run;

import com.kh.practice1.model.vo.Animal;
import com.kh.practice1.model.vo.Cat;
import com.kh.practice1.model.vo.Dog;

public class AnimalManager {

	public static void main(String[] args) {
		Animal[] a = new Animal[5];
		for (int i = 0; i < a.length; i++) {
			int random = (int)(Math.random()*2) + 1;
			if (random == 1) {
				a[i] = new Cat("후추", "코리안숏헤어", "우리집", "삼색이");
			}
			else {
				a[i] = new Dog("마요네즈", "MIX", 15);
			}
		}
		for(int i = 0; i < a.length; i++) {
			a[i].speak();
		}
	}
}
