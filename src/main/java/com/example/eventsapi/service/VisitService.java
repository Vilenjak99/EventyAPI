package com.example.eventsapi.service;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.VisitModel;
import com.example.eventsapi.repository.IVisitsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class VisitService implements IVisitService{
    @Autowired
    private IVisitsRepository visitsRepository;

    @Override
    public VisitModel insert(VisitModel model) {
        return visitsRepository.insert(model);
    }

    @Override
    public List<VisitModel> findAll() {
        return visitsRepository.findAll();
    }

    @Override
    public List<VisitModel> findAllByDate(String date) {
        return visitsRepository.findAllByDate(date);
    }

    @Override
    public List<VisitModel> findAllByEvent(EventModel event) {
        return visitsRepository.findAllByEvent(event);
    }

    @Override
    public List<VisitModel> findAllByUser(AuthorModel user) {
        return visitsRepository.findAllByUser(user);
    }

    @Override
    public VisitModel findLatestVisitForGivenParameters(String user, String event) {
        return visitsRepository.findLatestVisitForGivenParameters(user,event);
    }
}
