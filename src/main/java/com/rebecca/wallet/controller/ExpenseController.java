package com.rebecca.wallet.controller;

import com.rebecca.wallet.dto.ExpenseDTO;
import com.rebecca.wallet.model.entity.Category;
import com.rebecca.wallet.model.entity.Expense;
import com.rebecca.wallet.model.service.abstraction.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static com.rebecca.wallet.dto.ExpenseDTO.fromEntity;

@RestController
@RequestMapping("/api/expenses")
public class ExpenseController {

    private ExpenseService service;

    @Autowired
    public ExpenseController(ExpenseService service) {
        this.service = service;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findExpenseById(@PathVariable int id) {

        Optional<Expense> optionalExpense = service.findExpenseById(id);
        if (optionalExpense.isPresent()) {
            return ResponseEntity.ok(fromEntity(optionalExpense.get()));
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ExpenseDTO> createExpense(@RequestBody ExpenseDTO expenseDTO) {
        Expense expense = expenseDTO.toEntity();
        Expense create = service.createExpense(expense);
        ExpenseDTO dto = fromEntity(create);
        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateExpense(@PathVariable int id, @RequestBody ExpenseDTO dto) {
        if (dto.getId() == null || dto.getId() != id) {
            return ResponseEntity.badRequest().build();
        }

        Expense expense = dto.toEntity();
        boolean update = service.updateExpenseById(id, expense);
        if (update) {
            return ResponseEntity.ok(dto);
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteExpense(@PathVariable int id) {
        boolean deleted = service.deleteExpenseById(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();

    }

    //sumAmountByCategoryAndDateBetween
    @GetMapping("/sum")
    public ResponseEntity<BigDecimal> getSum(@RequestParam(required = false) Category category,
                                             @RequestParam(required = true) LocalDate dateFrom,
                                             @RequestParam(required = false) LocalDate dateTo) {
        BigDecimal result;
        if (dateTo == null) {
            result = service.sumAmountByDateAndCategory(category, dateFrom);
            return ResponseEntity.ok(result);
        }
        result = service.sumAmountByCategoryAndDateBetween(category, dateFrom, dateTo);
        return ResponseEntity.ok(result);
    }

    @GetMapping
    public List<ExpenseDTO> search(@RequestParam(required = false) LocalDate date,
                                   @RequestParam(required = false) Category category,
                                   @RequestParam(required = false) LocalDate dateFrom,
                                   @RequestParam(required = false) LocalDate dateTo) {

        List<Expense> search;

        if (category != null && date == null && dateFrom == null && dateTo == null) {
            search = service.findByCategory(category);
        } else if (dateFrom != null && dateTo != null && category == null && date == null) {
            search = service.findByDateBetween(dateFrom, dateTo);
        } else if (date != null && category == null && dateFrom == null && dateTo == null) {
            search = service.findByDate(date);
        } else {
            search = service.findAll();
        }
        return search.stream().map(ExpenseDTO::fromEntity).toList();

    }

}
