package com.cg.flatrental.app.service.implementation;


import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.flatrental.app.entity.Flat;
import com.cg.flatrental.app.exception.FlatNotFoundException;
import com.cg.flatrental.app.repository.IFlatRepository;
import com.cg.flatrental.app.service.IFlatService;

@Service
public class IFlatServiceImplementation implements IFlatService{
	
	@Autowired
	private IFlatRepository iFlatRepository;

	@Override
	public Flat addFlat(Flat flat) {
		iFlatRepository.save(flat);
		return flat;
	}

	@Override
	public Flat updateFlat(Flat flat, Long flatId) {
		Optional<Flat> flatOpt = iFlatRepository.findById(flatId);
		Flat flatupdated=null;
		if(!flatOpt.isPresent()) {
			throw new FlatNotFoundException("Flat("+flatId+") Not Found");
		}
		else{
			flatupdated = flatOpt.get();
			flatupdated.setCost(flat.getCost());
			flatupdated.setAvailability(flat.getAvailability());
			flatupdated.setFlatAddress(flat.getFlatAddress());
			flatupdated.setLandlord(flat.getLandlord());
			flatupdated.setFlatId(flat.getFlatId());
			iFlatRepository.save(flatupdated);
		}
		return flatupdated;
	}

	

	@Override
	public void deleteFlat(Long flatId) {
		Optional<Flat> flatOpt = iFlatRepository.findById(flatId);
		if(!flatOpt.isPresent()) {
			throw new FlatNotFoundException("Flat("+flatId+") Not Found");
		}else {
			iFlatRepository.deleteById(flatId);
		}
	}

	@Override
	public Flat viewFlat(Long flatId) {
		Optional<Flat> flatOpt = iFlatRepository.findById(flatId);
		if(!flatOpt.isPresent()) {
			throw new FlatNotFoundException("Flat("+flatId+") Not Found");
		}
		return flatOpt.get();
	}

	@Override
	public List<Flat> viewAllFlat() {
		return iFlatRepository.findAll();
	}

	@Override
	public List<Flat> viewAllFlatByCost(Double cost, String availability) {

		return iFlatRepository.findAll().stream().filter(flat->(flat.getCost().doubleValue()==cost.doubleValue() && flat.getAvailability().equalsIgnoreCase(availability))).collect(Collectors.toList());
	}
	
	
}
