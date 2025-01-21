package controller;

import java.time.LocalDate;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Teacher;
import service.GroupService;
import service.TeacherService;

public class TeacherController {
	@FXML private TextField teacherNameField, dobField, gradeField, groupIdField;
    @FXML private TableView<Teacher> teacherTable;
    @FXML private Label errorLabel;

    private final TeacherService teacherService = new TeacherService();
    private final GroupService groupService = new GroupService();

    @FXML
    private void handleAddTeacher() {
        try {
            Teacher teacher = new Teacher();
            teacher.setName(teacherNameField.getText().trim());
            teacher.setDob(LocalDate.parse(dobField.getText()));
            teacher.setGrade(gradeField.getText());
            teacher.setGroup(groupService.getGroupById(Integer.parseInt(groupIdField.getText())));
            
            teacherService.addTeacher(teacher);
            teacherTable.getItems().add(teacher);
            clearFields();
            showSuccess("Enseignant ajouté !");
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }
    
    private void showSuccess(String string) {
		// TODO Auto-generated method stub
		
	}

	private void showError(String message) {
		// TODO Auto-generated method stub
		
	}

	private void clearFields() {
        teacherNameField.clear();
        dobField.clear();
        gradeField.clear();
        groupIdField.clear();
        errorLabel.setText("");
    }
}
