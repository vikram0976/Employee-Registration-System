package com.kinbenassg.model;


import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


enum Education {
	BSC_CS,
    M_TECH,
	MCA,
    B_TECH
}

@Entity
@Data
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@NotNull
	private String name;
	
    @Pattern(regexp = "\\d{10}", message = "Contact number should be a 10-digit numeric value.")
	private String phoneNumber;
	
   @Email(message = "Email address should be in proper email format.")
	private String email;
	
	private String address;
	
    @Enumerated(EnumType.STRING)
    private Education education;
	
    private int exp;

}
