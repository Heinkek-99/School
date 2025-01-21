package dao;

import java.sql.*;
import java.util.List;

import contract.IUser;
import model.User;
import utils.DbConnectionManager;

public class UserDAO implements IUser {

    @Override
    public void addUser(User user) {
        String sql = "INSERT INTO users (username, password, role_id) VALUES (?, ?, ?)";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getRole().getRoleId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public User getUserById(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

	 @Override
	    public User getUserByUsername(String username) {
	        String sql = "SELECT * FROM users WHERE username = ?";
	        User user = new User();
	        try (Connection conn = DbConnectionManager.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, username);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                user.setUserId(rs.getInt("user_id"));
	                user.setUsername(rs.getString("username"));
	                user.setPassword(rs.getString("password"));
	                // Fetch role using RoleDAO
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return user;
	    }
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void archiveUser(int userId) {
		// TODO Auto-generated method stub
		
	}

	public List<User> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
