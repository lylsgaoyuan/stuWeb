package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import unity.User;

public class UserDao {
	
	public User searchByUserNameAndPassword(User searchUser) {
		User user=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager
					.getConnection(
							"jdbc:mysql://localhost:3306/school?characterEncoding=utf-8",
							"root", "123456");
			Statement stat = conn.createStatement();
			ResultSet rs = stat
					.executeQuery("select * from users where username= '"
							+ searchUser.getUsername() + "' and password= '"
							+ searchUser.getPassword() + "'");
			if (rs.next()) {
				user=new User();
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				user.setPassword(rs.getString("password"));
			}
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}
}
