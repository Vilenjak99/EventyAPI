package com.example.eventsapi.controller;

import com.example.eventsapi.model.VisitModel;
import com.example.eventsapi.service.VisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("visits")
public class VisitController {
    @Autowired
    private VisitService visitService;

    @PostMapping(value="")
    public VisitModel insert(@RequestBody VisitModel model){return visitService.insert(model);}

    @GetMapping(value="")
    public List<VisitModel> findAll(){return visitService.findAll();}

}
