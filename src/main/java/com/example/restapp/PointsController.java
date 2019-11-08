package com.example.restapp;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/points")
public class PointsController {

    private StudentService service = new StudentService();

    private List<String> users;

    public PointsController() {
        this.users = new CopyOnWriteArrayList<>();
        users.addAll(Arrays.asList("Larry Brayan", "Moe Lee", "Curly Sagan"));
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
