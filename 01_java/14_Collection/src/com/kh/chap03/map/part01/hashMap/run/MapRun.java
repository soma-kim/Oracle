package com.kh.chap03.map.part01.hashMap.run;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

import com.kh.chap03.map.part01.hashMap.model.vo.Snack;

public class MapRun {

	public static void main(String[] args) {
		// �÷����� ���� ������ ���� ��
		// List�� Set �迭�� Collection�� ������ Ŭ������ 
		// => add, get, . . . �޼ҵ���� ������ ����
		
		// Map�迭�� Collection�� ������ Ŭ������ �ƴ�
		// => �޼ҵ���� ���ݾ� �ٸ� ����!! 
		
		// �÷����� �̿��� �غ� : �÷��� ��ü ����
		HashMap<String, Snack> hm = new HashMap<>(); // ����ִ� ����
		
		// 1. put(K key, V value) : map ������ key + value ��Ʈ�� �߰����ִ� �޼ҵ�
		hm.put("������", new Snack("���ڸ�", 1500));
		hm.put("ĭ��", new Snack("�ܸ�", 600));
		hm.put("�����", new Snack("§��", 500));
		hm.put("��������Ĩ", new Snack("§��", 500));
		
		System.out.println(hm); // {Ű = ���, Ű=���..}
								// ���� ���� ���� X, value ���� �����ϴٰ� �ص� key ���� �ߺ����� �ʾ� �� �����
		
		hm.put("�����", new Snack("�ſ��", 700));
		System.out.println(hm);
		// �ߺ��� key ���� �����ϸ�, �ش� ������ value ���� ���ο� value ������ ���� ������
		
		// 2. get(Object key) : V => �÷��ǿ��� �ش� Ű���� value ���� �����ִ� �޼ҵ�
		System.out.println(hm.get("������"));
		
		System.out.println(hm.get("������")); // ���� �������� �ʴ� key ���� ������ ��� null�� ��ȯ��. ��Ÿ���� ��������.
		
		// Object snack = hm.get("ĭ��");
		Snack snack = (Snack)hm.get("ĭ��"); // ���׸� ������ ���� ������ �Ź� ����ȯ �ؾ���!
		
		// 3. size() : �÷����� ���� � ����ִ��� ���� ���� �޼ҵ�
		System.out.println("size : " + hm.size());
		// ���� ������ �ε����� ���� �� �� ���� (�ε����� ���)
		
		// 4. replace(k key, V value) : �÷��ǿ� �ش� key ���� ã�Ƽ� ���� ���޵� value�� ��������ִ� �޼ҵ�
		hm.replace("��������Ĩ", new Snack("�̳�§��", 1000));
		System.out.println(hm);
		
		// ���� : put �޼ҵ�� relace �޼ҵ�� ������ �ٸ�
		// => put �޼ҵ�� ���� �Ű������� ������ Ű���� �̹� ������ ������� ������� ����������
		//                               Ű ���� ������ ������� �߰����ִ� ���� (�߰��� ������ ����)
		// => replace �޼ҵ�� ���ʿ� �Ű������� Ű �� ������ �� �̹� �ִ� Ű���� �����ؼ� �Ҵ� ��� ���� �ٲ�ġ�� �ϴ°� ���� ����
		
		// 5. remove(Object key) :  �÷��ǿ� �ش� key ���� ã�Ƽ� key + value ��Ʈ�� �����ִ� �޼ҵ�
		hm.remove("��������Ĩ");
		System.out.println(hm);
		System.out.println("========================================");
		
		
		// ���������� HashMap�� ����ִ°ſ� �����ϰ��� �� ��?
		
		// �ε��� ������ ���� ������ �Ϲ� for�� ��� �Ұ�
		// key + value�� ��Ʈ�� ����ִ� �����̱� ������ ���� for���� ��� �Ұ�
		/*
		for (xxx:hm) {
			
		}
		*/
		
		// List�� Map�� �ٸ� �迭�̱� ������ ArrayList�� �Űܴ��� �� �ݺ��� ��뵵 �Ұ�
		// ArrayList list = new ArrayList(hm);
		// list.addAll(hm);
		
		// Iterator => .iterator() �޼ҵ带 �̿��Ͽ� ���� Iterator�� �ű��
		// / .iterator() �޼ҵ�� List�� Set �迭������ ����� �� �ִ� �޼ҵ�� �Ұ���
		// Iterator it = hm.iterator();
		
		// "Map�� Set���� �ٲٴ� ����"�� �켱������ �����ϸ� 
		// => �츮�� �Ʊ� ����� Set �迭�� �ݺ��� ������ 3���� ��� ��� Ȱ�� ��������
		
		// Map�� Set���� �ٲ��ִ� �޼ҵ� 2���� 
		// HashMap => Set �迭 => Iterator
		
		// 1. .keySet() �޼ҵ带 �̿��ϴ� ���
		// => Map�� ����ִ� Ű���� �߷����� Set���� ��ȯ�����ִ� �޼ҵ�
		
		// 1) hm�� �ִ� key�鸸 set�� ����ֱ�
		Set<String> keySet = hm.keySet();
		
		// 2) 1�� �������� �۾��� keySet�� Iterator�� ���
		Iterator<String> itKey = keySet.iterator();
		
		// 3) �ݺ��ڿ� ��� �͵��� ���������� �̱� (�ݺ��� ���)
		while(itKey.hasNext()) { // hasnext
			 // System.out.println(itkey.next());
	         String key = /*(String)*/ itKey.next(); 
	         Snack value = /* (Snack) */ hm.get(key); 
	         System.out.println(key + " = " + value);
	      }
		
		System.out.println("========================================");
		
		
		// 2. entrySet() �޼ҵ带 �̿��ϴ� ���
		// => Entry��� ���� ���� �÷� Key + Value ��Ʈ�� ��� Set�� �����
		
		// 1) hm�� �ִ� key + value ��� Entry ���·� Set�� ��� (Entry:��������)
		Set<Entry<String, Snack>> entrySet = hm.entrySet();
		
		// 2) entrySet�� �ִ� �͵��� Iterator�� �Űܴ��
		Iterator<Entry<String,Snack>> itEntry = entrySet.iterator();
		
		// 3) �ݺ����� �̿��ؼ� ���������� �̱�
		while(itEntry.hasNext()) {
			// System.out.println(itEntry.next());
			Entry<String, Snack> entry = (Entry)itEntry.next();
			String key2 = /*(String)*/ entry.getKey();
			Snack value2 = /*(Snack)*/ entry.getValue();
			
			System.out.println(key2 + "=" + value2);
		}
	}

}
