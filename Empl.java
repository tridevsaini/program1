package com.ytp;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class Empl {
	    private String name;
	    private int salary;
	     
	    public Empl(String n, int s){
	        this.name = n;
	        this.salary = s;
	    }
	     
//	    public String getName() {
//	        return name;
//	    }
//	    public void setName(String name) {
//	        this.name = name;
//	    }
//	    public int getSalary() {
//	        return salary;
//	    }
//	    public void setSalary(int salary) {
//	        this.salary = salary;
//	    }
	    public String toString(){
	        return this.name+"\t:"+this.salary;
	    }
}
