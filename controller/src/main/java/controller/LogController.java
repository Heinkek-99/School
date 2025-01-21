package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Log;
import service.LogService;

public class LogController {
	 @FXML private TableView<Log> logTable;
	    private final LogService logService = new LogService();

	    @FXML
	    private void initialize() {
	        logTable.getItems().setAll(logService.getAllLogs());
	    }
}
