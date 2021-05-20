package com.invesTacking.dao;

import java.util.List;

import com.invesTacking.model.Wallet;

public interface WalletDao {

	public List<Wallet> getWalletTxns(int user_Id);
	
	public int[] updateWalletBalance(Wallet wallet);
}

