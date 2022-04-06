package com.cameron.saveTravels.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import com.cameron.saveTravels.models.Expense;
import com.cameron.saveTravels.services.ExpenseService;

@Controller
public class TheController {
	@Autowired
	private ExpenseService eService;
	
	@GetMapping("/")
	public String rootRoute(){
		return "redirect:/expenses";
	}
	
	@GetMapping("/expenses")
	public String rootRoute(@ModelAttribute("newExpense")Expense expenseInput, Model model){
		model.addAttribute("expenses", this.eService.getAll());
		return "index.jsp";
	}
	@PostMapping("/create")
	public String createExpense(@Valid @ModelAttribute("newExpense")Expense expenseInput, BindingResult result, Model viewModel) {
		if (result.hasErrors()) {
			viewModel.addAttribute("expenses", this.eService.getAll());
			return "index.jsp";
		}
		this.eService.create(expenseInput);
		return "redirect:/";
	}
	@GetMapping("/expenses/edit/{id}")
	public String editRender(@PathVariable("id")Long expenseId, Model model) {
		model.addAttribute("editExpense", this.eService.getById(expenseId));
		return "edit.jsp";
	}
	@PutMapping("/edit")
	public String editPut(@Valid @ModelAttribute("editExpense")Expense expenseInput, BindingResult result, Model model) {
		if (result.hasErrors()) {
			model.addAttribute("editExpense", this.eService.getById(expenseInput.getId()));
			return "index.jsp";
		}
		this.eService.update(expenseInput);
		return "redirect:/expenses";
	}
}
