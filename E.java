package com.ytp.ems;

public class Employee {
	private int EMP_ID;
	private String EMP_NAME;
	private int EMP_AGE;
	private char EMP_GENDER;
	private String EMP_EMAIL;
	private double EMP_SALARY;
	private String EMP_DEPARTMENT;

	public Employee(int eMP_ID, String eMP_NAME, int eMP_AGE, char eMP_GENDER, String eMP_EMAIL, double eMP_SALARY,
			String eMP_DEPARTMENT) {
		super();
		EMP_ID = eMP_ID;
		EMP_NAME = eMP_NAME;
		EMP_AGE = eMP_AGE;
		EMP_GENDER = eMP_GENDER;
		EMP_EMAIL = eMP_EMAIL;
		EMP_SALARY = eMP_SALARY;
		EMP_DEPARTMENT = eMP_DEPARTMENT;

	}

	public int getEMP_ID() {
		return EMP_ID;
	}

	public void setEMP_ID(int eMP_ID) {
		EMP_ID = eMP_ID;
	}

	public String getEMP_NAME() {
		return EMP_NAME;
	}

	public void setEMP_NAME(String eMP_NAME) {
		EMP_NAME = eMP_NAME;
	}

	public int getEMP_AGE() {
		return EMP_AGE;
	}

	public void setEMP_AGE(int eMP_AGE) {
		EMP_AGE = eMP_AGE;
	}

	public char getEMP_GENDER() {
		return EMP_GENDER;
	}

	public void setEMP_GENDER(char eMP_GENDER) {
		EMP_GENDER = eMP_GENDER;
	}

	public String getEMP_EMAIL() {
		return EMP_EMAIL;
	}

	public void setEMP_EMAIL(String eMP_EMAIL) {
		EMP_EMAIL = eMP_EMAIL;
	}

	public double getEMP_SALARY() {
		return EMP_SALARY;
	}

	public void setEMP_SALARY(double eMP_SALARY) {
		EMP_SALARY = eMP_SALARY;
	}

	public String getEMP_DEPARTMENT() {
		return EMP_DEPARTMENT;
	}

	public void setEMP_DEPARTMENT(String eMP_DEPARTMENT) {
		EMP_DEPARTMENT = eMP_DEPARTMENT;
	}

	@Override
	public String toString() {
		return "Employee [EMP_ID=" + EMP_ID + ", EMP_NAME=" + EMP_NAME + ", EMP_AGE=" + EMP_AGE + ", EMP_GENDER="
				+ EMP_GENDER + ", EMP_EMAIL=" + EMP_EMAIL + ", EMP_SALARY=" + EMP_SALARY + ", EMP_DEPARTMENT="
				+ EMP_DEPARTMENT + "]";
	}
}
