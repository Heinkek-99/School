package model;

import java.util.List;

public class Payment {
    private int paymentId;
    private double amount;
    private String method;
    private String paymentDate;
    private int parentId;
    private Parent parent; // Object reference instead of parentId
    private List<PaymentDetail> paymentDetails; // One payment → multiple students
    private boolean isArchived;

    
    public Parent getParent() { return parent; }
    public void setParent(Parent parent) { this.parent = parent; }
    public List<PaymentDetail> getPaymentDetails() { return paymentDetails; }
    public void setPaymentDetails(List<PaymentDetail> paymentDetails) { 
        this.paymentDetails = paymentDetails; 
    }
	
    /**
	 * @return the paymentId
	 */
	public int getPaymentId() {
		return paymentId;
	}
	/**
	 * @param paymentId the paymentId to set
	 */
	public void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}
	/**
	 * @return the amount
	 */
	public double getAmount() {
		return amount;
	}
	/**
	 * @param amount the amount to set
	 */
	public void setAmount(double amount) {
		this.amount = amount;
	}
	/**
	 * @return the method
	 */
	public String getMethod() {
		return method;
	}
	/**
	 * @param method the method to set
	 */
	public void setMethod(String method) {
		this.method = method;
	}
	/**
	 * @return the paymentDate
	 */
	public String getPaymentDate() {
		return paymentDate;
	}
	/**
	 * @param paymentDate the paymentDate to set
	 */
	public void setPaymentDate(String paymentDate) {
		this.paymentDate = paymentDate;
	}
	/**
	 * @return the isArchived
	 */
	public boolean isArchived() {
		return isArchived;
	}
	/**
	 * @param isArchived the isArchived to set
	 */
	public void setArchived(boolean isArchived) {
		this.isArchived = isArchived;
	}
    
}
