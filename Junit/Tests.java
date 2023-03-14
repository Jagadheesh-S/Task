package StudentTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Tests {
	
	private int id;
	private String name;
	private String address;
	private long phone;
	
	
	public Tests(int id, String name, String address, long phone) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.phone = phone;
	}
	
	
	public Tests() {
		super();
		// TODO Auto-generated constructor stub
	}


	//public static String driver_class ="com.mysql.cj.jdbc.Driver";
	public static String url = "jdbc:mysql://localhost:3306/jdbc_new";
	public static String user = "root";
	public static String pass = "jaga2001";
	
	//Insert
	public boolean insertvalue() 
	{ 
		try
		{		
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st=con.createStatement();
				String sql="insert into student1 values("+id+",'"+name+"','"+address+"',"+phone+")";
				st.execute(sql);
			st.close();
			con.close();
			return true;
			
		} catch (Exception ex) {
			//System.out.println("Message: " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}
	}
	
	
	//Update
	public boolean update()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st=con.createStatement();		
			String sql="update student1 set Name='"+name+"', Phone="+phone+" ,Address='"+address+"' where id="+id; 
			st.execute(sql);
			st.close();
			con.close();
			return true;
			
		} catch (Exception ex) {
			//System.out.println("Message: " + ex.getMessage());
			ex.printStackTrace();
			return false;
		}

	}
	
	
	//Retrive
	public int retrive()
	{
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection(url, user, pass);
			Statement st=con.createStatement();
			String sql="select * from student1"; 
			ResultSet rs=st.executeQuery(sql);
			int count =0;
			while(rs.next()) {
				System.out.print("ID: "+rs.getInt("id")+" , ");
				System.out.println("Name: "+rs.getString("name")+" , ");
				System.out.print("Address: "+rs.getString("address")+" , ");
				System.out.print("Phone: "+rs.getLong("phone")+" , ");
				count++;
				System.out.println("\n");
			}
			st.close();
			con.close();
			return count;
			
		} catch (Exception ex) {
			System.out.println("Message: " + ex.getMessage());
			return 0;
		}
	}

		//Delete
		public boolean delete(int id)
		{
			try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection con = DriverManager.getConnection(url, user, pass);
					Statement st=con.createStatement();
					String sql="delete from student1 "+"where id = '" +id+"' "; 
					st.execute(sql);
					System.out.println("Delete SuccessFully "+id);
					st.close();
					con.close();
					return true;
					
				} catch (Exception ex) {
					System.out.println("Message: " + ex.getMessage());
					return false;
				}
		}
	}


