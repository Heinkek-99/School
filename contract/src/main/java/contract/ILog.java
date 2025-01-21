package contract;

import java.util.List;

import model.Log;

public interface ILog {
    void logAction(Log log);
    List<Log> getLogsByUserId(int userId);
}
