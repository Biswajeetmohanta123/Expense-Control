package com.geekster.ExpenseTracker.repository;

import com.geekster.ExpenseTracker.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.sql.Date;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Integer> {
    @Query(value = "select * from tbl_product where date=:date",nativeQuery = true)
    List<Product> findProductByDate(Date date);
}
