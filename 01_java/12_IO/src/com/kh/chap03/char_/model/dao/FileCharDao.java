package com.kh.chap03.char_.model.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCharDao {
	// ���α׷� ---> �ܺθ�ü (����)
	// ���
	
	public void fileSave() {
		
		// FileWriter : ���Ϸ� �����͸� 2byte ������ ����ϴ� ��Ʈ��
		// 0. ���� ���� �� null�� �ʱ�ȭ 
		FileWriter fw = null;
		
		// 1. ��Ʈ�� ��ü ���� == ������θ� ����ڴ�. (���ϸ� ����)
		try {
			fw = new FileWriter("b_char.txt");
			// ����� ��� ���� ���ϸ��� �����ϴ��� ���� ���� �� ������ΰ� ������
			
			
			// 2. ��� == ������ �������� : write() �޼ҵ� ���
			fw.write("��! IO ��մ�..��"); // ���������� ���� �Ѱ��� ��� �̵���
			fw.write('A');
			fw.write(97);
			fw.write("\n");
			
			char[] cArr = {'k', 'i', 'w', 'i'};
			fw.write(cArr);
			
			
			// 3. ���� ��� ���� == �ڿ� �ݳ� (�ݵ��) => finally ��Ͽ� �ۼ�
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			// 3. �پ� �ڿ� �ݳ��ϱ� (�ݵ��)
			try {
				fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	// ���α׷� <--- �ܺθ�ü(����)
	// �Է�
	public void fileRead() {
		// FileReader : ���Ϸκ��� �����͸� 2byte ������ �Է¹޴� ��Ʈ��
		// 0. ���� ���� �� null�� �ʱ�ȭ
		FileReader fr = null;
		
		try {
			// 1. ��Ʈ�� ��ü ���� == ���� ��θ� ����ڴ�. (���ϸ� ����)
			fr = new FileReader("b_char.txt");
			// �Է�����̱� ������ ������ �����ϴ� ��η� �����ؾ���
			
			// 2. �Է¹ޱ� : read() �޼ҵ� ��� 
			// => ��, �ѹ��� 2byte���� ������
			/*
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			System.out.println(fr.read());
			*/
			// => ���� ��� ��Ʈ���� ���������� ������ ���� �������� read �޼ҵ��� ��ȯ���� -1��
			
			// �ݺ����� Ȱ��
			int value = 0;
			while((value = fr.read()) != -1) {
				System.out.print((char)value);
			}
			
			
		// 3. ������� ���� == �ڿ� �ݳ� (�ݵ��) => finally ���� �ۼ�
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally {
			// 3. �ڿ� �ݳ� (�ݵ��)
			try {
				fr.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
}
