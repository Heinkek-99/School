package service;

import java.util.List;

import dao.StudentDAO;
import model.Student;

public class StudentService {
	private final StudentDAO studentDAO;

    public StudentService(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    public StudentService() {
		this.studentDAO = new StudentDAO();
		// TODO Auto-generated constructor stub
	}

	public void addStudent(Student student) {
        studentDAO.addStudent(student);
    }

    public Student getStudentById(int studentId) {
        return studentDAO.getStudentById(studentId);
    }

    public List<Student> getStudentsByParentId(int parentId) {
        return studentDAO.getStudentsByParentId(parentId);
    }

    public List<Student> getStudentsByGroupId(int groupId) {
        return studentDAO.getStudentsByGroupId(groupId);
    }

    public void archiveStudent(int studentId) {
        studentDAO.archiveStudent(studentId);
    }

    public List<Student> getAllStudents() {
        return studentDAO.getAllStudents();
    }

    public List<Student> searchStudents(String keyword) {
        return studentDAO.searchStudents(keyword);
    }
}
