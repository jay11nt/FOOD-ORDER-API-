
# Address.java
## Purpose -
- The Address class is a JPA entity that represents an address associated with a customer in the application. It stores detailed address information and has a one-to-one relationship with the Customer entity.

## Code Summary -
 ### Annotations Used
**@Entity:** Marks this class as a JPA entity, meaning it maps to a database table.

**@Data:** A Lombok annotation that generates getter and setter methods, equals(), hashCode(), and toString().

**@NoArgsConstructor** and **@AllArgsConstructor:** Lombok annotations to generate constructors with no arguments and all arguments, respectively.

**@ToString:** Generates a string representation of the object.

## Fields -

| **Field Name**   | **Type**    | **Description**                                    |
|------------------|-------------|----------------------------------------------------|
| `addressId`      | `Integer`   | Primary Key, Auto-generated unique identifier      |
| `buildingName`   | `String`    | Name or number of the building                     |
| `area`           | `String`    | Local area or neighborhood                         |
| `city`           | `String`    | City where the address is located                  |
| `state`          | `String`    | State of the address                               |
| `country`        | `String`    | Country of the address                             |
| `pincode`        | `Integer`   | Postal code or ZIP code of the address             |
| `customer`       | `Customer`  | One-to-one relationship with the `Customer` entity |

## **Relationship -**
**@OneToOne:** Establishes a one-to-one relationship between Address and Customer. Each address is associated with exactly one customer.

## **Usage -**
- This class is used to persist address details for a customer in the database.
- The customer field allows linking the address to a specific Customer entity.


## **Technologies Used -**
- Spring Boot (JPA, Hibernate)
- Lombok (to reduce boilerplate code)
- MySQL / PostgreSQL (or any relational database)


**📌 Notes -**
- Ensure that Lombok is properly configured in your IDE to avoid compilation issues.
- Database migrations should handle foreign key constraints between Customer and Address.

**🔗 Related Entities -**
- **Customer.java:** The Customer entity that is linked via a one-to-one relationship.
