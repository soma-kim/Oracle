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
				a[i] = new Cat("����", "�ڸ��ȼ����", "�츮��", "�����");
			}
			else {
				a[i] = new Dog("�������", "MIX", 15);
			}
		}
		for(int i = 0; i < a.length; i++) {
			a[i].speak();
		}
	}
}
