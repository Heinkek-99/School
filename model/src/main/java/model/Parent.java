package model;

import java.util.List;

public class Parent {
	private int parentId;
    private String name;
    private String contactInfo;
    private int numberPhone ;
    private List<Student> children; // One parent → multiple students
    private List<Payment> payments; // One parent → multiple payments
    // Getters and Setters
    
    public int getParentId() { return parentId; }
    public void setParentId(int parentId) { this.parentId = parentId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getContactInfo() { return contactInfo; }
    public void setContactInfo(String contactInfo) { this.contactInfo = contactInfo; }
    public List<Student> getChildren() { return children; }
    public void setChildren(List<Student> children) { this.children = children; }
    
    /**
	 * @return the numberPhone
	 */
	public int getNumberPhone() {
		return numberPhone;
	}
	/**
	 * @param numberPhone the numberPhone to set
	 */
	public void setNumberPhone(int numberPhone) {
		this.numberPhone = numberPhone;
	}
}
