package com.rebecca.wallet.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name = "expense")
public class Expense {

    @Id
    @Column(name = "id_expense")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "description", nullable = false)
    @NotBlank
    private String description;

    @Column(name = "date_expense", nullable = false)
    @NotNull(message = "Inserire la data")
    private LocalDate date;

    @Column(name = "amount")
    @NotNull
    private BigDecimal amount;

    @Column(name = "categories")
    @Enumerated(EnumType.STRING)
    private Category category = Category.OTHER;

    public Expense(){}

    public Expense(Integer id, String description, LocalDate date, BigDecimal amount, Category category) {
        this.id = id;
        this.description = description;
        this.date = date;
        this.amount = amount;
        this.category = category;
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
