package multicast;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastRecive {

	public static void main(String[] args) {
		
		try {
			//받는 멀티 캐스트 소켓 만들기
			MulticastSocket ms = new MulticastSocket(9999);
			//그룹에 참여
			ms.joinGroup(InetAddress.getByName("FF7E:230::1234"));
			//무한 반복해서 메세지 받기
			while(true) {
				//바이트 배열 생성
				 byte [] b = new byte[512];
				 //데이터를 전송 받을 패킷 만들기
				 DatagramPacket dp =new DatagramPacket(b, 512);
				 //데이터 받기 - 데이터가 올 때 까지 대기
				 ms.receive(dp);
				 //바이트 배열을 문자열로 변환
				 String msg = new String (b);
				 //화면에 공백을 제거 하고 출력
				 System.out.println(msg.trim());
			}
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
		}

	}

}
