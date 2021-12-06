package com.example.eventsapi.service;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.TagModel;

import java.util.List;

public interface ITagsService {
    List<TagModel> getAuthorTags(AuthorModel model);
    List<TagModel> getEventTags(EventModel model);
    TagModel createTag(String tagName);
}
