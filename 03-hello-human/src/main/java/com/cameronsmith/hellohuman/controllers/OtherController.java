package com.cameronsmith.hellohuman.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OtherController {
	@RequestMapping(value="/")
	public String index(@RequestParam(value="first_name", required=false) String first_name,
			@RequestParam(value="last_name", required=false) String last_name,
			@RequestParam(value="times", required=false) Integer times) {
		String output = " ";
		if(first_name == null && last_name == null && times == null) {
			output += "Hello Human"; 
		}
		else if (first_name != null && last_name != null && times == null) {
			output += "Hello "+ first_name + " " + last_name;
		}
		else {
			for(int i = 0; i <=times;i++) {
				output += "Hello "+ first_name + " ";
			}
		}
		return output;
	}
}
