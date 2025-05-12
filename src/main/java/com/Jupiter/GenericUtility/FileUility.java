package com.Jupiter.GenericUtility;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class FileUility {
	public String getDataFromPropertyFile(String key) throws IOException
	{
		FileInputStream fis=new FileInputStream("path file");
		Properties pobj=new Properties();
		pobj.load(fis);
		String data=pobj.getProperty(key);
		return data;
	}

}
