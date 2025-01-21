package controller;

import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.List;

import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.Group;
import model.Parent;
import model.Student;
import service.GroupService;
import service.ParentService;
import service.StudentService;

public class StudentController {
    // UI Components
    @FXML private TextField studentNameField, matriculeField, dobField, phoneField, parentIdField, groupIdField, searchField;
    @FXML private TableView<Student> studentTable;
    @FXML private TableColumn<Student, String> nameColumn;
    @FXML private Label errorLabel;

    // Services
    private final StudentService studentService = new StudentService();
    private final ParentService parentService = new ParentService();
    private final GroupService groupService = new GroupService();

    @FXML
    private void initialize() {
        // Configure table column to use the name property
        nameColumn.setCellValueFactory(cellData -> 
            new SimpleStringProperty(cellData.getValue().getName()));
        loadAllStudents();
    }

    private void loadAllStudents() {
        studentTable.getItems().setAll(studentService.getAllStudents());
    }

    @FXML
    private void handleAddStudent() {
        try {
            // Validate input fields
            validateInputs();

            // Create and populate student
            Student student = new Student();
            student.setName(studentNameField.getText().trim());
            student.setMatricule(matriculeField.getText().trim());
            student.setDob(LocalDate.parse(dobField.getText()));
            student.setPhone(Integer.parseInt(phoneField.getText()));
            Parent parent = parentService.getParentById(Integer.parseInt(parentIdField.getText()));
            Group group = groupService.getGroupById(Integer.parseInt(groupIdField.getText()));
            
            if (parent == null || group == null) {
                throw new IllegalArgumentException("Parent/Group not found!");
            }
            
            student.setParent(parent);
            student.setGroup(group);
            
            // Save and refresh
            studentService.addStudent(student);
            clearFields();
            loadAllStudents();
            showSuccess("Étudiant ajouté avec succès !");
            
        } catch (DateTimeParseException e) {
            showError("Format de date invalide (YYYY-MM-DD)");
        } catch (NumberFormatException e) {
            showError("ID parent/groupe doit être un nombre !");
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        } catch (Exception e) {
            showError("Erreur système : " + e.getMessage());
        }
    }

    @FXML
    private void handleArchiveStudent() {
        try {
            Student selected = studentTable.getSelectionModel().getSelectedItem();
            if (selected == null) {
                throw new IllegalArgumentException("Aucun étudiant sélectionné !");
            }
            studentService.archiveStudent(selected.getStudentId());
            loadAllStudents();
            showSuccess("Étudiant archivé !");
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

    @FXML
    private void handleSearch() {
        try {
            List<Student> results = studentService.searchStudents(searchField.getText().trim());
            studentTable.getItems().setAll(results);
        } catch (Exception e) {
            showError("Erreur de recherche : " + e.getMessage());
        }
    }

    // Input validation helper
    private void validateInputs() {
        if (studentNameField.getText().trim().isEmpty() 
            || dobField.getText().isEmpty() 
            || parentIdField.getText().isEmpty() 
            || groupIdField.getText().isEmpty()) {
            throw new IllegalArgumentException("Tous les champs sont obligatoires !");
        }
    }

    private void clearFields() { 
    	/* Clear input fields */ 
    	    studentNameField.clear();
    	    dobField.clear();
    	    parentIdField.clear();
    	    groupIdField.clear();
    	    errorLabel.setText("");
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