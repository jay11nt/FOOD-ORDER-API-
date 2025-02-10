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
