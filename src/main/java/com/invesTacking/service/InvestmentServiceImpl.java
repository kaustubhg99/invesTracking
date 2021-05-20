package com.invesTacking.service;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invesTacking.dao.InvestmentDao;
import com.invesTacking.model.Investments;
import com.invesTacking.model.Profit;
import com.invesTacking.model.UserDetails;

@Service
public class InvestmentServiceImpl implements InvestmentService{

	@Autowired
	InvestmentDao repository;
	
	@Override
	public Investments getInvestmentByName(String inves_Name) {
		// TODO Auto-generated method stub
		return repository.getInvestmentByName(inves_Name);
	}

	@Override
	public int[] updateInvestmentBalance(UserDetails details) {
		// TODO Auto-generated method stub
		return repository.updateInvestmentBalance(details);
	}

	@Override
	public void addNewInves(UserDetails details) {
		
		repository.addNewInves(details);
		
	}

	@Override
	public Map<Integer, String> getInvesMap() {
		// TODO Auto-generated method stub
		return repository.getInvesMap();
	}

	@Override
	public Profit checkProfitName(String profit_Name, int user_Id) {
		// TODO Auto-generated method stub
		return repository.checkProfitName(profit_Name, user_Id);
	}

	@Override
	public void addProfit(Profit profit) {
		repository.addProfit(profit);
	}

	@Override
	public void updateProfit(Profit profit) {
		repository.updateProfit(profit);
	}
	
	

}
