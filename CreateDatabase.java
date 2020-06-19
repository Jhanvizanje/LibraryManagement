package swing;
import java.sql.*;


public class CreateDatabase {
		
	public static void createDatabase()
	{
		try {
			Connection con=CreateConnection.createConnection();
			Statement stmt=con.createStatement();	
			stmt.addBatch("USE javaproject");
			//stmt.addBatch("create table users (u_id int not null primary key auto_increment,u_name varchar(30),pwd varchar(10),isAdmin varchar(3))");
//			stmt.addBatch("create table books (b_id int not null primary key auto_increment,b_name varchar(30),a_name varchar(30),price int(5),stock int(5),ava_stock int(5))");
//			stmt.addBatch("create table issuedBooks (ib_id int not null primary key auto_increment,b_id int,u_id int,issued_date date,return_date date,period int,fine int)");
//			
			stmt.executeBatch();
			stmt.executeUpdate("insert into users values(1,'admin','xyz','yes')");
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	
}


