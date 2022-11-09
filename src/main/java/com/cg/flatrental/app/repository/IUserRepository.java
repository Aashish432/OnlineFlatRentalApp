package com.cg.flatrental.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.flatrental.app.entity.User;

public interface IUserRepository extends JpaRepository<User,Long>{

}
