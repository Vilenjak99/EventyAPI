package com.example.eventsapi.service;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.VisitModel;

import java.util.Date;
import java.util.List;

public interface IVisitService {
    VisitModel insert(VisitModel model);
    List<VisitModel> findAll();
    List<VisitModel> findAllByDate(String date);
    List<VisitModel> findAllByEvent(EventModel event);
    List<VisitModel> findAllByUser(AuthorModel user);
    VisitModel findLatestVisitForGivenParameters(String user,String event);
}
