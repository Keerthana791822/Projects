package com.project.travel.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.travel.entity.ExpensesEntity;
import com.project.travel.repository.ExpensesRepo;

@Service
public class ExpensesService {
    
    @Autowired
    private ExpensesRepo expensesRepo;

    public ExpensesEntity addExpense(ExpensesEntity expense) {
        return expensesRepo.save(expense);
    }

    public List<ExpensesEntity> getByItinerary(Long itineraryId) {
        return expensesRepo.findAll().stream()
                .filter(e -> e.getDescription() != null && e.getDescription().contains(itineraryId.toString()))
                .toList();
    }

    public ExpensesEntity updateExpense(Long id, ExpensesEntity updated) {
        ExpensesEntity existing = expensesRepo.findById(id).orElse(null);
        if (existing == null) return null;

        existing.setCategory(updated.getCategory());
        existing.setAmount(updated.getAmount());
        existing.setCurrency(updated.getCurrency());
        existing.setExpenseDate(updated.getExpenseDate());
        existing.setDescription(updated.getDescription());
        existing.setReceiptUrl(updated.getReceiptUrl());
        existing.setPaymentMethod(updated.getPaymentMethod());

        return expensesRepo.save(existing);
    }

    public void deleteExpense(Long id) {
        expensesRepo.deleteById(id);
    }

    public String getSummary(Long itineraryId) {
        double total = getByItinerary(itineraryId).stream()
                .mapToDouble(e -> e.getAmount().doubleValue())
                .sum();
        return "Total expenses for itinerary " + itineraryId + " = " + total;
    }
}
