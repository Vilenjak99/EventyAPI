package com.example.eventsapi.service;

import com.example.eventsapi.model.EventLocalizationModel;
import com.example.eventsapi.model.EventModel;

public interface IEventLocalizationService {
    EventLocalizationModel insert(EventLocalizationModel eventLocalization);
}
