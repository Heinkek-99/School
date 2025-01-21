package controller;

import model.User;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class DashboardController {
	@FXML private VBox adminPanel;
    @FXML private VBox secretaryPanel;
    @FXML private VBox accountantPanel;
    @FXML private VBox directorPanel;

    private User currentUser;

    public void initialize(User user) {
        this.currentUser = user;
        configureAccess();
    }

    private void configureAccess() {
        // Masquer tous les panneaux d'abord
        adminPanel.setVisible(false);
        secretaryPanel.setVisible(false);
        accountantPanel.setVisible(false);
        directorPanel.setVisible(false);
    	
        switch(currentUser.getRole().getRoleName().toUpperCase()) {
        case "ADMIN":
            adminPanel.setVisible(true);
            break;
        case "SECRETARY":
            secretaryPanel.setVisible(true);
            break;
        case "ACCOUNTANT":
            accountantPanel.setVisible(true);
            break;
        case "DIRECTOR":
            directorPanel.setVisible(true);
            break;
        default:
            throw new IllegalArgumentException("Rôle non reconnu");
        }
    }
    
    // Méthodes de navigation
    @FXML
    private void handleLogout() {
        // Implémenter la déconnexion
    }
    
}
