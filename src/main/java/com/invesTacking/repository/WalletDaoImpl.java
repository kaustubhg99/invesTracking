package com.invesTacking.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.invesTacking.dao.WalletDao;
import com.invesTacking.model.Wallet;

@Repository
public class WalletDaoImpl implements WalletDao{

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public List<Wallet> getWalletTxns(int user_Id) {
		String sql = "select a.wtxn_Id, a.wtxn_Action, a.Amount, a.wtxn_Date,\r\n"
				+ "b.acc_Wallet from wallet_transactions a inner join account b on\r\n"
				+ "user_Id = b.userId where b.userId = "+user_Id+" order by a.wtxn_Id desc";
		return jdbc.query(sql,new RowMapper<Wallet>(){    
	        public Wallet mapRow(ResultSet rs, int row) throws SQLException {    
	        	Wallet wallet=new Wallet();    
	        	wallet.setWallet_txn(rs.getInt(1));
	        	wallet.setWallet_action(rs.getString(2));
	        	wallet.setWallet_Amount(rs.getDouble(3));
	        	wallet.setWallet_date(rs.getString(4));
	        	wallet.setWallet_Balance(rs.getDouble(5));
	            return wallet;    
	        }    
	    });  
		
	}

	@Override
	public int[] updateWalletBalance(Wallet wallet) {
		int[] row = null;
		String sql ="update account set acc_Wallet="+wallet.getWallet_Balance()+" where userId="+wallet.getUser_Id()+"";
		String sql2 = "insert into wallet_transactions(user_Id, wtxn_Action, Amount, wtxn_Date) value("+wallet.getUser_Id()+","
				+ "'"+wallet.getWallet_action()+"',"
						+ ""+wallet.getWallet_Amount()+","
								+ "'"+wallet.getWallet_date()+"')";
		
		try {
		 row =jdbc.batchUpdate(sql, sql2);
		}catch(Exception e) {
			System.out.println("Failed to update user wallet : "+e);
		}
		return row;
	}

}
