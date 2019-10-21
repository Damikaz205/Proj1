package com.example.IOProjekt;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@RestController
@RequestMapping("/puntky")
public class PuntkyController {
    CopyOnWriteArrayList<String> lista;
    @RequestMapping("/users")
    CopyOnWriteArrayList<String>  getUsers() {
lista.add("student");
return lista;
    }
    @RequestMapping(value ="/adduser", method = RequestMethod.POST)
    public int addUser(@RequestBody String name)
    {
        lista.add(name);
        return lista.size();
    }
}
