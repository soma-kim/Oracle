package com.kh.chap02.tcp.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

// Ŭ���̾�Ʈ�� ���α׷�
public class ClientProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		// 1) �����ϰ��� �ϴ� ������ IP �ּ�, port ��ȣ ����
		// ��û�ϰ��� �ϴ� ������ IP �ּ� : 192.168.40.53(�� IP�ּ�) �Ǵ� 127.0.0.1 (������ IP), localhost
		String serverIP = "192.168.40.26";
		int port = 3000;
		
		// �ݳ��� ���ؼ� ������ �̸� ���� �� null �� �ʱ�ȭ
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			// 2) ������ ���� ��û�� ������ ����
			// => ��û�ϰ��� �ϴ� ������ IP �ּҿ� port ��ȣ�� �����ϸ鼭 Socket ��ü ����
			socket = new Socket(serverIP, port);
			// => Socket ��ü ������ ������ ����� �Ǿ��ٸ� ��ü�� �� ������ ��
			//					   ������ ������ ��쿡�� null ���� socket ��ü�� ���
			
			// ������ ������ �� �Ƴ�?
			if (socket != null) { // ������ �� �Ǿ��� ��� => ��� ����
				System.out.println("������ ���� ����!");
				
				// 3) ������ ����� �� �ִ� �Է¿�, ��¿� ��Ʈ�� ���� ����
				// 4) ���� ��Ʈ���� �߰��ؼ� ���� ����
				
				// �Է¿� ��Ʈ�� 
				// socket.getInputStream() + InputStreamReader + BufferedReader
				br = new BufferedReader (new InputStreamReader (socket.getInputStream()));
				
				// ��¿� ��Ʈ��
				// socket.getOutputStream() + OutputStreamWriter + printWriter
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				// �ݺ���
				while(true) {
					// 5) ��Ʈ���� ���� �а� ����
					// �������� �����͸� ���� (output)
					System.out.print("�������� ���� ���� :");
					String sendMessage = sc.nextLine();
					pw.println(sendMessage);
					pw.flush();
					
					// �ݴ�� �����κ��� ���޵� �޽����� �о���̱� (input)
					String message = br.readLine();
					System.out.println("�����κ��� ���޹��� �޽���: " + message);
				}

			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
			// 6) ��� ���� (������ ������ ����)
			pw.close();
			br.close();
			socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
