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
			// 다운로드 받을 주소 만들기
			String addr = "https://rezeptepenny.files.wordpress.com/2013/10/baguette-royal-2.jpg";
			// addr에서 /이후의 문자열을 가져오기
			// 마지막 /의 위치를 찾습미다.
			int idx = addr.lastIndexOf("/");
			// addr에서 idx+1번째 글자부터 가져오기
			String filename = addr.substring(idx + 1);
			// System.out.println(filename);
			// filename을 이용해서 저장할 파일 경로 만들기
			String filepath = "C:\\이우미\\이미지\\" + filename;
			// 파일이 존재하는지 확인
			if ((new File(filepath)).exists()) {
				System.out.println("이미 존재 ");
			} else {
				// System.out.println("파일이 존재하지 않습니다.");

				// 스레드 객체 생성
				Thread th = new Thread() {
					public void run() {
						try {
							// 다운로드 받을 URL 만들기
							URL url = new URL(addr);
							// 연결 객체 생성
							HttpURLConnection con = (HttpURLConnection) url.openConnection();
							// 옵션 설정
							con.setConnectTimeout(20000);
							con.setUseCaches(false);
							// 바이드 단위로 다운로드 받기 위한 스트림 생성
							BufferedInputStream bis = new BufferedInputStream(con.getInputStream());
							// 다운로드 받은 내용을 기록할 스트림
							
								PrintStream ps = new PrintStream(filepath);
						while(true) {
							byte [] b = new byte [113348];
							int r = bis.read(b);
							//읽은 데이터가 없으면 중지
							if(r<=0) {
								break;
							}
							//읽은 데이터를  ps를 이용해서 기록
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
				// 스레드 시작
				th.start();

			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

}
