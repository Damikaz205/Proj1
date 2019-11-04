package com.example.restapp;

import io.vavr.collection.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class StudentServiceTest {
    @Test
    public void getEmptyList() {
        final StudentService service = new StudentService();
        List<Student> students = service.getStudents();
        assertTrue(students.isEmpty());
    }

    @Test
    public void addStudent() {
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3","IP"));
        assertNotNull(created);
    }

    @Test
    public void addStudentIsReturned(){
        final StudentService service = new StudentService();
        final Student created = service.addStudent(new NewStudent("Student1", "1-2-3","IP"));
        final List<Student> all = service.getStudents();
        assertEquals("Student1",all.get(0).name);
    }

    @Test
    public void addStudentHasNewId(){
        final StudentService service = new StudentService();
        final Student s1 = service.addStudent(new NewStudent("Student1", "1-2-3","IP"));
        final Student s2 = service.addStudent(new NewStudent("Student2", "1-2-2","IP"));
        System.out.println(s1.id+" "+s2.id);
        assertNotEquals(s1.id,s2.id);
        assertEquals(2,service.getStudents().size());
    }
}