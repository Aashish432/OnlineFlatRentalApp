package com.cg.flatrental.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@JsonIgnoreProperties(value = {"userId"}, allowGetters = true)
@Table(name = "USERS")
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long userId;
	
	
	@NotEmpty
	@Column(name="USER_NAME")
	private String userName;
	
	
	@Column(name="PASSWORD")
	@NotEmpty
	@Size(min=3,max=10,message = "Password must be between 3 to 10 characters")
	private String password;
	
	
	@Column(name="USER_TYPE")
	private String userType;
	
	
	
}
