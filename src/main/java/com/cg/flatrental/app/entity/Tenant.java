package com.cg.flatrental.app.entity;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Tenant")
@JsonIgnoreProperties(value = {"tenantId"}, allowGetters = true)
public class Tenant {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long tenantId;
	
	
	@Column(name="TENANT_AGE",nullable=false)
	@Min(value = 18 , message = "Tenant should be above 18 years of age")
	private Integer age;
 
	@Size(min=9,max=10,message = "Number should have 10 digit")
	private String mobileNumber;
	
	@Email(message = " Email should be in proper format")
	String emailadress;
	
//	@JsonIgnore
//	@OneToOne(cascade=CascadeType.ALL)
//	@JoinColumn(name="FLAT_ADDRESS")
//	private FlatAddress flatAddress;
	
}
