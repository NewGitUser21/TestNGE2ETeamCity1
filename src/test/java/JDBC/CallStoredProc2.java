/**
 * 
 * A Java program demonstrates how to use JDBC to call a MySQL stored procedure
 * and retrieve values of the OUT parameter. 
 * 
 * 
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Types;

import com.mysql.cj.jdbc.CallableStatement;

/**
 * @author DELL
 *
 */
public class CallStoredProc2 {

	/**
	 * @param args
	 * @throws SQLException 
	 */
	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub
		
		//JDBC connection url
		//"jdbc:mysql://"+host+":"+port+"/databasename";
		//"jdbc:mysql://"+localhost+":"+3306+"/Employeeportal";
		
		//One way to connect to MySQL server
		
		//String host="localhost";
		//String port="3306";
		
		//Connection con = DriverManager.getConnection("jdbc:mysql://" + host + ":" + port + "/Employeeportal", "root", "Linkua@012022");
		
		
		//Another way to connect to MySQL server
		
		String dbURL = "jdbc:mysql://localhost:3306/Employeeportal";
		String user = "root";
		String password = "Linkua@012022";
		
		Connection con = DriverManager.getConnection(dbURL, user, password);
		
		CallableStatement s = (CallableStatement) con.prepareCall("{CALL `employeeportal`.`GetManagerID_Name`(?, ?, ?)}");
	
		s.registerOutParameter(2, Types.VARCHAR);
		s.registerOutParameter(3, Types.VARCHAR);
		
		//CALL `employeeportal`.`GetManagerID`('101349', @ManagerID);
		//select @ManagerID;
		
		s.setString(1, "289451");
		
		s.execute();
		
		String ManagerID = s.getString("ManagerID");
		String ManagerName = s.getString("ManagerName");
		
		System.out.println("Employee Supervisor ID and Name: " + ManagerID + " - " + ManagerName);
		
		s.close();
		
			
		}

	}


