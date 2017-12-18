package com.sngpay.dao;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class USSDDBController {

	private Connection connection;
	
	public boolean ifVerifiedUser(String argMobileNumber) throws SQLException{
		try{
		Class.forName("com.mysql.jdbc.Driver");  
		connection=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sngpay","root","admin");  
		//here sonoo is database name, root is username and password 
		String query = "select * from customer_detail cd"+
                " where cd.MOBILENUMBER =  "  + argMobileNumber + " and cd.VERIFIED='Y'";
		Statement stmt=connection.createStatement();  
		ResultSet rs=stmt.executeQuery(query);  
		
		while(rs.next())  
		 return true;
		connection.close();  
		}catch(Exception e){ 
			e.printStackTrace();
			connection.close();
			return false;
		}  
		return false;
	}
	
	public UserVerificationDBData getTemporaryPIN(String argMobileNumber) throws SQLException{
		try{
		Class.forName("com.mysql.jdbc.Driver");  
		connection=DriverManager.getConnection(  
		"jdbc:mysql://localhost:3306/sngpay","root","admin");  
		//here sonoo is database name, root is username and password 
		String query1 = "select up.TEMP_PIN from user_temporary_profile up"+
                " where up.MOBILENUMBER =  "  + argMobileNumber + " and up.EXPIRED='N'";
		
		String query2 = "select cd.VERIFIED from customer_detail cd where MOBILENUMBER = "+argMobileNumber;
		
		Statement stmt=connection.createStatement();  
		
		UserVerificationDBData userVerificationDBData = new UserVerificationDBData();
		
		ResultSet rs=stmt.executeQuery(query2);  
		while(rs.next())  {
			
			userVerificationDBData.setVerificationChar(rs.getString("VERIFIED"));
		}
		
	    rs=stmt.executeQuery(query1); 
	    while(rs.next())  {
			
			userVerificationDBData.setPIN(rs.getBigDecimal("TEMP_PIN"));
		}
		
	    connection.close();
	    return userVerificationDBData;
		}catch(Exception e){ 
			e.printStackTrace();
			connection.close();
			return null;
		}  
	}
	
	public boolean udateTemporaryStatus(String argMobileNumber, String argPIN) throws SQLException{
		
		try{
			Class.forName("com.mysql.jdbc.Driver");  
			connection=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/sngpay","root","admin");  
			//here sonoo is database name, root is username and password 
			connection.setAutoCommit(false);
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String currentDate = dateFormat.format(new Date());
			String query = "update user_temporary_profile SET EXPIRED = 'Y',updated_date = str_to_date('"+currentDate+"','%Y-%m-%D %H:%i:%s'), updated_by='USSD'"+
	                " where EXPIRED='N' and MOBILENUMBER =  "  + argMobileNumber ;
			Statement stmt=connection.createStatement();  
			stmt.executeUpdate(query);  
			
			query = "INSERT into USSDLOGIN(MOBILENUMBER,PIN,VALID,CREATED_DATE,CREATED_BY) values("+argMobileNumber+","+
					argPIN+",'Y',str_to_date('"+currentDate+"','%Y-%m-%D %H:%i:%s'),'USSD');";
			stmt.executeUpdate(query);
			
			query = "INSERT into CUSTOMER_ACCOUNT_MASTER(MOBILENUMBER,BALANCE,CREATED_DATE,CREATED_BY) values("+argMobileNumber+","+
					BigDecimal.ZERO+",str_to_date('"+currentDate+"','%Y-%m-%D %H:%i:%s'),'USSD');";
			stmt.executeUpdate(query);
			
			connection.commit();
			stmt.close();
			connection.close();
			return true;
			}catch(Exception e){ 
				e.printStackTrace();
				connection.rollback();
				connection.close();
				return false;
			}  
			
	}
	
	public BigDecimal getBalance(String argMobileNumber) throws SQLException{
		
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection connection=DriverManager.getConnection(  
					"jdbc:mysql://localhost:3306/sngpay","root","admin");
			
			SimpleDateFormat dateFormat = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
			String currentDate = dateFormat.format(new Date());
			
			String query = "select BALANCE from CUSTOMER_ACCOUNT_MASTER where MOBILENUMBER =" + argMobileNumber;
			Statement stmt=connection.createStatement();  
			ResultSet rs = stmt.executeQuery(query);  
			while (rs.next()) {
				return rs.getBigDecimal("BALANCE");
				
			}
			
			stmt.close();
			connection.close();
			return BigDecimal.ZERO;
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return BigDecimal.ZERO;  
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			if(connection != null) 
				connection.close();
			return BigDecimal.ZERO;
		}
		
		
	}
	
}
