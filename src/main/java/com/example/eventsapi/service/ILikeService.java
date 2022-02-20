package com.example.eventsapi.service;

import com.example.eventsapi.model.LikeModel;

import java.util.List;

public interface ILikeService {
    LikeModel save(LikeModel likeModel);
    List<LikeModel> findAllByCommentId(String commentId);
    List<LikeModel> findAllByLikeType(String type);
    List<LikeModel> findAllByUserId(String userId);
    List<LikeModel> findLikesForCommentByLikeType(String commentId, String type);
    LikeModel existsByCommentIdAndUserId(String commentId,String userId);
}
