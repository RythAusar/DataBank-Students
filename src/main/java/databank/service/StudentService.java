package databank.service;

import java.util.List;

import jakarta.ejb.Singleton;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;

import databank.model.StudentPojo;

@Singleton
public class StudentService {

    @PersistenceContext
    protected EntityManager em;

    public List<StudentPojo> readAllStudents() {
        TypedQuery<StudentPojo> query =
            em.createNamedQuery(StudentPojo.STUDENT_FIND_ALL, StudentPojo.class);
        return query.getResultList();
    }

    public StudentPojo createStudent(StudentPojo student) {
        em.persist(student);
        return student;
    }

    public StudentPojo readStudentById(int studentId) {
        return em.find(StudentPojo.class, studentId);
    }

    public StudentPojo updateStudent(StudentPojo student) {
        return em.merge(student);
    }

    public void deleteStudentById(int studentId) {
        StudentPojo student = em.find(StudentPojo.class, studentId);
        if (student != null) {
            em.remove(student);
        }
    }
}