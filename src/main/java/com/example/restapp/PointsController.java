package com.example.restapp;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/points")
public class PointsController {

    private final StudentService service;

//    private StudentService service = new StudentService(repository);

    private List<String> users;

    public PointsController(StudentService service) {
        this.service = service;
//        this.users = new CopyOnWriteArrayList<>();
//        users.addAll(Arrays.asList("Larry Brayan", "Moe Lee", "Curly Sagan"));
    }

    @RequestMapping(value = "/students", method = RequestMethod.GET,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public List<Student> getUsers() {
        //List<String> l = Arrays.asList("Larry", "Moe", "Curly");
        return this.service.getStudents().asJava();
    }

    @RequestMapping(value = "/students", method = RequestMethod.POST,
            consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public Student addUsers(@RequestBody NewStudent student) {
        return this.service.addStudent(student);
    }


}
