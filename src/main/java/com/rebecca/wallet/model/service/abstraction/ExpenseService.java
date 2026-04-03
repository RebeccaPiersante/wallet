package com.rebecca.wallet.model.service.abstraction;

import com.rebecca.wallet.model.entity.Category;
import com.rebecca.wallet.model.entity.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


public interface ExpenseService {

    List<Expense> findAll();

    Optional<Expense> findExpenseById(int id);

    Expense createExpense(Expense createExpense);

    boolean deleteExpenseById(int id);

    boolean updateExpenseById(int id, Expense updateExpense);

    BigDecimal sumAmountByCategoryAndDateBetween(Category category, LocalDate dateFrom, LocalDate dateTo);

    BigDecimal sumAmountByDateAndCategory(Category category, LocalDate date);

}
