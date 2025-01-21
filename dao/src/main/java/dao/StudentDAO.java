/**
 * 
 */
package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import contract.IStudent;
import model.Group;
import model.Parent;
import model.Student;
import utils.DbConnectionManager;

/**
 * 
 */
public class StudentDAO implements IStudent {

	@Override
    public void addStudent(Student student) {
        String sql = "INSERT INTO students (name, dob, phone, parent_id, group_id, photo_path, is_archived) VALUES (?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, student.getName());
            stmt.setDate(2, Date.valueOf(student.getDob()));
            stmt.setInt(3, student.getPhone());
            stmt.setInt(4, student.getParent().getParentId());
            stmt.setInt(5, student.getGroup().getGroupId());
            stmt.setString(6, student.getPhotoPath());
            stmt.setBoolean(7, student.isArchived());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) student.setStudentId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

//   @Override
//    public Student getStudentById(int studentId) {
//        String sql = "SELECT * FROM students WHERE student_id = ?";
//        Student student = new Student();
//        try (Connection conn = DbConnectionManager.getConnection();
//             PreparedStatement stmt = conn.prepareStatement(sql)) {
//            stmt.setInt(1, studentId);
//            ResultSet rs = stmt.executeQuery();
//            if (rs.next()) {
//                student.setStudentId(rs.getInt("student_id"));
//                student.setName(rs.getString("name"));
//                // Fetch Parent and Group using their DAOs
//            }
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return student;
//    }

	public Student getStudentById(int studentId) {
	    String sql = "SELECT s.*, p.*, g.* FROM students s " +
	                 "LEFT JOIN parents p ON s.parent_id = p.parent_id " +
	                 "LEFT JOIN groups g ON s.group_id = g.group_id " +
	                 "WHERE s.student_id = ?";
	    
	    Student student = new Student();
	    try (Connection conn = DbConnectionManager.getConnection();
	         PreparedStatement stmt = conn.prepareStatement(sql)) {
	        
	        stmt.setInt(1, studentId);
	        ResultSet rs = stmt.executeQuery();
	        
	        if (rs.next()) {
	            // Map Student
	            student.setStudentId(rs.getInt("student_id"));
	            student.setName(rs.getString("s.name"));
	            
	            // Map Parent
	            Parent parent = new Parent();
	            parent.setParentId(rs.getInt("parent_id"));
	            parent.setName(rs.getString("p.name"));
	            student.setParent(parent);

	            // Map Group
	            Group group = new Group();
	            group.setGroupId(rs.getInt("group_id"));
	            group.setGroupName(rs.getString("group_name"));
	            student.setGroup(group);
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	    return student;
	}
	
	@Override
	public List<Student> getStudentsByParentId(int parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getStudentsByGroupId(int groupId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archiveStudent(int studentId) {
		// TODO Auto-generated method stub
		
	}

    @Override
    public List<Student> getAllStudents() {
        List<Student> students = new ArrayList<>();
        String sql = "SELECT * FROM students";
        // Implémentez la logique JDBC...
        return students;
    }

    @Override
    public List<Student> searchStudents(String keyword) {
        List<Student> results = new ArrayList<>();
        String sql = "SELECT * FROM students WHERE name LIKE ?";
        // Implémentez la recherche...
        return results;
    }

}
