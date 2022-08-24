package com.kh.chap01.list.prat02.mvc.view;

import java.util.ArrayList;
import java.util.Scanner;

import com.kh.chap01.list.prat02.mvc.controller.MusicController;
import com.kh.chap01.list.prat02.mvc.model.vo.Music;

// View : �ð����� ��� (����ڰ� ���� �� ȭ��)
// 		    ��¹��� �Է¹��� ���

public class MusicView {
//	��������
	private Scanner sc = new Scanner(System.in);
	MusicController mc = new MusicController();

//	����ڰ� ���α׷� ���� �� ���� ó�� �������� ȭ�� : ����ȭ��
//	���� ȭ���� ����� �޼ҵ�
	public void mainMenu() {
		
		while (true) {
			System.out.println("*** Welcome ���� ***");
			System.out.println("1. ���ο� �� �߰�");
			System.out.println("2. �� ��ü ��ȸ");
			System.out.println("3. Ư�� �� �˻�");
			System.out.println("4. Ư�� �� ����");
			System.out.println("5. Ư�� �� ����");
			System.out.println("0. ���α׷� ����");
			
			System.out.println("--------");
			System.out.print("�޴��Է� : ");
			int menu = sc.nextInt();
			sc.nextLine();
			
			switch(menu) {
			case 1 : insertMusic(); 
				break;
			case 2 : selectMusicList();
				break;
			case 3 : searchMusic();
				break;
			case 4 : deleteMusic();
				break;
			case 5 : updateMusic();
			 	break;
			case 0 : System.out.println("���α׷��� �����մϴ�");
			 	return;
			default : System.out.println("�߸��� �޴� �Դϴ�. �ٽ� �Է����ּ���");
			}
		}
	}
	

	// 1. ���ο� ���� �߰���ų �� �ִ� ȭ��
	public void insertMusic() {
		
		System.out.println("===���ο� �� �߰�===");
		System.out.print("��� �Է� : ");
		String title = sc.nextLine();
		
		System.out.print("������ �Է� : ");
		String artist = sc.nextLine();
		
		// �߰����ּ��� ��û => Controller Ŭ������ �޼ҵ带 ȣ��
		int result = mc.insertMusic(title, artist);
		
		// �߰� ���� �Ǻ�
		if(result > 0) { //�߰� ����
			System.out.println("���������� �߰��Ǿ����ϴ�.");
		}
		else { //�߰� ����
			System.out.println("�� �߰��� �����߽��ϴ�");
		}

		System.out.println("���������� �߰��Ǿ����ϴ�.");
	}
	
	
	public void selectMusicList() {
		System.out.println("===�� ��ü ��ȸ===");
		
		// ��ü ����Ʈ�� ��ȸ���ּ��� ��û => Controller Ŭ����
		ArrayList<Music> list = mc.selectMusicList();
		
		if (list.isEmpty()) { // ����Ʈ�� ������� ���
			System.out.println("���� �����ϴ� ���� �����ϴ�.");
		}
		else { // ����Ʈ�� ������� ���� ���
			for(int i =0; i <list.size(); i++) {
				System.out.println(list.get(i));
			}
		}
	}
	
	// 3. Ư�� ���� �˻� �� �� �ִ� ȭ��
	public void searchMusic() {
		System.out.println("===Ư�� �� �˻�===");
		System.out.println("�˻��� ��� Ű���� : ");
		String keyword = sc.nextLine();
		
		// �˻����ּ��� ��û => Controller Ŭ������ �޼ҵ� ȣ��
		ArrayList<Music> searched = mc.searchMusic(keyword);
		
		
		// �˻����
		System.out.println("�˻����");
		if(searched.isEmpty()) { // �˻� ����� ���ٸ�
			System.out.println("�˻� ����� �����ϴ�");
		}
		else { // �˻������ �ִٸ�
			for(Music m : searched) {
				System.out.println(m);
			}
		}
	}
	
	private void deleteMusic() {
		System.out.println("===Ư���� ����===");
		System.out.print("������ ��� : ");
		String title = sc.nextLine();
		
		// �������ּ��� ��û => Controller Ŭ������ �޼ҵ� ȣ��
		// ���� ���� ���ε� ���� ���� ��
		int result = mc.deleteMusic(title);
		
		// ���� ���� ���� �˻�
		if(result > 0) { // ����� == ���� �����
			System.out.println("���������� �����Ǿ����ϴ�.");
		}
		else { // ������ ���� ã�� ����
			System.out.println("������ ���� ã�� ���߽��ϴ�.");
		}
	}
	
	// 5. Ư�� ���� ������ �� �ִ� ȭ��
	public void updateMusic() {
		System.out.println("===Ư�� �� ����===");
		
		//���� ��� �����ؾ��ϴ��� ���!
		// => ���� ���, ������ ���, ������ ������ �Է¹ޱ�
		System.out.print("���� ��� : ");
		String title = sc.nextLine();
		
		System.out.print("���� ����(���) : ");
		String upTitle = sc.nextLine();
		
		System.out.println("���� ����(������) : ");
		String upArtist = sc.nextLine();
		
		// �������ּ��� ��û => Controller Ŭ������ �޼ҵ� ȣ��
		// ���� ���θ� ���Ϲޱ� (int)
		int result = mc.updateMusic(title, upTitle, upArtist);
		
		// ���� ���� �Ǻ�
		if(result > 0) { // ������ �����
			System.out.println("���������� �����Ǿ����ϴ�");
		}
		else { // ������ ���� ã�� ����
			System.out.println("������ ���� ã�� ���߽��ϴ�");
		}

	}

}
