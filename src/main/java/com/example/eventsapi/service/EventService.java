package com.example.eventsapi.service;

import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.TagModel;
import com.example.eventsapi.repository.IEventsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

@Service
public class EventService implements IEventService{
    @Autowired
    private IEventsRepository eventsRepository;
    @Autowired
    private EventLocalizationService eventLocalizationService;
    @Autowired
    private TagsService tagsService;
    @Autowired
    private AuthorService authorService;

    @Override
    public EventModel insert(EventModel event) {
        //SLUG
        String slug = ((event.getEventLocalization().getTitle()).toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-"));
        List<EventModel> entities = eventsRepository.findAllBySlug(slug);

        if(entities.size()>0){
            slug += "-" + entities.size();
        }
        event.setSlug(slug);
        event.getEventLocalization().setEventSlug(slug);

        if(event.getAuthor().getSlug()==null){
            event.setAuthor(authorService.insert(event.getAuthor()));
        }

        //TAG
        event.setTags(tagsService.getEventTags(event));

        //TIMESTAMP
        event.setDateCreated(new Timestamp(new Date().getTime()));

        //INSERT - FINAL STEP
        eventLocalizationService.insert(event.getEventLocalization());
        return eventsRepository.insert(event);
    }

    @Override
    public EventModel deleteBySlug(String eventSlug) {
        return eventsRepository.deleteBySlug(eventSlug);
    }

    @Override
    public List<EventModel> findAllByTags(String tagName) {
        String tagNameSearch = tagName.toLowerCase(Locale.ROOT).replaceAll("[^a-z0-9-]", "-");
        return eventsRepository.findAllByTags(tagNameSearch);
    }

    @Override
    public EventModel findOneBySlug(String slug) {
        return eventsRepository.findOneBySlug(slug);
    }

    @Override
    public List<EventModel> findAll() {
        return  eventsRepository.findAll();
    }
}
