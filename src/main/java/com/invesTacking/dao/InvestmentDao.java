package com.invesTacking.dao;

import java.util.Map;

import com.invesTacking.model.Investments;
import com.invesTacking.model.Profit;
import com.invesTacking.model.UserDetails;

public interface InvestmentDao {

	public Investments getInvestmentByName(String inves_Name);
	
	public int[] updateInvestmentBalance(UserDetails details);
	
	public void addNewInves(UserDetails details);
	
	public Map<Integer, String> getInvesMap();
	
	public Profit checkProfitName(String profit_Name, int user_Id);
	
	public void addProfit(Profit profit);
	
	public void updateProfit(Profit profit);
}
