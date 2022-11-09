package com.cg.flatrental.app.controller;

import java.util.List;

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

import com.cg.flatrental.app.entity.FlatBooking;
import com.cg.flatrental.app.entity.Tenant;
import com.cg.flatrental.app.service.IFlatBookingService;
import com.cg.flatrental.app.service.ITenantService;


@RestController
@RequestMapping("/api/v1/tenant")
public class TenantController {

	@Autowired
	ITenantService iTenantService;

	@GetMapping("/tenants")
	public ResponseEntity<List<Tenant>> viewAllTenant() {
		List<Tenant> tenants = iTenantService.viewAllTenant();
		ResponseEntity<List<Tenant>> response = new ResponseEntity<>(tenants, HttpStatus.OK);
		return response;
	}

	@GetMapping("/tenants/{tenant_id}")
	public ResponseEntity<Tenant> viewTenant(@PathVariable("tenant_id") Long tenantId) {
		Tenant tenant = iTenantService.viewTenant(tenantId);
		ResponseEntity<Tenant> response = new ResponseEntity<Tenant>(tenant, HttpStatus.OK);
		return response;
	}

	@PostMapping("/tenants")
	public ResponseEntity<Tenant> addTenant( @Valid @RequestBody Tenant tenant) {
		Tenant ten = iTenantService.addTenant(tenant);
		ResponseEntity<Tenant> response = new ResponseEntity<Tenant>(ten, HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/tenants/{tenant_id}")
	public ResponseEntity<Tenant> updateTenant( @RequestBody Tenant tenant,@PathVariable("tenant_id") Long tenantId){
		Tenant ten = iTenantService.updateTenant(tenant, tenantId);
		ResponseEntity<Tenant> reponse = new ResponseEntity<Tenant>(ten, HttpStatus.OK);
		return reponse;
	}

	@DeleteMapping("/tenants/{tenant_id}")
	public ResponseEntity<String>  deleteTenant(@PathVariable("tenant_id") Long tenantId){
		iTenantService.deleteTenant(tenantId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
	}

	@GetMapping("/tenants/Validate/{tenant_id}")
	public ResponseEntity<String> validateTenant(@PathVariable("tenant_id")Long tenantId){
		String tenant = iTenantService.validateTenant(tenantId);
		ResponseEntity<String> response = new ResponseEntity<String>("validation", HttpStatus.OK);
		return response;
	}
	@Autowired
	IFlatBookingService iFlatBookingService;
	@GetMapping("/flatbookings")
	public ResponseEntity<List<FlatBooking>> viewFlatBooking() {
		List<FlatBooking> flatbookings = iFlatBookingService.viewFlatBooking();
		ResponseEntity<List<FlatBooking>> response = new ResponseEntity<>(flatbookings, HttpStatus.OK);
		return response;
	}
	@GetMapping("/flatbookings/{flatbooking_id}")
	public ResponseEntity<FlatBooking> viewFlatBooking(@PathVariable("flatbooking_id") Long BookingId) {
		FlatBooking flatbooking = iFlatBookingService.viewFlatBooking(BookingId);
		ResponseEntity<FlatBooking> response = new ResponseEntity<FlatBooking>(flatbooking, HttpStatus.OK);
		return response;
	}

	@PostMapping("/flatBookings")
	public ResponseEntity<FlatBooking> addFlatBooking(@RequestBody @Valid FlatBooking flatBooking){
		FlatBooking flatbooking = iFlatBookingService.addFlatBooking(flatBooking);
		ResponseEntity<FlatBooking> response = new ResponseEntity<FlatBooking>(flatbooking, HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/flatbookings/{flatbooking_id}")
	public ResponseEntity<FlatBooking> updateFlatBooking(@RequestBody FlatBooking flatBooking,@PathVariable("flatbooking_id") Long BookingId){
		FlatBooking flatbooking = iFlatBookingService.updateFlatBooking(flatBooking, BookingId);
		ResponseEntity<FlatBooking> reponse = new ResponseEntity<FlatBooking>(flatbooking, HttpStatus.OK);
		return reponse;
	}

	@DeleteMapping("/flatbookings/{flatbooking_id}")
	public ResponseEntity<String>  deleteFlatBooking(@PathVariable("flatbooking_id") Long BookingId){
		iFlatBookingService.deleteFlatBooking(BookingId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
	}
		
}
