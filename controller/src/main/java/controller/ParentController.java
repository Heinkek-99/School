package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Parent;
import service.ParentService;

import java.util.List;

public class ParentController {
    @FXML private TextField parentNameField, contactField, phoneField;
    @FXML private TableView<Parent> parentTable;
    @FXML private Label errorLabel;

    private final ParentService parentService = new ParentService();

    @FXML
    private void handleAddParent() {
        Parent parent = new Parent();
        parent.setName(parentNameField.getText().trim());
        parent.setContactInfo(contactField.getText());
        parent.setNumberPhone(Integer.parseInt(phoneField.getText()));
        
        parentService.addParent(parent);
        parentTable.getItems().add(parent);
        showSuccess("Parent ajouté !");
    }
    
	private void showSuccess(String string) {
		// TODO Auto-generated method stub
		
	}

	private void clearFields() {
	    parentNameField.clear();
	    contactField.clear();
	    phoneField.clear();
	    errorLabel.setText("");
	}
}
