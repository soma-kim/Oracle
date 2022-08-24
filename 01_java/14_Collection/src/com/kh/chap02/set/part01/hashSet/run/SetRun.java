package com.kh.chap02.set.part01.hashSet.run;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

import com.kh.chap02.set.part01.hashSet.medel.vo.Student;

public class SetRun {

	public static void main(String[] args) {
		// �÷��� �� �غ� : �ش� �÷��� ��ü ����
		HashSet<String> hs1 = new HashSet();
		
		// 1. �� �߰� : add(�߰��� ��)
		hs1.add(new String("�ݰ����ϴ�."));
		hs1.add(new String("�ݰ����ϴ�."));
		hs1.add("�ݰ����ϴ�.");
		hs1.add(new String("������"));
		hs1.add(new String("�ȳ��ϼ���"));
		hs1.add(new String("������"));
		// hs1.add(50); // int --> Integer Ÿ������ AutoBoxing �Ǽ� �� ��
		
		System.out.println(hs1); // ���� ���� ���� x, �ߺ� ���� x
		
		// 2. ũ�� ���ϱ� : size()
		System.out.println(hs1.size());
		
		// ���� : get(int index)
		//		 �ش� �ε����� ���� ���� => Set �迭������ �� ������ �޼ҵ�
		
		// 3. �� ���� : remove(������ ��)
		hs1.remove("������");
		
		System.out.println(hs1);
	
		// 4. ��� �� ���� : clear()
		hs1.clear();
		
		System.out.println(hs1); // [] : ����ִ� ����
		
		// 5. ����ִ��� Ȯ�� : isEmpty()
		System.out.println("�ؽü��� ����ֽ��ϱ�? : " + hs1.isEmpty());
		System.out.println("=========================================");
		
		HashSet<Student> hs2 = new HashSet<>();
		
		hs2.add(new Student("����", 43, 100));
		hs2.add(new Student("�踻��",26,80));
		hs2.add(new Student("ȫ�浿", 24, 40));
		hs2.add(new Student("����", 43, 100));
		
		System.out.println(hs2); // ���� ���� ���� x, �ߺ� ���� o
		System.out.println(hs2.size());
		// => ��? �ߺ����� ������ ��ü�� �Ǵ��� ���� �ʾұ� ������ �ߺ��ؼ� �� �÷� ������
		// 		  Set �迭 Ư¡ : ���� �߰��ɶ����� equals() �޼ҵ�, hashCode() �޼ҵ�� �ּҰ� �� �Ŀ�
		//					      ���� ��ü ���� �Ǵ� �� �ƴϸ� �׶� �߰��� �Ͼ!
		
		// HashSet�� ��ü�� ���� �� ���������� equals()�� ��
		// ���� hashCode() ���� ��ġ�ϴ����� ��
		// => equals �޼ҵ� ����� true�̰�, hashCode()���� ��ġ�Ѵٸ�
		// 	   ���� ��ü�� �ǴܵǾ� �߰��� ���� ����(�ߺ�����Ұ�)
		
		// Object Ŭ������ equals() : �� ��ü�� �ּҰ��� ������ ���ؼ� ��ġ�ϸ� true, ����ġ false
		// Object Ŭ������ HashCode() :  �ش� ��ü�� �ּҰ��� ������� ������ ���� �߻��ؼ� ��ȯ
		
		// String Ŭ������ equals() : �� ���ڿ��� ���빰 ��
		// String Ŭ������ hashCode() : �ش� ���ڿ��� ���빰�� ������� ������ �� �߻�
		
		// ��ü�� �� �ʵ尪�� ��ġ�ϸ� �׳� ������ ��ü�� �Ǵ��� �Ǽ� 
		// �ߺ� ������ �ȵǰԲ� �ϰ�ʹٸ� ? => equals() �޼ҵ�, hashCode() �޼ҵ带 �������̵� �ϸ� �� (Student Ŭ������)
		
		// Student Ŭ������ equals : �� �ʵ� ���� ��ġ�ϸ� true /  �ϳ��� ��ġ���� �ʴ´ٸ� false ��ȯ
		// Student Ŭ������ hashCode() : �� �ʵ尪 ������� ���������� �߻� ���Ѽ� ��ȯ
		
		System.out.println("=========================================");
		
		// set => ������ ��ü�� ����Ǿ����� =>  index ������ ����
		// 	   => �ݺ��� Ȱ���� �Ұ� 
		
		// �׷� ����ִ� ��ü�� ���������� �����ϰ��� �� ��?
		// 1. ���� for�� ��� (for each��)
		// => for (�����޾��ٺ������� : �÷��Ǹ�)
		for(Student s : hs2) {
			
			System.out.println(s);
		}
		
		System.out.println("=========================================");
		
		// 2. ArrayList�� Set�� ����ִ� ������ ��� �Ű��� �� ArrayList �ݺ��� ����
		// Set�� ����ִ� ������ ArrayList�� �ű�� ��
		// ���1. �� ArrayList ��ü ���� �� addAll �޼ҵ�� Set�� ����ִ� ������ ��°�� �߰�
		// ArrayList<Student> list = new ArrayList<>(); // �� ����Ʈ�� ���� ��
		// list.addAll(hs2); // ����Ʈ�� hs2�� ����ִ� ������ ��°�� �߰���
		
		// ���2. ArrayList ��ü ���� �� �Ű������� Set�� �ѱ�� ���
		ArrayList<Student> list = new ArrayList<>(hs2); // hs2�� ��� ��ü���� ��� �߰��� ä�� ArrayList�� ������
		
		for(int i = 0; i < list.size(); i ++) {
			System.out.println(list.get(i));
		}
		
		System.out.println("=========================================");
		
		// 3. Iterator (�ݺ���)�� �̿��� ���
		// 	  => Set�� ���� ���빰���� �ݺ������� �����Ͽ� ������ �� �ְԲ� �����ִ� ����
		
		// �켱������ HashSet�� ����ִ� ��ü���� Iterator�� �Űܴ�� ����
		Iterator it = hs2.iterator();
		
		// Iterator�� ����ִ� ��ü���� �ݺ����� Ȱ���Ͽ� �ϳ��� �̾Ƴ���
		while(it.hasNext()) { // it�� ���̻� ���� ���� ���� �ִ���?
			// ���̻� ���� ���� �����ִٸ� next() �޼ҵ�� �̾Ƴ���
			System.out.println(it.next());
		} // StringTokenizer�� ����� ����
		
		// .iterator() �޼ҵ� : List �迭�� Set �迭������ ��� ������ �޼ҵ�
		//					  (MAP �迭������ ��� �Ұ����� �޼ҵ�)
	}

}
