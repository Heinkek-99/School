package contract;

import java.util.List;

import model.Receipt;

public interface IReceipt {
	void addReceipt(Receipt receipt);
    List<Receipt> getReceiptsByPaymentId(int paymentId);
    List<Receipt> getReceiptsByStudentId(int studentId);
}
