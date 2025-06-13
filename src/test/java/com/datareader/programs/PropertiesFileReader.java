package com.datareader.programs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesFileReader {
	
	public static void main(String[] args) throws FileNotFoundException,IOException {
		
		File file=new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\data.properties");
		FileInputStream fis=new FileInputStream(file);
		Properties prop = new Properties();
		prop.load(fis);
		for(Object value : prop.keySet())
		{
			String valueInString = value.toString();
			System.out.println(valueInString+" "+prop.get(valueInString));
		}
		
	}

}
