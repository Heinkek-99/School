package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import contract.ITeacher;
import model.Group;
import model.Teacher;
import utils.DbConnectionManager;

public class TeacherDAO implements ITeacher{

	@Override
	public void addTeacher(Teacher teacher) {
	    String sql = "INSERT INTO teachers (name, dob, grade, address, phone, group_id, is_archived) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?)";
	    try (Connection conn = DbConnectionManager.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	        
	        stmt.setString(1, teacher.getName());
	        stmt.setDate(2, Date.valueOf(teacher.getDob())); // Convert LocalDate to SQL Date
	        stmt.setString(3, teacher.getGrade());
	        stmt.setString(4, teacher.getAddress());
	        stmt.setString(5, teacher.getPhone());
	        stmt.setInt(6, teacher.getGroup().getGroupId()); // Assuming `group` is an object with ID
	        stmt.setBoolean(7, teacher.isArchived());
	        
	        stmt.executeUpdate();
	        
	        // Set generated teacher ID
	        ResultSet rs = stmt.getGeneratedKeys();
	        if (rs.next()) {
	            teacher.setTeacherId(rs.getInt(1));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to add teacher", e);
	    }
	}

	@Override
	public Teacher getTeacherById(int teacherId) {
	    String sql = "SELECT * FROM teachers WHERE teacher_id = ?";
	    Teacher teacher = new Teacher();
	    
	    try (Connection conn = DbConnectionManager.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, teacherId);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            teacher.setTeacherId(rs.getInt("teacher_id"));
	            teacher.setName(rs.getString("name"));
	            teacher.setDob(rs.getDate("dob").toLocalDate());
	            teacher.setGrade(rs.getString("grade"));
	            teacher.setAddress(rs.getString("address"));
	            teacher.setPhone(rs.getString("phone"));
	            
	            // Fetch group using GroupDAO (assuming `group` is an object)
	            Group group = new Group();
	            group.setGroupId(rs.getInt("group_id"));
	            teacher.setGroup(group);
	            
	            teacher.setArchived(rs.getBoolean("is_archived"));
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch teacher", e);
	    }
	    return teacher;
	}

	@Override
	public List<Teacher> getTeachersByGroupId(int groupId) {
	    List<Teacher> teachers = new ArrayList<>();
	    String sql = "SELECT * FROM teachers WHERE group_id = ?";
	    
	    try (Connection conn = DbConnectionManager.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, groupId);
	        ResultSet rs = stmt.executeQuery();
	        
	        while (rs.next()) {
	            Teacher teacher = new Teacher();
	            teacher.setTeacherId(rs.getInt("teacher_id"));
	            teacher.setName(rs.getString("name"));
	            teacher.setDob(rs.getDate("dob").toLocalDate());
	            teacher.setGrade(rs.getString("grade"));
	            teacher.setAddress(rs.getString("address"));
	            teacher.setPhone(rs.getString("phone"));
	            
	            Group group = new Group();
	            group.setGroupId(rs.getInt("group_id"));
	            teacher.setGroup(group);
	            
	            teacher.setArchived(rs.getBoolean("is_archived"));
	            teachers.add(teacher);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to fetch teachers by group", e);
	    }
	    return teachers;
	}

	@Override
	public void archiveTeacher(int teacherId) {
	    String sql = "UPDATE teachers SET is_archived = TRUE WHERE teacher_id = ?";
	    
	    try (Connection conn = DbConnectionManager.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, teacherId);
	        stmt.executeUpdate();
	    } catch (SQLException e) {
	        e.printStackTrace();
	        throw new RuntimeException("Failed to archive teacher", e);
	    }
	}

	@Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        String sql = "SELECT * FROM teachers";
        // Implémentez JDBC...
        return teachers;
    }

}
