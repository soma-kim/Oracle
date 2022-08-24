package com.kh.chap01.list.part01.arrayList.run;

import java.util.ArrayList;
import java.util.List;

import com.kh.chap01.list.part01.arrayList.model.vo.Music;

public class GenericListRun {
	/*
	 * * ���׸�(Generic)
	 * <> �ȿ� � Ÿ���� �������־� �ش� �÷����� ����� ��ü�� Ÿ���� ���������ִ� ����
	 * ���� �ٷ� ��ü�� Ÿ���� �̸� ����Ͽ� ���� ����ϰ� ���� ������ Ÿ�Ը� ����Ҽ� �ְ� ���ִ� ȿ�� 
	 * => ��ġ �迭ó�� ���� �ڷ����� ���鸸 ��ڴٶ�� ��
	 * 
	 * ������ ���׸� ���� ���� �÷��� ��ü�� �����ϸ� (E == object)
	 * ArrayList list = new ArrayList();
	 * ����������
	 * ArrayList<object> list = new ArrayLsit<>();
	 * object�� �������� ���� �ƹ��ų� ���� �� �־���
	 * 
	 * ������ ���׸� ���ø� �ؼ� �÷��� ��ü�� �����ϸ� (E == Music)
	 * ArrayList<Music> list = new ArrayList<>();
	 * ���� ����ϰ� ���� ������ Ÿ�Ը� ����� �� �ְ� ����
	 * 
	 * 
	 */
	
	public static void main(String[] args) {
		// �÷��Ÿ�<�ڷ���> ��ü�� = new �÷��Ǹ�<�ڷ���>();
		// => new ������ �ִ� ���׸� ���� �κп��� �ڷ��� ���� ����(JDK 8�������� ������ ����)
		
		ArrayList <Music> list = new ArrayList<>(3);
		System.out.println(list); // ����ִ� ���� 
		
		// E ---> Element : ���׸� (E == Music)
		// 1. add(E e)
		list.add(new Music("������Ÿ��", "����"));
		list.add(new Music("�׾���!", "���ƾ�"));
		// list.add("��");
		
		System.out.println(list);
		// ������ �����Ǹ鼭 �� �߰� (�� index�� ����ִ� ��)
		// ũ�⿡ ������ ����
		// �پ��� Ÿ���� ���� ���� ���� ���� => ���׸� ������ �߱� ����
		
		
		// 2. add(int index, E e)
		list.add(1, new Music("����� ����", "�ںұ�"));
		System.out.println(list);
		
		
		// 3. set (int index, E e)
		list.set(0, new Music("���ϸ�����", "������"));
		
		System.out.println(list);
		
		
		// 4. remove(int index)
		list.remove(1);
		System.out.println(list);
		
		
		// 5. size()
		System.out.println("����Ʈ�� ��� ������ �� :" + list.size());
		System.out.println("����Ʈ�� ������ �ε��� : " + (list.size() - 1));
		
		
		// 6. get(int index) : E (��ȯ�� MusicŸ��)
		// Object obj = list.get(0); // �������� ���� UpCasting
		// �������� objectŸ�Կ� ��ȯ�ε� ���׸� Music���� �����ؼ� Music ��ȯ
		
		Music m = list.get(0);
		System.out.println(m);
		System.out.println(list.get(0));
		System.out.println(list.get(0).getTilte()); // ��������ȯ ���ص� Title�� ��� ����
		
		System.out.println("==========================================");
		
		// 0�� ~ ������ �ε��������� �����͸� ���
		// for��
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("==========================================");
		
		// ���� for��
		// for(���� �޾��� ���� ���� : �迭�� �Ǵ� �÷��Ǹ�)
		for(Music music : list) {
			System.out.println(music);
		}
		
		System.out.println("==========================================");
		
		// 7. subList(int beginIndex, int endIndex)
		List<Music> sub = list.subList(0,1);
		
		System.out.println(sub);
		
		System.out.println("==========================================");
		
		// 8. addAll(Collection c)
		list.addAll(sub);
		
		System.out.println(list);
		
		System.out.println("==========================================");
		
		// 9. isEmpty()
		System.out.println("�ش� ����Ʈ�� ����ֽ��ϱ�? : " + list.isEmpty());
		
		// 10. clear()
		list.clear();
		System.out.println(list);
		System.out.println("�ش� ����Ʈ�� ����ֽ��ϱ�? : " + list.isEmpty());
		
	}
	
	/*
	 * * ���׸��� �����ϴ� ����
	 * 1. ����� Ÿ���� ��ü�� ���尡���ϵ��� Ÿ���� ������ �α� ���� 
	 * 2. �÷��ǿ� ����� ��ü�� ������ ����� �� �Ź� ����ȯ�ϴ� ������ ���ֱ� ���ؼ�
	 * 
	 * * ���׸� ���� �� ������ �� 
	 * �÷��ǿ��� ��ü Ÿ�Ը��� �� �ֱ� ������ �⺻ �ڷ������δ� ������ �Ұ�
	 * ��) ArrayList<int> list = new ArrayList<>(); �Ұ�
	 * 	   ArrayList<Integer> list = new ArrayList<>(); ���� => E == Integer
	 */
	
	
	
	
}
