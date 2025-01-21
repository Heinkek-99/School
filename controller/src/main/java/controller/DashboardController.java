package controller;

import model.User;
import javafx.fxml.FXML;
import javafx.scene.layout.VBox;

public class DashboardController {
    @FXML private VBox adminPanel, directorPanel;
    private User currentUser;

    public void initialize(User user) {
        this.currentUser = user;
        configureUI();
    }

    private void configureUI() {
        if (currentUser.getRole().getRoleName().equals("ADMIN")) {
            adminPanel.setVisible(true);
        } else if (currentUser.getRole().getRoleName().equals("DIRECTOR")) {
            directorPanel.setVisible(true);
        }
    }
}
