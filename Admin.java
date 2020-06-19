package swing;
import java.awt.event.*;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import javax.swing.*;
import net.proteanit.sql.DbUtils;

public class Admin {
	public static void adminAccess()
	{
		JFrame f=new JFrame("Admin");
		
		
		JButton btn_bookslist=new JButton("List Books");
		btn_bookslist.setBounds(20,20,120,25);
		btn_bookslist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try
				{
					JFrame f=new JFrame("List Books");
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
		
		JButton btn_addbook=new JButton("Add Book");
		btn_addbook.setBounds(160,20,120,25);
		btn_addbook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try
				{
					//f.dispose();
					Connection con=CreateConnection.createConnection();
					Statement stmt=con.createStatement();
					JFrame f1=new JFrame("Add Book");
					JLabel l1,l2,l3,l4,l5;
					l1=new JLabel("Book name:");
					l1.setBounds(30,15,100,30);
					l2=new JLabel("Author name:");
					l2.setBounds(30,50,100,30);
					l3=new JLabel("Quantity:");
					l3.setBounds(30,85,100,30);
					l4=new JLabel("Price:");
					l4.setBounds(30,120,100,30);
					
					JTextField b_name=new JTextField();
					b_name.setBounds(110,15,200,30);
					JTextField a_name=new JTextField();
					a_name.setBounds(110,50,200,30);
					JTextField qnt=new JTextField();
					qnt.setBounds(110,85,200,30);
					JTextField price=new JTextField();
					price.setBounds(110,120,200,30);
					
					JButton add=new JButton("ADD");
					add.setBounds(130,150,80,25);
					add.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							try
							{
								String bname=b_name.getText();
								String aname=a_name.getText();
								String qnt1=qnt.getText();
								String price1=price.getText();
								String s1=("insert into books values(null,'"+bname+"','"+aname+"',"+Integer.parseInt(price1)+","+Integer.parseInt(qnt1)+","+Integer.parseInt(qnt1)+")");
								stmt.executeUpdate(s1);
								JOptionPane.showMessageDialog(null, "inserted");
								
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
							}
						}
					});
					f1.add(add);
					f1.add(l1);
					f1.add(l2);
					f1.add(l3);
					f1.add(l4);
					f1.add(a_name);
					f1.add(b_name);
					f1.add(qnt);
					f1.add(price);
					f1.setSize(600,300);  
				    f1.setLayout(null);  
				    f1.setVisible(true); 
				    f1.setLocationRelativeTo(null);
						
					
					
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
		
		JButton btn_adduser=new JButton("Add user");
		btn_adduser.setBounds(300,20,120,25);
		btn_adduser.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try
				{
					//f.dispose();
					Connection con=CreateConnection.createConnection();
					Statement stmt=con.createStatement();
					JFrame f1=new JFrame("Add user");
					JLabel l1,l2,l3,l4,l5;
					l1=new JLabel("User name:");
					l1.setBounds(30,15,100,30);
					l2=new JLabel("password:");
					l2.setBounds(30,50,100,30);
					
					JTextField u_name=new JTextField();
					u_name.setBounds(110,15,200,30);
					JTextField u_pwd=new JTextField();
					u_pwd.setBounds(110,50,200,30);					
					
					JButton add=new JButton("ADD");
					add.setBounds(130,150,80,25);
					add.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							try
							{
								String uname=u_name.getText();
								String pwd=u_pwd.getText();								
								String s1=("insert into users values(null,'"+uname+"',\"abc@gmail.com\",'"+pwd+"','no')");
								stmt.executeUpdate(s1);
								JOptionPane.showMessageDialog(null, "user added successfully");
								
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
							}
						}
					});
					f1.add(add);
					f1.add(l1);
					f1.add(l2);					
					f1.add(u_name);
					f1.add(u_pwd);					
					f1.setSize(600,300);  
				    f1.setLayout(null);  
				    f1.setVisible(true); 
				    f1.setLocationRelativeTo(null);
					
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
		JButton btn_userslist=new JButton("List Users");
		btn_userslist.setBounds(20,65,120,25);
		btn_userslist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try
				{
					JFrame f=new JFrame("Users");
					Connection con=CreateConnection.createConnection();
					Statement stmt=con.createStatement();
					stmt.executeUpdate("use javaproject");
					ResultSet rs=stmt.executeQuery("select * from users");
					JTable users_list=new JTable();
					users_list.setModel(DbUtils.resultSetToTableModel(rs));
					JScrollPane scroll = new JScrollPane(users_list);
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

		JButton btn_issuebook=new JButton("Issue book");
		btn_issuebook.setBounds(160,65,120,25);
		btn_issuebook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try
				{
					//f.dispose();
					Connection con=CreateConnection.createConnection();
					Statement stmt=con.createStatement();
					JFrame f1=new JFrame("Issue book");
					JLabel l1,l2,l3,l4,l5;
					l1=new JLabel("UserId:");
					l1.setBounds(30,15,100,30);
					l2=new JLabel("BookId:");
					l2.setBounds(30,50,100,30);
					l4=new JLabel("Period:");
					l4.setBounds(30,85,100,30);
					
					JTextField u_id=new JTextField();
					u_id.setBounds(110,15,200,30);
					JTextField b_id=new JTextField();
					b_id.setBounds(110,50,200,30);
					JTextField period=new JTextField();
					period.setBounds(110,85,200,30);
					
					JButton add=new JButton("ADD");
					add.setBounds(130,150,80,25);
					
					add.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							try
							{
								
								String uid=u_id.getText();
								String bid=b_id.getText();
								String period1=period.getText();
								LocalDate myObj = LocalDate.now();
								String date1=myObj.toString();
								String s1=("insert into issuedbooks values(null,"+Integer.parseInt(bid)+","+Integer.parseInt(uid)+",'"+date1+"',null,"+Integer.parseInt(period1)+",null)");
								stmt.executeUpdate(s1);
								Statement stmt1=con.createStatement();
								int b_id=Integer.parseInt(bid);
								
								ResultSet rs1=stmt1.executeQuery("select * from books where b_id="+b_id+"");
								rs1.next();							
								int ava_qnt=rs1.getInt(6);
								ava_qnt--;
								stmt1.executeUpdate("update books set ava_stock="+ava_qnt+" where b_id="+b_id+"");
								JOptionPane.showMessageDialog(null, "inserted");
								
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
							}
						}
					});
					f1.add(add);
					f1.add(l1);
					f1.add(l2);
					f1.add(l4);
					f1.add(u_id);
					f1.add(b_id);
					f1.add(period);
					f1.setSize(600,300);  
				    f1.setLayout(null);  
				    f1.setVisible(true); 
				    f1.setLocationRelativeTo(null);
					
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});

		JButton btn_issuelist=new JButton("List IssuedBooks");
		btn_issuelist.setBounds(300,65,120,25);
		btn_issuelist.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try
				{
					JFrame f=new JFrame("Issued Books");
					Connection con=CreateConnection.createConnection();
					Statement stmt=con.createStatement();
					stmt.executeUpdate("use javaproject");
					ResultSet rs=stmt.executeQuery("select * from issuedbooks");
					JTable users_list=new JTable();
					users_list.setModel(DbUtils.resultSetToTableModel(rs));
					JScrollPane scroll = new JScrollPane(users_list);
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

		JButton btn_returnbook=new JButton("Return book");
		btn_returnbook.setBounds(160,105,120,25);
		btn_returnbook.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e){
				try
				{
					//f.dispose();
					Connection con=CreateConnection.createConnection();
					Statement stmt=con.createStatement();
					JFrame f1=new JFrame("Return book:");
					JLabel l1,l2,l3,l4,l5;
					l1=new JLabel("IssuedId:");
					l1.setBounds(30,15,100,30);
					
					
					JTextField u_id=new JTextField();
					u_id.setBounds(110,15,200,30);
					
					
					JButton add=new JButton("Return");
					add.setBounds(130,150,80,25);
					
					add.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent e){
							try
							{								
								String uid=u_id.getText();							
								
								String format = "yyyy-mm-dd";
								SimpleDateFormat sdf = new SimpleDateFormat(format);												
															
								
								Statement stmt1=con.createStatement();
								int u_id2=Integer.parseInt(uid);
								ResultSet rs1=stmt1.executeQuery("select * from issuedbooks where ib_id="+u_id2+" and return_date is null");
								if(rs1.next())
								{
									int period=rs1.getInt("period");
									int fine=0;
									
									String date1=rs1.getString("issued_date");
									java.util.Date dateObj1 = sdf.parse(date1);
									
									LocalDate dateobj2 = LocalDate.now();
									String date2=dateobj2.toString();
									java.util.Date dateObj2 = sdf.parse(date2);
									long diff = dateObj2.getTime() - dateObj1.getTime();
									 
									int diffDays = (int) (diff / (24 * 60 * 60 * 1000));
									System.out.println("date2:"+date2+" date1:"+date1+" days"+diffDays);
									
									if((diffDays-period)>0)									
									{
										fine=(diffDays-period)*5;
										JOptionPane.showMessageDialog(null, "Fine:"+fine);
									}
									
									int b_id=rs1.getInt("b_id");
									ResultSet rs2=stmt1.executeQuery("select * from books where b_id="+b_id+"");
									rs2.next();
									int ava_qnt=rs2.getInt("ava_stock");
									ava_qnt++;																								
									stmt1.executeUpdate("update books set ava_stock="+ava_qnt+" where b_id="+b_id+"");
									stmt1.executeUpdate("update issuedbooks set return_date='"+date2+"', fine="+fine+" where ib_id="+u_id2+"");
									JOptionPane.showMessageDialog(null, "Updated");								
								}
								else
								{
									JOptionPane.showMessageDialog(null, "No matching pair");	
								}
									
							}
							catch(Exception ex)
							{
								ex.printStackTrace();
							}
						}
					});
					f1.add(add);
					f1.add(l1);				
					f1.add(u_id);									
					f1.setSize(600,300);  
				    f1.setLayout(null);  
				    f1.setVisible(true); 
				    f1.setLocationRelativeTo(null);
					
				}
				
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			}
		});
		
		
		f.add(btn_returnbook);
		f.add(btn_adduser);
		f.add(btn_addbook);
		f.add(btn_bookslist);
		f.add(btn_userslist);
		f.add(btn_issuelist);
		f.add(btn_issuebook);
		 f.setSize(600,200);  
	    f.setLayout(null);  
	    f.setVisible(true); 
	    f.setLocationRelativeTo(null);
		
	}
	
	

}
