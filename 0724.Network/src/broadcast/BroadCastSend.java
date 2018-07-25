package broadcast;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class BroadCastSend {

	public static void main(String[] args) {
		try {
			DatagramSocket ds = new DatagramSocket();
			Scanner sc = new Scanner(System.in);
			System.out.println("�� ���� �Է� : ");
			String nick = sc.nextLine();
			String msg = nick + "���� ������ �غ� �Ǿ����ϴ�.";
			// �� ���� ����
			DatagramPacket dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length,
					InetAddress.getByName("192.168.0.255"), 7777);
			ds.send(dp);

			while (true) {
				System.out.println("�޼��� : ");
				msg = sc.nextLine();
				msg = nick + " : " + msg;
				dp = new DatagramPacket(msg.getBytes(), msg.getBytes().length, InetAddress.getByName("192.168.0.255"),
						7777);
				ds.send(dp);

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

	}

}
