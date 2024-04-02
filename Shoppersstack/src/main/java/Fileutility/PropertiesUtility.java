package Fileutility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import javax.imageio.stream.FileImageInputStream;

public class PropertiesUtility {

	public static String getProperty(String key)  {
		FileInputStream fis=null;
		try {
			fis = new FileInputStream("./src/main/resources/commonData.properties");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Properties p=new Properties();
		
		try {
			p.load(fis);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p.getProperty(key);
	}
	
	public static void main(String[] args) {
		System.out.println(getProperty("browser"));
	}
	
}
