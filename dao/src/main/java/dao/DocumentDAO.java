package dao;

import java.sql.Connection;
import java.sql.*;
import java.sql.ResultSet;
import java.util.List;

import contract.IDocument;
import model.Document;
import utils.DbConnectionManager;

public class DocumentDAO implements IDocument{

    @Override
    public void addDocument(Document document) {
        String sql = "INSERT INTO documents (title, author, edition, school_level, is_archived) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, document.getTitle());
            stmt.setString(2, document.getAuthor());
            stmt.setString(3, document.getEdition());
            stmt.setString(4, document.getSchoolLevel());
            stmt.setBoolean(5, document.isArchived());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Document getDocumentById(int documentId) {
        String sql = "SELECT * FROM documents WHERE document_id = ?";
        Document document = new Document();
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, documentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                document.setDocumentId(rs.getInt("document_id"));
                document.setTitle(rs.getString("title"));
                document.setAuthor(rs.getString("author"));
                document.setEdition(rs.getString("edition"));
                document.setSchoolLevel(rs.getString("school_level"));
                document.setArchived(rs.getBoolean("is_archived"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return document;
    }

	@Override
	public List<Document> getAllDocuments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateDocument(Document document) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void archiveDocument(int documentId) {
		// TODO Auto-generated method stub
		
	}

}
