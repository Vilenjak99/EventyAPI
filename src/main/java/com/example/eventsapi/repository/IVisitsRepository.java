package com.example.eventsapi.repository;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.VisitModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.Date;
import java.util.List;

public interface IVisitsRepository extends MongoRepository<VisitModel, String> {
    VisitModel insert(VisitModel visit);
    @Query("{$and:[{'user.slug': :#{#user}}, {'event.slug': :#{#event}}]}")
    VisitModel findLatestVisitForGivenParameters(String user, String event);
    List<VisitModel> findAll();
    List<VisitModel> findAllByDate(String date);
    List<VisitModel> findAllByEvent(EventModel event);
    List<VisitModel> findAllByUser(AuthorModel user);


}
