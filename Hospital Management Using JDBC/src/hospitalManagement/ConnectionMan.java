package hospitalManagement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMan {

	public Connection getConnection() throws SQLException,ClassNotFoundException
	{
		Class.forName("com.mysql.jdbc.Driver");
		Connection con =null;
		con =DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hospital","root","");
		if(con!=null)
		{
			return con;
		}
		else
		{
			return null;
		}
		
	}
	
	
}

