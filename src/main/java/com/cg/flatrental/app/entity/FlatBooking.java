package com.cg.flatrental.app.entity;

import java.time.LocalDate;


import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;


import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="FLAT_BOOKING_TABLE")
@JsonIgnoreProperties(value = {"bookingNo"}, allowGetters = true)
public class FlatBooking {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long bookingNo;
	
	@OneToOne
	@JoinColumn(name="FLAT_ID")
	private Flat flat;
	
	@OneToOne
	@JoinColumn(name="TENANT_ID")
	private Tenant tenant;
	
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate bookingFromDate;

	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern="yyyy-MM-dd")
	private LocalDate bookingToDate;


	
}
