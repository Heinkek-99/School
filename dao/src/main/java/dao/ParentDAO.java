package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import contract.IParent;
import model.Parent;
import model.Student;
import utils.DbConnectionManager;

public class ParentDAO implements IParent {

    // Dependency: Inject StudentDAO to handle student operations
    private final StudentDAO studentDAO;

    public ParentDAO() {
        this.studentDAO = new StudentDAO();
    }

    @Override
    public void addParent(Parent parent) {
        String sql = "INSERT INTO parents (name, contact_info, number_phone) VALUES (?, ?, ?)";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setString(1, parent.getName());
            stmt.setString(2, parent.getContactInfo());
            stmt.setInt(3, parent.getNumberPhone());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) parent.setParentId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Parent getParentById(int parentId) {
        String sql = "SELECT * FROM parents WHERE parent_id = ?";
        Parent parent = new Parent();
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, parentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                parent.setParentId(rs.getInt("parent_id"));
                parent.setName(rs.getString("name"));
                parent.setContactInfo(rs.getString("contact_info"));
                parent.setNumberPhone(rs.getInt("number_phone"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return parent;
    }
	@Override
	public List<Parent> getAllParents() {
		List<Parent> parents = new ArrayList<>();
        String sql = "SELECT * FROM parents";
        
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Parent parent = new Parent();
                parent.setParentId(rs.getInt("parent_id"));
                parent.setName(rs.getString("name"));
                parent.setContactInfo(rs.getString("contact_info"));
                parent.setNumberPhone(rs.getInt("number_phone"));
                parents.add(parent);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to fetch parents", e);
        }
        return parents;
	}

	@Override
	public void updateParent(Parent parent) {
        String sql = "UPDATE parents SET name = ?, contact_info = ?, number_phone = ? WHERE parent_id = ?";
        
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            
            stmt.setString(1, parent.getName());
            stmt.setString(2, parent.getContactInfo());
            stmt.setInt(3, parent.getNumberPhone());
            stmt.setInt(4, parent.getParentId());
            
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to update parent", e);
        }		
	}

	@Override
    public void archiveParent(int parentId) {
        // Use transaction for atomicity
        try (Connection conn = DbConnectionManager.getConnection()) {
            conn.setAutoCommit(false);  // Start transaction
            
            try {
                // 1. Archive all children (students)
                List<Student> children = studentDAO.getStudentsByParentId(parentId);
                for (Student child : children) {
                    studentDAO.archiveStudent(child.getStudentId());
                }
                
                // 2. Archive the parent
                String sql = "UPDATE parents SET is_archived = TRUE WHERE parent_id = ?";
                try (PreparedStatement stmt = conn.prepareStatement(sql)) {
                    stmt.setInt(1, parentId);
                    stmt.executeUpdate();
                }
                
                conn.commit();  // Commit transaction
            } catch (SQLException e) {
                conn.rollback();  // Rollback on error
                throw e;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to archive parent", e);
        }
    }

}
