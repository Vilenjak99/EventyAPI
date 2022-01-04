package com.example.eventsapi.controller;

import com.example.eventsapi.model.AuthorModel;
import com.example.eventsapi.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("authors")
public class AuthorController {
    @Autowired
    private AuthorService authorService;
    @Autowired
    private PasswordEncoder pswEncoder;

    @PostMapping("")
    public AuthorModel insert(@RequestBody AuthorModel author){
        return authorService.insert(author);
    }

    @GetMapping(value = "", params = "slug")
    public AuthorModel findOneBySlug(@RequestParam("slug") String slug){
        return  authorService.findOneBySlug(slug);
    }

    @GetMapping(value = "", params = "username")
    public AuthorModel findOneByUsername(@RequestParam("username") String username){
        return  authorService.findOneByUsername(username);
    }

    @GetMapping(value = "", params = "email")
    public AuthorModel findOneByEmail(@RequestParam("email") String email){
        return  authorService.findOneByEmail(email);
    }

    @PostMapping("register")
    public AuthorModel register(@RequestBody AuthorModel author){
        author.setPassword(pswEncoder.encode(author.getPassword()));
        return authorService.insert(author);
    }

    @GetMapping(value = "")
    public AuthorModel findOneByUsernameOrEmail(@RequestParam("username") String username, @RequestParam("password") String password){
        AuthorModel user =  authorService.findOneByUsernameOrEmail(username);
        if(user != null){
            if(pswEncoder.matches(password, user.getPassword())) {return user;}
        }
    return null;
    }
}
