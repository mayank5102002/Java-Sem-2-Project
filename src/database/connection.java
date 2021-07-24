package database;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

public class connection {

	Connection con = null;
	java.sql.PreparedStatement pst;
	public static Connection dbConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/students","root","");
			return conn;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
	public static Connection teacherNamesConnect() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/teachernames","root","");
			return conn;
		}catch(Exception e) {
			System.out.println(e);
			return null;
		}
	}
	
}