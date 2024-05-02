package controller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.mindrot.bcrypt.BCrypt;

import models.UserModel;
import utils.StringUtils;


public class DatabaseController {
	public Connection getConnection() throws SQLException, ClassNotFoundException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/TimZyStore";
		String user = "root";
		String pass = "";
		return DriverManager.getConnection(url, user, pass);
	}
	
	public int getUserLogin(String username, String password) {
		try(Connection con = getConnection()){
			PreparedStatement stmnt = con.prepareStatement(StringUtils.LOGIN_QUERY);
			stmnt.setString(1, username);
			ResultSet result = stmnt.executeQuery();
			
			if (result.next()) {
				String hashedPasswordFromDb = result.getString("password");
				if (BCrypt.checkpw(password, hashedPasswordFromDb)) {
					String accountCategory = result.getString("account_category");
					if ("User".equals(accountCategory)) {
						return 1;//indicates that the user is customer
			
					} else if ("Admin".equals(accountCategory)) {
						return 2; //indicates that the user type is admin
					}
				}
			}
			return 0; // Username or password is incorrect
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace();
			return -1; // Server error or exception
		}
	}
	
	public int addNewUser (UserModel userModel) {
		try (Connection con = getConnection()) {
			PreparedStatement statement = con.prepareStatement(StringUtils.USER_REGISTRATION_QUERY);
			String hashedPassword = BCrypt.hashpw(userModel.getPassword(), BCrypt.gensalt());
			statement.setString(1, userModel.getUser_name());
			statement.setString(2, hashedPassword);
			statement.setString(3, userModel.getFull_name());
			statement.setString(4, userModel.getEmail());
			statement.setString(5, userModel.getPhone_number());
			statement.setString(6, userModel.getProfile_picture_image());
			int result = statement.executeUpdate();
			return result > 0 ? 1 : 0;
		} catch (SQLException | ClassNotFoundException ex) {
			ex.printStackTrace(); // Log the exception for debugging
			return -1;
		}
	}
	
	public void addProduct() {
		try (Connection con = getConnection()) {
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
