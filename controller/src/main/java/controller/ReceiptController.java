package controller;

import javafx.fxml.FXML;
import javafx.scene.control.*;
import model.Payment;
import model.Receipt;
import service.PaymentService;
import service.ReceiptService;

public class ReceiptController {
    @FXML private TableView<Receipt> receiptTable;
    @FXML private ComboBox<Payment> paymentFilter;

    private final ReceiptService receiptService = new ReceiptService();
    private final PaymentService paymentService = new PaymentService();

    @FXML
    private void initialize() {
        paymentFilter.getItems().setAll(paymentService.getAllPayments());
        loadAllReceipts();
    }

    private void loadAllReceipts() {
        receiptTable.getItems().setAll(receiptService.getAllReceipts());
    }
}
