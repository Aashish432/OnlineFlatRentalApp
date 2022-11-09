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
import com.cg.flatrental.app.entity.FlatBooking;
import com.cg.flatrental.app.entity.User;
import com.cg.flatrental.app.service.IFlatBookingService;
import com.cg.flatrental.app.service.IFlatService;
import com.cg.flatrental.app.service.IUserService;



@RestController
@RequestMapping("/api/v1/user")
public class UserController {
	
	@Autowired
	IUserService iUserService;
	
	@GetMapping("/users/view_user/{user_id}")
	public ResponseEntity<User> viewUser(@PathVariable("user_id") Long userId)
	{
		User user = iUserService.viewUser(userId);
		return new ResponseEntity<>(user, HttpStatus.OK);
	}
	
//	@GetMapping("/users")
//	public ResponseEntity<List<User>> viewAlluser()
//	{
//		List<User> user = iUserService.viewAllUser();
//		return new ResponseEntity<>(user, HttpStatus.OK);
//	}
	
	@GetMapping("/users/{user_id}/{user_password}")
	public ResponseEntity<User> validateUser(@PathVariable("user_id") Long userId,@PathVariable ("user_password") String password)
	{
		User user1 = iUserService.validateUser(userId, password);
		return new ResponseEntity<>(user1, HttpStatus.OK);
	}
	
	
	@PostMapping("/users/addUser")
	public ResponseEntity<User> addUser(@Valid @RequestBody  User user)
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
	
//	@PutMapping("/users/{user_id}")
//	public ResponseEntity<User> upadtePassword(@PathVariable("user_id") Long userId, @PathVariable("user_password") String password)
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
	IFlatService iFlatservice;
	
	@GetMapping("/flat")
	public ResponseEntity<List<Flat>> viewAllFlatBycustomer() {
		List<Flat> flats = iFlatservice.viewAllFlat();
		List<Flat> availableFlats=flats.stream().filter(flat->flat.getAvailability().equals("yes")).collect(Collectors.toList());
		ResponseEntity<List<Flat>> response = new ResponseEntity<>(availableFlats, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/flat/customer/cost/{cost}")
	public ResponseEntity<List<Flat>> viewAllFlatCostBasisByCustomer(@PathVariable("cost") Double cost) {
		List<Flat> flats = iFlatservice.viewAllFlatByCost(cost,"yes");
		ResponseEntity<List<Flat>> response = new ResponseEntity<List<Flat>>(flats, HttpStatus.OK);
		return response;
	}
	
	@GetMapping("/flat/customer/{flat_id}")
	public ResponseEntity<Flat> viewFlatByCustomer(@PathVariable("flat_id") Long flatId) {
		Flat flat = iFlatservice.viewFlat(flatId);
		ResponseEntity<Flat> response = new ResponseEntity<Flat>(flat, HttpStatus.OK);
		return response;
	}
//	@Autowired
//	IFlatBookingService iFlatBookingService;
//	@GetMapping("/flatbookings")
//	public ResponseEntity<List<FlatBooking>> viewFlatBooking() {
//		List<FlatBooking> flatbookings = iFlatBookingService.viewFlatBooking();
//		ResponseEntity<List<FlatBooking>> response = new ResponseEntity<>(flatbookings, HttpStatus.OK);
//		return response;
//	}
//	@GetMapping("/flatbookings/{flatbooking_id}")
//	public ResponseEntity<FlatBooking> viewFlatBooking(@PathVariable("flatbooking_id") Long BookingId) {
//		FlatBooking flatbooking = iFlatBookingService.viewFlatBooking(BookingId);
//		ResponseEntity<FlatBooking> response = new ResponseEntity<FlatBooking>(flatbooking, HttpStatus.OK);
//		return response;
//	}
//
//	@PostMapping("/flatBookings")
//	public ResponseEntity<FlatBooking> addFlatBooking(@RequestBody @Valid FlatBooking flatBooking){
//		FlatBooking flatbooking = iFlatBookingService.addFlatBooking(flatBooking);
//		ResponseEntity<FlatBooking> response = new ResponseEntity<FlatBooking>(flatbooking, HttpStatus.CREATED);
//		return response;
//	}
//
//	@PutMapping("/flatbookings/{flatbooking_id}")
//	public ResponseEntity<FlatBooking> updateFlatBooking(@RequestBody FlatBooking flatBooking,@PathVariable("flatbooking_id") Long BookingId){
//		FlatBooking flatbooking = iFlatBookingService.updateFlatBooking(flatBooking, BookingId);
//		ResponseEntity<FlatBooking> reponse = new ResponseEntity<FlatBooking>(flatbooking, HttpStatus.OK);
//		return reponse;
//	}
//
//	@DeleteMapping("/flatbookings/{flatbooking_id}")
//	public ResponseEntity<String>  deleteFlatBooking(@PathVariable("flatbooking_id") Long BookingId){
//		iFlatBookingService.deleteFlatBooking(BookingId);
//		ResponseEntity<String> response = new ResponseEntity<String>("Successfully Deleted", HttpStatus.NO_CONTENT);
//		return response;
//	}
	

}

