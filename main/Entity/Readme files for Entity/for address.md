
## Address.java
## Purpose -
- The Address class is a JPA entity that represents an address associated with a customer in the application. It stores detailed address information and has a one-to-one relationship with the Customer entity.

## Code Summary -
 ### Annotations Used
**@Entity:** Marks this class as a JPA entity, meaning it maps to a database table.

**@Data:** A Lombok annotation that generates getter and setter methods, equals(), hashCode(), and toString().

**@NoArgsConstructor** and **@AllArgsConstructor:** Lombok annotations to generate constructors with no arguments and all arguments, respectively.

**@ToString:** Generates a string representation of the object.
