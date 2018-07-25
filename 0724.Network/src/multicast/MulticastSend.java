package multicast;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
import java.util.Scanner;

public class MulticastSend {

	public static void main(String[] args) {
		try {
			// 보내는 멀티 캐스트 소켓을 생성
			MulticastSocket ms = new MulticastSocket();
			// 문자열을 입력받기 위한 스캐너 만들기
			Scanner sc = new Scanner(System.in);
			// 닉네임 설정
			System.out.print("닉네임 입력 : ");
			String nick = sc.nextLine();
			String str = nick + "님이 입장하셨습니다.";
			// 보내는 패킷 만들기 - 내용, 길이, 받을 곳의 주소, 포트번호
			DatagramPacket dp = new DatagramPacket(str.getBytes(), str.getBytes().length,
					InetAddress.getByName("FF7E:230::1234"), 9999);
			// 데이터 전송
			ms.send(dp);
			while (true) {
				System.out.print("메세지 (종료는 end) : ");
				String msg = sc.nextLine();
				if (msg.equals("end")) {
					msg = nick + "님이 퇴장하셨습니다.";
					// 보내는 패킷 만들기 - 내용, 길이, 받을 곳의 주소, 포트번호
					 dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
							InetAddress.getByName("FF7E:230::1234"), 9999);
					// 데이터 전송
					ms.send(dp);
					// 소켓과 스캐너 닫기
					ms.close();
					sc.close();
					break;
				} else {
					msg = nick + " : " + msg;
					// 보내는 패킷 만들기 - 내용, 길이, 받을 곳의 주소, 포트번호
					 dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
							InetAddress.getByName("FF7E:230::1234"), 9999);
					// 데이터 전송
					ms.send(dp);

				}
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
