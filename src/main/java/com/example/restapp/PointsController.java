package com.example.restapp;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController @RequestMapping("/points")
public class PointsController {

    private List<String> users;

    public PointsController() {
        this.users = new CopyOnWriteArrayList<>();
        users.addAll(Arrays.asList("Larry Brayan", "Moe Lee", "Curly Sagan"));
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public List<String> getUsers(){
        //List<String> l = Arrays.asList("Larry", "Moe", "Curly");
        return users;
    }

    @RequestMapping(value = "/users", method = RequestMethod.POST)
    public int addUsers(@RequestBody String name){
        users.add(name);
        return users.size();
    }

}
