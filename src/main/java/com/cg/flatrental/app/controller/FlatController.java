package com.cg.flatrental.app.controller;
//package com.cg.flatrental.app.controller;
//
//import java.util.List;
//
//import javax.validation.Valid;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.HttpStatus;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.DeleteMapping;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//
//import com.cg.flatrental.app.entity.Flat;
//import com.cg.flatrental.app.service.IFlatService;
//
//@RestController
//@RequestMapping("/api/v1")
//public class IFlatController {
//	@Autowired
//	IFlatService iFlatservice;
//	@GetMapping("/tenant/flat")
//	public ResponseEntity<List<Flat>> viewAllFlatByTenant() {
//		List<Flat> flats = iFlatservice.viewAllFlat();
//		ResponseEntity<List<Flat>> response = new ResponseEntity<>(flats, HttpStatus.OK);
//		return response;
//	}
//	@GetMapping("/admin/flat")
//	public ResponseEntity<List<Flat>> viewAllFlatByAdmin() {
//		List<Flat> flats = iFlatservice.viewAllFlat();
//		ResponseEntity<List<Flat>> response = new ResponseEntity<>(flats, HttpStatus.OK);
//		return response;
//	}
//	@GetMapping("/landlord/flat")
//	public ResponseEntity<List<Flat>> viewAllFlatByLandlord() {
//		List<Flat> flats = iFlatservice.viewAllFlat();
//		ResponseEntity<List<Flat>> response = new ResponseEntity<>(flats, HttpStatus.OK);
//		return response;
//	}
//	@GetMapping("/customer/flat")
//	public ResponseEntity<List<Flat>> viewAllFlatBycustomer() {
//		List<Flat> flats = iFlatservice.viewAllFlat();
//		ResponseEntity<List<Flat>> response = new ResponseEntity<>(flats, HttpStatus.OK);
//		return response;
//	}
//	@GetMapping("/tenant/flat/{flat_id}")
//	public ResponseEntity<Flat> viewFlatByTenant(@PathVariable("flat_id") Long flatId) {
//		Flat flat = iFlatservice.viewFlat(flatId);
//		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flat, HttpStatus.OK);
//		return response;
//	}
//	@GetMapping("/admin/flat/{flat_id}")
//	public ResponseEntity<Flat> viewFlatByAdmin(@PathVariable("flat_id") Long flatId) {
//		Flat flat = iFlatservice.viewFlat(flatId);
//		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flat, HttpStatus.OK);
//		return response;
//	}
//	@GetMapping("/landlord/flat/{flat_id}")
//	public ResponseEntity<Flat> viewFlatLandlord(@PathVariable("flat_id") Long flatId) {
//		Flat flat = iFlatservice.viewFlat(flatId);
//		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flat, HttpStatus.OK);
//		return response;
//	}
//	@GetMapping("/customer/flat/{flat_id}")
//	public ResponseEntity<Flat> viewFlatByCustomer(@PathVariable("flat_id") Long flatId) {
//		Flat flat = iFlatservice.viewFlat(flatId);
//		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flat, HttpStatus.OK);
//		return response;
//	}
//	
//	@PostMapping("/admin/flat")
//	public ResponseEntity<Flat> addFlatByAdmin(@RequestBody @Valid Flat flat){
//		Flat flatsaved = iFlatservice.addFlat(flat);
//		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flatsaved, HttpStatus.CREATED);
//		return response;
//	}
//	
//	@PostMapping("/landlord/flat")
//	public ResponseEntity<Flat> addFlatByLandlord(@RequestBody @Valid Flat flat){
//		Flat flatsaved = iFlatservice.addFlat(flat);
//		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flatsaved, HttpStatus.CREATED);
//		return response;
//	}
//	
//	@PutMapping("/admin/flat/{flat_id}")
//	public ResponseEntity<Flat> updateFlatByAdmin(@RequestBody Flat flat, @PathVariable("flat_id") Long flatId){
//		Flat flatupdated = iFlatservice.updateFlat(flat, flatId);
//		ResponseEntity<Flat> reponse = new ResponseEntity<Flat>(flatupdated, HttpStatus.OK);
//		return reponse;
//	}
//	@PutMapping("/landlord/flat/{flat_id}")
//	public ResponseEntity<Flat> updateFlatByLandlord(@RequestBody Flat flat, @PathVariable("flat_id") Long flatId){
//		Flat flatupdated = iFlatservice.updateFlat(flat, flatId);
//		ResponseEntity<Flat> reponse = new ResponseEntity<Flat>(flatupdated, HttpStatus.OK);
//		return reponse;
//	}
//	
//	@DeleteMapping("/admin/flat/{flat_id}")
//	public ResponseEntity<String> deleteFlatByAdmin(@PathVariable("flat_id") Long flatId){
//		iFlatservice.deleteFlat(flatId);
//		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
//		return response;
//		
//	}
//	
//	@DeleteMapping("/landlord/flat/{flat_id}")
//	public ResponseEntity<String> deleteFlatByLandlord(@PathVariable("flat_id") Long flatId){
//		iFlatservice.deleteFlat(flatId);
//		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
//		return response;
//		
//	}
//	
//	@GetMapping("/tenant/flat/{cost}")
//	public ResponseEntity<List<Flat>> viewAllFlatCostBasisByTenant(@PathVariable("cost") Double cost) {
//		List<Flat> flats = iFlatservice.viewAllFlatByCost(cost,"yes");
//		ResponseEntity<List<Flat>> response = new ResponseEntity<List<Flat>>(flats, HttpStatus.OK);
//		return response;
//	}
//	
//	@GetMapping("/admin/flat/{cost}")
//	public ResponseEntity<List<Flat>> viewAllFlatCostBasisByAdmin(@PathVariable("cost") Double cost) {
//		List<Flat> flats = iFlatservice.viewAllFlatByCost(cost,"yes");
//		ResponseEntity<List<Flat>> response = new ResponseEntity<List<Flat>>(flats, HttpStatus.OK);
//		return response;
//	}
//	
//	@GetMapping("/landlord/flat/{cost}")
//	public ResponseEntity<List<Flat>> viewAllFlatCostBasisByLandlord(@PathVariable("cost") Double cost) {
//		List<Flat> flats = iFlatservice.viewAllFlatByCost(cost,"yes");
//		ResponseEntity<List<Flat>> response = new ResponseEntity<List<Flat>>(flats, HttpStatus.OK);
//		return response;
//	}
//	
//	@GetMapping("/customer/flat/{cost}")
//	public ResponseEntity<List<Flat>> viewAllFlatCostBasisByCustomer(@PathVariable("cost") Double cost) {
//		List<Flat> flats = iFlatservice.viewAllFlatByCost(cost,"yes");
//		ResponseEntity<List<Flat>> response = new ResponseEntity<List<Flat>>(flats, HttpStatus.OK);
//		return response;
//	}
//	
//	
//	
//}
