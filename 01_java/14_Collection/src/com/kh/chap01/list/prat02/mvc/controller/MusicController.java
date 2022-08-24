package com.kh.chap01.list.prat02.mvc.controller;

import java.util.ArrayList;

import com.kh.chap01.list.prat02.mvc.model.vo.Music;

// Controller :  ������� ��û�� �޾Ƽ� ��������� ó�����ִ� �κ�
//				 View�κ��� ��û �� ���ް��� �޾� ó�� �� View�� ó�� ��� ��ȯ
public class MusicController {
	
	// ������ ������ �� �ִ� ����Ҹ� ���������� ���ΰ� �ΰ�ΰ� ����� ����
	ArrayList<Music> list = new ArrayList<>();
	{
		// �ʱ�ȭ ���
		list.add(new Music("������Ÿ��", "����"));
		list.add(new Music("�׽���!", "���ƾ�"));
	}
	
	
	// ���ο� �� �߰� ��û�� ����� �޼ҵ� 
	public int insertMusic(String title, String artist) {
		
		int before = list.size(); // �߰��Ǳ� �� ArrayList�� ũ�⸦ �˾Ƴ�
		list.add(new Music(title, artist));
		
		
		// �߰��� �������� ������ ���� (��������)
		// �߰� �� ���� ArrayList�� ũ�� - �߰��Ǳ��� ArrayList�� ũ��
		
		return list.size() - before; // 0�̶�� �߰��� �ȵȰ�
		
		
		
		
		
	}
	
	// ��ü �� ��ȸ ��û �� ����� �޼ҵ�
	public ArrayList<Music> selectMusicList () {
		return list;
	}
	
	public ArrayList<Music> searchMusic (String keyword) {
		
		// �˻� ��� : �ش� Ű���尡 ���Ե� �͵��� ��� ��ȸ
		
		// 1. �˻��� ������� ���� ������ ���� (�˻� ����� 0���ϼ���, 1���ϼ���, ������ �ϼ��� ����)
		ArrayList<Music> searched = new ArrayList<>();
		
		// 2. �ݺ����� �������� "����"�� ���� �ֳ� �˻��ؾ� ��
		// => ���Ե� ���빰�̶�� �˻��� ������� ���� �� �ִ� ������ ��Ƶα�
		for (int i = 0; i < list.size(); i++) {
				// ���ڿ��� ��ġ ���踦 �˻��� �� �ִ� �޼ҵ� : ���ڿ�.equals(���� ���ڿ�) => true / false
				// ���ڿ��� ���԰��踦 �˻��� �� �ִ� �޼ҵ� : ���ڿ�.contains(�˻��� ���ڿ�)
				//									=> ���ڿ� �ȿ� �˻��� ���ڿ��� ���ԵǾ� �ִٸ� true
				//	 												  	      ���ԵǾ����� �ʴٸ� false
			if (list.get(i).getTilte().contains(keyword)) { // ���ԵǾ����� ��� 
				searched.add(list.get(i));
			}
		}
		
		// 3. �˻��� ����� View ������ �����ϱ�
		return searched;
	}
	
	// Ư�� �� ���� ��û �� ����� �޼ҵ�
	public int deleteMusic(String title) {
		
		int result = 0; // ������ ����� ������ ��Ÿ���� ���� 
		
		// �ݺ����� ���� �� ������ ��ġ�ϴ��� �˻�
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getTilte().equals(title)) { //�� ������ ��ġ�Ѵٸ�
				
				list.remove(i--); // ������ ��ĭ�� ���ܿ� �Ϳ� ����Ͽ� ���� ���� �߰� 
				result++;
			}
		}
		
		// result ����
		return result; // 0�ϼ����ְ� (�����Ȱ� �������), ������ϼ��� ����(�����Ȱ� �������)
		
	}
	
	
	// Ư�� �� ���� ��û�� ������ �޼ҵ�
	public int updateMusic (String Title, String upTitle, String upArtist) {
		// 1. ������ �� ������ ���� ���� ����
		int result = 0;
		
		
		// 2. �ݺ����� ���� ������ ��ġ�ϴ��� �˻� �� ��ġ�Ѵٸ� �� ������ ����
		for (int i=0; i < list.size(); i++) {
			if(list.get(i).getTilte().equals(Title)) { // ������ ��ġ�Ѵٸ�
					
				// �����ϴ� ��� 2����
				// 1. ���� ȿ������ ���
				// list.get(i).setTilte(upTitle);
				// list.get(i).setArtist(upArtist);
				
				// 2. ���� ȿ������ ����� �ƴ����� ���� ��� ������ Ȱ���� �� �ִ� ���
				// => �޸� ������ �Ҵ��� �ѹ� �� �̷������ �� 
				list.set(i, new Music(upTitle, upArtist));
				
				result++;
				
				}
			}
		
			// 3. ������ �� ������ ���� ���� ���� (��� ��ȯ)
			return result; // 0�ϼ��� �ְ�, ����� ���� ����
		
		}
		
		
		
	}

