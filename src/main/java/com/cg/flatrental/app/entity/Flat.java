package com.cg.flatrental.app.entity;


import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Positive;




import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FLAT")
public class Flat {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long flatId;
	
	@Positive(message="Cost should be positive")
	@Column(name="FLAT_COST")
	private Double cost;
	
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="houseNo")
	private FlatAddress flatAddress;
	
	
	@Column(name="FLAT_AVAILABILITY")
	private String availability;
	
	
	@ManyToOne
	@JoinColumn(name="LANDLORD_ID")
	private Landlord landlord;


	
}
