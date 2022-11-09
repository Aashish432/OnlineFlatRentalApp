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


import com.cg.flatrental.app.entity.FlatAddress;
import com.cg.flatrental.app.entity.Tenant;
import com.cg.flatrental.app.repository.ITenantRepository;
import com.cg.flatrental.app.service.implementation.ITenantServiceImplementation;



@ExtendWith(MockitoExtension.class)
public class TenantServiceTest {
	
	@InjectMocks
	private ITenantServiceImplementation tenantService;
	
	@Mock
	private ITenantRepository tenantRepository;
	
	@Test
	void testViewTeanants() {
		
		List<Tenant> tenants = getTenantsMockData();		
		Mockito.when(tenantRepository.findAll()).thenReturn(tenants);
		
		List<Tenant> tenantInfo = tenantService.viewAllTenant();
		
		assertThat(tenantInfo.size() == tenants.size());
		assertThat(tenantInfo.get(0).getAge().equals("Rahul"));
	}
	
	@Test
	void testViewTenant() {
		
		Long tenantId = 168L;
		
		Optional<Tenant> tenant = getTenantMockData();
		
		Mockito.when(tenantRepository.findById(tenantId)).thenReturn(tenant);
		
		Tenant tenant1 = tenantService.viewTenant(tenantId);
		
		assertThat(tenant1.getAge().equals(45));
		assertThat(tenant1.getTenantId().equals(174L));
	}
	
	@Test
	void testAddTenant() {
		
		Optional<Tenant> tenantOpt = getTenantMockData();
		Tenant tenant = tenantOpt.get();
		Mockito.when(tenantRepository.save(tenant)).thenReturn(tenant);
		
		Tenant tenant1 = tenantService.addTenant(tenant);
		
		assertThat(tenant1.getAge().equals(tenant.getAge()));
		assertThat(tenant.getTenantId().equals(tenant.getTenantId()));
		
	}
	
	private List<Tenant> getTenantsMockData() {
		List<Tenant> tenants = new ArrayList<>();
		Tenant tenant1 = new Tenant(174L, 45,"9315992692","aashishrao432@gmail.com");
		Tenant tenant2 = new Tenant(168L, 34,"9315992691","aashishra2432@gmail.com");
		Tenant tenant3 = new Tenant(172L, 25,"9315992690","aashishra1432@gmail.com");
		tenants.add(tenant1);
		tenants.add(tenant2);
		tenants.add(tenant3);
		return tenants;
	}
	
	private Optional<Tenant> getTenantMockData(){
		Tenant tenant = new Tenant(174L, 45,"9315992692","aashishrao432@gmail.com");
		return Optional.of(tenant);
	}

}
