package com.example.eventsapi.service;

import com.example.eventsapi.model.CommentModel;

import java.util.List;

public interface ICommentService {
    CommentModel insert(CommentModel comment);
    List<CommentModel> findAll();
    List<CommentModel> findAllByEventId(String eventId);
    List<CommentModel> findAllByParentCommentId(String parentComment);
    CommentModel update(CommentModel commentModel);
}
