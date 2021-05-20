package com.invesTacking.model;

public class InvestmentTransaction {

	private int inves_Txn_Id;
	private int user_Id;
	private String txn_Action;
	private double txn_Amount;
	private String txn_Date;
	private String inves_Name;
	public int getInves_Txn_Id() {
		return inves_Txn_Id;
	}
	public void setInves_Txn_Id(int inves_Txn_Id) {
		this.inves_Txn_Id = inves_Txn_Id;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	public String getTxn_Action() {
		return txn_Action;
	}
	public void setTxn_Action(String txn_Action) {
		this.txn_Action = txn_Action;
	}
	public double getTxn_Amount() {
		return txn_Amount;
	}
	public void setTxn_Amount(double txn_Amount) {
		this.txn_Amount = txn_Amount;
	}
	public String getTxn_Date() {
		return txn_Date;
	}
	public void setTxn_Date(String txn_Date) {
		this.txn_Date = txn_Date;
	}
	public String getInves_Name() {
		return inves_Name;
	}
	public void setInves_Name(String inves_Name) {
		this.inves_Name = inves_Name;
	}
	
}
