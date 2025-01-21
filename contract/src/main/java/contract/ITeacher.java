package contract;

import java.util.List;

import model.Teacher;

public interface ITeacher {
	void addTeacher(Teacher teacher);
    Teacher getTeacherById(int teacherId);
    List<Teacher> getTeachersByGroupId(int groupId);
    void archiveTeacher(int teacherId);
	List<Teacher> getAllTeachers();
}
