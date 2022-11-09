package com.cg.flatrental.app.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="Flat_Address_Table")
public class FlatAddress {
	
	@Id
	@Column(name="HOUSE_NO")
	private Integer houseNo;
	
	@Column(name="STREET",nullable=false)
	private String street;
	
	
	@Column(name="CITY",nullable=false)
	private String city;
	
	
	@Column(name="STATE",nullable=false)
	private String state;
	
	@NotNull
	@Column(name="PIN",nullable=false)
	private Integer pin;
	
	
	@Column(name="COUNTRY")
	private String country;


	
}
