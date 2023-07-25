package com.geekster.ExpenseTracker.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Entity
@NoArgsConstructor
@Data
@Table(name="tbl_expense")
public class Expense {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="expense_id")
    private Integer id;
    @Column(name = "expense_date")
    private Date expenseDate;
    @Column(name = "description")
    private String description;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product productId;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User userId;
}