package com.rebecca.wallet.model.service.implementation;

import com.rebecca.wallet.model.entity.Category;
import com.rebecca.wallet.model.entity.Expense;
import com.rebecca.wallet.model.repository.ExpenseRepository;
import com.rebecca.wallet.model.service.abstraction.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseServiceJPA implements ExpenseService {

    private ExpenseRepository repository;

    @Autowired
    public ExpenseServiceJPA(ExpenseRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<Expense> findAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Expense> findExpenseById(int id) {
        return repository.findById(id);
    }

    @Override
    public Expense createExpense(Expense createExpense) {
        return repository.save(createExpense);
    }

    @Override
    public boolean deleteExpenseById(int id) {
        if (!repository.existsById(id)) {
            return false;
        }
        repository.deleteById(id);
        return true;
    }

    @Override
    public boolean updateExpenseById(int id, Expense updateExpense) {
        if (!repository.existsById(id)) {
            return false;
        }
        updateExpense.setId(id);
        repository.save(updateExpense);
        return true;
    }


    @Override
    public BigDecimal sumAmountByCategoryAndDateBetween(Category category, LocalDate dateFrom, LocalDate dateTo) {
        BigDecimal sum = repository.sumAmountByCategoryAndDateBetween(category,dateFrom,dateTo);
        if(sum == null){
            return BigDecimal.ZERO;
        }
        return sum;
    }

    @Override
    public BigDecimal sumAmountByDateAndCategory(Category category, LocalDate date) {
        BigDecimal sum = repository.sumAmountByDateAndCategory(category, date);
        if(sum == null){
            return BigDecimal.ZERO;
        }
        return sum;
    }
}
