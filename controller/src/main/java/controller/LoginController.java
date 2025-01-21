package controller;

import model.*;
import service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private final UserService userService = new UserService();

    @FXML
    private void handleLogin() {
        User user = userService.getUserByUsername(usernameField.getText());
        if (user != null && user.getPassword().equals(passwordField.getText())) {
            loadDashboard(user);
        } else {
            showError("Identifiants invalides !");
        }
    }

    private void showError(String error) {
		// TODO Auto-generated method stub
		
	}

	private void loadDashboard(User user) { /* Navigate to main view */ }
}
