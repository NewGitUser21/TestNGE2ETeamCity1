/**
 * 
 * Fetching records from MySQL table using executeQuery
 * 
 * 
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author DELL
 *
 */
public class JDBCconnection {

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
	
		
		Statement s = con.createStatement();
		
		//ResultSet rs = s.executeQuery("select * from EmployeeInformation order by id");
		//ResultSet rs = s.executeQuery("select * from EmployeeReportLoc order by EmplocationID");
		ResultSet rs = s.executeQuery("select distinct E.id, E.name, E.dept, E.age, R.SupervisorID, R.SupervisorName from EmployeeInformation as E, EmployeeReportLoc as R\r\n"
				+ "where R.Empid=E.id and R.SupervisorID<>' '");
		

		
		while(rs.next())
		{
		//System.out.println(rs.getString("name"));
		//System.out.println(rs.getString("dept"));
			System.out.println(String.format(rs.getString("id") + " - " + 
		                                     rs.getString("name") + " - " + 
					                         rs.getString("dept") + " - " + 
		                                     rs.getInt("age") + " - " + 
					                         rs.getString("SupervisorID") + " - " + 
		                                     rs.getString("SupervisorName")));
			
			//String.format("%s - %s", rs.getString("first_name") + " " + rs.getString("last_name")
			
		}

	}

}
