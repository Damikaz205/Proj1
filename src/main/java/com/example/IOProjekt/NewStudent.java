package com.example.restapp;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public class NewStudent {
    final String name;
    final String numer;
    final String grupa;

    @JsonCreator
    public NewStudent(@JsonProperty("name") String name, @JsonProperty("number") String numer, @JsonProperty("group1") String grupa) {
        this.name = name;
        this.numer = numer;
        this.grupa = grupa;
    }
}
