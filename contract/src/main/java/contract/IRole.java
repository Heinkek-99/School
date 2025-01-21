package contract;

import java.util.List;

import model.Role;

public interface IRole {
    Role getRoleById(int roleId);
    List<Role> getAllRoles();
}
