package com.invesTacking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invesTacking.dao.HistoryDao;
import com.invesTacking.model.InvestmentTransaction;
import com.invesTacking.model.Profit;

@Service
public class HistoryServiceImpl implements HistoryService{

	@Autowired
	HistoryDao repository;
	
	@Override
	public List<InvestmentTransaction> getInvesTxns(int user_Id) {
		// TODO Auto-generated method stub
		return repository.getInvesTxns(user_Id);
	}

	@Override
	public List<Profit> getAllProft(int user_Id) {
		// TODO Auto-generated method stub
		return repository.getAllProft(user_Id);
	}

}
