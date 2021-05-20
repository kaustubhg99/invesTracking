package com.invesTacking.service;

import java.util.List;
import com.invesTacking.model.Wallet;

public interface WalletService {

	public List<Wallet> getWalletTxns(int user_Id);
	
	public int[] updateWalletBalance(Wallet wallet);
	

}
