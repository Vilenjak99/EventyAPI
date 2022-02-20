package com.example.eventsapi.repository;

import com.example.eventsapi.model.CommentModel;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ICommentsRepository extends MongoRepository<CommentModel, String> {
    CommentModel insert(CommentModel comment);
    List<CommentModel> findAll();
    List<CommentModel> findAllByEventId(String eventId);
    @Query("{'parent_comment._id': ?0}")
    List<CommentModel> findAllByParentCommentId(ObjectId parentCommentId);
    CommentModel save(CommentModel model);
}
