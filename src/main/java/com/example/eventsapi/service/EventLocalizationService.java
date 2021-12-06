package com.example.eventsapi.service;

import com.example.eventsapi.model.EventLocalizationModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.repository.IEventLocalizationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EventLocalizationService implements IEventLocalizationService {
    @Autowired
    private IEventLocalizationsRepository eventLocalizationsRepository;
    @Override
    public EventLocalizationModel insert(EventLocalizationModel eventLocalization) {
        return eventLocalizationsRepository.insert(eventLocalization);
    }
}
