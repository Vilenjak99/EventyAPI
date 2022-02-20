package com.example.eventsapi.service;

import com.example.eventsapi.model.LikeModel;
import com.example.eventsapi.repository.ILikesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService implements ILikeService{
    @Autowired
    private ILikesRepository likesRepository;

    @Override
    public LikeModel save(LikeModel likeModel) {
        return likesRepository.save(likeModel);
    }

    @Override
    public List<LikeModel> findAllByCommentId(String commentId) {
        return likesRepository.findAllByCommentId(commentId);
    }

    @Override
    public List<LikeModel> findAllByLikeType(String type) {
        return likesRepository.findAllByLikeType(type);
    }

    @Override
    public List<LikeModel> findAllByUserId(String userId) {
        return likesRepository.findAllByUserId(userId);
    }

    @Override
    public List<LikeModel> findLikesForCommentByLikeType(String commentId, String type) {
        return likesRepository.findLikesForCommentByLikeType(commentId, type);
    }

    @Override
    public LikeModel existsByCommentIdAndUserId(String commentId, String userId) {
        return likesRepository.existsByCommentIdAndUserId(commentId, userId);
    }
}
