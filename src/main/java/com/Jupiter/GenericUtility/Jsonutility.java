package com.Jupiter.GenericUtility;

import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;



public class Jsonutility {
	public String getDataFromJsonfile(String key) throws IOException, ParseException
	{
	FileReader f=new FileReader("./src/test/resources/TrelloCommanData.json");
	JSONParser parser=new JSONParser();
	Object obj = parser.parse(f);
	JSONObject map=(JSONObject)obj;
	String data = (String) map.get(key);
	return data;
	}

}
