package service;

import java.util.List;

import dao.DocumentDAO;
import model.Document;

public class DocumentService {
	private final DocumentDAO documentDAO;

    public DocumentService(DocumentDAO documentDAO) {
        this.documentDAO = documentDAO;
    }

    public DocumentService() {
		this.documentDAO = new DocumentDAO();
		// TODO Auto-generated constructor stub
	}

	public void addDocument(Document document) {
        documentDAO.addDocument(document);
    }

    public Document getDocumentById(int documentId) {
        return documentDAO.getDocumentById(documentId);
    }

    public List<Document> getAllDocuments() {
        return documentDAO.getAllDocuments();
    }

    public void archiveDocument(int documentId) {
        documentDAO.archiveDocument(documentId);
    }
}
