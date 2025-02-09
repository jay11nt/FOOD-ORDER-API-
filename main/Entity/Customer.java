package com.food.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity

public class Customer {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer customerId;

	@NotNull
	@Size(min = 3, max = 30, message = "name of min length should be 3 and max be 10")
	private String firstName;

	@NotNull
	@Size(min = 3, max = 30, message = "name of min length should be 3 and max be 10")
	private String lastName;

	@NotNull(message = "age field should not be null")
	@Max(100)
	private Integer age;

	@NotNull(message = "gender field should not be null")
	private String gender;

	@NotNull(message = "mobile no. field should not be null")
	private String mobileNumber;

	@NotNull
	@Email
	private String email;

	// @NotNull(message = "Address Should not be empty")
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
	private Address address;
	
	

	@NotNull(message = "password should not be null")
	@Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{3,10}$", message = "Invalid Password pattern. Password must contain 3 to 10characters at least one digit, lower, upper case and one special character.")
	private String password;
	
	@JsonManagedReference
	@OneToOne(mappedBy = "customer", cascade = CascadeType.ALL)
    private FoodCart foodCart;

}

