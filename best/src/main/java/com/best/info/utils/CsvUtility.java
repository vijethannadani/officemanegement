package com.best.info.utils;

import java.io.FileReader;
import java.io.IOException;

import com.opencsv.CSVReader;

public class CsvUtility {

	public static void ReadCsv() {
		  String csvFile = "C:\\Users\\Gopi N\\Desktop\\New folder\\csvdemo.csv";
		  long readLine=0;
	        CSVReader reader = null;
	        try {
	            reader = new CSVReader(new FileReader(csvFile));
	            String[] line;
	            while ((line = reader.readNext()) != null) {
	            	readLine++;
	                System.out.println("Country [id= " + line[0] + ", code= " + line[1] + " , name=" + line[2] + "]");
	                if(readLine==3) {
	                	return;
	                }
	            }
	        } catch (IOException e) {
	            e.printStackTrace();
	        } finally {
	        	try {
					reader.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
	        
	}
}
