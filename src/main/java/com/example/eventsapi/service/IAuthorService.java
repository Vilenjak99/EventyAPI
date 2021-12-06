package com.example.eventsapi.service;

import com.example.eventsapi.model.AuthorModel;

import java.util.List;

public interface IAuthorService {
    AuthorModel insert(AuthorModel event);
    AuthorModel findOneBySlug(String slug);
    List<AuthorModel> findAll();
}
