/**
 * 
 * A Java program demonstrates how to create a MySQL stored procedure
 * using JDBC. 
 * 
 * 
 */
package JDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author DELL
 *
 */
public class CreateStoredProcBase {

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
		
		String queryDrop = "DROP PROCEDURE IF EXISTS delete_book";

		String queryCreate = "CREATE PROCEDURE delete_book (IN bookID INT) ";
		queryCreate += "BEGIN ";
		queryCreate += "DELETE FROM book WHERE book_id = bookID; ";
		queryCreate += "END";

		// drops the existing procedure if exists
		s.execute(queryDrop);

		// then creates a new stored procedure
		s.execute(queryCreate);

		s.close();

		System.out.println("Stored procedure created successfully!");
			
		}

	}


