package kr.or.ddit.object.marshalling;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import kr.or.ddit.object.TestVO;

/**
 * Marshalling / UnMarshalling
 * 
 * 	json/xml - 이기종 시스템간 메시지 교환시 사용되는 공통 데이터 표현 방식
 * Marshalling : native data -> JSON/XML  
 * UnMarshalling : JSON/XML -> native data
 * 
 * Serialization : 전송이나 저장을 목적으로 객체의 상태를 byte array(bit stream) 로 변환하는 과정.
 * DeSerialization : byte array(bit stream) 으로부터 객체의 상태를 복원하는 과정.
 * 
 * nativa data 	->	JSON/XML	-> 	byte array		->		JSON/XML	-> 	native data
 * 		Marshalling			Serialization		DeSerialization		UnMarshalling
 * 
 * nativa data 	<-	JSON/XML	<-	byte array		<-		JSON/XML	<- 	native data
 * 		UnMarshalling		DeSerialization		Serialization	Marshalling
 *
 */
public class XMLMarshallingDesc {
	public static void main(String[] args) throws JsonProcessingException {
		TestVO vo = new TestVO();
		vo.setProp1("Value1");
		vo.setProp2("Value2");
		
//		serialize(vo);
//		deSerialize();
		
		
		String json = marshalling(vo);
		TestVO vo2 = unMarshalling(json, TestVO.class);
		
		System.out.println(vo2);
		
//		transfer(vo);
		
	}
	
	private static void transfer(Object target) {
		String json = marshalling(target);
		serialize(json);
	}
	
	private static <T> T unMarshalling(String json, Class<T> javaType) {
		try {
			ObjectMapper mapper = new XmlMapper();
			return mapper.readValue(json, javaType);
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static String  marshalling(Object target) {
		try {
			ObjectMapper mapper = new XmlMapper();
			String json = mapper
							.writerWithDefaultPrettyPrinter()
							.writeValueAsString(target);
			System.out.println(json);
			return json;
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void deSerialize() {
		File objFile = new File("d:/contents", "obj.dat");
		try(
			FileInputStream fis = new FileInputStream(objFile);
			ObjectInputStream ois = new ObjectInputStream(fis);	
		){
			Object obj = ois.readObject();
			System.out.println(obj);
		}catch (IOException | ClassNotFoundException e) {
			throw new RuntimeException(e);
		}
	}
	
	private static void serialize(Object target) {
		File objFile = new File("d:/contents", "obj.dat");
		try(
			FileOutputStream fos = new FileOutputStream(objFile);	
			ObjectOutputStream oos = new ObjectOutputStream(fos);
		){
			oos.writeObject(target);
		}catch (IOException e) {
			throw new RuntimeException(e);
		}
	} 
}

























