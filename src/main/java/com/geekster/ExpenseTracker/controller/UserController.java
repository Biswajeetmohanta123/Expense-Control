package com.geekster.ExpenseTracker.controller;


import com.geekster.ExpenseTracker.model.User;
import com.geekster.ExpenseTracker.service.UserProductService;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Time;
import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {
    @Autowired
    UserProductService service;
    @PostMapping(value = "/add-user")
    public ResponseEntity<String> createUser(@Valid @RequestBody User user) {
        service.addUser(user);
        return new ResponseEntity<>("Saved", HttpStatus.CREATED);
    }
    @GetMapping(value = "/get-users")
    public List<User> getUsers(@Nullable @RequestParam Integer userId) {
        List<User> userArr = service.getUsers(userId);
        return userArr;
    }

    @PostMapping(value = "/login")
    public ResponseEntity<String> login(@Valid @RequestBody String requestData) {
        JSONObject requestJson = new JSONObject(requestData);

        JSONObject isValidLogin = validateLogin(requestJson);

        if (isValidLogin.isEmpty()) {
            String username = requestJson.getString("username");
            String password = requestJson.getString("password");
            JSONObject responseObj = service.login(username, password);
            if(responseObj.has("errorMessage")) {
                return new ResponseEntity<String>(responseObj.toString(), HttpStatus.BAD_REQUEST);
            }else {
                return new ResponseEntity<String>(responseObj.toString(), HttpStatus.OK);
            }
        } else {
            return new ResponseEntity<String>(isValidLogin.toString(), HttpStatus.BAD_REQUEST);
        }
    }

    private JSONObject validateLogin(JSONObject requestJson) {

        JSONObject errorList = new JSONObject();

        if(!requestJson.has("username")) {
            errorList.put("username", "missing parameter");
        }
        if(!requestJson.has("password")) {
            errorList.put("password", "missing parameter");
        }
        return errorList;
    }

    @PutMapping(value = "/update-user")
    public ResponseEntity<String> updateUser(@RequestParam Integer userId, @Valid @RequestBody User user) {
        service.updateUser(user,userId);
            return ResponseEntity.ok("User is updated");
        }

//    private User setUser(String userData)  {
//        User user = new User();
//        JSONObject json = new JSONObject(userData);
//        user.setEmail(json.getString("email"));
//        user.setPassword(json.getString("password"));
//        user.setUserName(json.getString("userName"));
//        user.setPhoneNumber(json.getString("phoneNumber"));
////        Time time = new Time(System.currentTimeMillis());
//        return user;
//    }

}
