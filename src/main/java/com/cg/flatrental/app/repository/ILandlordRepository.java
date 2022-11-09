package com.cg.flatrental.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flatrental.app.entity.Landlord;


public interface ILandlordRepository extends JpaRepository<Landlord,Long>{

}