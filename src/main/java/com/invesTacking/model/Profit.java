package com.invesTacking.model;

public class Profit {

	private int profit_Id;
	private String profit_Name;
	private double profit_Amount;
	private int user_Id;
	
	public Profit() {
		
	}
	
	public Profit(String profit_Name, double profit_Amount, int user_Id) {
		super();
		this.profit_Name = profit_Name;
		this.profit_Amount = profit_Amount;
		this.user_Id = user_Id;
	}
	public int getProfit_Id() {
		return profit_Id;
	}
	public void setProfit_Id(int profit_Id) {
		this.profit_Id = profit_Id;
	}
	public String getProfit_Name() {
		return profit_Name;
	}
	public void setProfit_Name(String profit_Name) {
		this.profit_Name = profit_Name;
	}
	public double getProfit_Amount() {
		return profit_Amount;
	}
	public void setProfit_Amount(double profit_Amount) {
		this.profit_Amount = profit_Amount;
	}
	public int getUser_Id() {
		return user_Id;
	}
	public void setUser_Id(int user_Id) {
		this.user_Id = user_Id;
	}
	
	
}
