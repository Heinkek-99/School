package model;

public class PaymentDetail {
	 private int paymentDetailId;
	    private Payment payment;
	    private Student student;

	    // Getters and Setters
	    public Payment getPayment() { return payment; }
	    public void setPayment(Payment payment) { this.payment = payment; }
	    public Student getStudent() { return student; }
	    public void setStudent(Student student) { this.student = student; }
}
