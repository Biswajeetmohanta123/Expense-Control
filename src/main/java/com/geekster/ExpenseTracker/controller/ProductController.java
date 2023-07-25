package com.geekster.ExpenseTracker.controller;

import com.geekster.ExpenseTracker.model.Product;
import com.geekster.ExpenseTracker.model.User;
import com.geekster.ExpenseTracker.service.UserProductService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {
    @Autowired
    UserProductService service;
    @PostMapping("/add-product")
    public ResponseEntity<String> addProduct(@Valid @RequestBody Product productData){
        service.addProduct(productData);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }
    @GetMapping("/get-products")
    public List<Product> getProducts(@RequestParam String date){
        Date first = Date.valueOf(date);
        return service.getProducts(first);
    }
    @GetMapping("/get-all-products")
    public List<Product> getProducts(){
        return service.getAllProducts();
    }
}