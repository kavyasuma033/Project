package com.bankapp.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.CustomerCache;
import com.bankapp.model.Customer;

@RestController
public class CustomerController {

	@Autowired
	private CustomerCache custCache;

	@RequestMapping("/getAllCustomers")
	public Map<Integer, Customer> getAllCustomers() {

		return custCache.createInitialCustomerCache();
	}

	@PostMapping("/addCustomer")
	public Map<Integer, Customer> addCustomer(@RequestBody Customer c) {
		
		Map<Integer, Customer> map = custCache.createInitialCustomerCache();
		map.put(c.getCustId(), c);
		return map;
	}

	@GetMapping("updateCustomerByCustId/{id}/{name}")
	public Map<Integer, Customer> updateCustomerNameByCustId(@PathVariable("id") Integer id,@PathVariable("name") String name ) {
		Map<Integer, Customer> map = custCache.createInitialCustomerCache();
		Customer  cust = map.get(id);
		cust.setName(name);
		map.put(id, cust);
		return map;
	}

	@GetMapping("/deleteCustomer/{id}")
	public Map<Integer, Customer> deleteCustomer(@PathVariable("id") Integer id) {
		Map<Integer, Customer> map = custCache.createInitialCustomerCache();
		map.remove(id);
		return map;
		
	}

}
