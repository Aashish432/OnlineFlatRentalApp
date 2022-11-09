package com.cg.flatrental.app.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.flatrental.app.entity.Flat;
import com.cg.flatrental.app.entity.Landlord;
import com.cg.flatrental.app.service.IFlatService;
import com.cg.flatrental.app.service.ILandlordService;


@RestController
@RequestMapping("/api/v1/landlord")
public class LandlordController {
	
	@Autowired
	private ILandlordService iLandlordService;
	
	@Autowired
	private IFlatService iFlatservice;
	
	@GetMapping("/landlords")
	public ResponseEntity<List<Landlord>> viewallLandLord() {
		List<Landlord> landlord = iLandlordService.viewAllLandlord();
		ResponseEntity<List<Landlord>> response = new ResponseEntity<>(landlord, HttpStatus.OK);
		return response;
	}

	@GetMapping("/landlords/{landlord_id}")
	public ResponseEntity<Landlord> viewLandlord(@PathVariable("landlord_id") Long landlordid) {
		Landlord lan = iLandlordService.viewLandlord(landlordid);
		ResponseEntity<Landlord> response = new ResponseEntity<Landlord>(lan, HttpStatus.OK);
		return response;
	}
	
	@PutMapping("/landlords/{landlord_id}")
	public ResponseEntity<Landlord> updateLandlord(@RequestBody Landlord landlord, @PathVariable("landlord_id") Long landlordid){
		Landlord lan = iLandlordService.updateLandlord(landlord, landlordid);
		ResponseEntity<Landlord> reponse = new ResponseEntity<Landlord>(lan, HttpStatus.OK);
		return reponse;
	}
	@PostMapping("/landlords/add_landlord")
	public ResponseEntity<Landlord> addLandlord(@RequestBody @Valid Landlord landlord){
		Landlord landLord = iLandlordService.addLandlord(landlord);
		ResponseEntity<Landlord> response = new ResponseEntity<Landlord>(landLord, HttpStatus.CREATED);
		return response;
	}
	
	@GetMapping("/flats/all/{landlord_id}")
	public ResponseEntity<List<Flat>> viewAllFlatByLandlord(@PathVariable("landlord_id") Long landlordid) {
		List<Flat> flats = iFlatservice.viewAllFlat();
		List<Flat> landlordFlats=flats.stream().filter(flat->flat.getLandlord().getLandlordId()==landlordid).collect(Collectors.toList());
		ResponseEntity<List<Flat>> response = new ResponseEntity<>(landlordFlats, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/flats/{flat_id}")
	public ResponseEntity<Flat> viewFlatByLandlord(@PathVariable("flat_id") Long flatId) {
		Flat flat = iFlatservice.viewFlat(flatId);
		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flat, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/flats")
	public ResponseEntity<Flat> addFlatByLandlord(@RequestBody @Valid Flat flat){
		Flat flatsaved = iFlatservice.addFlat(flat);
		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flatsaved, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/flats/{flat_id}")
	public ResponseEntity<Flat> updateFlatByLandlord(@RequestBody Flat flat, @PathVariable("flat_id") Long flatId){
		Flat flatupdated = iFlatservice.updateFlat(flat, flatId);
		ResponseEntity<Flat> reponse = new ResponseEntity<Flat>(flatupdated, HttpStatus.OK);
		return reponse;
	}
	
	@DeleteMapping("/flats/{flat_id}")
	public ResponseEntity<String> deleteFlatByLandlord(@PathVariable("flat_id") Long flatId){
		iFlatservice.deleteFlat(flatId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
		
	}
	
	@GetMapping("/flats/cost/{cost}")
	public ResponseEntity<List<Flat>> viewAllFlatCostBasisByLandlord(@PathVariable("cost") Double cost) {
		List<Flat> flats = iFlatservice.viewAllFlatByCost(cost,"yes");
		ResponseEntity<List<Flat>> response = new ResponseEntity<List<Flat>>(flats, HttpStatus.OK);
		return response;
	}
}
