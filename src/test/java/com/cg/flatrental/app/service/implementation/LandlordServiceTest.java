package com.cg.flatrental.app.service.implementation;
import static org.assertj.core.api.Assertions.assertThat;

import static org.mockito.Mockito.doNothing;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cg.flatrental.app.entity.Flat;
import com.cg.flatrental.app.entity.FlatAddress;
import com.cg.flatrental.app.entity.Landlord;
import com.cg.flatrental.app.repository.ILandlordRepository;
import com.cg.flatrental.app.service.ILandlordService;
import com.cg.flatrental.app.service.implementation.ILandlordServiceImplementation;


@ExtendWith(MockitoExtension.class)

public class LandlordServiceTest {

	@InjectMocks
	private ILandlordServiceImplementation iLandlordService;
	
	@Mock
	private ILandlordRepository iLandlordRepository;
	
	
	@Test
	void test() {
		
		List<Landlord> landlord = getLandlordsMockData();		
		Mockito.when(iLandlordRepository.findAll()).thenReturn(landlord);
		
		List<Landlord> lanInfo = iLandlordService.viewAllLandlord();
		
		assertThat(lanInfo.size() == landlord.size());
		assertThat(lanInfo.get(0).getLandlordName().equals("Rahul"));
	}
	
	private List<Landlord> getLandlordsMockData(){
		List<Landlord> landlords = new ArrayList<>();
		List<Flat> flats = new ArrayList<Flat>();
		Landlord lan1 = new Landlord();
		
		
		lan1.setLandlordId(174L);
		lan1.setLandlordAge(24);
		lan1.setLandlordName("Rahul");
		Landlord lan2 = new Landlord();
		
		lan2.setLandlordAge(34);
		lan2.setLandlordId(168L);
		lan2.setLandlordName("Ramesh");
		Landlord lan3 = new Landlord();
		
		lan3.setLandlordAge(45);
		lan3.setLandlordId(172L);
		lan3.setLandlordName("Kumar");
		landlords.add(lan1);
		landlords.add(lan2);
		landlords.add(lan3);
		return landlords;
	}
	
	private Optional<Landlord> getLandlordMockData(){
		Landlord lan = new Landlord();
		Landlord lan1 = new Landlord();
		List<Flat> flats = new ArrayList<Flat>();
	
		lan1.setLandlordId(174L);
		lan1.setLandlordAge(24);
		lan1.setLandlordName("rahul");
		return Optional.of(lan);
	}
	
}