package com.example.eventsapi.service;

import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.TagModel;

import java.util.List;

public interface IEventService {
    EventModel insert(EventModel event);
    EventModel deleteBySlug(String eventSlug);
    List<EventModel> findAllByTags(String tagName);
    EventModel findOneBySlug(String slug);
    List<EventModel> findAll();
}
