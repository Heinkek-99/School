/**
 * 
 */
package model;

/**
 * 
 */
public class Receipt {
	private int receiptId;
    private String receiptNumber; // Unique receipt ID (e.g., "REC-2023-001")
    private String date;
    private double amount;
    private String paymentMethod;
    private Student student;      // Linked student
    private Payment payment;      // Linked payment
    private String filePath;      // Path to generated PDF

    // Getters and Setters
    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }
}
