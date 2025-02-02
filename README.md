# **🍽️ Food Delivery REST API**
A comprehensive Spring Boot-based REST API for a food delivery system with features for managing customers, restaurants, orders, and deliveries.

### **📁 Project Structure:-**

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

### **📋 Table of Contents**

 - Features
 - Tech Stack
 - Project Structure
 - Entity Relationship Diagram
 - API Endpoints
 - Setup Instructions
 - Configuration
 - Documentation
