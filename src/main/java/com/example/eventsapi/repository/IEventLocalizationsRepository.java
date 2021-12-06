package com.example.eventsapi.repository;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventLocalizationModel;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface IEventLocalizationsRepository extends MongoRepository<EventLocalizationModel, String> {
}
