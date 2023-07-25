package com.geekster.ExpenseTracker.service;

import com.geekster.ExpenseTracker.model.Expense;
import com.geekster.ExpenseTracker.model.Product;
import com.geekster.ExpenseTracker.model.User;
import com.geekster.ExpenseTracker.repository.ExpenseRepository;
import com.geekster.ExpenseTracker.repository.ProductRepository;
import com.geekster.ExpenseTracker.repository.UserRepository;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserProductService implements IUserService,IProductService,IExpenseService {
    @Autowired
    UserRepository userRepository;
    @Autowired
    ProductRepository productRepository;
    @Autowired
    ExpenseRepository expenseRepository;

    @Override
    public List<User> getUsers(Integer userId) {
        if (userId == null)
            return userRepository.findAll();
        else {
            List<User> users = new ArrayList<>();
            users.add(userRepository.findById(userId).get());
            return users;
        }
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public JSONObject login(String userName, String password) {
        JSONObject response = new JSONObject();
        List<User> user = userRepository.findByUsername(userName);
        if (user.isEmpty()) {
            response.put("errorMessage", "username doesn't exist");
        } else {
            User userObj = user.get(0);
            if (password.equals(userObj.getPassword())) {
                response = createResponse(userObj);
            } else {
                response.put("errorMessage", "password is not valid");
            }
        }
        return response;
    }

    private JSONObject createResponse(User user) {
        JSONObject jsonObj = new JSONObject();
        jsonObj.put("userId", user.getUserId());
        jsonObj.put("userName", user.getUserName());
        jsonObj.put("email", user.getEmail());
        jsonObj.put("phoneNumber", user.getPhoneNumber());
        return jsonObj;
    }

    @Override
    public void updateUser(User user, Integer userId) {
        User oldUser = new User();
        if (userRepository.findById(userId).isPresent()) {
            oldUser = userRepository.findById(userId).get();
        }
        oldUser.setUserName(user.getUserName());
        oldUser.setPassword(user.getPassword());
        oldUser.setEmail(user.getEmail());
        oldUser.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(oldUser);
    }

    @Override
    public void addProduct(Product newProduct) {
        productRepository.save(newProduct);
    }

    @Override
    public List<Product> getProductByDate(Date date) {
        List<Product> productsList = new ArrayList<>();
        productRepository.findProductByDate(date);
        return productsList;
    }

    @Override
    public List<Product> getProducts(Date date) {
        return productRepository.findProductByDate(date);
    }

    @Override
    public void addExpense(Expense expense) {
        expenseRepository.save(expense);
    }

    @Override
    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    @Override
    public void updateExpese(Integer id, Expense newExpense) {
        Expense expense = new Expense();
        if (expenseRepository.findById(id).isPresent())
            expense = expenseRepository.findById(id).get();
        expense.setDescription(newExpense.getDescription());
        expense.setUserId(newExpense.getUserId());
        expense.setProductId(newExpense.getProductId());
        expense.setExpenseDate(newExpense.getExpenseDate());
        expenseRepository.save(expense);
    }

    @Override
    public void deleteExpense(Integer id) {
        expenseRepository.deleteById(id);
    }

    @Override
    public List<Expense> getExpenseByMonth(Date first, Date last, int userId, int id) {
        List<Expense> expenseList = expenseRepository.findAll();
        List<Expense> responseList = new ArrayList<>();
        for (Expense expense : expenseList) {
            if (expense.getExpenseDate().after(first) && expense.getExpenseDate().before(last)) {
                User user = expense.getUserId();
                Product product = expense.getProductId();
                if (user.getUserId() == userId && product.getId() == id) {
                    responseList.add(expense);
                }
            }
        }
        return responseList;
    }
    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
