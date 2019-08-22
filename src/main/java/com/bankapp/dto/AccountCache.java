package com.bankapp.dto;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import com.bankapp.model.AccountInfo;

@Component
public class AccountCache {

	public AccountCache() {
	}

	@Cacheable("accounts")
	public Map<Integer, AccountInfo> createInitialAccountCache() {

		Map<Integer, AccountInfo> accountCache = new HashMap<>();

		// One customer having multiple accounts
		AccountInfo account1 = new AccountInfo(1, "SAVINGS", 1000, 1);
		AccountInfo account2 = new AccountInfo(2, "CURRENT", 1000, 1);

		AccountInfo account3 = new AccountInfo(3, "CURRENT", 1000, 2);
		AccountInfo account4 = new AccountInfo(4, "SAVINGS", 1000, 3);

		accountCache.put(1, account1);
		accountCache.put(2, account2);
		accountCache.put(3, account3);
		accountCache.put(4, account4);

		return accountCache;

	}

}
