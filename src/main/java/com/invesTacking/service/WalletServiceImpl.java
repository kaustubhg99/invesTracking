package com.invesTacking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.invesTacking.dao.WalletDao;
import com.invesTacking.model.UserDetails;
import com.invesTacking.model.Wallet;

@Service
public class WalletServiceImpl implements WalletService{

	@Autowired
	WalletDao repository;
	
	@Override
	public List<Wallet> getWalletTxns(int user_Id) {
		
		return repository.getWalletTxns(user_Id);
	}

	@Override
	public int[] updateWalletBalance(Wallet wallet) {
		// TODO Auto-generated method stub
		return repository.updateWalletBalance(wallet);
	}

	
}
