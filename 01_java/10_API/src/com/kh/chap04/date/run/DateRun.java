package com.kh.chap04.date.run;

import java.text.SimpleDateFormat;
import java.util.Date;

// ��¥ ���� Ŭ������
public class DateRun {
	public static void main(String[] args) {
		// java.util.Date Ŭ����
		// : ��¥�� �ð��� ���� ������ ���� �� �ִ� Ŭ����
		//   �ڹ� ���� ��â�⿡ ������� Ŭ����
		
		// �⺻ �����ڸ� ���� Data ��ü ����
		Date today = new Date(); // ���� ��¥ �� �ð��� �������
		System.out.println("�⺻������ : " + today);
		
		// ���� ���ϴ� ��¥ (2020�� 6�� 19��)
		// 1. �Ű����� �����ڸ� �̿��ϴ� ���
		// Date date2 = new Date(2020, 6 , 19); // deprecated : ���������� ����
		// �⵵ + 1900, �� + 1
		Date date2 = new Date(2020 -1900, 6 -1, 19);
		System.out.println("�Ű����� ������ : " + date2);
		//2. �⺻�����ڷ� ���� �� Setter�޼ҵ带 �̿��ϴ� ���
	      Date date3 = new Date(); //���� �ð� �� ��¥
	      
	      date3.setYear(2021-1900);
	      date3.setMonth(7-1);
	      date3.setDate(30);
	      date3.setHours(15);
	      date3.setMinutes(42);
	      date3.setSeconds(18);
	      
	      System.out.println("Setter�޼ҵ� : " + date3);
	      
	      System.out.println("----------------------------------------------------");
	      
	      //java.text.SimpleDateFormat Ŭ����
	      // : ����ڰ� ���ϴ´�� ��¥ ������ ������ ���ڿ��� �����ϴ� Ŭ����
	      
	      //�����
	      //1. ������ �����ϸ鼭 SimpleDateFormat ��ü�� ���� => �Ű����� ������
	      SimpleDateFormat sdf = new SimpleDateFormat("yyyy�� MM�� dd�� hh:mm:ss");
	      
	      /*
	       * * SimpleDateFormat ����
	       * -�⵵ :yyyy
	       * - �� : MM
	       * - �� : ����
	       * - �� : hh
	       * - �� : mm
	       * - �� : ss
	       */
	      
	      //2. SimpleDateFormat(sdf)��ü���� �����ϴ� format() �޼ҵ� ȣ�� �� Date ��ü ����(�Ű�������)
	      // => sdf������ ������ ��¥�� StringŸ������ ��ȯ�ȴ�.
	      // ��ü��.format(Date��ü) : ��ȯ�� String��
	      String formatDate = sdf.format(today);
	      System.out.println(formatDate);
	   }

	}