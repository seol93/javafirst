package gmail.seol211112;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class HTMLDownload {
	public static void main(String[] args) {
		try {
			URL url = new URL(
					"https://newsstand.naver.com/?list=&pcode=038");
			
			//연결하기
			HttpURLConnection con = (HttpURLConnection)url.openConnection();
			
			//옵션설정
			con.setConnectTimeout(30000);
			con.setUseCaches(false);
			
			//읽기 위한 스트림 생성
			BufferedReader br = new BufferedReader(
									new InputStreamReader(con.getInputStream()));
			
			String html = "";
			StringBuilder sb = new StringBuilder();
			
			while(true) {
				String line = br.readLine();
				if(line == null) {
					break;
				}
				sb.append(line);
				sb.append("\n");	
			}
			
			html = sb.toString();
			System.out.println(html);
			
		}catch(Exception e) {
			System.out.println(e.getLocalizedMessage());
		}finally {
			
		}
	}

}
