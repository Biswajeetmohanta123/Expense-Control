package com.geekster.ExpenseTracker.repository;

import com.geekster.ExpenseTracker.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UserRepository extends JpaRepository<User,Integer> {
    @Query(value = "select * from tbl_user where user_name=:userName",nativeQuery = true)
    List<User> findByUsername(String userName);
}
