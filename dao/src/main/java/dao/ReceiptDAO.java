package dao;

import java.sql.*;
import java.util.List;

import contract.IReceipt;
import model.Receipt;
import utils.DbConnectionManager;

public class ReceiptDAO implements IReceipt {

	 @Override
	    public void addReceipt(Receipt receipt) {
	        String sql = "INSERT INTO receipts (receipt_number, date, amount, payment_method, student_id, payment_id, file_path) VALUES (?, ?, ?, ?, ?, ?, ?)";
	        try (Connection conn = DbConnectionManager.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {
	            stmt.setString(1, receipt.getReceiptNumber());
	            stmt.setDate(2, Date.valueOf(receipt.getDate()));
	            stmt.setDouble(3, receipt.getAmount());
	            stmt.setString(4, receipt.getPaymentMethod());
	            stmt.setInt(5, receipt.getStudent().getStudentId());
	            stmt.setInt(6, receipt.getPayment().getPaymentId());
	            stmt.setString(7, receipt.getFilePath());
	            stmt.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }

	@Override
	public List<Receipt> getReceiptsByPaymentId(int paymentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Receipt> getReceiptsByStudentId(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

}
