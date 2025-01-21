/**
 * 
 */
package model;

import java.time.LocalDate;

/**
 * 
 */
public class Receipt {
	private int receiptId;
    private String receiptNumber; // Unique receipt ID (e.g., "REC-2023-001")
    private LocalDate date;
    private double amount;
    private String paymentMethod;
    private Student student;      // Linked student
    private Payment payment;      // Linked payment
    private String filePath;      // Path to generated PDF

    // Getters and Setters
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
	/**
	 * @return the receiptNumber
	 */
	public String getReceiptNumber() {
		return receiptNumber;
	}
	/**
	 * @param receiptNumber the receiptNumber to set
	 */
	public void setReceiptNumber(String receiptNumber) {
		this.receiptNumber = receiptNumber;
	}
	/**
	 * @return the paymentMethod
	 */
	public String getPaymentMethod() {
		return paymentMethod;
	}
	/**
	 * @param paymentMethod the paymentMethod to set
	 */
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
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
	 * @return the student
	 */
	public Student getStudent() {
		return student;
	}
	/**
	 * @param student the student to set
	 */
	public void setStudent(Student student) {
		this.student = student;
	}
	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
	/**
	 * @return the receiptId
	 */
	public int getReceiptId() {
		return receiptId;
	}
	/**
	 * @param receiptId the receiptId to set
	 */
	public void setReceiptId(int receiptId) {
		this.receiptId = receiptId;
	}
}
