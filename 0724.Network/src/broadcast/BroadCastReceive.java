package broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class BroadCastReceive {

	public static void main(String[] args) {
		try {
			//UDP 방식으로 데이터를 전송 받을 수 있는 소켓 만들기
			//포트 번호가 있어야 함.
			DatagramSocket ds = new DatagramSocket(7777);
			System.out.println("서버 대기 중..");
			while(true) {
				//메세지를 저장할 배열을 생성
				byte [] b = new byte [512];
				//메세지를 저장할 DatagramPacket 생성
				DatagramPacket dp = new DatagramPacket(b, 512);
				//데이터 받기
				ds.receive(dp);
				//데이터 읽기
				String msg = new String(b);
				//512바이트가 안될 때 공백을 제거 하기 위해서 trim()을 호출
				System.out.println(msg.trim());
				
			}
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
