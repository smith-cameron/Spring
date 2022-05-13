package com.cameron.saveTravels.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.cameron.saveTravels.models.Expense;

public interface ExpenseRepo extends CrudRepository<Expense, Long> {
	List<Expense> findAll();

}
