package com.ytp.RandomNumber;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class RandomNameProgram {


  public static void main(String[] args) throws SQLException {

    PreparedStatement stmt2 = null;
    Connection connection = null;

    try {

      connection = DriverManager.getConnection(
          "jdbc:mysql://localhost:3306/insurancedemo", "root", "root");

      String[] customerFistNamesList = new String[] { "Marry", "Elizabeth",
          "Sarah", "Margaret", "Ann", "Jane", "Alice", "Ellen", "Annie",
          "Florence", "Emma", "Edith", "Emily", "Eliza", "Hanna", "Susan",
          "Martha", "Dorothy", "Catherine", "Ethel", "Ada", "Anne", "Frances",
          "Elsie", "Harriet", "John", "William", "Thomas", "George", "James",
          "Robert", "Charles", "Henry", "Joseph", "David", "Richard",
          "Frederick", "Arthur", "Edward", "Albert", "Alfred", "Michael",
          "Peter", "Walter", "Ernest", "Samuel", "Harry", "Stephen", "Frank",
          "Paul" };
      String[] customerLastNamesList = new String[] { "Cassie", "Ragnar",
          "Pendragon", "Black", "Amelia", "Olivia", "Isla", "Emily", "Poppy",
          "Ava", "Isabella", "Jessica", "Lily", "Stophia", "Grace", "Mia",
          "Evie", "Ruby", "Ella", "Scarlett", "Chloe", "Sienna", "Freya",
          "Phoebe", "Charlotte", "Daisy", "Oliver", "Jack", "Harry", "Jacob",
          "Charlie", "Oscar", "Noah", "Alfie", "Joshua", "Muhammad", "Henry",
          "Leo", "Archie", "Ethan", "FreddieSamuel", "Alexander", "Logan",
          "Daniel", "Issan", "Newton", "Weasly", "Broak", "Bjorn" };
      String[] agentNamesList = new String[] { "Ronan Gruber", "Brayden Huber",
          "Hugo Mayer", "Diego schmid", "Antonio Winkler", "Marco Black",
          "Steffan Maier", "Devin Moser", "Aaron Picher" };
      String[] status = new String[] { "Lapsed", "Death-claim", "Pending",
          "Surrendered", "Not Taken", "In-Force", "Issue Not-Paid",
          "Withdrawn" };
      String[] policyCode = new String[] { "FEL20", "DRS12", "ECG45", "KCB08",
          "GHA33" };
      int[] agentId = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
      int[] insureId = new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
          14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
          31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47,
          48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64,
          65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81,
          82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 92, 93, 94, 95, 96, 97, 98,
          99, 100 };
      int[] policyId = new int[] { 1, 2, 3, 4, 5 };

      Random random = new Random();
      String dateOfBirth = "2020-03-01";

      Date utilDateOfBirth = new SimpleDateFormat("yyyy-MM-dd")
          .parse(dateOfBirth);

      java.sql.Date sqlcreationDate = new java.sql.Date(
          utilDateOfBirth.getTime());
      java.sql.Date sqlmodifiedDate = new java.sql.Date(
          utilDateOfBirth.getTime());
      java.sql.Date sqleffectiveDate = new java.sql.Date(
          utilDateOfBirth.getTime());
      int count = 0;
System.out.println(utilDateOfBirth);
      System.out.println(sqleffectiveDate);
      stmt2 = connection.prepareStatement(
          "INSERT INTO tbl_policy_insurance (creation_date, effective_date, modified_date, policy_code, status, agent_id, insure_id,policy_id) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");

      for (int i = 0; i < 100; i++) {

        count++;

        connection.setAutoCommit(false);
        int rfn = random.nextInt(customerFistNamesList.length);
        int rln = random.nextInt(customerLastNamesList.length);
        int anl = random.nextInt(agentNamesList.length);
        int sta = random.nextInt(status.length);
        int pCode = random.nextInt(policyCode.length);
        int aid = random.nextInt(agentId.length);
        int pid = random.nextInt(policyId.length);
        int insid = random.nextInt(insureId.length);

        stmt2.setDate(1, sqlcreationDate);
        stmt2.setDate(2, sqleffectiveDate);
        stmt2.setDate(3, sqlmodifiedDate);
        stmt2.setString(4, policyCode[pCode]);
        stmt2.setString(5, status[sta]);
        stmt2.setInt(6, agentId[aid]);
        stmt2.setInt(7, insureId[insid]);
        stmt2.setInt(8, policyId[pid]);

        stmt2.addBatch();

        if (count == 5) {

          int[] result = stmt2.executeBatch();
          connection.commit();
          count = 0;
          System.out.println("");
          System.out.println("firing");
        }
      }

      System.out.println("complted successfully");
      stmt2.close();
    }

    catch (Exception e) {
      e.printStackTrace();
    } finally {
      connection.close();
    }
  }

}