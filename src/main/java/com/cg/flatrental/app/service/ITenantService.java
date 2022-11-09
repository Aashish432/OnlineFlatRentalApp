package com.cg.flatrental.app.service;

import java.util.List;

import com.cg.flatrental.app.entity.Tenant;

public interface ITenantService {
	Tenant addTenant(Tenant tenant);
	Tenant updateTenant(Tenant tenant,Long tenantId);
	void deleteTenant(Long tenantId);
	Tenant viewTenant(Long tenantId);
	List<Tenant> viewAllTenant();
	String validateTenant(Long tenantId);
}
