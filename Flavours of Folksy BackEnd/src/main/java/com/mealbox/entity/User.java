package com.mealbox.entity;



import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
@Table(name="user_table")
@SequenceGenerator(name = "generator1", sequenceName = "gen1", initialValue = 1000)
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "generator1")
	@Column(name="user_id")
	private long userId;
	
	@Column(name="full_name" ,length=20)
	@NotEmpty
	@Size(min=3 , message="fullName must contain atleast 3 characters")
	private String fullName;
		
	@Column(name="phone_number")
	@NotEmpty
	@Size(min=10 ,max=10, message="phoneNumber must contain  10 digits")
	private String phoneNumber;
	
		
	@Column(name="city",length=20)
	@NotEmpty
	@Size(min=3 , message="city must contain atleast 3 characters")
    private String city;
	
	@Column(name="address")
	@NotEmpty
	private String address;
	
	@Column(name="email_id",unique=true,length=30)
	@NotEmpty
	@Email(message="Email  is not valid!")
	public String emailId;
	
	@Column(name="password",length=20)
	@NotEmpty
	@Size(min=8, message="Password length must be 8 and contain uppercase,lowercase,digits")
	@Pattern(regexp="(?=.*\\d)(?=.*[a-z])(?=.*[A-Z]).{8,}")
	public String password;
	
	public String role;	
}
	

