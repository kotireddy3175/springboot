package com.combinations.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.stereotype.Service;

import net.minidev.json.JSONObject;

@Service
public class CombinationsService {
	
	private static final HashMap<Character, String> map = new HashMap<>(8);
	static {
		map.put('0', "0");
		map.put('1', "1");
	    map.put('2', "2ABC");
	    map.put('3', "3DEF");
	    map.put('4', "4GHI");
	    map.put('5', "5JKL");
	    map.put('6', "6MNO");
	    map.put('7', "7PQRS");
	    map.put('8', "8TUV");
	    map.put('9', "9WXYZ");
	};

	public boolean validateNull(String digits) {
		if(digits==null || digits.equals(""))
			return false;
		return true;
	}

	public boolean validateNumber(String digits) {
		String regex ="\\d+";
		if(!(Pattern.matches(regex, digits)))
			return false;
		return true;
	}
	
	public boolean validateNumberLegnth(String digits) {
		String regex ="^[0-9]{10}$|^[0-9]{7}$";
		if(!(Pattern.matches(regex, digits)))
			return false;
		return true;
	}
	
	public JSONObject letterCombinations(String digits) {
		if(validateNull(digits) && validateNumber(digits) && validateNumberLegnth(digits)) {
	    List<String> results = new ArrayList<String>();
	    results.add("");
	    JSONObject job=new JSONObject();
	    for (int i = 0; i < digits.length(); i++) {
	        String letters = map.get(digits.charAt(i));
	        List<String> nextResults = new ArrayList<>(letters.length() * results.size());
	        for (String str : results) {
	            for (int j = 0; j < letters.length(); j++) {
	                nextResults.add(str + letters.charAt(j));
	            }
	        }
	        results = nextResults;
	    }
	    for (String string : results) {
			job.put( string,digits);
		}
	    return job;
		}else {
			return null;
		}
	}

}
