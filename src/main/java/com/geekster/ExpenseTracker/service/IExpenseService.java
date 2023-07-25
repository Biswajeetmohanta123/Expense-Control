package com.geekster.ExpenseTracker.service;

import com.geekster.ExpenseTracker.model.Expense;
import com.geekster.ExpenseTracker.model.Product;
import com.geekster.ExpenseTracker.model.User;
import org.json.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;

import java.sql.Date;
import java.util.List;

public interface IExpenseService{
    void addExpense(Expense expense);

    List<Expense> getAllExpenses();

    void updateExpese(Integer id,Expense expense);

    void deleteExpense(Integer id);

    public List<Expense>  getExpenseByMonth(Date first, Date last, int userId, int id);
}
