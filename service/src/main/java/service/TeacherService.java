package service;

import java.util.List;

import dao.TeacherDAO;
import model.Teacher;

public class TeacherService {
	private final TeacherDAO teacherDAO;

    public TeacherService(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }

    public TeacherService() {
		this.teacherDAO = new TeacherDAO();
		// TODO Auto-generated constructor stub
	}

	public void addTeacher(Teacher teacher) {
        teacherDAO.addTeacher(teacher);
    }

    public Teacher getTeacherById(int teacherId) {
        return teacherDAO.getTeacherById(teacherId);
    }

    public List<Teacher> getTeachersByGroupId(int groupId) {
        return teacherDAO.getTeachersByGroupId(groupId);
    }

    public void archiveTeacher(int teacherId) {
        teacherDAO.archiveTeacher(teacherId);
    }
    
    public List<Teacher> getAllTeachers() {
        return teacherDAO.getAllTeachers();
    }
    
}
