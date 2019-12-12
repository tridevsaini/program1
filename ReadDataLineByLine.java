package com.ytp;

import java.io.FileReader;
import com.opencsv.CSVReader;

public class ReadDataLineByLine {
	
	public static void readDataLineByLine() {
	String file=null;
	try { 

		// Create an object of filereader class 
		// with CSV file as a parameter. 
		
		FileReader filereader = new FileReader(file); 

		// create csvReader object passing 
		// filereader as parameter 
		
		CSVReader csvReader = new CSVReader(filereader); 
		String[] nextRecord = null; 

		// we are going to read data line by line 
		
		while ((nextRecord = csvReader.readNext()) != null) { 
			for (String cell : nextRecord) { 
				System.out.print(cell + "\t"); 
			} 
			System.out.println(); 
		} 
	} 
	catch (Exception e) { 
		e.printStackTrace(); 
	} 
  }
}
