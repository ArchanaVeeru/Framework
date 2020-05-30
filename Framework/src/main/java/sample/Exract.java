package sample;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Exract {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		FileInputStream fis=new FileInputStream("C:\\Users\\ArchanaVeeru\\eclipse-workspace\\Framework\\src\\main\\java\\sample\\config.properties");
		Properties prop=new Properties();
		prop.load(fis);
		System.out.println(prop.getProperty("username"));
		System.out.println(prop.getProperty("password"));
	
	}

}
