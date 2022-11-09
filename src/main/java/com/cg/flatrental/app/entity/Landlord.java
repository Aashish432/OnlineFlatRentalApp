package com.cg.flatrental.app.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="LANDLORD")
//@JsonIgnoreProperties(value = {"landlordId"}, allowGetters = true)
public class Landlord {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long landlordId;
	
	
	@Column(name="LANDLORD_NAME",nullable=false)
	private String landlordName;
	

	@Min(18)
	@Max(100)
	@Column(name="LANDLORD_AGE",nullable=false)
	private Integer landlordAge;
	
//	@OneToMany(mappedBy="landlord",cascade = CascadeType.ALL, fetch=FetchType.LAZY)
//	private List<Flat> flatList;

	
	

//	public Landlord(Long landlordId, @NotBlank(message = "LandLord Name must not be empty or null") String landlordName,
//			@NotBlank(message = "LandLord Age must not be empty or null") Integer landlordAge, List<Flat> flatList) {
//		super();
//		this.landlordId = landlordId;
//		this.landlordName = landlordName;
//		this.landlordAge = landlordAge;
//		
//	}
	
	
}
