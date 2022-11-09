package com.cg.flatrental.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flatrental.app.entity.FlatBooking;

public interface IFlatBookingRepository extends JpaRepository<FlatBooking,Long>{

}