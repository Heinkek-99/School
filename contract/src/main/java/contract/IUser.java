package contract;

import java.util.List;

import model.User;

public interface IUser {
	void addUser(User user);
    User getUserById(int userId);
    User getUserByUsername(String username);
    void updateUser(User user);
    void archiveUser(int userId);
    List<User> getAllUsers();
}
