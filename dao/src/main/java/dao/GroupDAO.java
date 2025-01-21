package dao;

import java.sql.*;
import java.util.List;

import contract.IGroup;
import model.Group;
import utils.DbConnectionManager;

public class GroupDAO implements IGroup{

	@Override
    public void addGroup(Group group) {
        String sql = "INSERT INTO groups (group_name) VALUES (?)";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, group.getGroupName());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) group.setGroupId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Group getGroupById(int groupId) {
        String sql = "SELECT * FROM groups WHERE group_id = ?";
        Group group = new Group();
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, groupId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                group.setGroupId(rs.getInt("group_id"));
                group.setGroupName(rs.getString("group_name"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return group;
    }

	@Override
	public List<Group> getAllGroups() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateGroup(Group group) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void archiveGroup(int groupId) {
		// TODO Auto-generated method stub
		
	}

}
