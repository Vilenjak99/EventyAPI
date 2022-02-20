package com.example.eventsapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import java.util.Date;
import java.util.List;

@Data
@Document(collection = "comments")
public class CommentModel {
    @Id
    private String id;
    @Field("event_id")
    private String eventId;
    @Field("user")
    private AuthorModel user;
    @Field("text")
    private String text;
    @Field("parent_comment")
    private CommentModel parentComment;
    @Field("sub_comment")
    private List<CommentModel> subComments;
    @Field("date")
    private Date date;
}
