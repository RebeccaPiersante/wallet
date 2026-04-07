package com.rebecca.wallet.dto;

import com.rebecca.wallet.model.entity.Category;
import com.rebecca.wallet.model.entity.Expense;

import java.math.BigDecimal;
import java.time.LocalDate;

public class ExpenseDTO {

    private Integer id;
    private String description;
    private LocalDate date;
    private BigDecimal amount;
    private Category category;

    public ExpenseDTO() {
    }

    public ExpenseDTO(Integer id, String description, LocalDate date, BigDecimal amount, Category category) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.category = category;
    }

    //dto -> entity
    public Expense toEntity() {
        return new Expense(id, description, date, amount, category);
    }

    //entity -> dto
    public static ExpenseDTO fromEntity(Expense expense) {
        return new ExpenseDTO(expense.getId(), expense.getDescription(), expense.getDate(), expense.getAmount(), expense.getCategory());
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
