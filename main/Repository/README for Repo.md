## Food Application Repositories-

### Overview -
- This project contains several Spring Data JPA repositories for a food ordering application, managing different entities related to the system.

### Repositories -
**1. BillRepo -**

- **Package**: com.food.repository
- **Entity:** Bill
- **Key Features:**
Extends JpaRepository for bill-related database operations
Custom query method getBillByDate() to retrieve bills within a specific date range

**2. CartRepo -**

- **Package:** com.food.repository
- **Entity:** FoodCart
- **Functionality**: Standard JPA repository for cart-related database operations

**3. CategoryRepo -**

- **Package:** com.food.repository
- **Entity:** Category
- **Functionality:** Standard JPA repository for category-related database operations

**4. CurrentUserSessionRepo -**

- **Package:** com.food.repository
- **Entity:** CurrentUserSession
- **Key Methods:**
  **findByEmail(String email):**   Retrieve user session by email
  **findByPrivateKey(String key):**   Retrieve user session by private key

**5. CustomerRepo -**

- **Package:** com.food.repository
- **Entity:** Customer
- **Key Method:**
**findByEmail(String email):** Retrieve customer by email address

### Technologies -

- Spring Data JPA
- Java
- LocalDate for date-based operations

### Setup -
Ensure you have the following dependencies in your project:

1. Spring Boot
2. Spring Data JPA
3. Appropriate database connector
