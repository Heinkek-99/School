package controller;

import model.*;
import service.*;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import java.util.List;

public class PaymentController {
    @FXML private TextField amountField, parentIdField;
    @FXML private ChoiceBox<String> paymentMethodField;
    @FXML private TableView<Payment> paymentTable;
    @FXML private Label errorLabel;

    private final PaymentService paymentService = new PaymentService();
    private final ParentService parentService = new ParentService();

    @FXML
    private void initialize() {
        paymentMethodField.getItems().addAll("CASH", "CHEQUE");
    }

    @FXML
    private void handleProcessPayment() {
        try {
            Payment payment = new Payment();
            payment.setAmount(Double.parseDouble(amountField.getText()));
            payment.setMethod(paymentMethodField.getValue());
            payment.setParent(parentService.getParentById(Integer.parseInt(parentIdField.getText())));
            
            paymentService.addPayment(payment);
            paymentTable.getItems().add(payment);
            showSuccess("Paiement enregistré !");
        } catch (Exception e) {
            showError(e.getMessage());
        }
    }

	private void showError(String message) {
		// TODO Auto-generated method stub
		
	}

	private void showSuccess(String string) {
		// TODO Auto-generated method stub
		
	}
}
