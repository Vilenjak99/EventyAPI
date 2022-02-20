package com.example.eventsapi.service;

import com.example.eventsapi.model.CommentModel;
import com.example.eventsapi.repository.ICommentsRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentService implements ICommentService{
    @Autowired
    private ICommentsRepository commentsRepository;

    @Override
    public CommentModel insert(CommentModel comment) {
        return commentsRepository.insert(comment);
    }

    @Override
    public List<CommentModel> findAll() {
        return commentsRepository.findAll();
    }

    @Override
    public List<CommentModel> findAllByEventId(String eventId) {
        return commentsRepository.findAllByEventId(eventId);
    }

    @Override
    public List<CommentModel> findAllByParentCommentId(String parentCommentId) {
        return commentsRepository.findAllByParentCommentId(new ObjectId(parentCommentId));
    }

    @Override
    public CommentModel update(CommentModel commentModel) {
        return commentsRepository.save(commentModel);
    }
}
