package com.example.eventsapi.repository;

import com.example.eventsapi.model.LikeModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ILikesRepository extends MongoRepository<LikeModel, String> {

    LikeModel save(LikeModel likeModel);
    List<LikeModel> findAllByCommentId(String commentId);
    List<LikeModel> findAllByLikeType(String type);
    List<LikeModel> findAllByUserId(String userId);
    @Query("{$and:[{'comment_id': :#{#commentId}}, {'like_type': :#{#type}}]}")
    List<LikeModel> findLikesForCommentByLikeType(String commentId, String type);

    @Query("{'commentId' : ?0 , 'userId' : ?1}") //?0- prvi argument, ?1- drugi argument
    LikeModel existsByCommentIdAndUserId(String commentId, String userId);

    @Query(value="{$and:[{'comment_id': :#{#commentId}}, {'like_type': :#{#type}}]}", count = true)
    List<LikeModel> countLikesForCommentByLikeType(String commentId, String type);
}
