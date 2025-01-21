package controller;

import model.*;
import service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;

public class UserController {
    @FXML private TextField usernameField, passwordField;
    @FXML private ChoiceBox<Role> roleField;
    @FXML private TableView<User> userTable;

    private final UserService userService = new UserService();
    private final RoleService roleService = new RoleService();

    @FXML
    private void initialize() {
        roleField.getItems().setAll(roleService.getAllRoles());
    }

    @FXML
    private void handleAddUser() {
        User user = new User();
        user.setUsername(usernameField.getText());
        user.setPassword(passwordField.getText());
        user.setRole(roleField.getValue());
        
        userService.addUser(user);
        userTable.getItems().add(user);
    }
}
