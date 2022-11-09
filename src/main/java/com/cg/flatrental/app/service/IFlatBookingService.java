package com.cg.flatrental.app.service;

import java.util.List;


import com.cg.flatrental.app.entity.FlatBooking;

public interface IFlatBookingService {
	FlatBooking addFlatBooking(FlatBooking flatBooking);
	FlatBooking updateFlatBooking(FlatBooking flatBooking,Long bookingId);
	FlatBooking viewFlatBooking(Long bookingId);
	void deleteFlatBooking(Long bookingId);
	List<FlatBooking> viewFlatBooking();
	
}
