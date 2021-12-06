package com.example.eventsapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "events")
public class EventModel {
    @Id
    private String id;
    @Field("slug")
    private String slug;
    @Field("tags")
    private List<TagModel> tags;
    @Field("author")
    private AuthorModel author;
    @Field("number_of_visits")
    private Long numberOfVisits;
    @Field("date_crated")
    private Date dateCreated;
    @Field("event_localization")
    private EventLocalizationModel eventLocalization;
}
