package com.example.springboot;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.UUID;

import org.springframework.stereotype.Component;

@Component
public class DbConnection {
	
	Connection con;
	DbConnection(String user, String pwd) throws ClassNotFoundException{
		Class.forName("oracle.jdbc.driver.OracleDriver");
		try {
			con=DriverManager.getConnection(  
					"jdbc:oracle:thin:@localhost:1521:xe",user,pwd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	  
	  
	  
	//;  
	  
	 /*
	ResultSet rs=stmt.executeQuery("select * from emp");  
	while(rs.next())  
	System.out.println(rs.getInt(1)+"  "+rs.getString(2)+"  "+rs.getString(3));  
	  */
	
	
	  
	void createTeam(Team team) throws SQLException{
		Statement stmt=con.createStatement();
		
		
		String createst = "INSERT into Team (name, id) values ("+team.getName()+","+team.getId()+");";
				
		stmt.execute(createst);
	}
	
	void createDev(Developer dev) throws SQLException{
		Statement stmt=con.createStatement();
		
		String id = UUID.randomUUID().toString();
		String createst = "INSERT into Developer (name, id,phone, team_id) values ("
		+dev.getName()+","+id+","+dev.getPhone()+","+dev.getTeam_id()+");";
		
		stmt.execute(createst);
	}
	

	void close() throws SQLException{
		con.close();
	}

}
