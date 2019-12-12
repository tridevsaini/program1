package com.ytp;

import java.util.Comparator;

public class MyComp implements Comparator<Empl> {
	
	public int compare(Empl e1, Empl e2) {
        if(e1.getSalary() > e2.getSalary()){
            return -1;
        } else if(e1.getSalary() < e2.getSalary()){
            return 1;
        } else {
        	return (e1.getName()).compareTo(e2.getName());
        }
	}
	
}
