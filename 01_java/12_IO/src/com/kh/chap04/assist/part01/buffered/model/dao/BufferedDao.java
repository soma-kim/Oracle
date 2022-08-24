package com.kh.chap04.assist.part01.buffered.model.dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class BufferedDao {
	// BufferedWriter (��¿�) / BufferedReader (�Է¿�)
	// ���α׷� ----> �ܺθ�ü (����)
	
	public void fileSave() {
		// FileWriter : 2byte ������ ���Ϸ� �����͸� �������� ��� ��Ʈ��
		// +
		// BufferdWriter : ���۶�� ������ �������ִ� ���� ��Ʈ�� (�ӵ� ���)
		// ��� ��Ʈ���̶� ������Ʈ���̶� ũ�⵵ ���� ��������� (2byte -> 2byte)
		
		// 0. ���� ���� �� null �� �ʱ�ȭ
		// FileWriter fw = null;
		// BufferedWriter bw = null;
				
		// �ڵ� ���ٷ� �ٿ��� ǥ��
		BufferedWriter bw = null;

		try {
			// 1. ��ݽ�Ʈ�� ��ü ���� (���� ���� ��θ� ����ڴ�)
			// fw = new FileWriter("c_buffer.txt");

			// 2. ������Ʈ�� ��ü ���� (�Ű������� ��ݽ�Ʈ�� ��ü�� ����)
			// bw = new BufferedWriter(fw);
		
			// �ڵ� ���ٷ� �ٿ��� ǥ��
			bw = new BufferedWriter(new FileWriter("c_buffer.txt"));
			
			
			// 3. ��� : BufferedWriter ��ü���� �����ϴ� write() �޼ҵ� ���
			// fw.writer(); => FileWriter ��ü���� �����ϴ� write() �޼ҵ带 ����ϸ� ���� ��� ����Ҽ� X
			bw.write ("�ȳ��ϼ���.");
			bw.newLine(); // ������ �־��ִ� �޼ҵ� 
			bw.write("�ݰ����ϴ�. \n");
			bw.write("���� ������.");
			

		// 4. �ڿ� �ݳ�(�ݵ��) => finally �� �ȿ� �ۼ�
		} catch (IOException e) {
			e.printStackTrace();
		} 
		finally {
			// 4. �ڿ� �ݳ� (�ݵ��)
			//    => ������ �� : �ݳ��ؾ��� ������ 2�� (fw,bw)
			//    => �ݳ��ϴ� ���� : ��ü�� ������ ������ "����"���� �ݳ�
			try {
				bw.close();
			//	fw.close(); // �ڵ带 ���ٷ� ���̸� �� ������ ���� ����!
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	// ���α׷� <--- �ܺ� ��ü (����)
	public void fileRead() {
		// FileReader : ���ϰ� ���������� �����ؼ� �ѹ��� 2byte ������ �����͸� �Է��� �� �ִ� ��� ��Ʈ��
		// +
		// BufferedReader : ���۶�� ������ �������ִ� ���� ��Ʈ�� (�ӵ� ���)
		
		/*
		// 0. ���� ���� �� null ������ �ʱ�ȭ
		BufferedReader br = null;
		
		// 1. ��ü ���� == ��θ� ����ڴ�.
		try {
			br = new BufferedReader(new FileReader("c_buffer.txt"));
			
		// 2. �Է� : BufferedReader Ŭ�������� �����ϴ� �޼ҵ�� �о���̱�
			/*
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			System.out.println(br.readLine());
			*/
		/*	
			// �ݺ��� Ȱ��
			String value = null;
			while(br.readLine() != null) {
				System.out.println(br.readLine());
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
			
		} finally { // 3. �ڿ� �ݳ� == ���� ��θ� ���ڴ�.
			try {
				br.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		*/
		
//      try - with - resource ���� (jdk7 ���� �̻���͸� ����)
	      
//      [ ǥ���� ]
//      try(�ݳ��ؾ��ϴ� �ʿ��� ��ü ���� ����) {
//         		���ܰ� �߻��� ���� ����;
//      } catch(����Ŭ������ e){
//            	�ش� ���� �߻��� ������ ����;
//      }
      
//      -> ��Ʈ�� ��ü ���� ������ try(����)�� �ۼ��ϰ� �Ǹ�
//         ��Ʈ�� ��ü ���� �� �ش� try �� ������ ����� ��
//         �˾Ƽ� �ڿ� �ݳ��� �ȴ�. . . �ڿ��ݳ� ���ص� ��
		 
		   try(BufferedReader br = new BufferedReader(new FileReader("c_buffer.txt"))){

				// �ݺ��� Ȱ��
				String value = null;
				while((value = br.readLine()) != null) {
					System.out.println(value);
				}
				
			} catch (FileNotFoundException e) {
				e.printStackTrace();
				
			} catch (IOException e) {
				e.printStackTrace();
				
			} // close ���� �� �ʿ� ���� �˾Ƽ� �ݳ� ���ش�
			
		}
	}

		


