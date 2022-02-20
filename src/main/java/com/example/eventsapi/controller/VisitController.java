package com.example.eventsapi.controller;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.model.VisitModel;
import com.example.eventsapi.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("visits")
public class VisitController {
    @Autowired
    private VisitService visitService;

//    @GetMapping(value = "")
//    public List<VisitModel> findAll() {
//        return visitService.findAll();
//    }

//    @GetMapping(value = "")
//    public VisitModel findLatestVisitForGivenParameters(@RequestParam("user-slug") String user, @RequestParam("event-slug") String event){
//        return visitService.findLatestVisitForGivenParameters(user, event);
//    }

    @GetMapping(value = "")
    public List<VisitModel> findAllByDate(@RequestParam("date") String date){
        return visitService.findAllByDate(date);
    }

    @PostMapping(value = "")
    public VisitModel insert(@RequestBody VisitModel model) {
        return visitService.insert(model);
    }

}
