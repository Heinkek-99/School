package service;

import java.util.List;

import dao.RoleDAO;
import dao.UserDAO;
import model.Role;
import model.User;

public class UserService {
	private final UserDAO userDAO;
    private final RoleDAO roleDAO;

    public UserService(UserDAO userDAO, RoleDAO roleDAO) {
        this.userDAO = userDAO;
        this.roleDAO = roleDAO;
    }

    public UserService() {
		this.userDAO = new UserDAO();
		this.roleDAO = new RoleDAO();
		// TODO Auto-generated constructor stub
	}

	public void addUser(User user) {
        userDAO.addUser(user);
    }

    public User getUserByUsername(String username) {
        return userDAO.getUserByUsername(username);
    }

    public void updateUser(User user) {
        userDAO.updateUser(user);
    }

    public void archiveUser(int userId) {
        userDAO.archiveUser(userId);
    }

    public Role getUserRole(int userId) {
        return roleDAO.getRoleById(userDAO.getUserById(userId).getRole().getRoleId());
    }
    
    public List<User> getAllUsers() {
        return userDAO.getAllUsers();
    }
}
