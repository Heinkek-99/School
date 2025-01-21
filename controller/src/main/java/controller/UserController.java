package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Role;
import model.User;
import service.RoleService;
import service.UserService;
import utils.PasswordUtil;

public class UserController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private ChoiceBox<Role> roleField;
    @FXML private TableView<User> userTable;
    @FXML private TableColumn<User, String> roleColumn;
    @FXML private Label errorLabel;

    private final UserService userService = new UserService();
    private final RoleService roleService = new RoleService();

    @FXML
    private void initialize() {
        roleField.getItems().addAll(roleService.getAllRoles());
        loadAllUsers();
    }

    @FXML
    private void handleAddUser() {
        try {
            validateInputs();
            
            User user = new User();
            user.setUsername(usernameField.getText());
            user.setPassword(PasswordUtil.hashPassword(passwordField.getText()));
            user.setRole(roleField.getValue());
            
            userService.addUser(user);
            loadAllUsers();
            clearFields();
            showSuccess("Utilisateur créé avec succès !");
            
        } catch (IllegalArgumentException e) {
            showError(e.getMessage());
        }
    }

    private void validateInputs() {
        if(usernameField.getText().isEmpty() || 
           passwordField.getText().isEmpty() || 
           roleField.getValue() == null) {
            throw new IllegalArgumentException("Tous les champs sont obligatoires");
        }
    }

    private void loadAllUsers() {
        userTable.getItems().setAll(userService.getAllUsers());
    }

    private void clearFields() {
        usernameField.clear();
        passwordField.clear();
        roleField.setValue(null);
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