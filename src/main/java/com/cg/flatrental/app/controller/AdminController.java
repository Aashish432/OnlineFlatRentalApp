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

import com.cg.flatrental.app.entity.Flat;
import com.cg.flatrental.app.entity.FlatBooking;
import com.cg.flatrental.app.entity.Landlord;
import com.cg.flatrental.app.entity.Tenant;
import com.cg.flatrental.app.entity.User;
import com.cg.flatrental.app.service.IFlatBookingService;
import com.cg.flatrental.app.service.IFlatService;
import com.cg.flatrental.app.service.ILandlordService;
import com.cg.flatrental.app.service.ITenantService;
import com.cg.flatrental.app.service.IUserService;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
	@Autowired
	IFlatService iFlatservice;
	
	@GetMapping("/flats")
	public ResponseEntity<List<Flat>> viewAllFlatByAdmin() {
		List<Flat> flats = iFlatservice.viewAllFlat();
		ResponseEntity<List<Flat>> response = new ResponseEntity<>(flats, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/flats/{flat_id}")
	public ResponseEntity<Flat> viewFlatByAdmin(@PathVariable("flat_id") Long flatId) {
		Flat flat = iFlatservice.viewFlat(flatId);
		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flat, HttpStatus.OK);
		return response;
	}
	
	@PostMapping("/flats")
	public ResponseEntity<Flat> addFlatByAdmin(@RequestBody @Valid Flat flat){
		Flat flatsaved = iFlatservice.addFlat(flat);
		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flatsaved, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/flats/{flat_id}")
	public ResponseEntity<Flat> updateFlatByAdmin(@RequestBody Flat flat, @PathVariable("flat_id") Long flatId){
		Flat flatupdated = iFlatservice.updateFlat(flat, flatId);
		ResponseEntity<Flat> reponse = new ResponseEntity<Flat>(flatupdated, HttpStatus.OK);
		return reponse;
	}
	
	@DeleteMapping("/flats/{flat_id}")
	public ResponseEntity<String> deleteFlatByAdmin(@PathVariable("flat_id") Long flatId){
		iFlatservice.deleteFlat(flatId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
		
	}
	
	@GetMapping("/flats/{cost}")
	public ResponseEntity<List<Flat>> viewAllFlatCostBasisByAdmin(@PathVariable("cost") Double cost) {
		List<Flat> flats = iFlatservice.viewAllFlatByCost(cost,"yes");
		ResponseEntity<List<Flat>> response = new ResponseEntity<List<Flat>>(flats, HttpStatus.OK);
		return response;
	}
	
	@Autowired
	private ILandlordService iLandlordService;
	
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
	
	@PostMapping("/landlords")
	public ResponseEntity<Landlord> addLandlord(@RequestBody @Valid Landlord landlord){
		Landlord landLord = iLandlordService.addLandlord(landlord);
		ResponseEntity<Landlord> response = new ResponseEntity<Landlord>(landLord, HttpStatus.CREATED);
		return response;
	}
	
	@PutMapping("/landlords/{landlord_id}")
	public ResponseEntity<Landlord> updateLandlord(@RequestBody Landlord landlord, @PathVariable("landlord_id") Long landlordid){
		Landlord lan = iLandlordService.updateLandlord(landlord, landlordid);
		ResponseEntity<Landlord> reponse = new ResponseEntity<Landlord>(lan, HttpStatus.OK);
		return reponse;
	}
	
	@DeleteMapping("/landlords/{landlord_id}")
	public ResponseEntity<String> deleteLandLord(@PathVariable("landlord_id") Long landlordId){
		iLandlordService.deleteLandlord(landlordId);
		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
		return response;
		
	}
	
	@Autowired
	private IUserService iUserService;
	
	@GetMapping("/users/{user_id}")
	public ResponseEntity<User> viewUser(@PathVariable("user_id") Long userId)
	{
		User user = iUserService.viewUser(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/users/allusers")
	public ResponseEntity<List<User>> viewAlluser()
	{
		List<User> user = iUserService.viewAllUser();
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
	@GetMapping("/users/validate/{user_id}")
	public ResponseEntity<User> validateUser(@PathVariable("user_id") Long userId,@PathVariable ("user_password") String password   )
	{
		User user1 = iUserService.validateUser(userId, password);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}
	
	
	@PostMapping("/users/addUser")
	public ResponseEntity<User> addUser(@RequestBody @Valid User user)
	{
		User user1 = iUserService.addUser(user);
		return new ResponseEntity<>(user1, HttpStatus.CREATED);
	}
	
	@PutMapping("/users/{user_id}")
	public ResponseEntity<User> updateUser(@RequestBody User user, @PathVariable("user_id") Long userId)
	{
		User user1 = iUserService.updateUser(user, userId);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}
	
//	@PutMapping("/users/{user_userId}")
//	public ResponseEntity<User> upadtePassword(@PathVariable("user_userId") Long userId, @PathVariable("user_password") String password)
//	{
//		User user1 = iUserService.updatePassword(userId, password);
//		return new ResponseEntity<>(user1, HttpStatus.OK);
//	}
	
	@DeleteMapping("/users/{user_id}")
	public ResponseEntity<String> removeUser(@RequestBody Long userId)
	{
		iUserService.removeUser(userId);
		return new ResponseEntity<String>("Succesfully Removed", HttpStatus.NO_CONTENT);
	}
	@Autowired
	IFlatBookingService iFlatBookingService;
	
	@GetMapping("/flatbookings")
	public ResponseEntity<List<FlatBooking>> viewAllFlatBooking() {
		List<FlatBooking> flatbookings = iFlatBookingService.viewFlatBooking();
		ResponseEntity<List<FlatBooking>> response = new ResponseEntity<>(flatbookings, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/flatbookings/{flatbooking_id}")
	public ResponseEntity<FlatBooking> viewFlatBookingById(@PathVariable("flatbooking_id") Long BookingId) {
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
	public ResponseEntity<Tenant> addTenant(@RequestBody Tenant tenant) {
		Tenant ten = iTenantService.addTenant(tenant);
		ResponseEntity<Tenant> response = new ResponseEntity<Tenant>(ten, HttpStatus.CREATED);
		return response;
	}

	@PutMapping("/tenants/{tenant_id}")
	public ResponseEntity<Tenant> updateTenant(@RequestBody Tenant tenant,@PathVariable("tenant_id") Long tenantId){
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
	
}
