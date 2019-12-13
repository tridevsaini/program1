package com.ytp.ems;

import java.io.File;


import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection2 {

	static Connection connection = null;
	static String databasename = "EMPLOYEES";
	static String url = "jdbc:mysql://localhost:3306/";
	static String user = "root";
	static String password = "saigopi";

	public static void main(String[] args) {
		Statement stmt = null;
		try {

			Class.forName("com.mysql.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, user, password);
			stmt = connection.createStatement();

			String sql = "DROP DATABASE IF EXISTS EMPLOYEES";
			stmt.executeUpdate(sql);
			sql = "CREATE DATABASE EMPLOYEES";
			stmt.executeUpdate(sql);
			System.out.println("Database created successfully...");

			connection = DriverManager.getConnection(url + databasename, user, password);

			System.out.println("Creating table in given database...");
			stmt = connection.createStatement();

			sql = "CREATE TABLE EMPLOYEE DEATILS" + "(EMP_ID INTEGER not NULL, " + " EMP_NAME VARCHAR(255), "
					+ " EMP_AGE INTEGER, " + " EMP_GENDER CHAR, " + " EMP_EMAIL VARCHAR(250)," + "EMP_SALARY DOUBLE,"
					+ "EMP_DEPARTMENT VARCHAR(45)," + " PRIMARY KEY ( EMP_ID))";

			stmt.executeUpdate(sql);
			System.out.println("Created table in given database...");
			connection = DriverManager.getConnection(url+databasename,user,password);
			System.out.println("Creating table in given  database");
			stmt = connection.createStatement();
			
			sql = "CREATE TABLE OF EMPLOYEE"

			Scanner scanner = new Scanner(new File("/home/ytp-ind-003/Desktop/sai/empdetails"));


			while (scanner.hasNextLine())
			
			{
				String lineOfText = scanner.nextLine();
				// nextline() is used to read the line and move on
				// we are keeping if conditon to reomve unwanted conditions are(lines)
				if (lineOfText.startsWith("--") || lineOfText.startsWith("EMP")) {
					continue; // Exit this iteration if line starts with space or /
				}
				Scanner scannerLine = new Scanner(lineOfText.replaceAll(" ", "")).useDelimiter("\\|");
				System.out.println(lineOfText);
				while (scannerLine.hasNext()) {
					Employee employee = new Employee(scannerLine.nextInt(), scannerLine.next(), scannerLine.nextInt(),
							scannerLine.next().charAt(0), scannerLine.next(), scannerLine.nextDouble(),
							scannerLine.next());
					if (employee.getEMP_DEPARTMENT().equals("IT")) {
						employee.setEMP_SALARY(employee.getEMP_SALARY() * 1.6);
					}

					if (employee.getEMP_DEPARTMENT().equals("HR")) {
						employee.setEMP_SALARY(employee.getEMP_SALARY() * 1.4);

					}
					if (employee.getEMP_DEPARTMENT().equals("A/C")) {
						employee.setEMP_SALARY(employee.getEMP_SALARY() * 1.3);
					}
					PreparedStatement ps = connection.prepareStatement(
							"insert into EMPLOYEE(EMP_ID ,EMP_NAME,EMP_AGE,EMP_GENDER, EMP_EMAIL,EMP_SALARY ,EMP_DEPARTMENT ) "
									+ "values(" + employee.getEMP_ID() + ",'" + employee.getEMP_NAME() + "',"
									+ employee.getEMP_AGE() + ",'" + employee.getEMP_GENDER() + "','"
									+ employee.getEMP_AGE() + "','" + employee.getEMP_SALARY() + "','"
									+ employee.getEMP_DEPARTMENT() + "')");
					int status = ps.executeUpdate();

					if (status != 0) {
						System.out.println("row inserted.. ");
					}
				}

			}
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
				connection.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

}
