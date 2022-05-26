package com.cameron.displayDate.controllers;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {
	Date today = new Date();

	@GetMapping("/")
	public String index(Model model) {
		return "index.jsp";
	}

	@GetMapping("/date")
	public String date(Model model) {
		String pattern = "EEEEE, 'the' dd 'of' MMMMM, yyyy";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		model.addAttribute("todaysDate", simpleDateFormat.format(today));

		return "date.jsp";
	}

	@GetMapping("/time")
	public String time(Model model) {
		model.addAttribute("todaysTime", today);

		return "time.jsp";
	}
}
