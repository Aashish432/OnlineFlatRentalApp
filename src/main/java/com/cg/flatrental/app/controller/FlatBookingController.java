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
//import com.cg.flatrental.app.entity.FlatBooking;
//import com.cg.flatrental.app.entity.Tenant;
//import com.cg.flatrental.app.service.IFlatBookingService;
//import com.cg.flatrental.app.service.ITenantService;
//
//@RestController
//@RequestMapping("/api/v1")
//public class IFlatBookingController {
//
//	@Autowired
//	IFlatBookingService iFlatBookingService;
//	
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
//}
