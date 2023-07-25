package com.geekster.ExpenseTracker.controller;

import com.geekster.ExpenseTracker.model.Expense;
import com.geekster.ExpenseTracker.model.Product;
import com.geekster.ExpenseTracker.model.User;
import com.geekster.ExpenseTracker.repository.ProductRepository;
import com.geekster.ExpenseTracker.repository.UserRepository;
import com.geekster.ExpenseTracker.service.UserProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ExpenseController {
    @Autowired
    UserProductService service;
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @GetMapping("/get-expenses")
    public List<Expense> getExpenses(){
        List<Expense> expenses = new ArrayList<>();
        expenses = service.getAllExpenses();
        return expenses;
    }

    @PostMapping("/add-expense")
    public void createExpense(@RequestBody Expense expense ){
        service.addExpense(expense);
    }
    @PutMapping("/update-expense")
    public void updateExpense(@RequestParam Integer id,@RequestBody Expense newExpense){
        service.updateExpese(id,newExpense);
    }
    @DeleteMapping("/delete-expense")
    public void deleteExpense(@RequestParam Integer id){
        service.deleteExpense(id);
    }
    @GetMapping("/get-expense-by-month")
    public List<Expense> getExpenses(@RequestParam String startDate, @RequestParam  String endDate,@RequestParam Integer userId, @RequestParam Integer productId){
        Date first = Date.valueOf(startDate);
        Date last = Date.valueOf(endDate);
        return service.getExpenseByMonth(first, last,userId,productId);
    }

}
