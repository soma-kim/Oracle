package com.kh.chap02.byte_.medel.deao;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

// DAO (data Access Object)
// �����Ͱ� �����Ǿ� �ִ� ������ ���� �����ؼ� �����͸� ������ϴ� �뵵�� Ŭ����
public class FileByteDao {
//	���α׷� ---> �ܺθ�ü (����)
//	��� : ���α׷� ���� �����͸� ���Ϸ� �������� (��, ���Ͽ� ����ϰڴ�, ���Ϸ� �����ϰڴ�.)
	
	public void fileSave() {
		// FileOutputStream : "����"�� �����͸� 1byte ������ ����ϴ� ��Ʈ��
		// 0�ܰ�. FileOutputStream fout ���� ���� �� null�� �ʱ�ȭ
		FileOutputStream fout = null; // ���� ���� �� null�� �ʱ�ȭ

		try {
			// 1. FileOutputStream ��ü ���� (== ������� �����)
			//	  => �ش� ���ϰ� ���� ����Ǵ� ��θ� ����ڴ�. (���ϸ��� �Ű������� ������ ȣ��)
			// 	          �ش� ������ �������� �ʴ´ٸ� �ش� ������ �����Ǹ鼭 ������ΰ� ������
			// 			           �����ϴ� �����̸� ���� ��θ� �ٷ� ������
			
			fout = new FileOutputStream("a_byte.txt" /* , false */); // false�� �⺻��
			// => ������ �ش� ������ ���� ��� ���� ������
			
			// fout = new FileOutputStream("a_byte.txt", true);
			// => �̾�� ���� ��쿡��? �Ű������� true�� ���� �Ѱ��ָ� ��
			
			// 2. ���� ��η� �����͸� ��� : write() �޼ҵ� ���
			// 	  => 1byte ������ ���� ���� : -128 ~ 127������ ����, ������ �Ұ� ! 
			// 	     (��, ���Ͽ� ��ϵǱ⸦ �ش� ������ ������ ���ڰ� ��ϵ� : �ƽ�Ű�ڵ�)
		
			fout.write(97); // 'a'�� ���
			fout.write('b'); // 'b'�� ���
			// fout.write('��'); // => �ѱ��� ������ 2byte�̱� ������ ������ �����
							    // (����Ʈ ��Ʈ�����δ� ������)
			
			byte[] bArr = {99, 100, 101};
			fout.write(bArr); // 'c','d','e'�� ��� 
			
			fout.write(bArr, 1, 2); // 'd', 'e'�� ���
			
			
			// 3. ��Ʈ���� �� �̿� ������ �ڿ��� �ݳ��ϱ� (�ݵ��)
			//    => ��, ���� ��θ� ���ڴ�.
			// fout.close(); => ������ Ȥ�� ���ܰ� �߻����� ��� ������ �ȵɼ��� ����! => finally ������� 
			

		} catch(FileNotFoundException e) { // �������� �ʴ� ��θ� �������� ��
			e.printStackTrace();
			
		} catch (IOException e) { // ����� ��Ȳ���� ��� �������� �߻����� ��
			e.printStackTrace();
		} finally { // � ���ܰ� �߻��ϴ��� ����, ���ܰ� �߻����ϴ������� �ݵ�� ������ ������ �ۼ��ϴ� ��
			// 3. ��Ʈ���� �� �̿������� �ڿ� �ݳ��ϱ� (�ݵ��)
			try {
				fout.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// ���α׷� <-- �ܺθ�ü(����)
	// �Է� : ���Ϸκ��� �����͸� ������ ���ڴ�. (��, �о���̰ڴ�.)
	public void fileRead() {
		// FileInputStream : ���Ϸκ��� �����͸� 1byte ������ �Է¹޴� ��Ʈ��
		
		// 0. ���� ���� �� null�� �ʱ�ȭ (�������� ������ Ʈ���� ������)
		FileInputStream fin = null;

		
		try {
			// 1. ��Ʈ�� ��ü �����ϱ� == ������� ����� 
			fin = new FileInputStream("a_byte.txt"); 
			// => ���� ��� ����, �Է� ���� ������ �ݵ�� �����ϴ� ���ϸ����� ���� !
		
			// 2. �о���̱� == �Է¹ޱ� : read() �޼ҵ� ���
			// => ��, 1byte ������ �ϳ��� �о��
			/*
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			System.out.println(fin.read());
			// ���� ���� ������ ���� fin.read() => -1 ��ȯ
			System.out.println(fin.read());
			System.out.println(fin.read());
			*/
			
			// �ݺ��� Ȱ���ϱ�
			// �������� ��µ�
			/*
			while (fin.read() != -1) {
				System.out.println(fin.read());
			}
			*/
			
			// �ذ���1. ���ѹݺ����� �Ź� ���ǰ˻� �ϱ�
			/*
			while(true) {
				
				int value = fin. read();
				
				if (value == -1) {
					break;
				}
				System.out.println(fin.read());
			}
			*/
			
			// �ذ���2. ���ǽ� ���ο� ���� ���Ա����� Ȱ���ϴ� ���(����)
			int value = 0;
			while((value = fin.read()) != -1) {
				System.out.println(value);
			}
			
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally { // 3. ������� ���� == �ڿ� �ݳ��ϱ� (������) => finally ���� �ۼ�
			
			// 3. �� �� ��Ʈ�� ��ü �ݳ�
			try {
				fin.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
}
