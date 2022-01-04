package com.example.eventsapi.repository;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.VisitModel;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface IVisitsRepository extends MongoRepository<VisitModel, String> {
    VisitModel insert(VisitModel visit);
    List<VisitModel> findAll();
    List<VisitModel> findAllByDate(Date date);
    List<VisitModel> findAllByEvent(EventModel event);
    List<VisitModel> findAllByUser(AuthorModel user);

}
