package kr.or.ddit.io;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;

/**
 * 
 * Stream 이용한 IO
 *
 * Stream : 연속성을 지닌 일련의 데이터 집합이면서 동시에 읽거나 쓰기 위한 단방향(***)통로
 * 
 *	스트림을 사용한 IO단계
 *	1. media(매체)를 어플리케이션에서 제어할 수 있는 객체의 형태로 생성.
 *		ex) new File(filesystem Path), k Socket, memory
 *	2. 1차 스트림을 매체에 연결.
 *		ex) new FileInputStream(file)
 *	3. 2차 스트림을 1차 스트림에 연결.
 *		ex) new BufferedInputSrem(inputStream)
 *	4. EOF(EOS, -1, null) 까지 반복적인 read
 *	5. close
 *
 *
 *
 *	Stream 종류
 *	1. 전송 데이터 크기
 *		1) byte Stream (~Stream))
 *			FileInputStream/ FileOutputStream
 *			SocketInputStream / SocketOutputStream
 *			ByteArrayInputStream / ByteArrayOutputStream
 *						
 *
 *		2) character stream
 *			FileReader / FileWriter
 *
 *	2. stream 생성 방법에 따라.
 *		1) 1차 stream
 *		2) 2차 stream(연결형 스트림)
 *			BufferedReader (readLine)
 *			FilteredStream : DataInputStream
 *			ObjectInput[Output]Stream : Serializable 객체 직렬화/역직렬화 스트림.
 *
 *
 *
 */

public class StreamDesc {
	public static void main(String[] args) throws IOException, URISyntaxException {
		readAndPrintFileSystemResource();
		readAndPrintClassPathResource();
		readAndWriteToTileSystemResource();
	}
	private static void readAndWriteToTileSystemResource() throws URISyntaxException, IOException {
		String logo = "https://www.google.com/images/branding/googlelogo/1x/googlelogo_color_272x92dp.png";
		String filePath = "D:\\contents\\googleLogo.png";
		
		URI logoURI = new URI(logo);
		URL logoURL = logoURI.toURL();
		File file = new File(filePath);
		
		try(
		InputStream is = logoURL.openStream();
		FileOutputStream fos = new FileOutputStream(file);
		
		BufferedInputStream bis = new BufferedInputStream(is);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		){
			int temp = 0;
			//step4
			while((temp = bis.read()) != 0) {
				bos.write(temp);
				
			}
			
		}
		
	}
	private static void readAndPrintClassPathResource() throws URISyntaxException, IOException{
//		String resCpPath ="/kr/or/ddit/medias/오래된 노래_utf8.txt";
		String resCpPath ="/kr/or/ddit/medias/오래된 노래.txt";
		
		try(
				//step2
				InputStream is = StreamDesc.class.getResourceAsStream(resCpPath);//byte
				InputStreamReader isr = new InputStreamReader(is,"MS949");
				//step3
				//한줄을 모아둘 저장공간
				BufferedReader br = new BufferedReader(isr);
					
			){
				String temp = null;
				//step4
				while((temp = br.readLine()) != null) {
					System.out.println(temp);
				}
				
			}
		
	
	}
	private static void readAndPrintFileSystemResource() throws IOException {
		String resPath = "D:\\contents\\another day.txt";
		//step1
		File file = new File(resPath);//pathname
		
//		try with resource 문법
//		try(
//			Closable 객체 생성. -> 자동으로 finally 가 추가되고, close됨.
//			
//		) {
//			
//		}catch(Exception e) {
//			
//		}finally {
//			
//		}
		try(
			//step2
			FileReader reader = new FileReader(file);
			//step3
			//한줄을 모아둘 저장공간
			BufferedReader br = new BufferedReader(reader);
				
		){
			String temp = null;
			//step4
			while((temp = br.readLine()) != null) {
				System.out.println(temp);
			}
			
		}
		
		//step5
//		br.close();
//		reader.close();


	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	}
}
