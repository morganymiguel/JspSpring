package kr.or.ddit.message;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;
import java.util.ResourceBundle;

public class MessageBundleRead {

	public static void main(String[] args) {
//		propertiesRead();
		String baseName = "egovframework/message/com/message-common";
		
		ResourceBundle bundle = ResourceBundle.getBundle(baseName, Locale.ENGLISH);
		System.out.println(bundle.getString("fail.common.msg"));
	}

	private static void propertiesRead() {
		Properties properties = new Properties();
		String path = "/egovframework/message/com/message-common_ko.properties";
		try(
				InputStream is = MessageBundleRead.class.getResourceAsStream(path);
		) {
			properties.load(is);
//					if(is == null)
//						throw new FileNotFoundException();
//					properties.stringPropertyNames().stream().map(key -> key + ":" + properties.getProperty(key))
//					.forEach(System.out::println); 검색을 했음.
			for(Entry<Object, Object> pro : properties.entrySet()) {
				String key = Objects.toString(pro.getKey());
				String value = Objects.toString(pro.getValue());
				
				System.out.printf("%s : %s \n",key,value);
			}
		} catch (IOException e) {
			System.err.println(e.getMessage());
			throw new RuntimeException(e);
		}
				
	}

}
