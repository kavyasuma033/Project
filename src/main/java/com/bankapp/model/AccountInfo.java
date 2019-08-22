package com.bankapp.model;

public class AccountInfo {
	private int accId;
	private String accountType;
	private double balance;
	private int custId;

	public AccountInfo() {
		// TODO Auto-generated constructor stub
	}
	
	public AccountInfo(int accId, String accountType, double balance, int custId) {
		super();
		this.accId = accId;
		this.accountType = accountType;
		this.balance = balance;
		this.setCustId(custId);
	}

	public int getAccId() {
		return accId;
	}

	public void setAccId(int accId) {
		this.accId = accId;
	}

	public String getAccountType() {
		return accountType;
	}

	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}

	public int getCustId() {
		return custId;
	}

	public void setCustId(int custId) {
		this.custId = custId;
	}

}
