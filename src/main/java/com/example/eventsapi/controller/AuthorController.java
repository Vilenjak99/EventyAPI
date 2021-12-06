package com.example.eventsapi.controller;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.model.EventModel;
import com.example.eventsapi.service.AuthorService;
import com.example.eventsapi.service.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PasswordEncoder pswEncoder;

    @PostMapping("insert")
    public AuthorModel insert(@RequestBody AuthorModel author){
        return authorService.insert(author);
    }

    @RequestMapping(
            value = "/findonebyslug",
            method = {RequestMethod.GET})
    public AuthorModel findOneBySlug (String slug){
        return  authorService.findOneBySlug(slug);
    }

    @PostMapping("register")
    public AuthorModel register(@RequestBody AuthorModel author){
        author.setPassword(pswEncoder.encode(author.getPassword()));
        return authorService.insert(author);
    }
}
