package com.geekster.ExpenseTracker.repository;

import com.geekster.ExpenseTracker.model.Expense;
import com.geekster.ExpenseTracker.model.Product;
import com.geekster.ExpenseTracker.model.User;
import org.json.JSONArray;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense,Integer> {

}
