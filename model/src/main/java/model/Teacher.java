package model;

import java.time.LocalDate;

public class Teacher {
	private int teacherId;
    private String name;
    private LocalDate Dob;
    private String phone;
    private String Address;
    private String Grade;
    private Group group; // Object reference instead of groupId
    private boolean isArchived;

    // Getters and Setters
    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }
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
	/**
	 * @return the teacherId
	 */
	public int getTeacherId() {
		return teacherId;
	}
	/**
	 * @param teacherId the teacherId to set
	 */
	public void setTeacherId(int teacherId) {
		this.teacherId = teacherId;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the dob
	 */
	public LocalDate getDob() {
		return Dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		Dob = dob;
	}
	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}
	/**
	 * @return the address
	 */
	public String getAddress() {
		return Address;
	}
	/**
	 * @param address the address to set
	 */
	public void setAddress(String address) {
		Address = address;
	}
	/**
	 * @return the grade
	 */
	public String getGrade() {
		return Grade;
	}
	/**
	 * @param grade the grade to set
	 */
	public void setGrade(String grade) {
		Grade = grade;
	}
}
