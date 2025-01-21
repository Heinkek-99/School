package contract;

import java.util.List;

import model.Student;

public interface IStudent {
	void addStudent(Student student);
    Student getStudentById(int studentId);
    List<Student> getStudentsByParentId(int parentId);
    List<Student> getStudentsByGroupId(int groupId);
    void archiveStudent(int studentId);
	List<Student> searchStudents(String keyword);
	List<Student> getAllStudents();
}
