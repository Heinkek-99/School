package contract;

import java.util.List;

import model.PaymentDetail;

public interface IPaymentDetail {
	void addPaymentDetail(PaymentDetail paymentDetail);
    List<PaymentDetail> getDetailsByPaymentId(int paymentId);
}
