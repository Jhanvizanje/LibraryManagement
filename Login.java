package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.ArrayList;
import java.text.ParseException;
import javax.swing.*;


public class Login  {
	public static void login()
	{
		JFrame f=new JFrame("Login");
		JLabel l1,l2;
		l1=new JLabel("Username:");
		l1.setBounds(30,15,100,30);
		l2=new JLabel("Password:");
		l2.setBounds(30,50,100,30);
		
		JTextField f_user =new JTextField();
		f_user.setBounds(110,15,200,30);
		JTextField f_pass = new JTextField();
		f_pass.setBounds(110,50,200,30);
		
		JButton btn_login =new JButton("Login");
		btn_login.setBounds(130,90,80,25);
		btn_login.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e)
			{
				String username=f_user.getText();
				String password=f_pass.getText();
				if(username.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter your username");
				}
				else if(password.equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter your password");
				}
				else
				{
					Connection conn=CreateConnection.createConnection();
					try
					{
						Statement stmt=conn.createStatement();
						stmt.executeUpdate("use javaproject");
						String s1=("select * from users where u_name='"+username+"' and pwd='"+password+"'");
						ResultSet rs=stmt.executeQuery(s1);
						if(!rs.next())
						{
							JOptionPane.showMessageDialog(null, "Invalid username/password pair");
						}
						else
						{
							
							 f.dispose();
				               rs.beforeFirst();
							while(rs.next())
							{								
								String admin=rs.getString("isAdmin");
								int uid=rs.getInt("u_id");
								System.out.println(admin+":"+uid);
								if(admin.equals("yes"))
								{
									Admin.adminAccess();
								}
								else
								{
									User.userAccess(uid);
								
								}
							}
						}
						
					}
					catch(Exception ex)
					{
						ex.printStackTrace();
					}
				}
				
			
		}
		});
		f.add(l1);
		f.add(l2);
		f.add(btn_login);
		f.add(f_user);
		f.add(f_pass);
		f.setSize(400,180);
		f.setLayout(null);
		f.setLocationRelativeTo(null);
		f.setVisible(true);
	}

	

}
