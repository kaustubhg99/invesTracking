package com.invesTacking.dao;

import java.util.List;
import com.invesTacking.model.InvestmentTransaction;
import com.invesTacking.model.Profit;

public interface HistoryDao {

	public List<InvestmentTransaction> getInvesTxns(int user_Id);
	
	public List<Profit> getAllProft(int user_Id);
}
