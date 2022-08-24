package com.kh.chap03.map.part02.properties.run;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesRun2 {

	public static void main(String[] args) {
		// ���Ϸκ��� �о�鿩�� Properties ��ü�� ��Ƶη���
		// �켱������ Properties ��ü���� �����ؾ���
		
		Properties prop = new Properties(); // ����ִ� ���� : {}
		
		try {
			// 4. load(InputStream in)
			// => �ش� ���Ϸκ��� ���� key - value ��Ʈ�� �о�鿩 �ش� Properties ��ü�� ���� �־��ִ� ����
			//prop.load(new FileInputStream("test.properties"));
			
			// 5 loadFromXML(InputSteam in)
			// => �ش� xml ���Ϸκ��� ���� key - value ��Ʈ�� �о�鿩 �ش� Properties ��ü�� ���� �־��ִ� ����
			prop.loadFromXML(new FileInputStream("test.xml"));
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		// System.out.println(prop);
		
		// 6. getProperty(String key) : String value
		// => String Ÿ���� Ű���� �����ϸ� String Ÿ���� ������� ����
		System.out.println(prop.getProperty("List"));
		System.out.println(prop.getProperty("Set"));
		System.out.println(prop.getProperty("Map"));
		System.out.println(prop.getProperty("Collection"));
		// ���� Ű ���� ������ ��� null�� ��ȯ��!
		
		/*
		 * * .properties ������ ����ϴ� ���
		 * �츮�� ���� ���߽� �ش� ���α׷��� �⺻������ ������ �� ȯ�漳���� ���� ��������
		 * ������ .properties Ȯ���ڸ� ���� ���Ͽ� ��Ƶ�
		 * key - value ������ ���ڿ��� �ܺ� ���Ͽ� ������ �Ǹ鼭 
		 * ���߿� �����Ǿ����� �����ڰ��ƴ� �̶� �����ڰ� �ս��� ȯ�漳���� ���õ� ������ �ٷ� �� �ְԵ�
		 * => JDBC ���� ����� ����
		 * 
		 * * .xml ������ ����ϴ� ���
		 * xml Ȯ���� ������ �پ��� ���α׷��� ���� ȣȯ�� ���ٶ�� ������ �ְ�,
		 * value ������ �������̿��� ���� ���� ���Ͽ� ��� �� �ִ� ��� ������ �ֱ� ������
		 * ���α׷����� ������ ����� �ܺ� ��ɹ����� ��Ƶ� �� �ַ� ����� �� �ִ�.
		 * 
		 */
		
	}

}
