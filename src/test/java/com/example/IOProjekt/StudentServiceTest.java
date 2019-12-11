package com.example.restapp;

import com.example.restapp.db.ScoreRepository;
import com.example.restapp.db.StudentRepository;
import io.vavr.collection.List;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static junit.framework.TestCase.assertTrue;
import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {

    @Autowired
    private StudentRepository repository;

    @Autowired
    private ScoreRepository scoreRepository;

    @Test
    public void getEmptyList() {
        final StudentService service = new StudentService(repository, scoreRepository);
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }

    @Test
    public void addStudent() {
        final StudentService service = new StudentService(repository, scoreRepository);
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        assertNotNull(created);
    }

    @Test
    public void addStudentIsReturned() {
        final StudentService service = new StudentService(repository, scoreRepository);
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final List<Student> all = service.getStudents();
        assertEquals("Student1", all.get(0).name);
    }

    @Test
    public void addStudentHasNewId() {
        final StudentService service = new StudentService(repository, scoreRepository);
        final Student s1 = service.addStudent(new NewStudent("Student1", "1-2-3", "IP"));
        final Student s2 = service.addStudent(new NewStudent("Student2", "1-2-2", "IP"));
        System.out.println(s1.id + " " + s2.id);
        assertNotEquals(s1.id, s2.id);
        assertEquals(2, service.getStudents().size());
    }

    @After
    public void cleanAfterTest() {
        this.repository.deleteAll();
    }
}