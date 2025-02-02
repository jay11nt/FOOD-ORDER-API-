# **🍽️ Food Delivery REST API**
A Spring Boot-based REST API for managing a food delivery system. This project provides endpoints for managing customers, restaurants, orders, food items, and cart operations.

### **📁 Project Structure :-**

          src/main/java/com/food/
          ├── config/
          │   └── ProjectConfig.java
          ├── controller/
          │   ├── BillController.java
          │   ├── CartController.java
          │   ├── CategoryController.java
          │   ├── CustomerController.java
          │   ├── ItemController.java
          │   ├── LoginController.java
          │   ├── OrderController.java
          │   └── RestaurantController.java
          ├── exception/
          │   ├── BillException.java
          │   ├── CartException.java
          │   ├── CategoryException.java
          │   ├── CustomerNotFound.java
          │   ├── GlobalExceptionHandler.java
          │   ├── ItemException.java
          │   ├── LoginException.java
          │   ├── OrderException.java
          │   └── RestaurantException.java
          ├── model/
          │   ├── Address.java
          │   ├── Bill.java
          │   ├── Category.java
          │   ├── Contact.java
          │   ├── CurrentUserSession.java
          │   ├── Customer.java
          │   ├── FoodCart.java
          │   ├── Item.java
          │   ├── Login.java
          │   ├── MyErrorDetails.java
          │   ├── OrderDetails.java
          │   └── Restaurant.java
          ├── repository/
          │   ├── BillRepository.java
          │   ├── CartRepository.java
          │   ├── CategoryRepository.java
          │   ├── CustomerRepository.java
          │   ├── ItemRepository.java
          │   ├── OrderRepository.java
          │   └── RestaurantRepository.java
          └── service/
              ├── impl/
              │   ├── BillServiceImpl.java
              │   ├── CartServiceImpl.java
              │   ├── CategoryServiceImpl.java
              │   ├── CustomerServiceImpl.java
              │   ├── ItemServiceImpl.java
              │   ├── LoginServiceImpl.java
              │   ├── OrderServiceImpl.java
              │   └── RestaurantServiceImpl.java
              ├── BillService.java
              ├── CartService.java
              ├── CategoryService.java
              ├── CustomerService.java
              ├── ItemService.java
              ├── LoginService.java
              ├── OrderService.java
              └── RestaurantService.java

### **📋 Table of Contents :-**

 - Features
 - Tech Stack
 - Project Structure
 - Entity Relationship Diagram
 - API Endpoints
 - Setup Instructions
 - Configuration
 - Documentation

### **✨ Features :-**

**User Management**

   - Customer registration and authentication
   - User profile management
   - Address management
   - Session handling


**Restaurant Management**

   - Restaurant registration and profiles
   - Menu management
   - Item category management
   - Location-based restaurant search


**Order Processing**

 - Shopping cart functionality
 - Order placement and tracking
 - Order history
 - Bill generation


**Admin Features**

 - User management
 - Restaurant approval
 - Category management
 - System monitoring

### **🛠️ Tech Stack :-**

- Framework: Spring Boot 3.x
- Language: Java 17
- Build Tool: Maven
- Database: MySQL 8.x
- ORM: Spring Data JPA
- API Documentation: Swagger UI
- Testing: JUnit 5, Mockito
- Security: Spring Security
- Lombok: For reducing boilerplate code
- Validation: Spring Validation   

### **⚙️ Configuration :-**
The `ProjectConfig.java` file handles the following configurations:

- Database connection settings
- Security configurations
- Swagger documentation
- Cross-origin resource sharing (CORS)
- Exception handling

### **📌 API Endpoints :-**
1. Customer APIs-

    | Method | Endpoint        | Description             |
    |--------|---------------|---------------------------|
    | POST   | `/add`        | Register new customer     |
    | PUT    | `/update`     | Update customer details   |
    | DELETE | `/delete/{id}`| Delete customer           |
    | GET    | `/get/{id}`   | Get customer details      |


2. Restaurant APIs-

    | Method | Endpoint                      | Description                  |
    |--------|--------------------------------|-----------------------------|
    | POST   | `/addrestaurant`               | Add new restaurant          |
    | PUT    | `/updaterestaurant`            | Update restaurant           |
    | DELETE | `/deleterestaurant/{id}`       | Delete restaurant           |
    | GET    | `/getrestaurant/{id}`          | Get restaurant by ID        |
    | GET    | `/getrestaurant/{city}`        | Get restaurants by city     |


3. Order APIs-

    | Method | Endpoint                | Description         |
    |--------|-------------------------|---------------------|
    | POST   | `/addOrder`             | Place new order     |
    | PUT    | `/updateOrder/{id}`     | Update order        |
    | DELETE | `/removeOrder/{id}`     | Cancel order        |
    | GET    | `/viewOrder/{id}`       | View order details  |
    | GET    | `/getAll`               | Get all orders      |

4. Cart APIs-

    | Method | Endpoint                              | Description          |
    |--------|---------------------------------------|----------------------|
    | POST   | `/addFoodCart`                        | Create new cart      |
    | PUT    | `/addItemToFoodCart/{id}`             | Add item to cart     |
    | PUT    | `/increaseQuantity/{id}/{quantity}`   | Increase quantity    |
    | PUT    | `/reduceQuantity/{id}/{quantity}`     | Reduce quantity      |
    | DELETE | `/deleteCart`                         | Delete cart          |

5. Bill APIs-

    | Method | Endpoint                   | Description                  |
    |--------|----------------------------|------------------------------|
    | POST   | `/addBill`                 | Generate new bill            |
    | PUT    | `/updateBill`              | Update bill                  |
    | DELETE | `/deleteBill/{id}`         | Remove bill                  |
    | GET    | `/viewBill/{id}`           | View bill details            |
    | GET    | `/viewAllBills`            | View bills between dates     |
    | GET    | `/getTotalCost/{id}`       | Calculate total cost         |


### **🔒 Security**

JWT-based authentication
Role-based access control
Password encryption
Session management

**📄 License**
This project is licensed under the MIT License - see the LICENSE file for details.

**👥 Authors**

Jayant Ingle - www.github.com/jay11nt

Team- 
Ajay mandhare 
