package com.combinations.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.combinations.model.CombinationsModel;

import net.minidev.json.JSONArray;
import net.minidev.json.JSONObject;

@RestController
@CrossOrigin(origins="*")
public class CombinationsController {

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
	
	@PostMapping("/all")
	public ResponseEntity<JSONArray> mobileNoCombinations(@RequestBody CombinationsModel cmodel){		
		 List<String> results = new ArrayList<String>();
		    results.add("");
		    JSONArray array=new JSONArray();
		    for (int i = 0; i < cmodel.getMobileNo().length(); i++) {
		        String letters = map.get(cmodel.getMobileNo().charAt(i));
		        List<String> nextResults = new ArrayList<>(letters.length() * results.size());
		        for (String str : results) {
		            for (int j = 0; j < letters.length(); j++) {
		                nextResults.add(str + letters.charAt(j));
		            }
		        }
		        results = nextResults;
		    }
		    int i = 0;
		    for (String res : results) {
		    	JSONObject obj=new JSONObject();
		    	obj.put("mobileNo",res);
		    	obj.put("position",++i);		    	
		    	array.add(obj);
			}
	 return new ResponseEntity<JSONArray>(array,HttpStatus.OK);
	}
	
	@GetMapping("/hello")
	public String sayHello() {		
		return "hello world";
	}
	
}
