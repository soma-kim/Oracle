package com.kh.chap04.assist.part02.object.model.dao;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import com.kh.chap04.assist.part02.object.model.vo.Phone;

public class ObjectsDao {
	// ���α׷� ---> �ܺθ�ü (����)
	// ���
	public void fileSave() {
		// FileOutputStream + ObjectOutputStream (1byte ¥�� ���� ���)
		/*
		// �׽�Ʈ�� ��ü �迭 ����
		Phone [] arr = new Phone[3];
		
		// �׽�Ʈ�� ������ ���
		arr[0] = new Phone("������", 1300000);
		arr[1] = new Phone("������", 1500000);
		arr[2] = new Phone("�ø���", 2000000);
		*/
		
		
		// Phone ��ü�� �� �� �ִ� ArrayList ����
		ArrayList<Phone> phoneList = new ArrayList<>();
		phoneList.add(new Phone("������", 1300000)); // 0�� �ε���
		phoneList.add(new Phone("������", 1500000)); // 1�� �ε���
		phoneList.add(new Phone("�ø���", 2000000)); // 2�� �ε���
		
		
		
		
		
		
		try(ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("phones.txt"))) {
			
			// ��� : ObjectOutputStream ��ü���� �����ϴ� WriteObject() �޼ҵ� ���
//			oos.writeObject(arr[0]);
//			oos.writeObject(arr[1]);
//			oos.writeObject(arr[2]);
			
			/* ��ü �迭�̾����� ����
			// �ݺ��� �̿��ؼ� ���Ϸ� �������� 
			for(int i = 0; i < arr.length; i++) {
				oos.writeObject(arr[i]);
			}
			*/
			
			// ArrayList�϶��� ����
			for (int i = 0; i < phoneList.size(); i++) {
				
				oos.writeObject(phoneList.get(i));
				
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
			
		}
		
	// ���α׷� <--- �ܺθ�ü (����)
	// �Է� 
	public void fileRead() {
		// FileInputStream + ObjectInputStream (1byte¥�� ���)
		
		try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("phones.txt"))){
			
			// toString() �޼ҵ带 �������̵� �߱� ������ ���� ����ȯ���ϰ� �ٷ� ��� ���� 
			
			// System.out.println(ois.readObject( /* .toString() */ ));
			// System.out.println(ois.readObject());
			// System.out.println(ois.readObject());
			// System.out.println(ois.readObject());
			// ������ ���� �������� EOFException�� �߻���
			// => End Of File �� ���� , IOExceprion�� �ڽ�
			
			// EOFException�� �߻��ɶ� ������ �ݺ��� ������
			// => ���� �Ұ����� �����̱� ������ ��Ȯ�� ������ ���� �� ����
			while(true) { // �׷��� �ϴ��� ���ѹݺ�
				System.out.println(ois.readObject());
			}
			
			
			
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
			
		}  catch (EOFException e) { // ���ѹݺ��Ǵٰ� ������ EOFException�� �߻��ϴ� ���� �������� ���ƿ�
		   System.out.println("������ �� �о����ϴ�.");
			
		} catch (IOException e) {
			
			e.printStackTrace();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			
		} 
	
		System.out.println("���α׷� ����");
	}
}
