package databank.dao;

import java.io.Serializable;
import java.util.List;

import jakarta.ejb.EJB;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import databank.model.StudentPojo;
import databank.service.StudentService;


/**
 * Description:  Implements the C-R-U-D API for the database
 * 
 *
 */

@Named
@ApplicationScoped
public class StudentDaoImpl implements StudentDao, Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    protected StudentService studentService;

    @Override
    public List<StudentPojo> readAllStudents() {
        return studentService.readAllStudents();
    }

    @Override
    public StudentPojo createStudent(StudentPojo student) {
        return studentService.createStudent(student);
    }

    @Override
    public StudentPojo readStudentById(int studentId) {
        return studentService.readStudentById(studentId);
    }

    @Override
    public StudentPojo updateStudent(StudentPojo studentWithUpdates) {
        return studentService.updateStudent(studentWithUpdates);
    }

    @Override
    public void deleteStudentById(int studentId) {
        studentService.deleteStudentById(studentId);
    }
}
