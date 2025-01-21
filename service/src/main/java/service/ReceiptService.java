package service;

import java.util.List;

import dao.ReceiptDAO;
import model.Receipt;

public class ReceiptService {
	private final ReceiptDAO receiptDAO;

    public ReceiptService(ReceiptDAO receiptDAO) {
        this.receiptDAO = receiptDAO;
    }

    public ReceiptService() {
		this.receiptDAO = new ReceiptDAO();
		// TODO Auto-generated constructor stub
	}

	public List<Receipt> getReceiptsByPaymentId(int paymentId) {
        return receiptDAO.getReceiptsByPaymentId(paymentId);
    }

    public List<Receipt> getReceiptsByStudentId(int studentId) {
        return receiptDAO.getReceiptsByStudentId(studentId);
    }

	public Receipt getAllReceipts() {
		// TODO Auto-generated method stub
		return null;
	}
}
