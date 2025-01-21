package service;

import java.util.List;

import dao.RoleDAO;
import model.Role;

public class RoleService {
    
	private final RoleDAO roleDAO = new RoleDAO();

	
	public List<Role> getAllRoles() {
        return roleDAO.getAllRoles();
    }
}
