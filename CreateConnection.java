package swing;
import java.sql.*;

public class CreateConnection {
	public static Connection createConnection()
	{
		try{
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("");
			return con;
		}
		catch(Exception ex)
		{
			System.out.println(ex);
		}
		return null;
	}

}
