package genericUtilities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
/**
 * this class contains methods related to Database connectivity
 * @author Brijraj
 */
public class DatabaseUtility {
	Connection con=null;
	
	public void connectToDB() throws SQLException
	{
		Driver driver=new Driver();
		DriverManager.registerDriver(driver);
		
		con = DriverManager.getConnection(IPathConstant.DBURL, IPathConstant.DBUserName, IPathConstant.DBPassword);
	}
	public void executeQueryAndVerify(String query,int colIndex,String expectedData) throws SQLException
	{
		
		Statement statement = con.createStatement();
		
		ResultSet result = statement.executeQuery(query);
		
		boolean flag=false;
		while (result.next())
		{
			String actual= result.getString(colIndex);
			if(actual.equals(expectedData))
			{
				flag=true;
				break;
			}
			
			
		}
		if(flag)
			System.out.println("--Data is verified--");
		else
			System.out.println("--data not present--");
		
	}
	
	public void updateDB(String query) throws SQLException
	{
		Statement statement = con.createStatement();
		
		int result = statement.executeUpdate(query);
		System.out.println(result+" lines affected");
	}
	public void closeConnection() throws SQLException
	{
		con.close();
	}

}
