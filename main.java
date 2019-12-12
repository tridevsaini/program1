package com.ytp;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class main {

	private static final String driver = "org.postgresql.Driver";
	private static final String postgreUrl = "jdbc:postgresql://localhost/postgres";
	private static final String username = "postgres";
	private static final String password = "password";
	
	public static void main(String[] args) throws ClassNotFoundException,IOException {
		
		Connection conn = null;
		Statement stmt = null;
				
		try {
			//load the jdbc driver
			Class.forName(driver);
			
			//Establish the connection
			conn = DriverManager.getConnection(postgreUrl, username, password);
			conn.setAutoCommit(false);
			
            if (conn != null) 
                System.out.println("Connected to the database!");
            else 
                System.out.println("Failed to make connection!");
           
            stmt=conn.createStatement();
            String sql = "CREATE TABLE EMPLOYEE " + "(EMP_ID INTEGER PRIMARY KEY NOT NULL," + " EMP_NAME VARCHAR(50) NOT NULL, " + " EMP_AGE INTEGER NOT NULL, " + " EMP_GENDER CHAR, " +" EMP_EMAIL VARCHAR(60) NOT NULL)";
            stmt.executeUpdate(sql);
            System.out.println("Table created successfully");
            
            //close the statement
            stmt.close();
            //commit the connection
            conn.commit();
            //close the connection
            conn.close();
		}//try
		
		catch(SQLException e) {
			e.getMessage();
		}
		
	}
	

}
