package service;

import java.util.List;

import dao.PaymentDAO;
import dao.ReceiptDAO;
import model.Payment;
import model.Receipt;
import model.Student;

public class PaymentService {
	private final PaymentDAO paymentDAO;
    private final ReceiptDAO receiptDAO;

    public PaymentService(PaymentDAO paymentDAO, ReceiptDAO receiptDAO) {
        this.paymentDAO = paymentDAO;
        this.receiptDAO = receiptDAO;
    }

    public PaymentService() {
		this.paymentDAO = new PaymentDAO();
		// TODO Auto-generated constructor stub
		this.receiptDAO = new ReceiptDAO();
	}

	public void addPayment(Payment payment, List<Student> students) {
        paymentDAO.addPayment(payment);
        for (Student student : students) {
            Receipt receipt = new Receipt();
            receipt.setPayment(payment);
            receipt.setStudent(student);
            receipt.setAmount(payment.getAmount());
            receiptDAO.addReceipt(receipt);
        }
    }

    public List<Payment> getPaymentsByParentId(int parentId) {
        return paymentDAO.getPaymentsByParentId(parentId);
    }

    public void archivePayment(int paymentId) {
        paymentDAO.archivePayment(paymentId);
    }
    
    public List<Payment> getAllPayments() {
        return paymentDAO.getAllPayments();
    }

	public void addPayment(Payment payment) {
        paymentDAO.addPayment(payment);

		// TODO Auto-generated method stub
		
	}
}

