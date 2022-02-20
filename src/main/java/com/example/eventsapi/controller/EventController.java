package com.example.eventsapi.controller;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.TagModel;
import com.example.eventsapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Locale;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("events")
public class EventController {
    @Autowired
    private EventService eventService;

    @PostMapping(value = "") // POST /events
    public EventModel insert(@RequestBody EventModel event){
        return eventService.insert(event);
    }

    @GetMapping(value = "")
    public List<EventModel> findAll(){
        return eventService.findAll();}

    @GetMapping(value = "", params = "eventSlug")
    public EventModel findOneBySlug(@RequestParam String eventSlug){
        return eventService.findOneBySlug(eventSlug);}

    @DeleteMapping(value = "", params = "eventSlug") // DELETE /events/{slug}
    public void delete(@RequestParam String eventSlug) {
        eventService.deleteBySlug(eventSlug);
    }

    @GetMapping (value = "", params = "tag")
    public List<EventModel> findAllByTag(@RequestParam String tag){return eventService.findAllByTags(tag);}

    @GetMapping (value = "", params = "author")
    public List<EventModel> findAllByAuthor(@RequestParam String author){return eventService.findAllByAuthor(author);}


}
