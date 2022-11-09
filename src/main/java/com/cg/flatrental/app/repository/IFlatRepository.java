package com.cg.flatrental.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flatrental.app.entity.Flat;

public interface IFlatRepository extends JpaRepository<Flat,Long>{

}
