package multicast;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastRecive {

	public static void main(String[] args) {
		
		try {
			//�޴� ��Ƽ ĳ��Ʈ ���� �����
			MulticastSocket ms = new MulticastSocket(9999);
			//�׷쿡 ����
			ms.joinGroup(InetAddress.getByName("FF7E:230::1234"));
			//���� �ݺ��ؼ� �޼��� �ޱ�
			while(true) {
				//����Ʈ �迭 ����
				 byte [] b = new byte[512];
				 //�����͸� ���� ���� ��Ŷ �����
				 DatagramPacket dp =new DatagramPacket(b, 512);
				 //������ �ޱ� - �����Ͱ� �� �� ���� ���
				 ms.receive(dp);
				 //����Ʈ �迭�� ���ڿ��� ��ȯ
				 String msg = new String (b);
				 //ȭ�鿡 ������ ���� �ϰ� ���
				 System.out.println(msg.trim());
			}
		} catch (Exception e) {
		
			System.out.println(e.getMessage());
		}

	}

}
