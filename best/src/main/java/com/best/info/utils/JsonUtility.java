package com.best.info.utils;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonUtility {

	public static void readJsonFile() {

		JSONParser parser = new JSONParser();

		try {
			JSONArray a = (JSONArray) parser.parse(new FileReader("D:\\2018-4-21.json"));

			for (Object o : a) {
				JSONObject person = (JSONObject) o;

				String userId = (String) person.get("UserID");
				System.out.print(userId);

				String inout = (String) person.get("INOUT");
				System.out.print("   " + inout);

				String swippedDateTime = (String) person.get("SwippedDateTime");
				System.out.print("   " + swippedDateTime);

				System.out.println("");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} catch (org.json.simple.parser.ParseException e) {
			e.printStackTrace();
		}
	}
}
