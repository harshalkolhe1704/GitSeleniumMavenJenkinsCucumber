package utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ReadProperties {
	
	Properties prop = new Properties();
	
	public String ReadProperty(String FilePath, String propertyName) throws IOException {
		
		FileInputStream fis = new FileInputStream(FilePath);
		
		prop.load(fis);
		
		return prop.getProperty(propertyName);
	}
}
