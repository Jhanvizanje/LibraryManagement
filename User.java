package swing;

import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.DbUtils;

import javax.swing.*;

public class User {
	public static void userAccess(int u_id){
		JFrame f=new JFrame("UserAccess");
		
		JButton btn_bookslist=new JButton("List Books");
		btn_bookslist.setBounds(20,20,120,25);
		btn_bookslist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try
				{
					JFrame f=new JFrame("Books");
					Connection con=CreateConnection.createConnection();
					Statement stmt=con.createStatement();
					stmt.executeUpdate("use javaproject");
					ResultSet rs=stmt.executeQuery("select * from books");
					JTable books_list=new JTable();
					books_list.setModel(DbUtils.resultSetToTableModel(rs));
					JScrollPane scroll = new JScrollPane(books_list);
					f.add(scroll);
					f.setSize(800,400);
					f.setVisible(true);
					f.setLocationRelativeTo(null);
				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
		

		JButton btn_viewbook=new JButton("My Books");
		btn_viewbook.setBounds(160,20,120,25);
		btn_viewbook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				String s1=("select * from issuedbooks where u_id="+u_id+"");
				try
				{
					JFrame f=new JFrame("My Books");
					Connection con=CreateConnection.createConnection();
					Statement stmt=con.createStatement();
					ResultSet rs=stmt.executeQuery(s1);
					if(rs.next())
					{
						rs.beforeFirst();
						JTable table=new JTable();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						JScrollPane scroll = new JScrollPane(table);
						f.add(scroll);
						f.setSize(800,400);
						f.setVisible(true);
						f.setLocationRelativeTo(null);
					}
					else
					{
						JOptionPane.showMessageDialog(null, "No issued books");
					}

				}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		   f.add(btn_bookslist); 
		    f.add(btn_viewbook); 
		    f.setSize(300,100);  
		    f.setLayout(null);  
		    f.setVisible(true); 
		    f.setLocationRelativeTo(null);
	}

}
