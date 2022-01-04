package com.example.eventsapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;

@Data
@Document(collection = "visits")
public class VisitModel {
    @Id
    private String id;
    @Field("event")
    private EventModel event;
    @Field("date")
    private Date date;
    @Field("user")
    private AuthorModel user;
}
