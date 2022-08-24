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

// 클라이언트용 프로그램
public class ClientProgram {

	public static void main(String[] args) {
		Scanner sc = new Scanner (System.in);
		
		// 1) 접속하고자 하는 서버의 IP 주소, port 번호 지정
		// 요청하고자 하는 서버의 IP 주소 : 192.168.40.53(내 IP주소) 또는 127.0.0.1 (루프백 IP), localhost
		String serverIP = "192.168.40.26";
		int port = 3000;
		
		// 반납을 위해서 변수를 미리 선언 후 null 로 초기화
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		
		try {
			// 2) 서버에 연결 요청을 보내는 구문
			// => 요청하고자 하는 서버의 IP 주소와 port 번호를 제시하면서 Socket 객체 생성
			socket = new Socket(serverIP, port);
			// => Socket 객체 생성시 연결이 제대로 되었다면 객체가 잘 생성될 것
			//					   연결이 실패할 경우에는 null 값이 socket 객체에 담김
			
			// 서버랑 연결이 잘 됐나?
			if (socket != null) { // 연결이 잘 되었을 경우 => 통신 진행
				System.out.println("서버와 연결 성공!");
				
				// 3) 서버와 통신할 수 있는 입력용, 출력용 스트림 각각 생성
				// 4) 보조 스트림을 추가해서 성능 개선
				
				// 입력용 스트림 
				// socket.getInputStream() + InputStreamReader + BufferedReader
				br = new BufferedReader (new InputStreamReader (socket.getInputStream()));
				
				// 출력용 스트림
				// socket.getOutputStream() + OutputStreamWriter + printWriter
				pw = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
				
				// 반복문
				while(true) {
					// 5) 스트림을 통해 읽고 쓰기
					// 서버에게 데이터를 전달 (output)
					System.out.print("서버에게 보낼 내용 :");
					String sendMessage = sc.nextLine();
					pw.println(sendMessage);
					pw.flush();
					
					// 반대로 서버로부터 전달된 메시지를 읽어들이기 (input)
					String message = br.readLine();
					System.out.println("서버로부터 전달받은 메시지: " + message);
				}

			}
			
		} catch (UnknownHostException e) {
			e.printStackTrace();
			
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			
			try {
			// 6) 통신 종료 (생성된 순서의 역순)
			pw.close();
			br.close();
			socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
	}

}
