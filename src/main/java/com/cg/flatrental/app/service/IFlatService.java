package com.cg.flatrental.app.service;

import java.util.List;

import com.cg.flatrental.app.entity.Flat;

public interface IFlatService {
	Flat addFlat(Flat flat);
	Flat updateFlat(Flat flat, Long flatId);
	void deleteFlat(Long flatId);
	Flat viewFlat(Long id);
	List<Flat> viewAllFlat();
	List<Flat> viewAllFlatByCost(Double cost, String availability);
}
