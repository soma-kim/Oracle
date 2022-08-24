package com.kh.chap01.poly.part02.electronic.controller;

import com.kh.chap01.poly.part02.electronic.model.vo.Desktop;
import com.kh.chap01.poly.part02.electronic.model.vo.NoteBook;
import com.kh.chap01.poly.part02.electronic.model.vo.Tablet;

// �������� �����Ű�� ��
public class ElectronicController1 {
	
//	������ڻ󰡿� ���� ���� ����
//	�ʵ�� : ������ǰ�� ������ �� �ִ� �� ���� �������� �Ѱ��� ����
	private Desktop desk;
	private NoteBook note;
	private Tablet tab;
	
//	�޼ҵ�� : �ش� ���ڿ� ������ �ִ� �뵵�� �޼ҵ��, ���ڿ� ��� ������ ������ �����ִ� �޼ҵ�� 
//	������ �ִ� (�ʵ忡 ���� �����ϴ�) �뵵�� �޼ҵ��
	
//	Desktop�� �ִ� �޼ҵ�
	public void insert(Desktop d) {
//		Desktop d = new Desktop("�Ｚ", "����ũž", 1200000, "Geforce 1070");
		desk = d;
	}
	
//	NoteBook�� �ִ� �޼ҵ� : �����ε� ����
	public void insert(NoteBook n) {
		note = n;
	}
	
//	tablet�� �ִ� �޼ҵ�
	public void insert(Tablet t) {
		tab = t;
	}
	
	
//	���ڿ� ��� ������ ������ �����ִ�(�ʵ忡 ��� ���� ����) �뵵�� �޼ҵ�
//	Desktop ��ü�� ������ �����ִ� �޼ҵ�
	public Desktop selectDesktop() { 
		return desk;
	}
	
//	NoteBook ��ü�� ������ �����ִ� �޼ҵ� : �̹� ��쿡�� �����ε� ���� �Ұ�
	public NoteBook selectNoteBook() {
		return note;
	}
	
//	Tablet ��ü�� ������ �����ִ� �޼ҵ�
	public Tablet selectTablet() {
		return tab;
	}
	
	
	
	
}
