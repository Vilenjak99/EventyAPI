package com.example.eventsapi.repository;

import com.example.eventsapi.model.AuthorModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface IAuthorsRepository extends MongoRepository<AuthorModel, String> {
    AuthorModel findBySlug(String slug);
    AuthorModel findOneByUsername(String username);
    AuthorModel findOneByEmail(String email);
    @Query("{$or:[{'username' : :#{#username}}, {'email' : :#{#email}}]}")
    AuthorModel findOneByUsernameOrEmail(String username, String email);
    AuthorModel insert(AuthorModel author);
    @Query(value = "{'slug':{$regex : ?0, $options: 'i'}}")
    List<AuthorModel> findAllBySlug(String slug);



}
