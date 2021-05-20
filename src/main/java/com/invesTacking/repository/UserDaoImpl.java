package com.invesTacking.repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import com.invesTacking.dao.UserDao;
import com.invesTacking.model.User;
import com.invesTacking.model.UserDetails;

@Repository
public class UserDaoImpl implements UserDao {

	@Autowired
	JdbcTemplate jdbc;
	
	@Override
	public int registerUser(User user) {
		String sql = "insert into users(user_FirstName, user_LastName, user_Name, user_Password) values(?,?,?,?)";
		try{
			  return jdbc.update(sql, user.getUser_FirstName(), user.getUser_LastName(),user.getUser_Mail(),user.getUser_Password());
		  }catch (Exception e) { System.out.println(e); }
		 
		return 0;
	}

	@Override
	public User checkUserLoginUser(String userName, String userPassword) {
		String sql = "select * from users where user_Name='"+userName+"' and user_Password='"+userPassword+"'";
		 List<User> user = jdbc.query(sql, new EmpMapper());
		    return user.size() > 0 ? user.get(0) : null; 
	}
	
	class EmpMapper implements RowMapper<User> {
		  public User mapRow(ResultSet rs, int arg1) throws SQLException {
			  User user = new User();
			  user.setUser_Id(rs.getInt(1));
			  user.setUser_FirstName(rs.getString(2));
			  user.setUser_LastName(rs.getString(3));
			  user.setUser_Mail(rs.getString(3));
		    return user;
		  }
	  }

	@Override
	public List<UserDetails> getUserDetailsById(int user_Id) {
		String sql = "select a.user_Id, a.user_FirstName, a.user_LastName, a.user_Name,\r\n"
				+ "b.inves_Name, b.inves_Market_Cap, b.inves_Holding, b.inves_Amount,\r\n"
				+ "c.acc_Wallet, c.acc_Investment, c.acc_Profit, b.inves_Buying_Amt \r\n"
				+ "from  users a inner join inves_table b on\r\n"
				+ "a.user_Id = b.user_Id inner join  account c on\r\n"
				+ "c.userId = b.user_Id where a.user_Id = "+user_Id+"";
		
		return jdbc.query(sql,new RowMapper<UserDetails>(){    
	        public UserDetails mapRow(ResultSet rs, int row) throws SQLException {    
	        	UserDetails user=new UserDetails();    
	        	user.setUser_Id(rs.getInt(1));
	        	user.setUser_FirstName(rs.getString(2));
	        	user.setUser_LastName(rs.getString(3));
	        	user.setUser_Name(rs.getString(4));
	        	user.setInves_Name(rs.getString(5));
	        	user.setInves_Market_Cap(rs.getDouble(6));
	        	user.setInves_Holding(rs.getDouble(7));
	        	user.setInves_Amount(rs.getDouble(8));
	        	user.setAcc_Wallet(rs.getDouble(9));
	        	user.setAcc_Invested(rs.getDouble(10));
	        	user.setAcc_Profit(rs.getDouble(11));
	        	user.setInve_Buying_Amt(rs.getDouble(12));
	            return user;    
	        }    
	    });  
	}

}
