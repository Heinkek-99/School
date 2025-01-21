package controller;

import model.*;
import service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class DocumentController {
    @FXML private TextField titleField, authorField, levelField;
    @FXML private TableView<Document> documentTable;
    @FXML private Label errorLabel;

    private final DocumentService documentService = new DocumentService();

    @FXML
    private void handleAddDocument() {
        Document doc = new Document();
        doc.setTitle(titleField.getText().trim());
        doc.setAuthor(authorField.getText());
        doc.setSchoolLevel(levelField.getText());
        
        documentService.addDocument(doc);
        documentTable.getItems().add(doc);
        showSuccess("Document ajouté !");
    }

    private void showError(String msg) { 
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setText(msg); 
    }

    private void showSuccess(String msg) { 
        errorLabel.setStyle("-fx-text-fill: green;");
        errorLabel.setText(msg); 
    }
}
