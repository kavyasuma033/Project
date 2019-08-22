package com.bankapp.controller;

import java.util.Map;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankapp.dto.AccountCache;
import com.bankapp.model.AccountInfo;

@RestController
public class AccountController {

	@Autowired
	private AccountCache accCache;

	@PostMapping("/createAccount")
	public Map<Integer, AccountInfo> createAccount(@RequestBody AccountInfo acc) {
		int id = acc.getAccId();
		
		Map<Integer, AccountInfo> map = accCache.createInitialAccountCache();
		map.put(id, acc);
		return map;
	}

	@GetMapping(value = "/getAllAccounts", produces = "application/json")
	public Map<Integer, AccountInfo> getAllAccounts() {
		return accCache.createInitialAccountCache();
	}

	@GetMapping("/updateAccountTypeById/{id}/{type}")
	public Map<Integer, AccountInfo> updateAccountTypeById(@PathVariable("type") String type, @PathVariable("id") Integer id) {

		Map<Integer, AccountInfo> map = accCache.createInitialAccountCache();
		AccountInfo accInfo = map.get(id);
		accInfo.setAccountType(type);
		map.put(id, accInfo);
		return map;
	}
	@GetMapping("/deleteAccountById/{id}")
	public Map<Integer, AccountInfo> deleteAccountById(@PathVariable("id") Integer id) {
		
		Map<Integer, AccountInfo> map = accCache.createInitialAccountCache();
		map.remove(id);
		return map;
	}
}
