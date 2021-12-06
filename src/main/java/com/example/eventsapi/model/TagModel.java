package com.example.eventsapi.model;

import lombok.Data;

@Data
public class TagModel {
    private String name;
    private String name_srch;

    public TagModel(String name, String name_srch) {
        this.name = name;
        this.name_srch = name_srch;
    }
}
