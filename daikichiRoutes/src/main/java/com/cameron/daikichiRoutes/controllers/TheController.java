package com.cameron.daikichiRoutes.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TheController {
	@RequestMapping("/")
	public String indexRoute(){
		
		return "";
	}
}
