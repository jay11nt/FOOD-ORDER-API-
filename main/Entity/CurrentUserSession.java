package com.food.model;

import java.time.LocalDateTime;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Entity
public class CurrentUserSession 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer currSessionId;
	private String email;
	private LocalDateTime loginDateTime;
	private String privateKey;

}

