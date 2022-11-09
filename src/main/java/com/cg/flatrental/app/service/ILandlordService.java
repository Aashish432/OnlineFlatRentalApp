package com.cg.flatrental.app.service;

import java.util.List;

import com.cg.flatrental.app.entity.Landlord;

public interface ILandlordService {
	Landlord addLandlord(Landlord landlord);
	Landlord updateLandlord(Landlord landlord, Long landlordId);
	void deleteLandlord(Long landlordId);
	Landlord viewLandlord(Long id);
	List<Landlord> viewAllLandlord();
}
