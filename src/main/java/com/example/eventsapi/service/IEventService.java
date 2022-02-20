package com.example.eventsapi.service;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.TagModel;

import java.util.List;

public interface IEventService {
    EventModel insert(EventModel event);
    EventModel deleteBySlug(String eventSlug);
    List<EventModel> findAllByTags(String tagName);
    List<EventModel> findAllByAuthor(String author);
    EventModel findOneBySlug(String slug);
    List<EventModel> findAll();
}
