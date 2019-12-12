package com.ytp;

import java.util.Set;
import java.util.TreeMap;

public class Comparator {
  
    public static void main(String[] args) 
    { 
    	TreeMap<Empl,String> tm = new TreeMap<Empl,String>(new MyComp());
    	tm.put(new Empl("Ranshu",5000), "Ranshu");
        tm.put(new Empl("John",6000), "JOHN");
        tm.put(new Empl("Crish",2400), "CRISH");
        tm.put(new Empl("Tom",3400), "TOM");
        tm.put(new Empl("Rajat",5000), "Rajat");
        Set<Empl> keys = tm.keySet();
        for(Empl key:keys){
            System.out.println(key);
        }
   
    } 
}
