package com.rebecca.wallet.model.repository;

import com.rebecca.wallet.model.entity.Category;
import com.rebecca.wallet.model.entity.Expense;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {

    //SELECT * FROM expense WHERE date_expense = ?
    List<Expense> findByDate(LocalDate date);

    //SELECT * FROM expense WHERE categories = ?
    List<Expense> findByCategory(Category category);

    //SELECT * FROM expense WHERE date_expense BETWEEN ? AND ?
    List<Expense> findByDateBetween(LocalDate dateFrom, LocalDate dateTo);

    //totale di una specifica categoria in un giorno o totale di tutte le spese in un giorno
    @Query("""
            SELECT SUM(e.amount)
            FROM Expense e
            WHERE (:category IS NULL OR e.category = :category) AND e.date = :date
            """)
    BigDecimal sumAmountByDateAndCategory(@Param("category") Category category,
                                          @Param("date") LocalDate date);

    //totale di una specifica categoria in un periodo o di tutte le spese in un periodo
    @Query("""
            SELECT SUM(e.amount)
            FROM Expense e
            WHERE (:category IS NULL OR e.category = :category) AND e.date BETWEEN :dateFrom AND :dateTo
            """)
    BigDecimal sumAmountByCategoryAndDateBetween(@Param("category") Category category,
                                                 @Param("dateFrom") LocalDate dateFrom,
                                                 @Param("dateTo") LocalDate dateTo);
}
