package service;

import java.util.List;

import dao.LogDAO;
import model.Log;

public class LogService {
	private final LogDAO logDAO;

    public LogService(LogDAO logDAO) {
        this.logDAO = logDAO;
    }

    public LogService() {
		this.logDAO = new LogDAO();
		// TODO Auto-generated constructor stub
	}

	public void logAction(Log log) {
        logDAO.logAction(log);
    }

    public List<Log> getLogsByUserId(int userId) {
        return logDAO.getLogsByUserId(userId);
    }

	public Log getAllLogs() {
		// TODO Auto-generated method stub
		return null;
	}

}
