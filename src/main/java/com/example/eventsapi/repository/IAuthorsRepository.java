package com.example.eventsapi.repository;

import com.example.eventsapi.model.AuthorModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IAuthorsRepository extends MongoRepository<AuthorModel, String> {
    AuthorModel findBySlug(String slug);
    AuthorModel findByUsername(String username);
    AuthorModel insert(AuthorModel author);
    @Query(value = "{'slug':{$regex : ?0, $options: 'i'}}")
    List<AuthorModel> findAllBySlug(String slug);
}
