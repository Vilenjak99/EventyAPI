package com.example.eventsapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "authors")
public class AuthorModel {
    @Id
    private String id;
    @Field("email")
    private String email;
    @Field("username")
    private String username;
    @Field("password")
    private String password;
    @Field("slug")
    private String slug;
    @Field("tags")
    private List<TagModel> tags;
    @Field("date_created")
    private Date dateCreated;
}
