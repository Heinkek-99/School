package dao;

import java.sql.*;
import java.util.List;

import contract.IRole;
import model.Role;
import utils.DbConnectionManager;

public class RoleDAO implements IRole {

	 @Override
	    public Role getRoleById(int roleId) {
	        String sql = "SELECT * FROM roles WHERE role_id = ?";
	        Role role = new Role();
	        try (Connection conn = DbConnectionManager.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setInt(1, roleId);
	            ResultSet rs = stmt.executeQuery();
	            if (rs.next()) {
	                role.setRoleId(rs.getInt("role_id"));
	                role.setRoleName(rs.getString("role_name"));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return role;
	    }

	@Override
	public List<Role> getAllRoles() {
		// TODO Auto-generated method stub
		return null;
	}

}
