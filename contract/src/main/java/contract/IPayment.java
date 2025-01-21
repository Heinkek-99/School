package contract;

import java.util.List;

import model.Payment;

public interface IPayment {
	void addPayment(Payment payment);
    Payment getPaymentById(int paymentId);
    List<Payment> getPaymentsByParentId(int parentId);
    void archivePayment(int paymentId);
}
