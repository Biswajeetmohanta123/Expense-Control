package com.geekster.ExpenseTracker.service;

import com.geekster.ExpenseTracker.model.Product;

import java.sql.Date;
import java.util.List;

public interface IProductService {
    void addProduct(Product newProduct);

    List<Product> getProductByDate(Date date);

    List<Product> getProducts(Date date);

    List<Product> getAllProducts();
}
