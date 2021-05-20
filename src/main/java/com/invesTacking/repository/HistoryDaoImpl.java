package com.invesTacking.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.invesTacking.dao.HistoryDao;
import com.invesTacking.model.InvestmentTransaction;
import com.invesTacking.model.Profit;

@Repository
public class HistoryDaoImpl implements HistoryDao{

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public List<InvestmentTransaction> getInvesTxns(int user_Id) {
		String sql = "select a.txn_Id, a.user_Id, a.txn_Action, a.txn_Amount, a.txn_Date, "
				+ "a.inves_Name from inves_transaction a where a.user_Id = "+user_Id+" order by a.txn_Id desc";
		return jdbc.query(sql,new RowMapper<InvestmentTransaction>(){    
	        public InvestmentTransaction mapRow(ResultSet rs, int row) throws SQLException {    
	        	InvestmentTransaction history=new InvestmentTransaction();    
	        	history.setInves_Txn_Id(rs.getInt(1));
	        	history.setUser_Id(rs.getInt(2));
	        	history.setTxn_Action(rs.getString(3));
	        	history.setTxn_Amount(rs.getDouble(4));
	        	history.setTxn_Date(rs.getString(5));
	        	history.setInves_Name(rs.getString(6));
	            return history;    
	        }    
	    });  
	}
	
	@Override
	public List<Profit> getAllProft(int user_Id) {
		String sql = "select a.profit_Id, a.profit_Name, a.profit_Amount, a.user_Id from inves_profit a where a.user_Id = "+user_Id+" order by a.profit_Id desc";
		return jdbc.query(sql,new RowMapper<Profit>(){    
	        public Profit mapRow(ResultSet rs, int row) throws SQLException {    
	        	Profit profit=new Profit();    
	        	profit.setProfit_Id(rs.getInt(1));
	        	profit.setProfit_Name(rs.getString(2));
	        	profit.setProfit_Amount(rs.getDouble(3));
	        	profit.setUser_Id(rs.getInt(4));
	            return profit;    
	        }    
	    });  
	}


}
