package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import contract.IUser;
import model.Role;
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
        String sql = "SELECT u.*, r.role_name FROM users u JOIN roles r ON u.role_id = r.role_id WHERE user_id = ?";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                return mapUserWithRole(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de l'utilisateur", e);
        }
        return null;
    }

//	 @Override
//	    public User getUserByUsername(String username) {
//	        String sql = "SELECT * FROM users WHERE username = ?";
//	        User user = new User();
//	        try (Connection conn = DbConnectionManager.getConnection();
//	             PreparedStatement stmt = conn.prepareStatement(sql)) {
//	            stmt.setString(1, username);
//	            ResultSet rs = stmt.executeQuery();
//	            if (rs.next()) {
//	                user.setUserId(rs.getInt("user_id"));
//	                user.setUsername(rs.getString("username"));
//	                user.setPassword(rs.getString("password"));
//	                // Fetch role using RoleDAO
//	            }
//	        } catch (SQLException e) {
//	            e.printStackTrace();
//	        }
//	        return user;
//	    }
    
    @Override
    public User getUserByUsername(String username) {
        String sql = "SELECT u.*, r.role_name FROM users u JOIN roles r ON u.role_id = r.role_id WHERE username = ?";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            if(rs.next()) {
                return mapUserWithRole(rs);
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération de l'utilisateur", e);
        }
        return null;
    }
    
    
    @Override
    public void updateUser(User user) {
        String sql = "UPDATE users SET username = ?, password = ?, role_id = ? WHERE user_id = ?";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, user.getUsername());
            stmt.setString(2, user.getPassword());
            stmt.setInt(3, user.getRole().getRoleId());
            stmt.setInt(4, user.getUserId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la mise à jour de l'utilisateur", e);
        }
    }

    @Override
    public void archiveUser(int userId) {
        String sql = "UPDATE users SET is_archived = TRUE WHERE user_id = ?";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de l'archivage de l'utilisateur", e);
        }
    }

    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT u.*, r.role_name FROM users u JOIN roles r ON u.role_id = r.role_id";
        
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql);
             ResultSet rs = stmt.executeQuery()) {
            
            while(rs.next()) {
                users.add(mapUserWithRole(rs));
            }
        } catch (SQLException e) {
            throw new RuntimeException("Erreur lors de la récupération des utilisateurs", e);
        }
        return users;
    }

    private User mapUserWithRole(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setUsername(rs.getString("username"));
        user.setPassword(rs.getString("password"));
        
        Role role = new Role();
        role.setRoleId(rs.getInt("role_id"));
        role.setRoleName(rs.getString("role_name"));
        
        user.setRole(role);
        return user;
    }

}
