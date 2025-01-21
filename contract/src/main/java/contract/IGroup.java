package contract;

import java.util.List;

import model.Group;

public interface IGroup {
	void addGroup(Group group);
    Group getGroupById(int groupId);
    List<Group> getAllGroups();
    void updateGroup(Group group);
    void archiveGroup(int groupId);
}
