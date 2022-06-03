package com.cameron.officeHour.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TheController {
	@GetMapping("/")
	public String index() {
		return "index.jsp";
	}
}
