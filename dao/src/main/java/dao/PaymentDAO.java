package dao;

import java.sql.*;
import java.util.List;

import contract.IPayment;
import model.Payment;
import utils.DbConnectionManager;

public class PaymentDAO implements IPayment{

	@Override
    public void addPayment(Payment payment) {
        String sql = "INSERT INTO payments (amount, method, parent_id, is_archived) VALUES (?, ?, ?, ?)";
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            stmt.setDouble(1, payment.getAmount());
            stmt.setString(2, payment.getMethod());
            stmt.setInt(3, payment.getParent().getParentId());
            stmt.setBoolean(4, payment.isArchived());
            stmt.executeUpdate();
            ResultSet rs = stmt.getGeneratedKeys();
            if (rs.next()) payment.setPaymentId(rs.getInt(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Payment getPaymentById(int paymentId) {
        String sql = "SELECT * FROM payments WHERE payment_id = ?";
        Payment payment = new Payment();
        try (Connection conn = DbConnectionManager.getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, paymentId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                payment.setPaymentId(rs.getInt("payment_id"));
                payment.setAmount(rs.getDouble("amount"));
                payment.setMethod(rs.getString("method"));
                // Fetch parent using ParentDAO
                payment.setArchived(rs.getBoolean("is_archived"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return payment;
    }

	@Override
	public List<Payment> getPaymentsByParentId(int parentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void archivePayment(int paymentId) {
		// TODO Auto-generated method stub
		
	}

	public List<Payment> getAllPayments() {
		// TODO Auto-generated method stub
		return null;
	}

}
