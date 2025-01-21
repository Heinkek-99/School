package model;

import java.time.LocalDate;

import javafx.beans.property.StringProperty;

public class Student {
	private int studentId;
	private String matricule;
    private String name;
    private LocalDate dob;
    private int phone;
    private Group group;
    private Parent parent; // Object reference instead of parentId
    private int parentId;
    private String photoPath;
    private boolean isArchived;

    // Getters and Setters
    public Parent getParent() { return parent; }
    public void setParent(Parent parent) { this.parent = parent; }
    public Group getGroup() { return group; }
    public void setGroup(Group group) { this.group = group; }
	/**
	 * @return the photoPath
	 */
	public String getPhotoPath() {
		return photoPath;
	}
	/**
	 * @param photoPath the photoPath to set
	 */
	public void setPhotoPath(String photoPath) {
		this.photoPath = photoPath;
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
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
		return dob;
	}
	/**
	 * @param dob the dob to set
	 */
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}
	/**
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}
	/**
	 * @param matricule the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}
	/**
	 * @return the phone
	 */
	public int getPhone() {
		return phone;
	}
	/**
	 * @param phone the phone to set
	 */
	public void setPhone(int phone) {
		this.phone = phone;
	}


}
