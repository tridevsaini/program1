package com.ytp;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class findDuplicateCharacter {
	
	public static void main(String[] args) {
		  duplicateCharacter("aaabbccc");
	}

	  public static void duplicateCharacter(String str) {  
	        Map<Character, Integer> baseMap = new HashMap<Character, Integer>();  
	        char[] charArray = str.toCharArray();  
	        for (Character ch : charArray) {  
	            if (baseMap.containsKey(ch)) {  
	                baseMap.put(ch, baseMap.get(ch) + 1);  
	            } else {  
	                baseMap.put(ch, 1);  
	            }  
	        }  
	        Set<Character> keys = baseMap.keySet(); 
	        System.out.println(str);
	        for (Character ch : keys) {  
	            if (baseMap.get(ch) > 1) {  
	                System.out.print(baseMap.get(ch) +""+ ch );  
	            }  
	        }  
	    }  
	
}
