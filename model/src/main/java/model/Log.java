package model;

public class Log {
	private int logId;
    private int userId;
    private String actionDescription;
    private String actionTime;
    private User user;
	
    // Getters and Setters

    /**
	 * @return the logId
	 */
	public int getLogId() {
		return logId;
	}
	/**
	 * @param logId the logId to set
	 */
	public void setLogId(int logId) {
		this.logId = logId;
	}
	/**
	 * @return the userId
	 */
	public int getUserId() {
		return userId;
	}
	/**
	 * @param userId the userId to set
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}
	/**
	 * @return the actionDescription
	 */
	public String getActionDescription() {
		return actionDescription;
	}
	/**
	 * @param actionDescription the actionDescription to set
	 */
	public void setActionDescription(String actionDescription) {
		this.actionDescription = actionDescription;
	}
	/**
	 * @return the actionTime
	 */
	public String getActionTime() {
		return actionTime;
	}
	/**
	 * @param actionTime the actionTime to set
	 */
	public void setActionTime(String actionTime) {
		this.actionTime = actionTime;
	}
	/**
	 * @return the user
	 */
	public User getUser() {
		return user;
	}
	/**
	 * @param user the user to set
	 */
	public void setUser(User user) {
		this.user = user;
	}

  
}
