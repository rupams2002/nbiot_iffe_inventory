package com.Ligado.nbiot_iffe_inventory.controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.Ligado.nbiot_iffe_inventory.Entity.FiberStatus;
import com.Ligado.nbiot_iffe_inventory.Entity.FiberStatusResponse;

public class Services {

	

    public FiberStatusResponse getNbiot_IFFE_All_Inventory() throws SQLException{
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} 

		
		Connection connection = null;
		try {
		    //String url = "jdbc:mysql://10.10.70.167:3306/ligado";
		    String url = "jdbc:mysql://10.10.130.172:3306/Ligado";
		    connection = DriverManager.getConnection(url, "mh3568", "MH$pbxdev123");
		}
		catch (Exception e){
		    e.printStackTrace();
		}		
		
		
		String sql = "SELECT * FROM Ligado.nbiot_iffe_inventory";
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		
		Integer fiber_id = null;
		String fwd_link_op_status = null;
		String fwd_link_status = null;
		
		String lhcp_link_op_status = null;
		String lhcp_link_status = null;
		
		String rhcp_link_op_status = null;
		String rhcp_link_status = null;
		
		List<FiberStatus> data = new ArrayList<FiberStatus>(); 

		while (resultSet.next()) {
			  fiber_id = resultSet.getInt("fiber_id");  
			  fwd_link_op_status = resultSet.getString("fwd_link_op_status");  
			  fwd_link_status = resultSet.getString("fwd_link_status");  

			  lhcp_link_op_status = resultSet.getString("lhcp_link_op_status");  
			  lhcp_link_status = resultSet.getString("lhcp_link_status");  

			  rhcp_link_op_status = resultSet.getString("rhcp_link_op_status");  
			  rhcp_link_status = resultSet.getString("rhcp_link_status");
			  
			  data.add(new FiberStatus(fiber_id, fwd_link_op_status, fwd_link_status, lhcp_link_op_status, lhcp_link_status, rhcp_link_op_status, rhcp_link_status));
		}

		connection.close();
		
        return new FiberStatusResponse("OperationSucceeded", data);			  
	}
    
    
    public FiberStatusResponse getNbiot_IFFE_Single_Inventory(int fiberID) throws SQLException{
		
		try {
		    Class.forName("com.mysql.cj.jdbc.Driver");
		} 
		catch (ClassNotFoundException e) {
		    e.printStackTrace();
		} 

		
		Connection connection = null;
		try {
		    //String url = "jdbc:mysql://10.10.70.167:3306/ligado";
		    String url = "jdbc:mysql://10.10.130.172:3306/Ligado";
		    connection = DriverManager.getConnection(url, "mh3568", "MH$pbxdev123");
		}
		catch (Exception e){
		    e.printStackTrace();
		}		
		
		
		String sql = "SELECT * FROM Ligado.nbiot_iffe_inventory WHERE fiber_id = " + fiberID;
		Statement statement = connection.createStatement();
		ResultSet resultSet = statement.executeQuery(sql);
		
		
		Integer fiber_id = null;
		String fwd_link_op_status = null;
		String fwd_link_status = null;
		
		String lhcp_link_op_status = null;
		String lhcp_link_status = null;
		
		String rhcp_link_op_status = null;
		String rhcp_link_status = null;
		
		List<FiberStatus> data = new ArrayList<FiberStatus>(); 

		while (resultSet.next()) {
			  fiber_id = resultSet.getInt("fiber_id");  
			  fwd_link_op_status = resultSet.getString("fwd_link_op_status");  
			  fwd_link_status = resultSet.getString("fwd_link_status");  

			  lhcp_link_op_status = resultSet.getString("lhcp_link_op_status");  
			  lhcp_link_status = resultSet.getString("lhcp_link_status");  

			  rhcp_link_op_status = resultSet.getString("rhcp_link_op_status");  
			  rhcp_link_status = resultSet.getString("rhcp_link_status");
			  
			  data.add(new FiberStatus(fiber_id, fwd_link_op_status, fwd_link_status, lhcp_link_op_status, lhcp_link_status, rhcp_link_op_status, rhcp_link_status));
		}

		connection.close();
		
        return new FiberStatusResponse("OperationSucceeded", data);			  
	}
    
    
    
}
