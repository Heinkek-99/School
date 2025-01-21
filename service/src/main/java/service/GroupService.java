package service;

import java.util.List;

import dao.GroupDAO;
import model.Group;

public class GroupService {
	private final GroupDAO groupDAO;

	public GroupService() {
		this.groupDAO = new GroupDAO();
	}
	
    public GroupService(GroupDAO groupDAO) {
        this.groupDAO = groupDAO;
    }

    public void addGroup(Group group) {
        groupDAO.addGroup(group);
    }

    public Group getGroupById(int groupId) {
        return groupDAO.getGroupById(groupId);
    }

    public List<Group> getAllGroups() {
        return groupDAO.getAllGroups();
    }

    public void archiveGroup(int groupId) {
        groupDAO.archiveGroup(groupId);
    }
}
