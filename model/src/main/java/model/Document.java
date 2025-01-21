package model;

public class Document {
	private int documentId;
    private String title;
    private String author;
    private String edition;
    private String schoolLevel;
    private boolean isArchived;
	
    /**
	 * @return the documentId
	 */
	public int getDocumentId() {
		return documentId;
	}
	/**
	 * @param documentId the documentId to set
	 */
	public void setDocumentId(int documentId) {
		this.documentId = documentId;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * @param author the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * @return the edition
	 */
	public String getEdition() {
		return edition;
	}
	/**
	 * @param edition the edition to set
	 */
	public void setEdition(String edition) {
		this.edition = edition;
	}
	/**
	 * @return the schoolLevel
	 */
	public String getSchoolLevel() {
		return schoolLevel;
	}
	/**
	 * @param schoolLevel the schoolLevel to set
	 */
	public void setSchoolLevel(String schoolLevel) {
		this.schoolLevel = schoolLevel;
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
