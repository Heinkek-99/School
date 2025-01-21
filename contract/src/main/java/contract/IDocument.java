package contract;

import java.util.List;

import model.Document;

public interface IDocument {
	void addDocument(Document document);
    Document getDocumentById(int documentId);
    List<Document> getAllDocuments();
    void updateDocument(Document document);
    void archiveDocument(int documentId);
}
