package com.example.eventsapi.repository;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.TagModel;
import com.mongodb.client.MongoCollection;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface IEventsRepository extends MongoRepository<EventModel, String> {

    @Query(value="{'tags.name_srch' : ?0}")
    List<EventModel> findAllByTags(String tag);
    @Query(value = "{'author.username': :#{#username}}")
    List<EventModel> findAllByAuthor(String username);
    EventModel findOneBySlug(String slug);
    EventModel insert(EventModel event);
    @Query(value="{'slug' : $0}", delete = true)
    EventModel deleteBySlug(String slug);
    @Query(value = "{'slug':{$regex : ?0, $options: 'i'}}")
    List<EventModel> findAllBySlug(String slug);
    List<EventModel> findAll();

}
