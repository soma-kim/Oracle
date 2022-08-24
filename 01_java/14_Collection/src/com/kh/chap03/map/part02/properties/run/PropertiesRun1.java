package com.kh.chap03.map.part02.properties.run;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;
import com.kh.chap03.map.part01.hashMap.model.vo.Snack;

public class PropertiesRun1 {

	public static void main(String[] args) {
		// Properties : Map �迭 => key, value ��Ʈ�� �����
		// 				��, Properties���� Ư¡�̶�� �Ѵٸ� 
		//				key, value ��� String Ÿ������ ���� ���� �����Ѵ�.
		
		Properties prop = new Properties();
		
		/*
		prop.put("������", new Snack("���ڸ�", 1500));
		// String�� �ƴ� ���� ���� ��� ������ Map �迭�� �����ϰ� put �޼ҵ�� key + value ��Ʈ�� ���� �� �ִ�.
		
		System.out.println(prop);
		System.out.println(prop.get("������"));
		// ������ Map �迭�� �����ϰ� get �޼ҵ�� value ���� �ҷ��� �� �ִ�.
		
		// ��, �ַ� Properties�� ����ϴ� ���� Properties�� ����ִ� key + value�� ��Ʈ��
		// ���Ϸ� ����ϰų�, ���Ͽ� ��ϵǾ� �ִ� key + value�� ������ �� ��� �ַ� ����
		// => ���� ����¿� Ưȭ�� Ÿ���̱� ������ "���ڿ�"���·� Ű�� ����� �����ϴ� ���� ����ȴ� 
		
		// Properties���� �����ϴ�
		// ���Ϸ� ����ϴ� �޼ҵ� : store(), storeToXML()
		// ���Ϸκ��� �Է¹޴� �޼ҵ� : load(), loadFromXML()
		
		try {
			prop.store(new FileOutputStream("test.properties"), "Properties Test");
			// ���������� ���� ����½� String Ÿ���� �ƴ� �ٸ� Ÿ������ key, value�� �־������
			// ClassCastException�� �߻��ϰԵ�
		} catch (IOException e) {
			e.printStackTrace();
		}
		*/
		
		// Properties�� put �޼ҵ带 �̿��ϸ�
		// key, Value�� ��� Object Ÿ������ ���ǵǾ� �־ String�� �ƴ� �ٸ� Ÿ���� ������ �� �� �ִµ�
		// setProperty �޼ҵ带 �̿��ϸ� key, value ��� String Ÿ������ �Ű������� ���� �� ����!! 
		
		// 1. setProperty (String key, String value)
		prop.setProperty("List", "ArrayList");
		prop.setProperty("Set", "HashSet");
		prop.setProperty("Map", "HashMap");
		prop.setProperty("Map", "Properties");
		
		System.out.println(prop); // ���� ���� ���� x, key �� �ߺ� x, �ߺ��Ǿ value�� �������
		
		// => Properties�� �� �� ������ ���� �߰��ϰ��� �� ��� setProperty �޼ҵ带 ����Ѵ�.
		
		try {
			// 2. store(OutputStream os, String comments)
			// => Properties�� ��� key - value ������ ���Ϸ� ���
			prop.store(new FileOutputStream("test.properties"), "Properties Test");
		
			// 3. storeToXML(Outputstream os, String comments)
			// => Properties�� ��� key - value ������ xml ������ ���Ϸ� ���
			prop.storeToXML(new FileOutputStream("test.xml"), "Properties Test");
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
