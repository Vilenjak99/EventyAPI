package com.example.eventsapi.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
@Data
@Document(collection = "likes")
public class LikeModel {
    @Id
    private String id;
    @Field("like_type")
    private String likeType;
    @Field("user_id")
    private String userId;
    @Field("comment_id")
    private String commentId;
}
