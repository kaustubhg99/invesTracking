package com.invesTacking.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.invesTacking.dao.InvestmentDao;
import com.invesTacking.model.Investments;
import com.invesTacking.model.Profit;
import com.invesTacking.model.UserDetails;

@Repository
public class InvestmentDaoImpl implements InvestmentDao{

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public Investments getInvestmentByName(String inves_Name) {
		String sql = "select * from inves_table where inves_Name = '"+inves_Name+"'";
		 List<Investments> inves = jdbc.query(sql, new InvesMapper());
		    return inves.size() > 0 ? inves.get(0) : null; 
	}
	
	class InvesMapper implements RowMapper<Investments> {
		  public Investments mapRow(ResultSet rs, int arg1) throws SQLException {
			  Investments inves = new Investments();
			  inves.setUser_Id(rs.getInt(1));
			  inves.setInves_Name(rs.getString(2));
			  inves.setInves_Market_Cap(rs.getDouble(3));
			  inves.setUser_Id(rs.getInt(4));
			  inves.setInves_Holdings(rs.getDouble(5));
			  inves.setInves_Amount(rs.getDouble(6));
		    return inves;
		  }
	  }

	@Override
	public int[] updateInvestmentBalance(UserDetails details) {
		int[] row = null;
		String sql ="update account set acc_Wallet="+details.getAcc_Wallet()+", acc_Investment="+details.getAcc_Invested()+", acc_Profit="+details.getAcc_Profit()+" where userId="+details.getUser_Id()+"";
		String sql2 = "insert into inves_transaction(user_Id, txn_Action, txn_Amount, txn_Date, inves_Name) value("+details.getUser_Id()+","
				+ "'"+details.getInves_Action()+"',"
						+ ""+details.getInves_Amount()+","
								+ "'"+details.getInves_Date()+"',"
										+ "'"+details.getInves_Name()+"')";
		String sql3 = "update inves_table set inves_Market_Cap="+details.getInves_Market_Cap()+","
				+ "inves_Holding="+details.getInves_Holding()+","
						+ "inves_Buying_Amt = "+details.getInve_Buying_Amt()+","
						+ "inves_Amount="+details.getInves_Amount()+" where inves_Name='"+details.getInves_Name()+"' and user_Id="+details.getUser_Id()+"";
		
		try {
		 row =jdbc.batchUpdate(sql, sql2,sql3);
		}catch(Exception e) {
			System.out.println("Failed to update user wallet : "+e);
		}
		return row;
	}

	@Override
	public void addNewInves(UserDetails details) {
		String sql1 = "insert into inves_transaction(user_Id, txn_Action, txn_Amount, txn_Date, inves_Name) value("+details.getUser_Id()+","
				+ "'"+details.getInves_Action()+"',"
						+ ""+details.getInves_Amount()+","
								+ "'"+details.getInves_Date()+"',"
										+ "'"+details.getInves_Name()+"')";
		String sql2 = "insert into inves_table(inves_Name, inves_Market_Cap, user_Id, inves_Holding, inves_Amount, inves_Buying_Amt) value("
				+ "'"+details.getInves_Name()+"',"
						+ ""+details.getInves_Market_Cap()+","
								+ ""+details.getUser_Id()+","
										+ ""+details.getInves_Holding()+","
												+ ""+details.getInves_Amount()+","
														+ ""+details.getInve_Buying_Amt()+")";
		String sql3 ="update account set acc_Wallet="+details.getAcc_Wallet()+", acc_Investment="+details.getAcc_Invested()+" where userId="+details.getUser_Id()+"";
		try{
			jdbc.batchUpdate(sql1, sql2,sql3);
		  }catch (Exception e) { System.out.println(e); }
		 
	}
	

	@Override
	public Map<Integer, String> getInvesMap() {
		
		return jdbc.query("select inves_Id,inves_Name from inves_table", (ResultSet rs) -> {
		    HashMap<Integer,String> results = new HashMap<>();
		    while (rs.next()) {
		        results.put(rs.getInt(1), rs.getString(2));
		    }
		    return results;
		});
	}

	@Override
	public Profit checkProfitName(String profit_Name, int user_Id) {
		String sql = "select * from inves_profit where profit_Name = '"+profit_Name+"' and user_Id = "+user_Id+"";
		 List<Profit> inves = jdbc.query(sql, new ProfitMapper());
		    return inves.size() > 0 ? inves.get(0) : null; 
	}
	
	class ProfitMapper implements RowMapper<Profit> {
		  public Profit mapRow(ResultSet rs, int arg1) throws SQLException {
			  Profit profit = new Profit();
			  profit.setUser_Id(rs.getInt(1));
			  return profit;
		  }
	}

	@Override
	public void addProfit(Profit profit) {
		String sql1 = "insert into inves_profit(profit_Name, profit_Amount, user_Id) value("
				+ "'"+profit.getProfit_Name()+"',"
						+ ""+profit.getProfit_Amount()+","
								+ "'"+profit.getUser_Id()+"')";
		jdbc.update(sql1);
		
	}

	@Override
	public void updateProfit(Profit profit) {
		String sql = "update inves_profit set profit_Amount="+profit.getProfit_Amount()+" where profit_Name='"+profit.getProfit_Name()+"' and user_Id="+profit.getUser_Id()+"";
		jdbc.update(sql);
	}

}
