package com.sviat.jflower.models;

import lombok.Getter;
import lombok.Setter;

public class Answer {

    public Answer(String name, int code) {
        this.name = name;
        this.code = code;
    }

    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int code;
}
