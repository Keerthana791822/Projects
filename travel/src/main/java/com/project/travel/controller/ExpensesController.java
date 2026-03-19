package com.project.travel.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.travel.entity.ExpensesEntity;
import com.project.travel.service.ExpensesService;

@RestController
@RequestMapping("/api/expenses") 
public class ExpensesController {
    @Autowired
    private ExpensesService expensesService;

    @PostMapping
    public ExpensesEntity addExpense(@RequestBody ExpensesEntity expense) {
        return expensesService.addExpense(expense);
    }

    @GetMapping("/itinerary/{itineraryId}")
    public List<ExpensesEntity> getItineraryExpenses(@PathVariable Long itineraryId) {
        return expensesService.getByItinerary(itineraryId);
    }

    @PutMapping("/{id}")
    public ExpensesEntity updateExpense(@PathVariable Long id, @RequestBody ExpensesEntity expense) {
        return expensesService.updateExpense(id, expense);
    }

    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable Long id) {
        expensesService.deleteExpense(id);
    }

    @GetMapping("/budget/{itineraryId}/summary")
    public String getBudgetSummary(@PathVariable Long itineraryId) {
        return expensesService.getSummary(itineraryId);
    }
}
