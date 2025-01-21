package dao;

import java.sql.*;
import java.util.List;

import contract.IPaymentDetail;
import model.PaymentDetail;
import utils.DbConnectionManager;

public class PaymentDetailDAO implements IPaymentDetail{

    @Override
    public void addPaymentDetail(PaymentDetail paymentDetail) {
        String sql = "INSERT INTO payment_details (payment_id, student_id) VALUES (?, ?)";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, paymentDetail.getPayment().getPaymentId());
            stmt.setInt(2, paymentDetail.getStudent().getStudentId());
            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

	@Override
	public List<PaymentDetail> getDetailsByPaymentId(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
