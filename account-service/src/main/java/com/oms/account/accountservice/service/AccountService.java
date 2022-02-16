package com.oms.account.accountservice.service;

import java.security.NoSuchAlgorithmException;

import com.oms.account.accountservice.exception.AuthenticationFailedException;
import com.oms.account.accountservice.model.Customer;

public interface AccountService {

	Customer authentication(String username, String password) 
			throws NoSuchAlgorithmException, AuthenticationFailedException;
	Long addCustomer(Customer customer) throws NoSuchAlgorithmException;
}
