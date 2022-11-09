package com.cg.flatrental.app.service.implementation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import com.cg.flatrental.app.entity.FlatBooking;
import com.cg.flatrental.app.exception.FlatBookingNotFoundException;
import com.cg.flatrental.app.repository.IFlatBookingRepository;
import com.cg.flatrental.app.service.IFlatBookingService;



@Service
public class IFlatBookingServiceImplementation implements IFlatBookingService {

	@Autowired
	private IFlatBookingRepository iFlatBookingRepository;
	

	@Override
	public FlatBooking addFlatBooking(FlatBooking flatBooking) {
		iFlatBookingRepository.save(flatBooking);
		return flatBooking;
	}
	
	
	public FlatBooking updateFlatBooking(FlatBooking flatBooking,Long bookingId) {
		Optional<FlatBooking> flatBookingOpt = iFlatBookingRepository.findById(bookingId);
		
		FlatBooking updatedBooking=null;
		if(!flatBookingOpt.isPresent()) {
			throw new FlatBookingNotFoundException("FlatBooking ("+bookingId+") Not Found");
		}else {
			updatedBooking = flatBookingOpt.get();
			updatedBooking.setFlat(flatBooking.getFlat());
			updatedBooking.setTenant(flatBooking.getTenant());
			updatedBooking.setBookingFromDate(flatBooking.getBookingFromDate());
			updatedBooking.setBookingToDate(flatBooking.getBookingToDate());
			iFlatBookingRepository.save(updatedBooking);
		}
			
		return updatedBooking;
	}

	public FlatBooking viewFlatBooking(Long bookingId) {
		Optional<FlatBooking> flatBookingOpt = iFlatBookingRepository.findById(bookingId);
		
		if(!flatBookingOpt.isPresent()) {
			throw new FlatBookingNotFoundException("FlatBooking("+bookingId+") Not Found");
		}
		return flatBookingOpt.get();
	}

	public void deleteFlatBooking(Long bookingId) {
		Optional<FlatBooking> flatBookingOpt = iFlatBookingRepository.findById(bookingId);
		
		if(!flatBookingOpt.isPresent()) {
			throw new FlatBookingNotFoundException("FlatBooking("+bookingId+") Not Found");
		}else {
			iFlatBookingRepository.deleteById(bookingId);
		}
		
	}
	public List<FlatBooking> viewFlatBooking(){
		return iFlatBookingRepository.findAll();
	}

}
