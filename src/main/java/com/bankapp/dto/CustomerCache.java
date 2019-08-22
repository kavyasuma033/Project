package com.bankapp.dto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;

import com.bankapp.model.Customer;

@Component
public class CustomerCache {

	public CustomerCache() {
	}

	public Map<Integer, Customer> createInitialCustomerCache() {

		Map<Integer, Customer> customerCache = new HashMap<>();

		// One customer having multiple accounts
		Customer account1 = new Customer(1, "Tylor", "address1");
		Customer account2 = new Customer(2, "Alex", "address2");

		Customer account3 = new Customer(3, "Stewart", "address3");
		Customer account4 = new Customer(4, "Richard", "address4");

		customerCache.put(1, account1);
		customerCache.put(2, account2);
		customerCache.put(3, account3);
		customerCache.put(4, account4);

		return customerCache;

	}

}
