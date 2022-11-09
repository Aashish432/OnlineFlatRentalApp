package com.cg.flatrental.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flatrental.app.entity.Tenant;


public interface ITenantRepository extends JpaRepository<Tenant,Long>{

}