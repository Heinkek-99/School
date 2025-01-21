package service;

import java.util.List;

import dao.ParentDAO;
import dao.StudentDAO;
import model.Parent;
import model.Student;

public class ParentService {
	private final ParentDAO parentDAO;
    private final StudentDAO studentDAO;

    public ParentService(ParentDAO parentDAO, StudentDAO studentDAO) {
        this.parentDAO = parentDAO;
        this.studentDAO = studentDAO;
    }

    public ParentService() {
		this.parentDAO = new ParentDAO();
		this.studentDAO = new StudentDAO();
		// TODO Auto-generated constructor stub
	}

	public void addParent(Parent parent) {
        parentDAO.addParent(parent);
    }

    public Parent getParentById(int parentId) {
        return parentDAO.getParentById(parentId);
    }

    public List<Parent> getAllParents() {
        return parentDAO.getAllParents();
    }

    public void updateParent(Parent parent) {
        parentDAO.updateParent(parent);
    }

    public void archiveParent(int parentId) {
        List<Student> children = studentDAO.getStudentsByParentId(parentId);
        for (Student child : children) {
            studentDAO.archiveStudent(child.getStudentId());
        }
        parentDAO.archiveParent(parentId);
    }

}
