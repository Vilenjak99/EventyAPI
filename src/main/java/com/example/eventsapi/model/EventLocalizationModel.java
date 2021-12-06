package com.example.eventsapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Data
@Document(collection = "event_localizations")
public class EventLocalizationModel {
    @Id
    private String id;
    @Field("event_slug")
    private String eventSlug;
    @Field("title")
    private String title;
    @Field("location")
    private LocationModel location;
    @Field("description")
    private String description;
    @Field("content")
    private String content;
    @Field("culture")
    private String culture;
}
