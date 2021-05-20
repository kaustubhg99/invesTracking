package com.invesTacking.model;

public class Wallet {

	private int wallet_txn;
	private int user_Id;
	private double wallet_Balance;
	private double wallet_Amount;
	private String wallet_action;
	private String wallet_date;
	public int getWallet_txn() {
		return wallet_txn;
	}
	public void setWallet_txn(int wallet_txn) {
		this.wallet_txn = wallet_txn;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public double getWallet_Balance() {
		return wallet_Balance;
	}
	public void setWallet_Balance(double wallet_Balance) {
		this.wallet_Balance = wallet_Balance;
	}
	public double getWallet_Amount() {
		return wallet_Amount;
	}
	public void setWallet_Amount(double wallet_Amount) {
		this.wallet_Amount = wallet_Amount;
	}
	public String getWallet_action() {
		return wallet_action;
	}
	public void setWallet_action(String wallet_action) {
		this.wallet_action = wallet_action;
	}
	public String getWallet_date() {
		return wallet_date;
	}
	public void setWallet_date(String wallet_date) {
		this.wallet_date = wallet_date;
	}
	
	
}
