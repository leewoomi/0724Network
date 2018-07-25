package urlconnection;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class URLFileDownload {

	public static void main(String[] args) {

		try {
			// �ٿ�ε� ���� �ּ� �����
			String addr = "https://rezeptepenny.files.wordpress.com/2013/10/baguette-royal-2.jpg";
			// addr���� /������ ���ڿ��� ��������
			// ������ /�� ��ġ�� ã���̴�.
			int idx = addr.lastIndexOf("/");
			// addr���� idx+1��° ���ں��� ��������
			String filename = addr.substring(idx + 1);
			// System.out.println(filename);
			// filename�� �̿��ؼ� ������ ���� ��� �����
			String filepath = "C:\\�̿��\\�̹���\\" + filename;
			// ������ �����ϴ��� Ȯ��
			if ((new File(filepath)).exists()) {
				System.out.println("�̹� ���� ");
			} else {
				// System.out.println("������ �������� �ʽ��ϴ�.");

				// ������ ��ü ����
				Thread th = new Thread() {
					public void run() {
						try {
							// �ٿ�ε� ���� URL �����
							URL url = new URL(addr);
							// ���� ��ü ����
							HttpURLConnection con = (HttpURLConnection) url.openConnection();
							// �ɼ� ����
							con.setConnectTimeout(20000);
							con.setUseCaches(false);
							// ���̵� ������ �ٿ�ε� �ޱ� ���� ��Ʈ�� ����
							BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
							// �ٿ�ε� ���� ������ ����� ��Ʈ��
							
								PrintStream ps = new PrintStream(filepath);
						while(true) {
							byte [] b = new byte [113348];
							int r = bis.read(b);
							//���� �����Ͱ� ������ ����
							if(r<=0) {
								break;
							}
							//���� �����͸�  ps�� �̿��ؼ� ���
							ps.write(b, 0 ,r);
						}
						ps.close();
						bis.close();
						con.disconnect();
						} catch (MalformedURLException e) {

							e.printStackTrace();
							System.out.println(e.getMessage());

						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
							System.out.println(e1.getMessage());
						}

					}
				};
				// ������ ����
				th.start();

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
