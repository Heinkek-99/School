package dao;

import java.sql.*;
import java.util.List;

import contract.ILog;
import model.Log;
import utils.DbConnectionManager;

public class LogDAO implements ILog{

	@Override
	public void logAction(Log log) {
	    String sql = "INSERT INTO logs (user_id, action_description) VALUES (?, ?)";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, log.getUserId());
            stmt.setString(2, log.getActionDescription());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }		

	@Override
	public List<Log> getLogsByUserId(int userId) {
		// TODO Auto-generated method stub
		return null;
	}

}
