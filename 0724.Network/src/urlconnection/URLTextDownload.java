package urlconnection;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.net.ssl.HttpsURLConnection;

public class URLTextDownload {

	public static void main(String[] args) {
		try {

			// �ٿ�ε� ���� �ּ� �����
			String addr = "https://www.naver.com/";
			// �ѱ��� ���Ե� ����� URLEncoder.encode �޼ҵ带 �̿��ؼ� �ѱ��� ���ڵ��մϴ�.

		
			// 2. �ּҸ� ������ URL ��ü�� ����
			URL url = new URL(addr);

			// 3.URL ���� ��ü�� ����
			HttpURLConnection con = (HttpURLConnection) url.openConnection();

			// 4.�ɼ��� ����
			// ���� �ȵǸ� 30�� ���� �õ�
			con.setConnectTimeout(30000);
			// ������ ���� �����Ͱ� �־ ������� �ʵ��� ����
			con.setUseCaches(false);

			// 5.�ٿ�ε� ���� ��Ʈ�� ����
			//����� �� �ѱ��� ������ ���ڵ��� ���������.
			BufferedReader br = new BufferedReader(new InputStreamReader(con.getInputStream(),"utf-8"));

			// 6. �����͸� �о String���� �����
			StringBuilder sb = new StringBuilder();
			while (true) {
				// ���ڿ� �б�
				String line = br.readLine();
				// ���� ���� ������ �ߴ�
				if (line == null) {
					break;
				}
				// ���� �����Ͱ� ������ sb�� �߰�
				sb.append(line + "\n");
			}
			// ���� �����͸� String���� ��ȯ
			String html = sb.toString();
			//ȭ�鿡 ���
			System.out.println(html);
			//7.����� ��ü ����
			br.close();
			con.disconnect();
		} catch (Exception e) {

			System.out.println(e.getMessage());
		}

	}

}
