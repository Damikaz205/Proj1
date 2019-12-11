package com.example.restapp;

import com.example.restapp.db.ScoreRepository;
import com.example.restapp.db.ScoreRow;
import com.example.restapp.db.StudentRepository;
import com.example.restapp.db.StudentRow;
import io.vavr.collection.List;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
public class StudentService {
    //List<Student> students = List.empty();

    private final StudentRepository studentRepository;
    private final ScoreRepository scoreRepository;

    public StudentService(StudentRepository studentRepository, ScoreRepository scoreRepository) {
        this.studentRepository = studentRepository;
        this.scoreRepository = scoreRepository;
    }

//    List<Student> getStudents() {
////        return this.students;
//        throw new UnsupportedOperationException();
//    }

    List<Student> getStudents() {
        return List.ofAll(this.studentRepository.findAll())
                .map(StudentRow::toStudent);
    }

//    private Function<StudentRow, Student> getStudentRowStudentFunction() {
//        return dbObj ->
//                new Student(
//                        dbObj.getId(),
//                        dbObj.getName(),
//                        dbObj.getNumber(),
//                        dbObj.getGroup1());
//    }

//    Student addStudent(NewStudent newStudent) {
//        Student created = new Student(students.size()+1, newStudent.name, newStudent.numer, newStudent.grupa);
//        students = students.prepend(created);
//        return created;
//    }

    Student addStudent(final NewStudent newStudent) {
        //throw new UnsupportedOperationException();
        return this.studentRepository.save(new StudentRow(
                newStudent.name,
                newStudent.numer,
                newStudent.grupa)).toStudent();
    }

    @Transactional
    public Optional<Student> changeNumber(long studentId, String newNumber) {
        final Optional<StudentRow> student =
                this.studentRepository.findById(studentId);
        return student.map(c -> {
            c.setNumber(newNumber);
            studentRepository.save(c);
            return c.toStudent();
        });
    }

    @Transactional
    public Optional<Integer> addScore(final long studentId, final Score score) {
        final Optional<StudentRow> student = this.studentRepository.findById(studentId);
        return student.map(c -> {
            int existingScore = List.ofAll(c.getScores()).foldLeft(0, (p, s) -> p + s.getScore());
            final ScoreRow newScore = new ScoreRow(score.score, score.comment, c);
            this.scoreRepository.save(newScore);
            return existingScore + score.score;
        });
    }
}