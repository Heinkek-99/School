package controller;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import model.User;
import service.UserService;
import utils.PasswordUtil;

public class LoginController {
    @FXML private TextField usernameField;
    @FXML private PasswordField passwordField;
    @FXML private Label errorLabel;

    private final UserService userService = new UserService();

    @FXML
    private void handleLogin() {
        String username = usernameField.getText();
        String password = passwordField.getText();

        if(username.isEmpty() || password.isEmpty()) {
            showError("Tous les champs sont obligatoires");
            return;
        }

        User user = userService.getUserByUsername(username);
        if(user != null && PasswordUtil.checkPassword(password, user.getPassword())) {
            loadDashboard(user);
        } else {
            showError("Identifiants invalides !");
        }
    }

    private void showError(String error) {
        errorLabel.setStyle("-fx-text-fill: red;");
        errorLabel.setText(error);
    }

    private void loadDashboard(User user) {
        // Implémentation la navigation vers le tableau de bord
    	try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/view/MainDashboard.fxml"));
            Parent root = loader.load();
            
            DashboardController dashboardController = loader.getController();
            dashboardController.initialize(user);
            
            Stage stage = (Stage) usernameField.getScene().getWindow();
            stage.setScene(new Scene(root));
            stage.setTitle("Tableau de bord - " + user.getRole().getRoleName());
            
        } catch (IOException e) {
            showError("Erreur de chargement du tableau de bord");
            e.printStackTrace();
        }
    }
}