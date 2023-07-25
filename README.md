# ExpenseTracker

- ## Frameworks and Language used
  - #### Spring Boot Framework
  - #### Java language
- ## Data Flow
  - ### UserController
     - ##### _createUser( )_   
     - ##### _getUsers( )_       
     - ##### _login( )_     
     - ##### _validateLogin( )_    
     - ##### _updateUser( )_       
     
   - ### ExpenseController
     - ##### _getExpenses( )_   
     - ##### _createExpense( )_       
     - ##### _updateExpense( )_     
     - ##### _deleteExpense( )_    
     
   - ### ProductController
     - ##### _addProduct( )_   
     - ##### _getProducts( )_      
     
   - ### IUserService
     - ##### _getUsers( )_   
     - ##### _addUser( )_       
     - ##### _login( )_     
     - ##### _updateUser( )_    
    
  - ### IExpenseService
     - ##### _addExpense( )_   
     - ##### _getAllExpenses( )_       
     - ##### _updateExpese( )_     
     - ##### _deleteExpense( )_    
     - ##### _getExpenseByMonth( )_  
  
   - ### IProductService
     - ##### _addProduct( )_   
     - ##### _getProductByDate( )_       
     - ##### _getProducts( )_    
     
     
   - ### UserRepository
     - ##### _findByUsername( )_
     - ##### _findAll( )_      
     - ##### _save( )_      

   - ### ExpenseRepository
     - ##### _findAll( )_      
     - ##### _save( )_     
     - ##### _deleteById( )_      
  
   - ### ProductRepository
     - ##### _findProductByDate( )_
     - ##### _findAll( )_      
     - ##### _save( )_     

     
     
- ## Data Structure used 
  - #### ArrayList
  - #### HashMap<String,String> for designing ResponseEntity while exception handling
- ## Database Used
  - #### MySQL database : dbexpense
- ## Project Summary
 In this project a user can perform all the CRUD operations on a list of Expenses. Here I have also provided some of the validators on the field values and if a user puts invalid details in  response, it will handle exception and will revert with Http Status code 400 as a BAD_REQUEST.
 Using the APIs provided in the links below we can perform the operations accordingly.
Problem Statement: A user now can easily keep tracks on his monthly expenses.
Execution and Results: The steps taken to execute the project are the follows:
First of all we created 3 models:
User, Expenses, Products.
Then we are required to create their services and controllers.
Along with that the next step is to provide some of the validations on the fields of the model classes.
  
  > [http://65.0.105.221:8080/swagger-ui/index.html](http://16.171.61.112:8080/swagger-ui/index.html#/)
  
  End points:
  
    - ##### /get-expenses
    - ##### /add-expense
    - ##### /update-expense
    - ##### /delete-expense
    - ##### /get-expense-by-month
    - ##### /add-product
    - ##### /get-products
    - ##### /add-user
    - ##### /get-users
    - ##### /login
    - ##### /update-user
