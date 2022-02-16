package com.oms.account.accountservice.dao;

import com.oms.account.accountservice.model.Customer;

public interface CustomerDao {

	Customer findBy(String username);
	Long save(Customer customer);
	
}
